package edu.ncsu.csc.iTrust2.persistant;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import edu.ncsu.csc.iTrust2.models.OfficeVisit;
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
public class OphOfficeVisit extends OfficeVisit {

    /**
     * time
     */
    private String       time;

    /**
     * left eye acuity
     */
    @Min ( 10 )
    @Max ( 200 )
    private int          lEyeAcuity;
    /**
     * right eye acuity
     */
    @Min ( 10 )
    @Max ( 200 )
    private int          rEyeAcuity;
    /**
     * left eye sphere
     */
    private double       lEyeSphere;
    /**
     * right eye sphere
     */
    private double       rEyeSphere;
    /**
     * left eye cylinder
     */
    private double       lEyeCyl;
    /**
     * right eye cylinder
     */
    private double       rEyeCyl;
    /**
     * left eye axis
     */
    @Min ( 1 )
    @Max ( 180 )
    private int          lEyeAxis;
    /**
     * right eye axis
     */
    @Min ( 1 )
    @Max ( 180 )
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
     */
    public OphOfficeVisit ( @NotNull final User patient, @NotNull final User hcp, final String notes, final String date,
            final String time, final int lEyeAcuity, final int rEyeAcuity, final int lEyeSphere, final int rEyeSphere,
            final int lEyeCyl, final int rEyeCyl, final int lEyeAxis, final int rEyeAxis ) {
        this.setPatient( patient );
        this.setHcp( hcp );
        this.setNotes( notes );

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
    public double getlEyeSphere () {
        return lEyeSphere;
    }

    /**
     * set left
     *
     * @param lEyeSphere
     *            the lEyeSphere to set
     */
    public void setlEyeSphere ( double lEyeSphere ) {
        final DecimalFormat numberFormat = new DecimalFormat( "0.0" );
        lEyeSphere = Double.parseDouble( numberFormat.format( lEyeSphere ) );
        this.lEyeSphere = lEyeSphere;
    }

    /**
     * get right
     *
     * @return the rEyeSphere
     */
    public double getrEyeSphere () {
        return rEyeSphere;
    }

    /**
     * set right
     *
     * @param rEyeSphere
     *            the rEyeSphere to set
     */
    public void setrEyeSphere ( double rEyeSphere ) {
        final DecimalFormat numberFormat = new DecimalFormat( "0.0" );
        rEyeSphere = Double.parseDouble( numberFormat.format( rEyeSphere ) );
        this.rEyeSphere = rEyeSphere;
    }

    /**
     * get left
     *
     * @return the lEyeCyl
     */
    public double getlEyeCyl () {
        return lEyeCyl;
    }

    /**
     * set left
     *
     * @param lEyeCyl
     *            the lEyeCyl to set
     */
    public void setlEyeCyl ( double lEyeCyl ) {
        final DecimalFormat numberFormat = new DecimalFormat( "0.0" );
        lEyeCyl = Double.parseDouble( numberFormat.format( lEyeCyl ) );
        this.lEyeCyl = lEyeCyl;
    }

    /**
     * get right
     *
     * @return the rEyeCyl
     */
    public double getrEyeCyl () {
        return rEyeCyl;
    }

    /**
     * set right
     *
     * @param rEyeCyl
     *            the rEyeCyl to set
     */
    public void setrEyeCyl ( double rEyeCyl ) {
        final DecimalFormat numberFormat = new DecimalFormat( "0.0" );
        rEyeCyl = Double.parseDouble( numberFormat.format( rEyeCyl ) );
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
