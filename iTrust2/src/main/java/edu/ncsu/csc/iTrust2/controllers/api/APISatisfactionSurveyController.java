package edu.ncsu.csc.iTrust2.controllers.api;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ncsu.csc.iTrust2.forms.SatisfactionSurveyForm;
import edu.ncsu.csc.iTrust2.models.Personnel;
import edu.ncsu.csc.iTrust2.models.User;
import edu.ncsu.csc.iTrust2.models.enums.Role;
import edu.ncsu.csc.iTrust2.models.enums.TransactionType;
import edu.ncsu.csc.iTrust2.persistant.SatisfactionSurvey;
import edu.ncsu.csc.iTrust2.services.PersonnelService;
import edu.ncsu.csc.iTrust2.services.SatisfactionSurveyService;
import edu.ncsu.csc.iTrust2.services.UserService;
import edu.ncsu.csc.iTrust2.utils.LoggerUtil;

@RestController
@SuppressWarnings({ "unchecked", "rawtypes" })
public class APISatisfactionSurveyController extends APIController {

    @Autowired
    private SatisfactionSurveyService surveyService;

    @Autowired
    private UserService userService;

    @Autowired
    private PersonnelService personnelService;

    @Autowired
    private LoggerUtil loggerUtil;

    private JsonElement createProviderAverage(User hcp, Map<String, String> data) {
        final var jsonObject = new JsonObject();
        jsonObject.addProperty("username", hcp.getUsername());
        jsonObject.add("data", APIController.toJsonTree(data));
        return jsonObject;
    }

    private String getProvidersAverages(boolean withNotes) {
        final List<Personnel> personage = (List<Personnel>) surveyService.findAllProvidersWithSurveys();

        final var averages = personage.stream().filter(p -> p.isDoctor()).map(hcp -> {
            final var data = withNotes ? surveyService.getSurveyAveragesWithNotes(hcp)
                    : surveyService.getSurveyAveragesByHCP(hcp);
            return createProviderAverage(hcp, data);
        }).collect(Collectors.toList());

        return APIController.toJson(averages);
    }

    @GetMapping(BASE_PATH + "/surveys/averages")
    public ResponseEntity getSurveyAverages() {
        final User self = userService.findByName(LoggerUtil.currentUser());

        String data = null;

        if (self.getRoles().contains(Role.ROLE_ADMIN)) {
            data = getProvidersAverages(true);
        } else if (self.getRoles().contains(Role.ROLE_PATIENT)) {
            data = getProvidersAverages(false);
        } else if (self.getRoles().contains(Role.ROLE_HCP)) {
            final var averageData = surveyService.getSurveyAveragesByHCP(self);
            data = '[' + createProviderAverage(self, averageData).toString() + ']';
        }

        if (data != null) {
            return new ResponseEntity(data, HttpStatus.OK);
        } else {
            return new ResponseEntity(errorResponse("User does not have access to average statistics"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * REST API method to provide GET access to all satisfaction surveys in the
     * system
     *
     * @return list of surveys
     */
    @PreAuthorize("hasAnyRole('ROLE_HCP', 'ROLE_OD', 'ROLE_OPH', 'ROLE_VIROLOGIST', 'ROLE_ADMIN', 'ROLE_PATIENT')")
    @GetMapping(BASE_PATH + "/surveys")
    public List<SatisfactionSurvey> getSurveys() {
        loggerUtil.log(TransactionType.SURVEY_VIEW, LoggerUtil.currentUser(), "HCP viewed a list of all survey");

        return surveyService.findAll();
    }

    /**
     * Retrieves all of the office visits for the current HCP.
     *
     * @return all of the office visits for the current HCP.
     */
    @GetMapping(BASE_PATH + "/surveys/HCP")
    @PreAuthorize("hasRole('ROLE_HCP', 'ROLE_ADMIN')")
    public List<SatisfactionSurvey> getSurveysForHCP() {
        final User self = userService.findByName(LoggerUtil.currentUser());
        loggerUtil.log(TransactionType.VIEW_ALL_OFFICE_VISITS, self);
        final List<SatisfactionSurvey> visits = surveyService.findByHcp(self);

        return visits;
    }

    /**
     * Retrieves a list of all OfficeVisits in the database for the current patient
     *
     * @return list of office visits
     */
    @GetMapping(BASE_PATH + "surveys/mysurveys")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public List<SatisfactionSurvey> getMySurveys() {
        final User self = userService.findByName(LoggerUtil.currentUser());
        loggerUtil.log(TransactionType.VIEW_ALL_OFFICE_VISITS, self);
        final List<SatisfactionSurvey> visits = surveyService.findByPatient(self);

        return visits;
    }

    /**
     * Retrieves a list of all OfficeVisits in the database for the current patient
     *
     * @return list of office visits
     */
    @GetMapping(BASE_PATH + "surveys/hcp/mysurveys")
    @PreAuthorize("hasRole('ROLE_HCP')")
    public List<SatisfactionSurvey> getHCPSurveys() {
        final User self = userService.findByName(LoggerUtil.currentUser());
        loggerUtil.log(TransactionType.VIEW_ALL_OFFICE_VISITS, self);
        final List<SatisfactionSurvey> visits = surveyService.findByHcp(self);
        return visits;
    }

    /**
     * Retrieves a list of all OfficeVisits in the database
     *
     * @param id ID of the office visit to retrieve
     * @return list of office visits
     */
    @GetMapping(BASE_PATH + "/surveys/{id}")
    @PreAuthorize("hasRole('ROLE_HCP')")
    public ResponseEntity getSurveys(@PathVariable final Long id) {
        final User self = userService.findByName(LoggerUtil.currentUser());
        loggerUtil.log(TransactionType.SURVEY_VIEW, self);
        if (!surveyService.existsById(id)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(surveyService.findById(id), HttpStatus.OK);
    }

    /**
     * Creates and saves a new OfficeVisit from the RequestBody provided.
     *
     * @param surveyForm The office visit to be validated and saved
     * @return response
     */
    @PostMapping(BASE_PATH + "/surveys")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity createSurvey(@RequestBody final SatisfactionSurveyForm surveyForm) {
        try {
            final SatisfactionSurvey survey = surveyService.build(surveyForm);

            if (survey == null) {
                return new ResponseEntity(errorResponse("Satisfaction Survey for office visit does not exist"),
                        HttpStatus.BAD_REQUEST);
            }
            surveyService.save(survey);
            loggerUtil.log(TransactionType.SURVEY_CREATE, LoggerUtil.currentUser(), survey.getPatient().getUsername());
            return new ResponseEntity(survey, HttpStatus.OK);

        } catch (final Exception e) {
            e.printStackTrace();
            return new ResponseEntity(
                    errorResponse("Could not validate or save the Survey provided due to " + e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
