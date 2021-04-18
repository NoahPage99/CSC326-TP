package edu.ncsu.csc.iTrust2.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import edu.ncsu.csc.iTrust2.forms.SatisfactionSurveyForm;
import edu.ncsu.csc.iTrust2.models.Personnel;
import edu.ncsu.csc.iTrust2.models.User;
import edu.ncsu.csc.iTrust2.persistant.SatisfactionSurvey;
import edu.ncsu.csc.iTrust2.repositories.SatisfactionSurveyRepository;

/**
 * Service for managing satisfaction surveys and communicating with the
 * repository
 *
 * @author awu3
 * @author dhnguye4
 * @author yli223
 * @author laagamai
 * @author ncpage
 * @author scheerl
 *
 */
@Component
@Transactional
public class SatisfactionSurveyService extends Service {
    private static Gson gson = new Gson();

    @Autowired
    private SatisfactionSurveyRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private PersonnelService personnelService;

    @Override
    protected JpaRepository getRepository() {
        return repository;
    }

    public SatisfactionSurvey build(final SatisfactionSurveyForm ssf) {
        final var ss = (SatisfactionSurvey) this.findById(ssf.getId());
        if (ss == null) {
            throw new IllegalArgumentException("Invalid survey id");
        }

        ss.setTimeWaitedWaitingRoom(ssf.getTimeWaitedWaitingRoom());
        ss.setTimeWaitedExaminationRoom(ssf.getTimeWaitedExaminationRoom());
        ss.setSatisfiedOfficeVisit(ssf.getSatisfiedOfficeVisit());
        ss.setSatisfiedTreatment(ssf.getSatisfiedTreatment());
        ss.setHcp(userService.findByName(ssf.getHcp()));
        ss.setPatient(userService.findByName(ssf.getPatient()));

        if (ssf.getNotes() != null) {
            ss.setNotes(ssf.getNotes());
        }

        ss.setCompleted(ssf.getCompleted());

        return ss;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SatisfactionSurvey> findAll() {
        return (List<SatisfactionSurvey>) super.findAll();
    }

    public List<SatisfactionSurvey> findByPatient(final User patient) {
        return repository.findByPatient(patient);
    }

    public List<SatisfactionSurvey> findByHcp(final User hcp) {
        return repository.findByHcp(hcp);
    }

    private Map<String, String> getSurveyAveragesHelper(final User hcp) {
        final var averages = repository.getSurveyAveragesByHCP(hcp.getId());
        final var averageCompleted = repository.getSurveyAverageCompleted(hcp.getId());

        Map<String, String> out = new HashMap<String, String>();
        out.putAll(averages);
        out.putAll(averageCompleted);

        return out;
    }

    public Map<String, String> getSurveyAveragesByHCP(final User hcp) {
        return getSurveyAveragesHelper(hcp);
    }

    public Map<String, String> getSurveyAveragesWithNotes(final User hcp) {
        final var averages = getSurveyAveragesHelper(hcp);
        final var notes = repository.getSurveyNotesByHCP(hcp.getId());
        final var tree = gson.toJsonTree(averages);
        tree.getAsJsonObject().add("notes", gson.toJsonTree(notes));

        return gson.fromJson(tree, Map.class);

    }

    public List<Personnel> findAllProvidersWithSurveys() {
        final var ids = repository.findAllProvidersWithSurveys();
        return ids.stream().map(id -> (Personnel) personnelService.findById(id)).collect(Collectors.toList());
    }

}
