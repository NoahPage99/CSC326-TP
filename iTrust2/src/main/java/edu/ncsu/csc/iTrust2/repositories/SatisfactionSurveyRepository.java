package edu.ncsu.csc.iTrust2.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.ncsu.csc.iTrust2.models.User;
import edu.ncsu.csc.iTrust2.persistant.SatisfactionSurvey;

public interface SatisfactionSurveyRepository extends JpaRepository<SatisfactionSurvey, Long> {
    public List<SatisfactionSurvey> findByPatient ( User patient );

    public List<SatisfactionSurvey> findByHcp ( User hcp );

    final static String SURVEY_SELECT = " SELECT " + " AVG(time_waited_waiting_room)" + " as"
            + " averageTimeWaitedWaitingRoom," + " AVG(time_waited_examination_room)" + " as"
            + " averageTimeWaitedExaminationRoom," + " AVG(satisfied_office_visit)" + " as"
            + " averageSatisfiedOfficeVisit," + " AVG(satisfied_treatment)" + " as" + " averageSatisfiedTreatment";

    final static String SURVEY_FROM   = " FROM satisfaction_survey " + " WHERE hcp_id LIKE :hcpId ";

    final static String SURVEY_FILTER = " AND completed is TRUE ";

    @Query ( value = SURVEY_SELECT + SURVEY_FROM + SURVEY_FILTER, nativeQuery = true )
    public Map<String, String> getSurveyAveragesByHCP ( @Param ( "hcpId" ) String hcpId );

    @Query ( value = "SELECT notes " + SURVEY_FROM + SURVEY_FILTER, nativeQuery = true )
    public List<String> getSurveyNotesByHCP ( @Param ( "hcpId" ) String hcpId );

    @Query ( value = "SELECT AVG(completed) as averageCompleted " + SURVEY_FROM, nativeQuery = true )
    public Map<String, String> getSurveyAverageCompleted ( @Param ( "hcpId" ) String hcpId );

    @Query ( value = "SELECT hcp_id FROM satisfaction_survey WHERE completed = TRUE GROUP BY hcp_id",
            nativeQuery = true )
    public List<String> findAllProvidersWithSurveys ();
}
