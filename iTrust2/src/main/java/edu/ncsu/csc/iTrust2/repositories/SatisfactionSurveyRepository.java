package edu.ncsu.csc.iTrust2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ncsu.csc.iTrust2.models.User;
import edu.ncsu.csc.iTrust2.persistant.SatisfactionSurvey;

public interface SatisfactionSurveyRepository extends JpaRepository<SatisfactionSurvey, Long> {

    public List<SatisfactionSurvey> findByHcp ( final User hcp );

    public List<SatisfactionSurvey> findByPatient ( User patient );

    public List<SatisfactionSurvey> findByHcpAndPatient ( User hcp, User patient );
}
