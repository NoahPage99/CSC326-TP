package edu.ncsu.csc.iTrust2.persistant;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

//import org.springframework.beans.factory.annotation.Autowired;

import edu.ncsu.csc.iTrust2.models.DomainObject;
import edu.ncsu.csc.iTrust2.models.User;

//import edu.ncsu.csc.iTrust2.services.SatisfactionSurveyService;
/**
 * Satisfaction Survey class takes care of all attributes for satisfaction
 * surveys like time waited in waiting and examination room, and satisfied
 * treatment and office visit. ID is managed by the database.
 *
 * @author awu3
 * @author dhnguye4
 * @author yli223
 * @author laagamai
 * @author ncpage
 * @author scheerl
 *
 */
@Entity
public class SatisfactionSurvey extends DomainObject {

    @NotNull
    @ManyToOne ( cascade = CascadeType.ALL )
    @JoinColumn ( name = "patient_id", columnDefinition = "varchar(100)" )
    private User   patient;

    @NotNull
    @ManyToOne ( cascade = CascadeType.ALL )
    @JoinColumn ( name = "hcp_id", columnDefinition = "varchar(100)" )
    private User   hcp;

    /** id */
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    private Long   id;

    /**
     * time waited in waiting room
     */
    @Min ( 0 )
    @Max ( 120 )
    private int    timeWaitedWaitingRoom;

    /**
     * time waited exam room
     */
    @Min ( 0 )
    @Max ( 120 )
    private int    timeWaitedExaminationRoom;

    /**
     * satisfaction of office visit
     */
    @Min ( 0 )
    @Max ( 10 )
    private int    satisfiedOfficeVisit;

    /**
     * satisfaction of treatment
     */
    @Min ( 0 )
    @Max ( 10 )
    private int    satisfiedTreatment;

    /**
     * notes on survey
     */
    private String notes;

    // /**
    //  * service to get averages
    //  */
    // @Autowired
    // private SatisfactionSurveyService service;

    /**
     * create a new default satisfaction survey
     */
    public SatisfactionSurvey () {
        
    }

    /**
     * create a new satisfaction surveys with all information
     *
     * @param timeWaitedWaitingRoom
     *            time waited in waiting room
     * @param timeWaitedExaminationRoom
     *            time waited in exam room
     * @param satisfiedOfficeVisit
     *            satisfied office visit
     * @param satisfiedTreatment
     *            satisfied treatment
     * @param notes
     *            on visit
     */
    public SatisfactionSurvey ( final int timeWaitedWaitingRoom, final int timeWaitedExaminationRoom,
            final int satisfiedOfficeVisit, final int satisfiedTreatment, final String notes, final User patient,
            final User hcp ) {
        this.setNotes( notes );
        this.setSatisfiedOfficeVisit( satisfiedOfficeVisit );
        this.setSatisfiedTreatment( satisfiedTreatment );
        this.setTimeWaitedExaminationRoom( timeWaitedExaminationRoom );
        this.setTimeWaitedWaitingRoom( timeWaitedWaitingRoom );
        this.setHcp( hcp );
        this.setPatient( patient );
    }

    /**
     * get the time waited in waiting room
     *
     * @return the time waited in waiting room
     */
    public int getTimeWaitedWaitingRoom () {
        return timeWaitedWaitingRoom;
    }

    /**
     * set time waited in waiting room
     *
     * @param timeWaitedWaitingRoom
     *            time waited in waiting room
     */
    public void setTimeWaitedWaitingRoom ( final int timeWaitedWaitingRoom ) {
        this.timeWaitedWaitingRoom = timeWaitedWaitingRoom;
    }

    /**
     * get the time waited in exam room
     *
     * @return the time waited in exam room
     */
    public int getTimeWaitedExaminationRoom () {
        return timeWaitedExaminationRoom;
    }

    /**
     * set time waited in exam room
     *
     * @param timeWaitedExaminationRoom
     *            time waited in exam room
     */
    public void setTimeWaitedExaminationRoom ( final int timeWaitedExaminationRoom ) {
        this.timeWaitedExaminationRoom = timeWaitedExaminationRoom;
    }

    /**
     * get how satisfied office visit
     *
     * @return satisfied office visit
     */
    public int getSatisfiedOfficeVisit () {
        return satisfiedOfficeVisit;
    }

    /**
     * set satisfied office visit
     *
     * @param satisfiedOfficeVisit
     *            satisfied office visit
     */
    public void setSatisfiedOfficeVisit ( final int satisfiedOfficeVisit ) {
        this.satisfiedOfficeVisit = satisfiedOfficeVisit;
    }

    /**
     * get how satisfied treatment
     *
     * @return satisfied treatment
     */
    public int getSatisfiedTreatment () {
        return satisfiedTreatment;
    }

