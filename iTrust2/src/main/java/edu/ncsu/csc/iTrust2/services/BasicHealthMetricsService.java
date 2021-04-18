package edu.ncsu.csc.iTrust2.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import edu.ncsu.csc.iTrust2.forms.OfficeVisitForm;
import edu.ncsu.csc.iTrust2.forms.OphOfficeVisitForm;
import edu.ncsu.csc.iTrust2.models.BasicHealthMetrics;
import edu.ncsu.csc.iTrust2.models.enums.HouseholdSmokingStatus;
import edu.ncsu.csc.iTrust2.models.enums.PatientSmokingStatus;
import edu.ncsu.csc.iTrust2.repositories.BasicHealthMetricsRepository;

@Component
@Transactional
public class BasicHealthMetricsService extends Service {
    @Autowired
    private BasicHealthMetricsRepository repository;

    @Autowired
    private UserService                  userService;

    @Override
    protected JpaRepository getRepository () {
        return repository;
    }

    public BasicHealthMetrics build ( final OfficeVisitForm ovf ) {
        final BasicHealthMetrics bhm = new BasicHealthMetrics();
        bhm.setPatient( userService.findByName( ovf.getPatient() ) );
        bhm.setHcp( userService.findByName( ovf.getHcp() ) );

        bhm.setDiastolic( ovf.getDiastolic() );
        bhm.setHdl( ovf.getHdl() );
        bhm.setHeight( ovf.getHeight() );
        bhm.setHouseSmokingStatus( ovf.getHouseSmokingStatus() );
        bhm.setHeadCircumference( ovf.getHeadCircumference() );
        bhm.setLdl( ovf.getLdl() );
        bhm.setPatientSmokingStatus( ovf.getPatientSmokingStatus() );
        bhm.setSystolic( ovf.getSystolic() );
        bhm.setTri( ovf.getTri() );
        bhm.setWeight( ovf.getWeight() );

        return bhm;
    }

    public BasicHealthMetrics build ( final OphOfficeVisitForm ophOPVF ) {
        final BasicHealthMetrics bhm = new BasicHealthMetrics();
        bhm.setPatient( userService.findByName( ophOPVF.getPatient() ) );
        bhm.setHcp( userService.findByName( ophOPVF.getHcp() ) );

        bhm.setDiastolic( ophOPVF.getDiastolic() );
        bhm.setHdl( ophOPVF.getHdl() );
        bhm.setHeight( ophOPVF.getHeight() );
        bhm.setHouseSmokingStatus( HouseholdSmokingStatus.valueOf( ophOPVF.getHouseSmokingStatus() ) );
        bhm.setHeadCircumference( ophOPVF.getHeadCircumference() );
        bhm.setLdl( ophOPVF.getLdl() );
        bhm.setPatientSmokingStatus( PatientSmokingStatus.valueOf( ophOPVF.getPatientSmokingStatus() ) );
        bhm.setSystolic( ophOPVF.getSystolic() );
        bhm.setTri( ophOPVF.getTri() );
        bhm.setWeight( ophOPVF.getWeight() );

        return bhm;
    }
}
