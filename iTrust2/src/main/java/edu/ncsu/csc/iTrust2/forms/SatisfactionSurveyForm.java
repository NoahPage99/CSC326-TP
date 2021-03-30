package edu.ncsu.csc.iTrust2.forms;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import edu.ncsu.csc.iTrust2.models.User;
import edu.ncsu.csc.iTrust2.persistant.SatisfactionSurvey;

/**
 * Documents a Satisfaction survey in a form object and converts it to
 * Satusfaction
 *
 * @author laagamai
 *
 */
public class SatisfactionSurveyForm implements Serializable {
    /**
     * Serial Version of the Form. For the Serializable
     */
    private static final long serialVersionUID = 1L;
    /** id for survey form */
    private String            id;
    /** waiting room time */
    private int               timeWaitedWaitingRoom;
    /** exam room time */
    private int               timeWaitedExaminationRoom;
    /** satisfaction office visit rating */
    private int               satisfiedOfficeVisit;
    /** treatment rating */
    private int               satisfiedTreatment;

    /** notes from survey */
    @NotEmpty
    private String            notes;

//     @NotNull
//     @ManyToOne ( cascade = CascadeType.ALL )
//     @JoinColumn ( name = "patient_id", columnDefinition = "varchar(100)" )
    @NotEmpty
    private String            patient;

//     @NotNull
//     @ManyToOne ( cascade = CascadeType.ALL )
//     @JoinColumn ( name = "hcp_id", columnDefinition = "varchar(100)" )
    @NotEmpty
    private String            hcp;

    public String getPatient () {
        return patient;
    }

    public void setPatient ( final String patient ) {
        this.patient = patient;
    }

    public String getHcp () {
        return hcp;
    }

    public void setHcp ( final String hcp ) {
        this.hcp = hcp;
    }

    public SatisfactionSurveyForm () {

    }

    /**
     * Constructor for SS form
     *
     * @param ss
     *            satisfaction survey
     */
    public SatisfactionSurveyForm ( final SatisfactionSurvey ss ) {
        setPatient( ss.getPatient().getUsername() );
        setHcp( ss.getHcp().getUsername() );
        setNotes( ss.getNotes() );
        setId( ss.getId().toString() );
        setSatisfiedOfficeVisit( ss.getSatisfiedOfficeVisit() );
        setSatisfiedTreatment( ss.getSatisfiedTreatment() );
        setTimeWaitedExaminationRoom( ss.getTimeWaitedExaminationRoom() );
        setTimeWaitedWaitingRoom( ss.getTimeWaitedWaitingRoom() );
    }

    /**
     * getter for id
     *
     * @return the id
     */
    public String getId () {
        return id;
    }

    /**
     * setter for id
     *
     * @param id
     *            the id to set
     */
    public void setId ( final String id ) {
        this.id = id;
    }

    /**
     * getter for timed waiting room
     *
     * @return the timeWaitedWaitingRoom
     */
    public int getTimeWaitedWaitingRoom () {
        return timeWaitedWaitingRoom;
    }

    /**
     * setter for timed waiting room
     *
     * @param timeWaitedWaitingRoom
     *            the timeWaitedWaitingRoom to set
     */
    public void setTimeWaitedWaitingRoom ( final int timeWaitedWaitingRoom ) {
        this.timeWaitedWaitingRoom = timeWaitedWaitingRoom;
    }

    /**
     * getter for timed exam room
     *
     * @return the timeWaitedExaminationRoom
     */
    public int getTimeWaitedExaminationRoom () {
        return timeWaitedExaminationRoom;
    }

    /**
     * setter for timed exam room
     *
     * @param timeWaitedExaminationRoom
     *            the timeWaitedExaminationRoom to set
     */
    public void setTimeWaitedExaminationRoom ( final int timeWaitedExaminationRoom ) {
        this.timeWaitedExaminationRoom = timeWaitedExaminationRoom;
    }

    /**
     * getter for rating office visit
     *
     * @return the satisfiedOfficeVisit
     */
    public int getSatisfiedOfficeVisit () {
        return satisfiedOfficeVisit;
    }

    /**
     * setter for rating office visit
     *
     * @param satisfiedOfficeVisit
     *            the satisfiedOfficeVisit to set
     */
    public void setSatisfiedOfficeVisit ( final int satisfiedOfficeVisit ) {
        this.satisfiedOfficeVisit = satisfiedOfficeVisit;
    }

    /**
     * getter for rating treatment
     *
     * @return the satisfiedTreatment
     */
    public int getSatisfiedTreatment () {
        return satisfiedTreatment;
    }

    /**
     * setter for rating treatment
     *
     * @param satisfiedTreatment
     *            the satisfiedTreatment to set
     */
    public void setSatisfiedTreatment ( final int satisfiedTreatment ) {
        this.satisfiedTreatment = satisfiedTreatment;
    }

    /**
     * getter for notes
     *
     * @return the notes
     */
    public String getNotes () {
        return notes;
    }

    /**
     * setter for notes
     *
     * @param notes
     *            the notes to set
     */
    public void setNotes ( final String notes ) {
        this.notes = notes;
    }
}
