package edu.ncsu.csc.iTrust2.services;

import java.time.ZonedDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import edu.ncsu.csc.iTrust2.forms.OphOfficeVisitForm;
import edu.ncsu.csc.iTrust2.models.AppointmentRequest;
import edu.ncsu.csc.iTrust2.models.DomainObject;
import edu.ncsu.csc.iTrust2.models.Patient;
import edu.ncsu.csc.iTrust2.models.User;
import edu.ncsu.csc.iTrust2.models.enums.AppointmentType;
import edu.ncsu.csc.iTrust2.persistant.OphOfficeVisit;
import edu.ncsu.csc.iTrust2.persistant.SatisfactionSurvey;
import edu.ncsu.csc.iTrust2.repositories.OphOfficeVisitRepository;

/**
 * Service for managing office visits and communicating with the repository
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
public class OphOfficeVisitService extends Service {
    @Autowired
    private OphOfficeVisitRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentRequestService appointmentRequestService;

    @Autowired
    private HospitalService hospitalService;

    @Override
    protected JpaRepository getRepository() {
        return repository;
    }

    public OphOfficeVisit build(final OphOfficeVisitForm oovf) {
        final OphOfficeVisit oov = new OphOfficeVisit();
        if (oovf.getDate() != null) {
            oov.setDate(ZonedDateTime.parse(oovf.getDate()));
        }
        if (oovf.getId() != null) {
            oov.setId(Long.parseLong(oovf.getId()));
        }
        // if ( oovf.getTime() != null ) {
        // oov.setTime( oovf.getTime() );
        // } 
        oov.setType(AppointmentType.valueOf(oovf.getType()));
        oov.setHospital(hospitalService.findByName(oovf.getHospital()));
        oov.setHcp(userService.findByName(oovf.getHcp()));
        oov.setPatient(userService.findByName(oovf.getPatient()));
        oov.setlEyeAcuity(oovf.getlEyeAcuity());
        oov.setrEyeAcuity(oovf.getrEyeAcuity());
        oov.setlEyeAxis(oovf.getlEyeAxis());
        oov.setrEyeAxis(oovf.getrEyeAxis());
        oov.setlEyeCyl(oovf.getlEyeCyl());
        oov.setrEyeCyl(oovf.getrEyeCyl());
        oov.setlEyeSphere(oovf.getlEyeSphere());
        oov.setrEyeSphere(oovf.getrEyeSphere());
        oov.setAppointment((AppointmentRequest) appointmentRequestService.findById(oovf.getAppointmentId()));
        return oov;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OphOfficeVisit> findAll() {
        return (List<OphOfficeVisit>) super.findAll();
    }

    public List<OphOfficeVisit> findByHcp(final User hcp) {
        return repository.findByHcp(hcp);
    }

    public List<OphOfficeVisit> findByPatient(final User patient) {
        return repository.findByPatient(patient);
    }

    public List<OphOfficeVisit> findByHcpAndPatient(final User hcp, final User patient) {
        return repository.findByHcpAndPatient(hcp, patient);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void save(final DomainObject obj) {
        final var officeVisit = (OphOfficeVisit) obj;
        if (officeVisit.getSatisfactionSurvey() == null) {
            final var survey = new SatisfactionSurvey();
            survey.setPatient((Patient) officeVisit.getPatient());
            survey.setHcp(officeVisit.getHcp());
            survey.setOfficeVisit(officeVisit);
            officeVisit.setSatisfactionSurvey(survey);
        }
        getRepository().saveAndFlush(obj);
    }
}
