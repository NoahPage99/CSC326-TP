package edu.ncsu.csc.iTrust2.persistant;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.ncsu.csc.iTrust2.TestConfig;
import edu.ncsu.csc.iTrust2.forms.OphOfficeVisitForm;
import edu.ncsu.csc.iTrust2.forms.UserForm;
import edu.ncsu.csc.iTrust2.models.Patient;
import edu.ncsu.csc.iTrust2.models.Personnel;
import edu.ncsu.csc.iTrust2.models.User;
import edu.ncsu.csc.iTrust2.models.enums.Disease;
import edu.ncsu.csc.iTrust2.models.enums.Role;
import edu.ncsu.csc.iTrust2.services.OphOfficeVisitService;
import edu.ncsu.csc.iTrust2.services.UserService;

/**
 * Test class for Ophthalmology Office Visit
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
public class OphOfficeVisitTest {

    /**
     * user service for testing
     */
    @Autowired
    private UserService           uservice;

    /**
     * oph service
     */
    @Autowired
    private OphOfficeVisitService service;

    /** first testing instance */
    private OphOfficeVisit        o1;
    /** second test instance */
    private OphOfficeVisit        o2;
    /** third test instance */
    private OphOfficeVisit        o3;
    /** oph form */
    private OphOfficeVisitForm    oovf;

    /**
     * setup - not used yet
     *
     * @throws java.lang.Exception
     */
    @Before
    public void setup () {
        // service.deleteAll();
        final User hcp = new Personnel( new UserForm( "hcp", "123456", Role.ROLE_HCP, 1 ) );

        final User alice = new Patient( new UserForm( "AliceThirteen", "123456", Role.ROLE_PATIENT, 1 ) );

        uservice.saveAll( List.of( hcp, alice ) );
    }

    @Test
    @Transactional
    public void test () {
        o1 = new OphOfficeVisit();
        o2 = new OphOfficeVisit( uservice.findByName( "AliceThirteen" ), uservice.findByName( "hcp" ), "test notes",
                "04/07/2021", "08:01", 2, 2, 2, 2, 2, 2, 2, 2 );
        o2.addDisease( Disease.CATARACTS );
        service.save( o2 );
        final List<OphOfficeVisit> ooList = service.findAll();
        assertEquals( 1, ooList.size() );
        oovf = new OphOfficeVisitForm( o2 );
        final OphOfficeVisit ophOfficeVisit = service.build( oovf );
        assertNotNull( ophOfficeVisit );
        assertEquals( "04/07/2021", o2.getDate() );
        assertEquals( "08:01", o2.getTime() );
        assertEquals( "test notes", o2.getNotes() );
        assertEquals( 2, o2.getlEyeAcuity() );
        assertEquals( 2, o2.getrEyeAcuity() );
        assertEquals( 2, o2.getlEyeAxis() );
        assertEquals( 2, o2.getrEyeAxis() );
        assertEquals( 2, o2.getlEyeCyl() );
        assertEquals( 2, o2.getrEyeCyl() );
        assertEquals( 2, o2.getlEyeSphere() );
        assertEquals( 2, o2.getrEyeSphere() );
    }
}
