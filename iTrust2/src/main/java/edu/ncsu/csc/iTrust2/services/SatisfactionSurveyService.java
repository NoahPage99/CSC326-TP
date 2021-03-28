package edu.ncsu.csc.iTrust2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.ncsu.csc.iTrust2.forms.SatisfactionSurveyForm;
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
public class SatisfactionSurveyService extends Service {
    @Autowired
    private SatisfactionSurveyRepository repository;

    @Override
    protected JpaRepository getRepository () {
        return repository;
    }

    public SatisfactionSurvey build ( final SatisfactionSurveyForm ssf ) {
        final SatisfactionSurvey ss = new SatisfactionSurvey();
        if ( ssf.getId() != null ) {
            ss.setId( Long.parseLong( ssf.getId() ) );
        }
        ss.setTimeWaitedWaitingRoom( ssf.getTimeWaitedWaitingRoom() );
        ss.setTimeWaitedExaminationRoom( ssf.getTimeWaitedExaminationRoom() );
        ss.setSatisfiedOfficeVisit( ssf.getSatisfiedOfficeVisit() );
        ss.setSatisfiedTreatment( ssf.getSatisfiedTreatment() );
        if ( ssf.getNotes() != null ) {
            ss.setNotes( ssf.getNotes() );
        }
        return ss;

    }

    public List<SatisfactionSurvey> findByHcp ( final User hcp ) {
        return repository.findByHcp( hcp );
    }

    public List<SatisfactionSurvey> findByPatient ( final User patient ) {
        return repository.findByPatient( patient );
    }

    public List<SatisfactionSurvey> findByHcpAndPatient ( final User hcp, final User patient ) {
        return repository.findByHcpAndPatient( hcp, patient );
    }

}
