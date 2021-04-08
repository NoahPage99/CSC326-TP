package edu.ncsu.csc.iTrust2.cucumber;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import edu.ncsu.csc.iTrust2.services.SatisfactionSurveyService;
import edu.ncsu.csc.iTrust2.services.UserService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

    @When ( "I navigate to the Manage Surveys page" )
    public void selectPage () {
        waitForAngular();
        ( (JavascriptExecutor) driver )
                .executeScript( "document.getElementById('manageSatisfactionSurveys').click();" );
        waitForAngular();
    }

    @Then ( "no appointments show up" )
    public void checkSuccessMessage () {
        waitForAngular();

    }

    @When ( "I choose to complete a survey for a medical appointment" )
    public void chooseToComplete () {
        waitForAngular();

        final WebElement TimeWaited = driver.findElement( By.name( "timeWaitedRoom" ) );
        TimeWaited.clear();
        TimeWaited.sendKeys( "0" );

        final WebElement TimeWaitedE = driver.findElement( By.name( "timeWaitedExam" ) );
        TimeWaitedE.clear();
        TimeWaitedE.sendKeys( "0" );

        final WebElement SatisfiedOffice = driver.findElement( By.name( "satisfiedVisit" ) );
        SatisfiedOffice.clear();
        SatisfiedOffice.sendKeys( "6" );

        final WebElement SatisfiedTreat = driver.findElement( By.name( "satisfiedTreat" ) );
        SatisfiedTreat.clear();
        SatisfiedTreat.sendKeys( "6" );

        final WebElement notes = driver.findElement( By.name( "notes" ) );
        notes.clear();
        notes.sendKeys( "6" );

        driver.findElement( By.name( "submitRequest" ) ).click();

        waitForAngular();

    }

    @Then ( "The appointment request with updated" )
    public void showMessage () {
        waitForAngular();

        // confirm that the message is displayed
        try {
            assertTrue( driver.findElement( By.name( "failure" ) ).getText().contains( "Error while adding survey" ) );
        }
        catch ( final Exception e ) {
            fail();
        }

    }
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
