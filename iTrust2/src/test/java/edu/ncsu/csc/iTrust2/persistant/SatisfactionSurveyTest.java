/**
 *
 */
package edu.ncsu.csc.iTrust2.persistant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.ncsu.csc.iTrust2.TestConfig;
import edu.ncsu.csc.iTrust2.forms.SatisfactionSurveyForm;
import edu.ncsu.csc.iTrust2.services.SatisfactionSurveyService;

/**
 * Test class for satisfaction surveys
 *
 * @author awu3
 * @author dhnguye4
 * @author yli223
 * @author laagamai
 * @author ncpage
 * @author scheerl
 *
 */
@RunWith ( SpringRunner.class )
@EnableAutoConfiguration
@SpringBootTest ( classes = TestConfig.class )
public class SatisfactionSurveyTest {
    /**
     * service for testing
     */
    @Autowired
    private SatisfactionSurveyService service;

    /**
     * survey 1 for testing purposes
     */
    private SatisfactionSurvey        s1;

    /**
     * survey 2 for testing purposes
     */
    private SatisfactionSurvey        s2;

    /**
     * survey 3 for testing purposes
     */
    private SatisfactionSurvey        s3;
    /**
     * survey 4 for testing purposes
     */
    private SatisfactionSurvey        s4;
    /**
     * survey 5 for testing purposes
     */
    private SatisfactionSurvey        s5;
    /**
     * survey 6 for testing purposes
     */
    private SatisfactionSurvey        s6;
    /**
     * form for testing
     */
    private SatisfactionSurveyForm    ssf;

    /**
     * setup - not used yet
     *
     * @throws java.lang.Exception
     */
    @Before
    public void setup () {
        service.deleteAll();
    }

    /**
     * test creating, toString, and equals of satisfaction surveys
     */
    @Test
    @Transactional
    public void test () {
        s1 = new SatisfactionSurvey();
        s2 = new SatisfactionSurvey();
        s3 = new SatisfactionSurvey( 5, 5, 5, 5, "yay" );
        s4 = new SatisfactionSurvey( 5, 2, 5, 5, "yay" );
        s5 = new SatisfactionSurvey( 5, 5, 2, 5, "yay" );
        s6 = new SatisfactionSurvey( 2, 5, 5, 5, "yay" );
        // final SatisfactionSurvey ss1 = new SatisfactionSurvey();
        service.save( s3 );
        ssf = new SatisfactionSurveyForm( s3 );
        assertNotNull( ssf.getNotes() );
        assertNotNull( ssf );
        // TODO: fix this
        final SatisfactionSurvey satisfactionSurvey = service.build( ssf );
        assertNotNull( satisfactionSurvey );
        assertTrue( s1.equals( s2 ) );
        assertTrue( s2.equals( s1 ) );
        assertFalse( s1.equals( s3 ) );

        assertEquals( s1.toString(),
                "SatisfactionSurvey [timeWaitedWaitingRoom=0, timeWaitedExaminationRoom=0, satisfiedOfficeVisit=1, satisfiedTreatment=1, notes=]" );
        assertEquals( s3.toString(),
                "SatisfactionSurvey [timeWaitedWaitingRoom=5, timeWaitedExaminationRoom=5, satisfiedOfficeVisit=5, satisfiedTreatment=5, notes=yay]" );
        assertEquals( "yay", s3.getNotes() );
        assertEquals( 5, s3.getTimeWaitedExaminationRoom() );
        assertEquals( 5, s3.getTimeWaitedWaitingRoom() );
        assertEquals( 5, s3.getSatisfiedOfficeVisit() );
        assertEquals( 5, s3.getSatisfiedTreatment() );
        assertFalse( s3.equals( s4 ) );
        assertFalse( s3.equals( s5 ) );
        assertFalse( s3.equals( s6 ) );
    }

}
