package edu.ncsu.csc.iTrust2.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.ncsu.csc.iTrust2.models.User;
import edu.ncsu.csc.iTrust2.persistant.SatisfactionSurvey;

public interface SatisfactionSurveyRepository extends JpaRepository<SatisfactionSurvey, Long> {

    public List<SatisfactionSurvey> findByHcp(final User hcp);

    public List<SatisfactionSurvey> findByPatient(User patient);

    public List<SatisfactionSurvey> findByHcpAndPatient(User hcp, User patient);

    final static String SURVEY_SELECT = " SELECT " + " AVG(completed)" + " as" + " averageCompleted,"
            + " AVG(time_waited_waiting_room)" + " as" + " averageTimeWaitedWaitingRoom,"
            + " AVG(time_waited_examination_room)" + " as" + " averageTimeWaitedExaminationRoom,"
            + " AVG(satisfied_office_visit)" + " as" + " averageSatisfiedOfficeVisit," 
            + " AVG(satisfied_treatment)" + " as" + " averageSatisfiedTreatment";

    final static String SURVEY_FROM = " FROM satisfaction_survey " + " WHERE hcp_id LIKE :hcpId "
            + "AND completed is TRUE";

    @Query(value = SURVEY_SELECT + SURVEY_FROM, nativeQuery = true)
    Map<String, String> getSurveyAggByHCP(@Param("hcpId") String hcpId);

    @Query(value = "SELECT notes " + SURVEY_FROM, nativeQuery = true)
    List<String> getHCPNotes(@Param("userName") String userName);
}
