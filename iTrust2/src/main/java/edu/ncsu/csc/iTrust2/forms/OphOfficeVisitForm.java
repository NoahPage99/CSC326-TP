package edu.ncsu.csc.iTrust2.forms;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import edu.ncsu.csc.iTrust2.models.enums.Disease;

/**
 * Documents a Ophthalmology Office Visit in a form object and converts it to
 * Ophthalmology Office Visit
 *
 * @author laagamai
 *
 */
public class OphOfficeVisitForm {
    /**
     * Serial Version of the Form. For the Serializable
     */
    @SuppressWarnings ( "unused" )
    private static final long serialVersionUID = 1L;
    /** id for survey form */
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    private String            id;

    /** notes from survey */
    @NotEmpty
    private String            notes;

    @NotNull
    @ManyToOne ( cascade = CascadeType.ALL )
    // @JoinColumn ( name = "patient_id", columnDefinition = "varchar(100)" )
    // @NotEmpty
    private String            patient;

    @NotNull
    @ManyToOne ( cascade = CascadeType.ALL )
    // @JoinColumn ( name = "hcp_id", columnDefinition = "varchar(100)" )
    // @NotEmpty
    private String            hcp;

    /**
     * date
     */
    @NotEmpty
    private String            date;
    /**
     * time
     */
    @NotEmpty
    private String            time;
    /**
     * left eye acuity
     */
    private int               lEyeAcuity;
    /**
     * right eye acuity
     */
    private int               rEyeAcuity;
    /**
     * left eye sphere
     */
    private int               lEyeSphere;
    /**
     * right eye sphere
     */
    private int               rEyeSphere;
    /**
     * left eye cylinder
     */
    private int               lEyeCyl;
    /**
     * right eye cylinder
     */
    private int               rEyeCyl;
    /**
     * left eye axis
     */
    private int               lEyeAxis;
    /**
     * right eye axis
     */
    private int               rEyeAxis;

    /**
     * The diseases that were diagnosed from the visit
     */
    @ElementCollection ( targetClass = Disease.class, fetch = FetchType.EAGER )
    @Enumerated ( EnumType.STRING )
    private Set<Disease>      diseases;

    public OphOfficeVisitForm () {

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
    public OphOfficeVisitForm ( @NotNull final String patient, @NotNull final String hcp, final String notes,
            final String date, final String time, final int lEyeAcuity, final int rEyeAcuity, final int lEyeSphere,
            final int rEyeSphere, final int lEyeCyl, final int rEyeCyl, final int lEyeAxis, final int rEyeAxis ) {
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
     * @return the id
     */
    public String getId () {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId ( final String id ) {
        this.id = id;
    }

    /**
     * @return the notes
     */
    public String getNotes () {
        return notes;
    }

    /**
     * @param notes
     *            the notes to set
     */
    public void setNotes ( final String notes ) {
        this.notes = notes;
    }

    /**
     * @return the patient
     */
    public String getPatient () {
        return patient;
    }

    /**
     * @param patient
     *            the patient to set
     */
    public void setPatient ( final String patient ) {
        this.patient = patient;
    }

    /**
     * @return the hcp
     */
    public String getHcp () {
        return hcp;
    }

    /**
     * @param hcp
     *            the hcp to set
     */
    public void setHcp ( final String hcp ) {
        this.hcp = hcp;
    }

    /**
     * @return the date
     */
    public String getDate () {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate ( final String date ) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime () {
        return time;
    }

    /**
     * @param time
     *            the time to set
     */
    public void setTime ( final String time ) {
        this.time = time;
    }

    /**
     * @return the lEyeAcuity
     */
    public int getlEyeAcuity () {
        return lEyeAcuity;
    }

    /**
     * @param lEyeAcuity
     *            the lEyeAcuity to set
     */
    public void setlEyeAcuity ( final int lEyeAcuity ) {
        this.lEyeAcuity = lEyeAcuity;
    }

    /**
     * @return the rEyeAcuity
     */
    public int getrEyeAcuity () {
        return rEyeAcuity;
    }

    /**
     * @param rEyeAcuity
     *            the rEyeAcuity to set
     */
    public void setrEyeAcuity ( final int rEyeAcuity ) {
        this.rEyeAcuity = rEyeAcuity;
    }

    /**
     * @return the lEyeSphere
     */
    public int getlEyeSphere () {
        return lEyeSphere;
    }

    /**
     * @param lEyeSphere
     *            the lEyeSphere to set
     */
    public void setlEyeSphere ( final int lEyeSphere ) {
        this.lEyeSphere = lEyeSphere;
    }

    /**
     * @return the rEyeSphere
     */
    public int getrEyeSphere () {
        return rEyeSphere;
    }

    /**
     * @param rEyeSphere
     *            the rEyeSphere to set
     */
    public void setrEyeSphere ( final int rEyeSphere ) {
        this.rEyeSphere = rEyeSphere;
    }

    /**
     * @return the lEyeCyl
     */
    public int getlEyeCyl () {
        return lEyeCyl;
    }

    /**
     * @param lEyeCyl
     *            the lEyeCyl to set
     */
    public void setlEyeCyl ( final int lEyeCyl ) {
        this.lEyeCyl = lEyeCyl;
    }

    /**
     * @return the rEyeCyl
     */
    public int getrEyeCyl () {
        return rEyeCyl;
    }

    /**
     * @param rEyeCyl
     *            the rEyeCyl to set
     */
    public void setrEyeCyl ( final int rEyeCyl ) {
        this.rEyeCyl = rEyeCyl;
    }

    /**
     * @return the lEyeAxis
     */
    public int getlEyeAxis () {
        return lEyeAxis;
    }

    /**
     * @param lEyeAxis
     *            the lEyeAxis to set
     */
    public void setlEyeAxis ( final int lEyeAxis ) {
        this.lEyeAxis = lEyeAxis;
    }

    /**
     * @return the rEyeAxis
     */
    public int getrEyeAxis () {
        return rEyeAxis;
    }

    /**
     * @param rEyeAxis
     *            the rEyeAxis to set
     */
    public void setrEyeAxis ( final int rEyeAxis ) {
        this.rEyeAxis = rEyeAxis;
    }

}
