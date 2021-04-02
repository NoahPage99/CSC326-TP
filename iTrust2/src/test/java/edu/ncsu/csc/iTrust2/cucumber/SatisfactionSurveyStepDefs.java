package edu.ncsu.csc.iTrust2.cucumber;

import org.springframework.beans.factory.annotation.Autowired;

import edu.ncsu.csc.iTrust2.services.SatisfactionSurveyService;
import edu.ncsu.csc.iTrust2.services.UserService;

/**
 * Step Definitions for Satisfaction Survey
 *
 * @author laagamai
 *
 */
public class SatisfactionSurveyStepDefs extends CucumberTest {
    private final String              patientString = "patient";
    private final String              hcpString     = "hcp";

    @Autowired
    private UserService               userService;

    @Autowired
    private SatisfactionSurveyService service;

    /**
     * Navigates to the Manage Appointment Requests page.
     */
    // @When ( "^I log in as a patient$" )
    // public void navigateToView () {
    // ( (JavascriptExecutor) driver ).executeScript(
    // "document.getElementById('requestappointment').click();" );
    // final WebDriverWait wait = new WebDriverWait( driver, 20 );
    // wait.until( ExpectedConditions.titleContains( "Request Appointment" ) );
    // assertEquals( "iTrust2: Request Appointment", driver.getTitle() );
    // }
}
