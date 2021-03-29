package edu.ncsu.csc.iTrust2.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import edu.ncsu.csc.iTrust2.models.enums.TransactionType;
import edu.ncsu.csc.iTrust2.persistant.SatisfactionSurvey;
import edu.ncsu.csc.iTrust2.services.SatisfactionSurveyService;
import edu.ncsu.csc.iTrust2.services.UserService;
import edu.ncsu.csc.iTrust2.utils.LoggerUtil;

public class APISatisfactionSurveyController extends APIController {

    @Autowired
    private SatisfactionSurveyService surveyService;

    @Autowired
    private UserService               userService;

    @Autowired
    private LoggerUtil                loggerUtil;

    /**
     * REST API method to provide GET access to all satisfaction surveys in the
     * system
     *
     * @return
     */
    @GetMapping ( BASE_PATH + "/surveys" )
    public List<SatisfactionSurvey> getSurveys () {
        loggerUtil.log( TransactionType.VIEW_ALL_OFFICE_VISITS, LoggerUtil.currentUser() );
        return surveyService.findAll();
    }
}