    /**
     * set Satisfied Treatment
     *
     * @param satisfiedTreatment
     *            Satisfied Treatment
     */
    public void setSatisfiedTreatment ( final int satisfiedTreatment ) {
        this.satisfiedTreatment = satisfiedTreatment;
    }

    /**
     * get notes
     *
     * @return notes
     */
    public String getNotes () {
        return notes;
    }

    /**
     * set notes
     *
     * @param notes
     *            to set
     * @throws IllegalArgumentException
     *             if the notes are null, or greater than 500 characters
     */
    public void setNotes ( final String notes ) {
        if ( notes == null || notes.length() > 500 ) {
            throw new IllegalArgumentException( "Notes must be less than or equal to 500 characters" );
        }
        this.notes = notes;
    }

    // /**
    // * hashcode
    // */
    // @Override
    // public int hashCode () {
    // final int prime = 31;
    // int result = 1;
    // result = prime * result + ( ( notes == null ) ? 0 : notes.hashCode() );
    // result = prime * result + satisfiedOfficeVisit;
    // result = prime * result + satisfiedTreatment;
    // result = prime * result + timeWaitedExaminationRoom;
    // result = prime * result + timeWaitedWaitingRoom;
    // return result;
    // }

    /**
     * equals
     *
     * @return true if equals, false otherwise
     */
    @Override
    public boolean equals ( final Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final SatisfactionSurvey other = (SatisfactionSurvey) obj;
        if ( notes == null ) {
            if ( other.notes != null ) {
                return false;
            }
        }
        else if ( !notes.equals( other.notes ) ) {
            return false;
        }
        if ( satisfiedOfficeVisit != other.satisfiedOfficeVisit ) {
            return false;
        }
        if ( satisfiedTreatment != other.satisfiedTreatment ) {
            return false;
        }
        if ( timeWaitedExaminationRoom != other.timeWaitedExaminationRoom ) {
            return false;
        }
        if ( timeWaitedWaitingRoom != other.timeWaitedWaitingRoom ) {
            return false;
        }
        return true;
    }

    /**
     * toString
     *
     * @return string representation of survey
     */
    @Override
    public String toString () {
        return "SatisfactionSurvey [timeWaitedWaitingRoom=" + timeWaitedWaitingRoom + ", timeWaitedExaminationRoom="
                + timeWaitedExaminationRoom + ", satisfiedOfficeVisit=" + satisfiedOfficeVisit + ", satisfiedTreatment="
                + satisfiedTreatment + ", notes=" + notes + "]";
    }

    /**
     * Get the ID of survey
     *
     * @return the ID
     */
    @Override
    public Long getId () {
        return id;
    }

    /**
     * Set the ID of the survey (Used by Hibernate)
     *
     * @param id
     *            the ID
     */
    public void setId ( final Long id ) {
        this.id = id;
    }

    /**
     * @return the hcp
     */
    public User getHcp () {
        return hcp;
    }

    /**
     * @param hcp
     *            the hcp to set
     */
    public void setHcp ( final User hcp ) {
        this.hcp = hcp;
    }

    /**
     * @return the patient
     */
    public User getPatient () {
        return patient;
    }

    /**
     * @param patient
     *            the patient to set
     */
    public void setPatient ( final User patient ) {
        this.patient = patient;
    }

    // public double getAverageTimeWaitedWaitingRoom(User hcp){
    //     List<SatisfactionSurvey> surveys = service.findByHcp(hcp);
    //     double avg = 0;
    //     for(SatisfactionSurvey s:surveys){
    //         avg += s.getTimeWaitedWaitingRoom();
    //     }
    //     return avg/surveys.size();
    // }

    // public double getAverageTimeWaitedExaminationRoom(User hcp){
    //     List<SatisfactionSurvey> surveys = service.findByHcp(hcp);
    //     double avg = 0;
    //     for(SatisfactionSurvey s:surveys){
    //         avg += s.getTimeWaitedExaminationRoom();
    //     }
    //     return avg/surveys.size();
    // }

    // public double getAverageSatisfiedOfficeVisit(User hcp){
    //     List<SatisfactionSurvey> surveys = service.findByHcp(hcp);
    //     double avg = 0;
    //     for(SatisfactionSurvey s:surveys){
    //         avg += s.getSatisfiedOfficeVisit();
    //     }
    //     return avg/surveys.size();
    // }

    // public double getAverageSatisfiedTreatment(User hcp){
    //     List<SatisfactionSurvey> surveys = service.findByHcp(hcp);
    //     double avg = 0;
    //     for(SatisfactionSurvey s:surveys){
    //         avg += s.getSatisfiedTreatment();
    //     }
    //     return avg/surveys.size();
    // }
}
