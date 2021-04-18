package edu.ncsu.csc.iTrust2.forms;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import edu.ncsu.csc.iTrust2.models.enums.Disease;
import edu.ncsu.csc.iTrust2.persistant.OphOfficeVisit;

/**
 * Documents a Ophthalmology Office Visit in a form object and converts it to
 * Ophthalmology Office Visit
 *
 * @author laagamai
 *
 */
public class OphOfficeVisitForm extends OfficeVisitForm implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * left eye acuity
     */
    private int lEyeAcuity;
    /**
     * right eye acuity
     */
    private int rEyeAcuity;
    /**
     * left eye sphere
     */
    private double lEyeSphere;
    /**
     * right eye sphere
     */
    private double rEyeSphere;
    /**
     * left eye cylinder
     */
    private double lEyeCyl;
    /**
     * right eye cylinder
     */
    private double rEyeCyl;
    /**
     * left eye axis
     */
    private int lEyeAxis;
    /**
     * right eye axis
     */
    private int rEyeAxis;

    private Long appointmentId;

    /**
     * @return the appointmentId
     */
    public Long getAppointmentId() {
        return appointmentId;
    }

    /**
     * @param appointmentId the appointmentId to set
     */
    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     * The diseases that were diagnosed from the visit
     */
    @ElementCollection(targetClass = Disease.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Disease> diseases;

    public OphOfficeVisitForm() {
        super();
    }

    public OphOfficeVisitForm(final OphOfficeVisit oov) {
        super(oov);

        setlEyeAcuity(oov.getlEyeAcuity());
        setrEyeAcuity(oov.getrEyeAcuity());
        setlEyeSphere(oov.getlEyeSphere());
        setrEyeSphere(oov.getrEyeSphere());
        setlEyeCyl(oov.getlEyeCyl());
        setrEyeCyl(oov.getrEyeCyl());
        setlEyeAxis(oov.getlEyeAxis());
        setrEyeAxis(oov.getrEyeAxis());
        
        this.diseases = new HashSet<Disease>();
    }

    /**
     * @return the lEyeAcuity
     */
    public int getlEyeAcuity() {
        return lEyeAcuity;
    }

    /**
     * @param lEyeAcuity the lEyeAcuity to set
     */
    public void setlEyeAcuity(final int lEyeAcuity) {
        this.lEyeAcuity = lEyeAcuity;
    }

    /**
     * @return the rEyeAcuity
     */
    public int getrEyeAcuity() {
        return rEyeAcuity;
    }

    /**
     * @param rEyeAcuity the rEyeAcuity to set
     */
    public void setrEyeAcuity(final int rEyeAcuity) {
        this.rEyeAcuity = rEyeAcuity;
    }

    /**
     * @return the lEyeSphere
     */
    public double getlEyeSphere() {
        return lEyeSphere;
    }

    /**
     * @param lEyeSphere the lEyeSphere to set
     */
    public void setlEyeSphere(double lEyeSphere) {
        final DecimalFormat numberFormat = new DecimalFormat("0.0");
        lEyeSphere = Double.parseDouble(numberFormat.format(lEyeSphere));
        this.lEyeSphere = lEyeSphere;
    }

    /**
     * @return the rEyeSphere
     */
    public double getrEyeSphere() {
        return rEyeSphere;
    }

    /**
     * @param rEyeSphere the rEyeSphere to set
     */
    public void setrEyeSphere(double rEyeSphere) {
        final DecimalFormat numberFormat = new DecimalFormat("0.0");
        rEyeSphere = Double.parseDouble(numberFormat.format(rEyeSphere));
        this.rEyeSphere = rEyeSphere;
    }

    /**
     * @return the lEyeCyl
     */
    public double getlEyeCyl() {
        return lEyeCyl;
    }

    /**
     * @param lEyeCyl the lEyeCyl to set
     */
    public void setlEyeCyl(double lEyeCyl) {
        final DecimalFormat numberFormat = new DecimalFormat("0.0");
        lEyeCyl = Double.parseDouble(numberFormat.format(lEyeCyl));
        this.lEyeCyl = lEyeCyl;
    }

    /**
     * @return the rEyeCyl
     */
    public double getrEyeCyl() {
        return rEyeCyl;
    }

    /**
     * @param rEyeCyl the rEyeCyl to set
     */
    public void setrEyeCyl(double rEyeCyl) {
        final DecimalFormat numberFormat = new DecimalFormat("0.0");
        rEyeCyl = Double.parseDouble(numberFormat.format(rEyeCyl));
        this.rEyeCyl = rEyeCyl;
    }

    /**
     * @return the lEyeAxis
     */
    public int getlEyeAxis() {
        return lEyeAxis;
    }

    /**
     * @param lEyeAxis the lEyeAxis to set
     */
    public void setlEyeAxis(final int lEyeAxis) {
        this.lEyeAxis = lEyeAxis;
    }

    /**
     * @return the rEyeAxis
     */
    public int getrEyeAxis() {
        return rEyeAxis;
    }

    /**
     * @param rEyeAxis the rEyeAxis to set
     */
    public void setrEyeAxis(final int rEyeAxis) {
        this.rEyeAxis = rEyeAxis;
    }

}
