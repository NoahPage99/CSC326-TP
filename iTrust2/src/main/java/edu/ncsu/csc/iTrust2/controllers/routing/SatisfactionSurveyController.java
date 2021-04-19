package edu.ncsu.csc.iTrust2.controllers.routing;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for satisfaction survey view that is allowed for HCPs, Admins, and
 * patients
 *
 * @author Kai Presler-Marshall
 *
 */
@Controller
public class SatisfactionSurveyController {

    /**
     * Returns the browse page for a patient to view all satisfaction surveys
     *
     * @param model
     *            The data for the front end
     * @return Page to display to the user
     */
    @GetMapping ( "/surveys/viewSatisfactionSurveys" )
    @PreAuthorize ( "hasAnyRole('ROLE_HCP', 'ROLE_ADMIN', 'ROLE_PATIENT')" )
    public String viewSatisfactionSurveys ( final Model model ) {
        return "surveys/viewSatisfactionSurveys";
    }

}
