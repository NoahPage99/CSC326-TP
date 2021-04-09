package edu.ncsu.csc.iTrust2.forms;

import java.text.DecimalFormat;
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

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import edu.ncsu.csc.iTrust2.models.enums.Disease;
import edu.ncsu.csc.iTrust2.persistant.OphOfficeVisit;

/**
 * Documents a Ophthalmology Office Visit in a form object and converts it to
 * Ophthalmology Office Visit
 *
 * @author laagamai
 *
 */
public class OphOfficeVisitForm extends OfficeVisitForm {
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
    @Length ( max = 255 )
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
    private double            lEyeSphere;
    /**
     * right eye sphere
     */
    private double            rEyeSphere;
    /**
     * left eye cylinder
     */
    private double            lEyeCyl;
    /**
     * right eye cylinder
     */
    private double            rEyeCyl;
    /**
     * left eye axis
     */
    private int               lEyeAxis;
    /**
     * right eye axis
     */
    private int               rEyeAxis;
    /**
     * The type of this office visit
     */
    @NotEmpty
    private String            type;
    /**
     * The hospital of this office visit
     */
    @NotEmpty
    private String            hospital;

    /**
     * The diseases that were diagnosed from the visit
     */
    @ElementCollection ( targetClass = Disease.class, fetch = FetchType.EAGER )
    @Enumerated ( EnumType.STRING )
    private Set<Disease>      diseases;

    /**
     * Whether the OfficeVisit was prescheduled or not
     */
    public String             preScheduled;

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
    public OphOfficeVisitForm ( final OphOfficeVisit oov ) {
        setPatient( oov.getPatient().getUsername() );
        setHcp( oov.getHcp().getUsername() );
        setNotes( oov.getNotes() );
        setDate( oov.getDate().toString() );
        setTime( oov.getTime() );
        setlEyeAcuity( oov.getlEyeAcuity() );
        setrEyeAcuity( oov.getrEyeAcuity() );
        setlEyeSphere( oov.getlEyeSphere() );
        setrEyeSphere( oov.getrEyeSphere() );
        setlEyeCyl( oov.getlEyeCyl() );
        setrEyeCyl( oov.getrEyeCyl() );
        setlEyeAxis( oov.getlEyeAxis() );
        setrEyeAxis( oov.getrEyeAxis() );
        this.diseases = new HashSet<Disease>();
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
    public double getlEyeSphere () {
        return lEyeSphere;
    }

    /**
     * @param lEyeSphere
     *            the lEyeSphere to set
     */
    public void setlEyeSphere ( double lEyeSphere ) {
        final DecimalFormat numberFormat = new DecimalFormat( "0.0" );
        lEyeSphere = Double.parseDouble( numberFormat.format( lEyeSphere ) );
        this.lEyeSphere = lEyeSphere;
    }

    /**
     * @return the rEyeSphere
     */
    public double getrEyeSphere () {
        return rEyeSphere;
    }

    /**
     * @param rEyeSphere
     *            the rEyeSphere to set
     */
    public void setrEyeSphere ( double rEyeSphere ) {
        final DecimalFormat numberFormat = new DecimalFormat( "0.0" );
        rEyeSphere = Double.parseDouble( numberFormat.format( rEyeSphere ) );
        this.rEyeSphere = rEyeSphere;
    }

    /**
     * @return the lEyeCyl
     */
    public double getlEyeCyl () {
        return lEyeCyl;
    }

    /**
     * @param lEyeCyl
     *            the lEyeCyl to set
     */
    public void setlEyeCyl ( double lEyeCyl ) {
        final DecimalFormat numberFormat = new DecimalFormat( "0.0" );
        lEyeCyl = Double.parseDouble( numberFormat.format( lEyeCyl ) );
        this.lEyeCyl = lEyeCyl;
    }

    /**
     * @return the rEyeCyl
     */
    public double getrEyeCyl () {
        return rEyeCyl;
    }

    /**
     * @param rEyeCyl
     *            the rEyeCyl to set
     */
    public void setrEyeCyl ( double rEyeCyl ) {
        final DecimalFormat numberFormat = new DecimalFormat( "0.0" );
        rEyeCyl = Double.parseDouble( numberFormat.format( rEyeCyl ) );
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

    /**
     * Get the type of this office visit
     *
     * @return the type of this office visit
     */
    @Override
    public String getType () {
        return type;
    }

    /**
     * Set the type of this office visit
     *
     * @param type
     *            the type to set this office visit to
     */
    @Override
    public void setType ( final String type ) {
        this.type = type;
    }

    /**
     * Get the hospital of this office visit
     *
     * @return the hospital of this office visit
     */
    @Override
    public String getHospital () {
        return hospital;
    }

    /**
     * Set the hospital of this office visit
     *
     * @param hospital
     *            the hospital to set this office visit to
     */
    @Override
    public void setHospital ( final String hospital ) {
        this.hospital = hospital;
    }

    /**
     * Sets whether the visit was prescheduled
     *
     * @param prescheduled
     *            Whether the Visit is prescheduled or not
     */
    @Override
    public void setPreScheduled ( final String prescheduled ) {
        this.preScheduled = prescheduled;
    }

    /**
     * Gets whether the visit was prescheduled or not
     *
     * @return Whether the visit was prescheduled
     */
    @Override
    public String getPreScheduled () {
        return this.preScheduled;
    }

}
