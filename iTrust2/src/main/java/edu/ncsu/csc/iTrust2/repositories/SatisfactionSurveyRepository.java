package edu.ncsu.csc.iTrust2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ncsu.csc.iTrust2.models.User;
import edu.ncsu.csc.iTrust2.persistant.SatisfactionSurvey;

public interface SatisfactionSurveyRepository extends JpaRepository<SatisfactionSurvey, Long> {

    /**
     * find by hcp
     * 
     * @param hcp to find
     * @return found list
     */
    public List<SatisfactionSurvey> findByHcp(final User hcp);

    /**
     * find by patient
     * 
     * @param patient to find
     * @return found list
     */
    public List<SatisfactionSurvey> findByPatient(User patient);

    /**
     * find by hcp + patient
     * 
     * @param hcp     to find
     * @param patient to find
     * @return found list
     */
    public List<SatisfactionSurvey> findByHcpAndPatient(User hcp, User patient);
}
