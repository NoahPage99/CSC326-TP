package edu.ncsu.csc.iTrust2.persistant;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import edu.ncsu.csc.iTrust2.models.DomainObject;
import edu.ncsu.csc.iTrust2.models.User;
import edu.ncsu.csc.iTrust2.models.enums.Disease;

/**
 * OphOfficeVisit creates an instance of an Ophthalmology office visit,
 * providing the necessary functionality for this specialized type of office
 * visit
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
public class OphOfficeVisit extends DomainObject {
    @NotNull
    @ManyToOne ( cascade = CascadeType.ALL )
    @JoinColumn ( name = "patient_id", columnDefinition = "varchar(100)" )
    private User         patient;

    @NotNull
    @ManyToOne ( cascade = CascadeType.ALL )
    @JoinColumn ( name = "hcp_id", columnDefinition = "varchar(100)" )
    private User         hcp;

    /** id */
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    private Long         id;

    /**
     * notes on visit
     */
    private String       notes;

    /**
     * date
     */
    private String       date;
    /**
     * time
     */
    private String       time;
    /**
     * left eye acuity
     */
    private int          lEyeAcuity;
    /**
     * right eye acuity
     */
    private int          rEyeAcuity;
    /**
     * left eye sphere
     */
    private int          lEyeSphere;
    /**
     * right eye sphere
     */
    private int          rEyeSphere;
    /**
     * left eye cylinder
     */
    private int          lEyeCyl;
    /**
     * right eye cylinder
     */
    private int          rEyeCyl;
    /**
     * left eye axis
     */
    private int          lEyeAxis;
    /**
     * right eye axis
     */
    private int          rEyeAxis;

    /**
     * The diseases that were diagnosed from the visit
     */
    @ElementCollection ( targetClass = Disease.class, fetch = FetchType.EAGER )
    @Enumerated ( EnumType.STRING )
    private Set<Disease> diseases;

    /**
     * Default constructor for office visit
     */
    public OphOfficeVisit () {

    }

    /**
     * Overridden constructor with all information
     *
     * @param patient
     *            patient for visit
     * @param hcp
     *            hcp hosting the visit
     * @param id
     *            id for visit
     * @param notes
     *            notes for visit
     * @param date
     *            date of visit
     * @param time
     *            of visit
     * @param lEyeAcuity
     *            acuity of patient
     * @param rEyeAcuity
     *            acuity of patient
     * @param lEyeSphere
     *            sphere of patient
     * @param rEyeSphere
     *            sphere of patient
     * @param lEyeCyl
     *            cylinder of patient
     * @param rEyeCyl
     *            cylinder of patient
     * @param lEyeAxis
     *            axis of patient
     * @param rEyeAxis
     *            axis of patient
     * @param diseases
     *            diseases diagnosed of patient
     */
    public OphOfficeVisit ( @NotNull final User patient, @NotNull final User hcp, final String notes, final String date,
            final String time, final int lEyeAcuity, final int rEyeAcuity, final int lEyeSphere, final int rEyeSphere,
            final int lEyeCyl, final int rEyeCyl, final int lEyeAxis, final int rEyeAxis ) {
        this.setPatient( patient );
        this.setHcp( hcp );
        this.setNotes( notes );
        this.setDate( date );
        this.setTime( time );
        this.setlEyeAcuity( lEyeAcuity );
        this.setrEyeAcuity( rEyeAcuity );
        this.setlEyeSphere( lEyeSphere );
        this.setrEyeSphere( rEyeSphere );
        this.setlEyeCyl( lEyeCyl );
        this.setrEyeCyl( rEyeCyl );
        this.setlEyeAxis( lEyeAxis );
        this.setrEyeAxis( rEyeAxis );
        this.diseases = new HashSet<Disease>();
    }

    /**
     * Get the ID of visit
     *
     * @return the ID
     */
    @Override
    public Long getId () {
        return id;
    }

    /**
     * Set the ID of the visit (Used by Hibernate)
     *
     * @param id
     *            the ID
     */
    public void setId ( final Long id ) {
        this.id = id;
    }

    /**
     * get patient
     *
     * @return the patient
     */
    public User getPatient () {
        return patient;
    }

    /**
     * set patient
     *
     * @param patient
     *            the patient to set
     */
    public void setPatient ( final User patient ) {
        this.patient = patient;
    }

    /**
     * get hcp
     *
     * @return the hcp
     */
    public User getHcp () {
        return hcp;
    }

    /**
     * set hcp
     *
     * @param hcp
     *            the hcp to set
     */
    public void setHcp ( final User hcp ) {
        this.hcp = hcp;
    }

    /**
     * get notes
     *
     * @return the notes
     */
    public String getNotes () {
        return notes;
    }

    /**
     * set notes
     *
     * @param notes
     *            the notes to set
     */
    public void setNotes ( final String notes ) {
        this.notes = notes;
    }

    /**
     * get date
     *
     * @return the date
     */
    public String getDate () {
        return date;
    }

    /**
     * set date
     *
     * @param date
     *            the date to set
     */
    public void setDate ( final String date ) {
        this.date = date;
    }

    /**
     * get time
     *
     * @return the time
     */
    public String getTime () {
        return time;
    }

    /**
     * set time
     *
     * @param time
     *            the time to set
     */
    public void setTime ( final String time ) {
        this.time = time;
    }

    /**
     * get left
     *
     * @return the lEyeAcuity
     */
    public int getlEyeAcuity () {
        return lEyeAcuity;
    }

    /**
     * set left
     *
     * @param lEyeAcuity
     *            the lEyeAcuity to set
     */
    public void setlEyeAcuity ( final int lEyeAcuity ) {
        this.lEyeAcuity = lEyeAcuity;
    }

    /**
     * get right
     *
     * @return the rEyeAcuity
     */
    public int getrEyeAcuity () {
        return rEyeAcuity;
    }

    /**
     * set right
     *
     * @param rEyeAcuity
     *            the rEyeAcuity to set
     */
    public void setrEyeAcuity ( final int rEyeAcuity ) {
        this.rEyeAcuity = rEyeAcuity;
    }

    /**
     * get left
     *
     * @return the lEyeSphere
     */
    public int getlEyeSphere () {
        return lEyeSphere;
    }

    /**
     * set left
     *
     * @param lEyeSphere
     *            the lEyeSphere to set
     */
    public void setlEyeSphere ( final int lEyeSphere ) {
        this.lEyeSphere = lEyeSphere;
    }

    /**
     * get right
     *
     * @return the rEyeSphere
     */
    public int getrEyeSphere () {
        return rEyeSphere;
    }

    /**
     * set right
     *
     * @param rEyeSphere
     *            the rEyeSphere to set
     */
    public void setrEyeSphere ( final int rEyeSphere ) {
        this.rEyeSphere = rEyeSphere;
    }

    /**
     * get left
     *
     * @return the lEyeCyl
     */
    public int getlEyeCyl () {
        return lEyeCyl;
    }

    /**
     * set left
     *
     * @param lEyeCyl
     *            the lEyeCyl to set
     */
    public void setlEyeCyl ( final int lEyeCyl ) {
        this.lEyeCyl = lEyeCyl;
    }

    /**
     * get right
     *
     * @return the rEyeCyl
     */
    public int getrEyeCyl () {
        return rEyeCyl;
    }

    /**
     * set right
     *
     * @param rEyeCyl
     *            the rEyeCyl to set
     */
    public void setrEyeCyl ( final int rEyeCyl ) {
        this.rEyeCyl = rEyeCyl;
    }

    /**
     * get left
     *
     * @return the lEyeAxis
     */
    public int getlEyeAxis () {
        return lEyeAxis;
    }

    /**
     * set left
     *
     * @param lEyeAxis
     *            the lEyeAxis to set
     */
    public void setlEyeAxis ( final int lEyeAxis ) {
        this.lEyeAxis = lEyeAxis;
    }

    /**
     * get right
     *
     * @return the rEyeAxis
     */
    public int getrEyeAxis () {
        return rEyeAxis;
    }

    /**
     * set right
     *
     * @param rEyeAxis
     *            the rEyeAxis to set
     */
    public void setrEyeAxis ( final int rEyeAxis ) {
        this.rEyeAxis = rEyeAxis;
    }

    public void addDisease ( final Disease disease ) {
        if ( null == this.diseases ) {
            this.diseases = new HashSet<Disease>();
        }
        this.diseases.add( disease );
    }

}
