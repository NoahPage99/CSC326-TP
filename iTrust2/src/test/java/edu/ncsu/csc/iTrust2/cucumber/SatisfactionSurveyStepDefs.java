package edu.ncsu.csc.iTrust2.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import edu.ncsu.csc.iTrust2.forms.AppointmentRequestForm;
import edu.ncsu.csc.iTrust2.forms.SatisfactionSurveyForm;
import edu.ncsu.csc.iTrust2.forms.UserForm;
import edu.ncsu.csc.iTrust2.models.AppointmentRequest;
import edu.ncsu.csc.iTrust2.models.Patient;
import edu.ncsu.csc.iTrust2.models.Personnel;
import edu.ncsu.csc.iTrust2.models.User;
import edu.ncsu.csc.iTrust2.models.enums.AppointmentType;
import edu.ncsu.csc.iTrust2.models.enums.Role;
import edu.ncsu.csc.iTrust2.models.enums.Status;
import edu.ncsu.csc.iTrust2.services.AppointmentRequestService;
import edu.ncsu.csc.iTrust2.services.SatisfactionSurveyService;
import edu.ncsu.csc.iTrust2.services.UserService;
import io.cucumber.java.en.Given;
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

    @Autowired
    private AppointmentRequestService app_service;

    @When ( "^I navigate to the Manage Surveys page$" )
    public void selectPage () {
        waitForAngular();

        ( (JavascriptExecutor) driver )
                .executeScript( "document.getElementById('manageSatisfactionSurveys').click();" );
        waitForAngular();
        // assertEquals( "iTrust2: Patient Home", driver.getTitle() );

    }

    @Then ( "^no appointments show up$" )
    public void checkSuccessMessage () {
        waitForAngular();
        assertEquals( 0, app_service.count() );
    }

    @When ( "^I choose to complete a survey for a medical appointment$" )
    public void chooseToComplete () {
        waitForAngular();

        ( (JavascriptExecutor) driver )
                .executeScript( "document.getElementById('manageSatisfactionSurveys').click();" );
        waitForAngular();

        assertEquals( "iTrust2: Manage Satisfaction Surveys", driver.getTitle() );

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

    @When ( "^I choose to complete a survey for a medical appointment with error input$" )
    public void chooseToCompleteError () {
        waitForAngular();

        ( (JavascriptExecutor) driver )
                .executeScript( "document.getElementById('manageSatisfactionSurveys').click();" );
        waitForAngular();

        assertEquals( "iTrust2: Manage Satisfaction Surveys", driver.getTitle() );

        final WebElement TimeWaited = driver.findElement( By.name( "timeWaitedRoom" ) );
        TimeWaited.clear();
        TimeWaited.sendKeys( "-1" );

        final WebElement TimeWaitedE = driver.findElement( By.name( "timeWaitedExam" ) );
        TimeWaitedE.clear();
        TimeWaitedE.sendKeys( "-1" );

        final WebElement SatisfiedOffice = driver.findElement( By.name( "satisfiedVisit" ) );
        SatisfiedOffice.clear();
        SatisfiedOffice.sendKeys( "-1" );

        final WebElement SatisfiedTreat = driver.findElement( By.name( "satisfiedTreat" ) );
        SatisfiedTreat.clear();
        SatisfiedTreat.sendKeys( "-1" );

        final WebElement notes = driver.findElement( By.name( "notes" ) );
        notes.clear();
        notes.sendKeys( "-1" );

        driver.findElement( By.name( "submitRequest" ) ).click();

        waitForAngular();

    }

    @Then ( "The appointment request is not submitted and the form remains the same for editing." )
    public void showMessage1 () {
        waitForAngular();

        // confirm that the message is displayed
        try {
            assertTrue( driver.findElement( By.name( "failure" ) ).getText().contains( "Error while adding survey" ) );
        }
        catch ( final Exception e ) {
            fail();
        }

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

    @When ( "^The patient has been to a medical appointment and the patient has completed a satisfaction survey$" )
    public void patientReview () {

        waitForAngular();

        ( (JavascriptExecutor) driver )
                .executeScript( "document.getElementById('manageSatisfactionSurveys').click();" );
        waitForAngular();

        assertEquals( "iTrust2: Manage Satisfaction Surveys", driver.getTitle() );

        final WebElement TimeWaited = driver.findElement( By.name( "timeWaitedRoom" ) );
        TimeWaited.clear();
        TimeWaited.sendKeys( "1" );

        final WebElement TimeWaitedE = driver.findElement( By.name( "timeWaitedExam" ) );
        TimeWaitedE.clear();
        TimeWaitedE.sendKeys( "1" );

        final WebElement SatisfiedOffice = driver.findElement( By.name( "satisfiedVisit" ) );
        SatisfiedOffice.clear();
        SatisfiedOffice.sendKeys( "1" );

        final WebElement SatisfiedTreat = driver.findElement( By.name( "satisfiedTreat" ) );
        SatisfiedTreat.clear();
        SatisfiedTreat.sendKeys( "1" );

        final WebElement notes = driver.findElement( By.name( "notes" ) );
        notes.clear();
        notes.sendKeys( "general checkup" );

        driver.findElement( By.name( "submitRequest" ) ).click();

        waitForAngular();

    }

    @When ( "^The patient has completed a satisfaction survey$" )
    public void patientReview1 () {

        waitForAngular();

    }

    @Then ( "I can review a survey" )
    public void showSurvey () {
        waitForAngular();

        ( (JavascriptExecutor) driver )
                .executeScript( "document.getElementById('manageSatisfactionSurveys').click();" );
        waitForAngular();

        assertEquals( "iTrust2: Manage Satisfaction Surveys", driver.getTitle() );

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

        try {
            assertTrue( driver.findElement( By.name( "failure" ) ).getText().contains( "Error while adding survey" ) );
        }
        catch ( final Exception e ) {
            fail();
        }
        // confirm that the message is displayed
        // try {
        // assertEquals( 3, driver.findElement( By.cssSelector( cssSelector )
        // By.name( "satsfactionSurveys" ) ).getSize() );
        // }
        // catch ( final Exception e ) {
        // fail();
        // }
    }

    @Given ( "The patient choose to request a medical appointment" )
    public void hasAppointment () {
        waitForAngular();
        final AppointmentRequestForm appointmentForm = new AppointmentRequestForm();
        appointmentForm.setDate( "2022-04-01T16:24:11.252+05:30[Asia/Calcutta]" );
        appointmentForm.setType( AppointmentType.GENERAL_CHECKUP.toString() );
        appointmentForm.setStatus( Status.PENDING.toString() );
        appointmentForm.setHcp( "hcp" );
        appointmentForm.setPatient( "patient" );
        appointmentForm.setComments( "Test appointment please ignore" );

        final AppointmentRequest appointment = app_service.build( appointmentForm );
        app_service.save( appointment );
        assertEquals( 1, app_service.count() );
    }

    @When ( "The HCP selects the appointment request" )
    public void selectAppointment () {
        assertNotNull( app_service.findAll().get( 0 ) );

    }

    @Then ( "The appointment request is moved into the upcoming medical appointment column" )
    public void appointmentMoved () {
        waitForAngular();

        assertEquals( 1, app_service.count() );

        final User patient = new Patient( new UserForm( "patient", "123456", Role.ROLE_PATIENT, 1 ) );

        final User hcp = new Personnel( new UserForm( "hcp", "123456", Role.ROLE_HCP, 1 ) );

        userService.saveAll( List.of( patient, hcp ) );

        final SatisfactionSurveyForm surveyForm = new SatisfactionSurveyForm();

        surveyForm.setSatisfiedOfficeVisit( 5 );
        surveyForm.setSatisfiedTreatment( 5 );
        surveyForm.setTimeWaitedExaminationRoom( 15 );
        surveyForm.setTimeWaitedWaitingRoom( 20 );
        surveyForm.setNotes( "Hello" );
        surveyForm.setHcp( "hcp" );
        surveyForm.setPatient( "patient" );

        service.build( surveyForm );

    }

}
