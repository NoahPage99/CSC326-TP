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

import edu.ncsu.csc.iTrust2.models.Hospital;
import edu.ncsu.csc.iTrust2.models.enums.AppointmentType;
import edu.ncsu.csc.iTrust2.models.enums.Disease;
import edu.ncsu.csc.iTrust2.models.enums.HouseholdSmokingStatus;
import edu.ncsu.csc.iTrust2.models.enums.PatientSmokingStatus;
import edu.ncsu.csc.iTrust2.persistant.OphOfficeVisit;

/**
 * Documents a Ophthalmology Office Visit in a form object and converts it to
 * Ophthalmology Office Visit
 *
 * @author laagamai
 *
 */
public class OphOfficeVisitForm implements Serializable {
    /**
     * Serial Version of the Form. For the Serializable
     */
    private static final long      serialVersionUID = 1L;

    /**
     * Name of the Patient involved in the OfficeVisit
     */
    @NotEmpty
    private String                 patient;

    /**
     * Name of the HCP involved in the OfficeVisit
     */
    @NotEmpty
    private String                 hcp;

    /**
     * Date at which the OfficeVisit occurred
     */
    @NotEmpty
    public String                  date;

    /**
     * time
     */
    @NotEmpty
    public String                  time;

    /**
     * ID of the OfficeVisit
     */
    private Long                   id;

    /**
     * Type of the OfficeVisit.
     */
    @NotEmpty
    public AppointmentType         type;

    /**
     * Hospital where the OfficeVisit occurred
     */
    @NotEmpty
    public Hospital                hospital;

    /**
     * Doctor's Notes on the OfficeVisit
     */
    @Length ( max = 255 )
    private String                 notes;

    /**
     * Whether the OfficeVisit was prescheduled or not
     */
    public String                  preScheduled;

    /**
     * Height or length of the person. Up to a 3-digit number and potentially
     * one digit of decimal precision. > 0
     */
    private Float                  height;

    /**
     * Weight of the person. Up to a 3-digit number and potentially one digit of
     * decimal precision. > 0
     */
    private Float                  weight;

    /**
     * Head circumference of the person. Up to a 3-digit number and potentially
     * one digit of decimal precision. > 0
     */
    private Float                  headCircumference;

    /**
     * Systolic blood pressure. 3-digit positive number.
     */
    private Integer                systolic;

    /**
     * Diastolic blood pressure. 3-digit positive number.
     */
    private Integer                diastolic;

    /**
     * HDL cholesterol. Between 0 and 90 inclusive.
     */
    private Integer                hdl;

    /**
     * LDL cholesterol. Between 0 and 600 inclusive.
     */
    private Integer                ldl;

    /**
     * Triglycerides cholesterol. Between 100 and 600 inclusive.
     */
    private Integer                tri;

    /**
     * Smoking status of the patient's household.
     */
    private HouseholdSmokingStatus houseSmokingStatus;

    /**
     * Smoking status of the patient.
     */
    private PatientSmokingStatus   patientSmokingStatus;

    /**
     * Diagnoses associated with this visit
     */
    private List<DiagnosisForm>    diagnoses;

    private List<PrescriptionForm> prescriptions;

    /**
     * left eye acuity
     */
    private int                    lEyeAcuity;
    /**
     * right eye acuity
     */
    private int                    rEyeAcuity;
    /**
     * left eye sphere
     */
    private double                 lEyeSphere;
    /**
     * right eye sphere
     */
    private double                 rEyeSphere;
    /**
     * left eye cylinder
     */
    private double                 lEyeCyl;
    /**
     * right eye cylinder
     */
    private double                 rEyeCyl;
    /**
     * left eye axis
     */
    private int                    lEyeAxis;
    /**
     * right eye axis
     */
    private int                    rEyeAxis;

    private Long                   appointmentId;

    /**
     * @return the appointmentId
     */
    public Long getAppointmentId () {
        return appointmentId;
    }

    /**
     * @param appointmentId
     *            the appointmentId to set
     */
    public void setAppointmentId ( Long appointmentId ) {
        this.appointmentId = appointmentId;
    }

    /**
     * The diseases that were diagnosed from the visit
     */
    @ElementCollection ( targetClass = Disease.class, fetch = FetchType.EAGER )
    @Enumerated ( EnumType.STRING )
    private Set<Disease> diseases;

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
     * Gets the ID of the OfficeVisit
     *
     * @return ID of the Visit
     */
    public Long getId () {
        return this.id;
    }

    /**
     * Sets the ID of the OfficeVisit
     *
     * @param id
     *            The ID of the OfficeVisit
     */
    public void setId ( final Long id ) {
        this.id = id;
    }

    /**
     * Get the patient in the OfficeVisit
     *
     * @return The patient's username
     */
    public String getPatient () {
        return this.patient;
    }

    /**
     * Sets a patient on the OfficeVisitForm
     *
     * @param patient
     *            The patient's username
     */
    public void setPatient ( final String patient ) {
        this.patient = patient;
    }

    /**
     * Retrieves the HCP on the OfficeVisit
     *
     * @return Username of the HCP on the OfficeVisit
     */
    public String getHcp () {
        return this.hcp;
    }

    /**
     * Set a HCP on the OfficeVisitForm
     *
     * @param hcp
     *            The HCP's username
     */
    public void setHcp ( final String hcp ) {
        this.hcp = hcp;
    }

