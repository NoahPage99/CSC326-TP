package edu.ncsu.csc.iTrust2.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import edu.ncsu.csc.iTrust2.models.User;
import edu.ncsu.csc.iTrust2.persistant.OphOfficeVisit;
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
    private UserService              userService;

    @Override
    protected JpaRepository getRepository () {
        return repository;
    }

    @SuppressWarnings ( "unchecked" )
    @Override
    public List<OphOfficeVisit> findAll () {
        return (List<OphOfficeVisit>) super.findAll();
    }

    public List<OphOfficeVisit> findByHcp ( final User hcp ) {
        return repository.findByHcp( hcp );
    }

    public List<OphOfficeVisit> findByPatient ( final User patient ) {
        return repository.findByPatient( patient );
    }

    public List<OphOfficeVisit> findByHcpAndPatient ( final User hcp, final User patient ) {
        return repository.findByHcpAndPatient( hcp, patient );
    }
}
