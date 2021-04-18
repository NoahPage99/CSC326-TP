package edu.ncsu.csc.iTrust2.models.enums;

/**
 * Set of diseases for Oph Office Visit
 *
 * @author awu3
 * @author dhnguye4
 * @author yli223
 * @author laagamai
 * @author ncpage
 * @author scheerl
 *
 */
public enum Disease {
    CATARACTS ( 1 ), AGE_RELATED_MACULAR_DEGENERATION ( 2 ), AMBLYOPIA ( 3 ), GLAUCOMA ( 4 );

    /**
     * Numerical code of the AppointmentType
     */
    private int code;

    /**
     * Creates the AppointmentType from its code.
     *
     * @param code
     *            Code of the AppointmentType
     */
    private Disease ( final int code ) {
        this.code = code;
    }

    /**
     * Gets the numerical code of the AppointmentType
     *
     * @return Code of the AppointmentType
     */
    public int getCode () {
        return code;
    }
}
