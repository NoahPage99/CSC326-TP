package edu.ncsu.csc.iTrust2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ncsu.csc.iTrust2.models.User;
import edu.ncsu.csc.iTrust2.persistant.OphOfficeVisit;

public interface OphOfficeVisitRepository extends JpaRepository<OphOfficeVisit, Long> {
    public List<OphOfficeVisit> findByHcp ( final User hcp );

    public List<OphOfficeVisit> findByPatient ( User patient );

    public List<OphOfficeVisit> findByHcpAndPatient ( User hcp, User patient );
}
