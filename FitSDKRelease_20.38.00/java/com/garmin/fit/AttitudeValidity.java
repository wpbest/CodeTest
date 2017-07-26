////////////////////////////////////////////////////////////////////////////////
// The following FIT Protocol software provided may be used with FIT protocol
// devices only and remains the copyrighted property of Dynastream Innovations Inc.
// The software is being provided on an "as-is" basis and as an accommodation,
// and therefore all warranties, representations, or guarantees of any kind
// (whether express, implied or statutory) including, without limitation,
// warranties of merchantability, non-infringement, or fitness for a particular
// purpose, are specifically disclaimed.
//
// Copyright 2017 Dynastream Innovations Inc.
////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 20.38Release
// Tag = production/akw/20.38.00-0-geccbce3
////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

public class AttitudeValidity {
    public static final int TRACK_ANGLE_HEADING_VALID = 0x0001;
    public static final int PITCH_VALID = 0x0002;
    public static final int ROLL_VALID = 0x0004;
    public static final int LATERAL_BODY_ACCEL_VALID = 0x0008;
    public static final int NORMAL_BODY_ACCEL_VALID = 0x0010;
    public static final int TURN_RATE_VALID = 0x0020;
    public static final int HW_FAIL = 0x0040;
    public static final int MAG_INVALID = 0x0080;
    public static final int NO_GPS = 0x0100;
    public static final int GPS_INVALID = 0x0200;
    public static final int SOLUTION_COASTING = 0x0400;
    public static final int TRUE_TRACK_ANGLE = 0x0800;
    public static final int MAGNETIC_HEADING = 0x1000;
    public static final int INVALID = Fit.UINT16_INVALID;

    private static final Map<Integer, String> stringMap;

    static {
        stringMap = new HashMap<Integer, String>();
        stringMap.put(TRACK_ANGLE_HEADING_VALID, "TRACK_ANGLE_HEADING_VALID");
        stringMap.put(PITCH_VALID, "PITCH_VALID");
        stringMap.put(ROLL_VALID, "ROLL_VALID");
        stringMap.put(LATERAL_BODY_ACCEL_VALID, "LATERAL_BODY_ACCEL_VALID");
        stringMap.put(NORMAL_BODY_ACCEL_VALID, "NORMAL_BODY_ACCEL_VALID");
        stringMap.put(TURN_RATE_VALID, "TURN_RATE_VALID");
        stringMap.put(HW_FAIL, "HW_FAIL");
        stringMap.put(MAG_INVALID, "MAG_INVALID");
        stringMap.put(NO_GPS, "NO_GPS");
        stringMap.put(GPS_INVALID, "GPS_INVALID");
        stringMap.put(SOLUTION_COASTING, "SOLUTION_COASTING");
        stringMap.put(TRUE_TRACK_ANGLE, "TRUE_TRACK_ANGLE");
        stringMap.put(MAGNETIC_HEADING, "MAGNETIC_HEADING");
    }


    /**
     * Retrieves the String Representation of the Value
     * @return The string representation of the value, or empty if unknown
     */
    public static String getStringFromValue( Integer value ) {
        if( stringMap.containsKey( value ) ) {
            return stringMap.get( value );
        }

        return "";
    }

    /**
     * Retrieves a value given a string representation
     * @return The value or INVALID if unkwown
     */
    public static Integer getValueFromString( String value ) {
        for( Map.Entry<Integer, String> entry : stringMap.entrySet() ) {
            if( entry.getValue().equals( value ) ) {
                return entry.getKey();
            }
        }

        return INVALID;
    }

}