    /**
     * Retrieves the date that the OfficeVisit occurred at
     *
     * @return Date of the OfficeVisit
     */
    public String getDate () {
        return this.date;
    }

    /**
     * Sets the date that the OfficeVisit occurred at
     *
     * @param date
     *            The date of the office visit
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
     * Get the Notes on the OfficeVisit
     *
     * @return The notes of the Visit
     */
    public String getNotes () {
        return this.notes;
    }

    /**
     * Set the notes on the OfficeVisit
     *
     * @param notes
     *            New notes
     */
    public void setNotes ( final String notes ) {
        this.notes = notes;
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
    public AppointmentType getType () {
        return type;
    }

    /**
     * Set the type of this office visit
     *
     * @param type
     *            the type to set this office visit to
     */
    public void setType ( final AppointmentType type ) {
        this.type = type;
    }

    /**
     * Get the hospital of this office visit
     *
     * @return the hospital of this office visit
     */
    public Hospital getHospital () {
        return hospital;
    }

    /**
     * Set the hospital of this office visit
     *
     * @param hospital
     *            the hospital to set this office visit to
     */
    public void setHospital ( final Hospital hospital ) {
        this.hospital = hospital;
    }

    /**
     * Sets whether the visit was prescheduled
     *
     * @param prescheduled
     *            Whether the Visit is prescheduled or not
     */
    public void setPreScheduled ( final String prescheduled ) {
        this.preScheduled = prescheduled;
    }

    /**
     * Gets whether the visit was prescheduled or not
     *
     * @return Whether the visit was prescheduled
     */
    public String getPreScheduled () {
        return this.preScheduled;
    }

    /**
     * Gets the diastolic blood pressure
     *
     * @return the diastolic
     */
    public Integer getDiastolic () {
        return diastolic;
    }

    /**
     * Sets the diastolic blood pressure
     *
     * @param diastolic
     *            the diastolic to set
     */
    public void setDiastolic ( final Integer diastolic ) {
        this.diastolic = diastolic;
    }

    /**
     * Gets the systolic blood pressure
     *
     * @return the systolic
     */
    public Integer getSystolic () {
        return systolic;
    }

    /**
     * Sets the systolic blood pressure
     *
     * @param systolic
     *            the systolic to set
     */
    public void setSystolic ( final Integer systolic ) {
        this.systolic = systolic;
    }

    /**
     * Gets HDL cholesterol.
     *
     * @return the hdl
     */
    public Integer getHdl () {
        return hdl;
    }

    /**
     * Sets HDL cholesterol. Between 0 and 90 inclusive.
     *
     * @param hdl
     *            the hdl to set
     */
    public void setHdl ( final Integer hdl ) {
        this.hdl = hdl;
    }

    /**
     * Gets the LDL cholesterol.
     *
     * @return the ldl
     */
    public Integer getLdl () {
        return ldl;
    }

    /**
     * Sets LDL cholesterol. Between 0 and 600 inclusive.
     *
     * @param ldl
     *            the ldl to set
     */
    public void setLdl ( final Integer ldl ) {
        this.ldl = ldl;
    }

    /**
     * Gets triglycerides level.
     *
     * @return the tri
     */
    public Integer getTri () {
        return tri;
    }

    /**
     * Sets triglycerides cholesterol. Between 100 and 600 inclusive.
     *
     * @param tri
     *            the tri to set
     */
    public void setTri ( final Integer tri ) {
        this.tri = tri;
    }

    /**
     * Gets the height
     *
     * @return the height
     */
    public Float getHeight () {
        return height;
    }

    /**
     * Sets the height
     *
     * @param height
     *            the height to set
     */
    public void setHeight ( final Float height ) {
        this.height = height;
    }

    /**
     * Gets the weight
     *
     * @return the weight
     */
    public Float getWeight () {
        return weight;
    }

    /**
     * Sets the weight
     *
     * @param weight
     *            the weight to set
     */
    public void setWeight ( final Float weight ) {
        this.weight = weight;
    }

    /**
     * Gets the head circumference
     *
     * @return the weight
     */
    public Float getHeadCircumference () {
        return headCircumference;
    }

    /**
     * Sets the headCircumference
     *
     * @param headCircumference
     *            the headCircumference to set
     */
    public void setHeadCircumference ( final Float headCircumference ) {
        this.headCircumference = headCircumference;
    }

    /**
     * Gets the smoking status of the patient's household.
     *
     * @return the houseSmokingStatus
     */
    public HouseholdSmokingStatus getHouseSmokingStatus () {
        return houseSmokingStatus;
    }

    /**
     * Sets the smoking status of the patient's household.
     *
     * @param houseSmokingStatus
     *            the houseSmokingStatus to set
     */
    public void setHouseSmokingStatus ( final HouseholdSmokingStatus houseSmokingStatus ) {
        this.houseSmokingStatus = houseSmokingStatus;
    }

    /**
     * Gets the smoking status of the patient.
     *
     * @return the patientSmokingStatus
     */
    public PatientSmokingStatus getPatientSmokingStatus () {
        return patientSmokingStatus;
    }

    /**
     * Sets the smoking status of the patient.
     *
     * @param patientSmokingStatus
     *            the patientSmokingStatus to set
     */
    public void setPatientSmokingStatus ( final PatientSmokingStatus patientSmokingStatus ) {
        this.patientSmokingStatus = patientSmokingStatus;
    }

}
