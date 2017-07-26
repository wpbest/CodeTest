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


public enum HrZoneCalc {
   CUSTOM((short)0),
   PERCENT_MAX_HR((short)1),
   PERCENT_HRR((short)2),
    INVALID((short)255);

    protected short value;

    private HrZoneCalc(short value) {
        this.value = value;
    }

   public static HrZoneCalc getByValue(final Short value) {
      for (final HrZoneCalc type : HrZoneCalc.values()) {
         if (value == type.value)
            return type;
      }

      return HrZoneCalc.INVALID;
   }

    /**
     * Retrieves the String Representation of the Value
     * @return The string representation of the value
     */
   public static String getStringFromValue( HrZoneCalc value ) {
       return value.name();
   }

   public short getValue() {
      return value;
   }


}
