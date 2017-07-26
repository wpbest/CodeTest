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
import java.math.BigInteger;


public class WeatherConditionsMesg extends Mesg {

   
   public static final int TimestampFieldNum = 253;
   
   public static final int WeatherReportFieldNum = 0;
   
   public static final int TemperatureFieldNum = 1;
   
   public static final int ConditionFieldNum = 2;
   
   public static final int WindDirectionFieldNum = 3;
   
   public static final int WindSpeedFieldNum = 4;
   
   public static final int PrecipitationProbabilityFieldNum = 5;
   
   public static final int TemperatureFeelsLikeFieldNum = 6;
   
   public static final int RelativeHumidityFieldNum = 7;
   
   public static final int LocationFieldNum = 8;
   
   public static final int ObservedAtTimeFieldNum = 9;
   
   public static final int ObservedLocationLatFieldNum = 10;
   
   public static final int ObservedLocationLongFieldNum = 11;
   
   public static final int DayOfWeekFieldNum = 12;
   
   public static final int HighTemperatureFieldNum = 13;
   
   public static final int LowTemperatureFieldNum = 14;
   

   protected static final  Mesg weatherConditionsMesg;
   static {
      // weather_conditions
      weatherConditionsMesg = new Mesg("weather_conditions", MesgNum.WEATHER_CONDITIONS);
      weatherConditionsMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "", false, Profile.Type.DATE_TIME));
      
      weatherConditionsMesg.addField(new Field("weather_report", WeatherReportFieldNum, 0, 1, 0, "", false, Profile.Type.WEATHER_REPORT));
      
      weatherConditionsMesg.addField(new Field("temperature", TemperatureFieldNum, 1, 1, 0, "C", false, Profile.Type.SINT8));
      
      weatherConditionsMesg.addField(new Field("condition", ConditionFieldNum, 0, 1, 0, "", false, Profile.Type.WEATHER_STATUS));
      
      weatherConditionsMesg.addField(new Field("wind_direction", WindDirectionFieldNum, 132, 1, 0, "degrees", false, Profile.Type.UINT16));
      
      weatherConditionsMesg.addField(new Field("wind_speed", WindSpeedFieldNum, 132, 1000, 0, "m/s", false, Profile.Type.UINT16));
      
      weatherConditionsMesg.addField(new Field("precipitation_probability", PrecipitationProbabilityFieldNum, 2, 1, 0, "", false, Profile.Type.UINT8));
      
      weatherConditionsMesg.addField(new Field("temperature_feels_like", TemperatureFeelsLikeFieldNum, 1, 1, 0, "C", false, Profile.Type.SINT8));
      
      weatherConditionsMesg.addField(new Field("relative_humidity", RelativeHumidityFieldNum, 2, 1, 0, "", false, Profile.Type.UINT8));
      
      weatherConditionsMesg.addField(new Field("location", LocationFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
      
      weatherConditionsMesg.addField(new Field("observed_at_time", ObservedAtTimeFieldNum, 134, 1, 0, "", false, Profile.Type.DATE_TIME));
      
      weatherConditionsMesg.addField(new Field("observed_location_lat", ObservedLocationLatFieldNum, 133, 1, 0, "semicircles", false, Profile.Type.SINT32));
      
      weatherConditionsMesg.addField(new Field("observed_location_long", ObservedLocationLongFieldNum, 133, 1, 0, "semicircles", false, Profile.Type.SINT32));
      
      weatherConditionsMesg.addField(new Field("day_of_week", DayOfWeekFieldNum, 0, 1, 0, "", false, Profile.Type.DAY_OF_WEEK));
      
      weatherConditionsMesg.addField(new Field("high_temperature", HighTemperatureFieldNum, 1, 1, 0, "C", false, Profile.Type.SINT8));
      
      weatherConditionsMesg.addField(new Field("low_temperature", LowTemperatureFieldNum, 1, 1, 0, "C", false, Profile.Type.SINT8));
      
   }

   public WeatherConditionsMesg() {
      super(Factory.createMesg(MesgNum.WEATHER_CONDITIONS));
   }

   public WeatherConditionsMesg(final Mesg mesg) {
      super(mesg);
   }


   /**
    * Get timestamp field
    * Comment: time of update for current conditions, else forecast time
    *
    * @return timestamp
    */
   public DateTime getTimestamp() {
      return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
   }

   /**
    * Set timestamp field
    * Comment: time of update for current conditions, else forecast time
    *
    * @param timestamp
    */
   public void setTimestamp(DateTime timestamp) {
      setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get weather_report field
    * Comment: Current or forecast
    *
    * @return weather_report
    */
   public WeatherReport getWeatherReport() {
      Short value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return WeatherReport.getByValue(value);
   }

   /**
    * Set weather_report field
    * Comment: Current or forecast
    *
    * @param weatherReport
    */
   public void setWeatherReport(WeatherReport weatherReport) {
      setFieldValue(0, 0, weatherReport.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get temperature field
    * Units: C
    *
    * @return temperature
    */
   public Byte getTemperature() {
      return getFieldByteValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set temperature field
    * Units: C
    *
    * @param temperature
    */
   public void setTemperature(Byte temperature) {
      setFieldValue(1, 0, temperature, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get condition field
    * Comment: Corresponds to GSC Response weatherIcon field
    *
    * @return condition
    */
   public WeatherStatus getCondition() {
      Short value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return WeatherStatus.getByValue(value);
   }

   /**
    * Set condition field
    * Comment: Corresponds to GSC Response weatherIcon field
    *
    * @param condition
    */
   public void setCondition(WeatherStatus condition) {
      setFieldValue(2, 0, condition.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get wind_direction field
    * Units: degrees
    *
    * @return wind_direction
    */
   public Integer getWindDirection() {
      return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set wind_direction field
    * Units: degrees
    *
    * @param windDirection
    */
   public void setWindDirection(Integer windDirection) {
      setFieldValue(3, 0, windDirection, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get wind_speed field
    * Units: m/s
    *
    * @return wind_speed
    */
   public Float getWindSpeed() {
      return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set wind_speed field
    * Units: m/s
    *
    * @param windSpeed
    */
   public void setWindSpeed(Float windSpeed) {
      setFieldValue(4, 0, windSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get precipitation_probability field
    * Comment: range 0-100
    *
    * @return precipitation_probability
    */
   public Short getPrecipitationProbability() {
      return getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set precipitation_probability field
    * Comment: range 0-100
    *
    * @param precipitationProbability
    */
   public void setPrecipitationProbability(Short precipitationProbability) {
      setFieldValue(5, 0, precipitationProbability, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get temperature_feels_like field
    * Units: C
    * Comment: Heat Index if  GCS heatIdx above or equal to 90F or wind chill if GCS windChill below or equal to 32F
    *
    * @return temperature_feels_like
    */
   public Byte getTemperatureFeelsLike() {
      return getFieldByteValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set temperature_feels_like field
    * Units: C
    * Comment: Heat Index if  GCS heatIdx above or equal to 90F or wind chill if GCS windChill below or equal to 32F
    *
    * @param temperatureFeelsLike
    */
   public void setTemperatureFeelsLike(Byte temperatureFeelsLike) {
      setFieldValue(6, 0, temperatureFeelsLike, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get relative_humidity field
    *
    * @return relative_humidity
    */
   public Short getRelativeHumidity() {
      return getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set relative_humidity field
    *
    * @param relativeHumidity
    */
   public void setRelativeHumidity(Short relativeHumidity) {
      setFieldValue(7, 0, relativeHumidity, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get location field
    * Comment: string corresponding to GCS response location string
    *
    * @return location
    */
   public String getLocation() {
      return getFieldStringValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set location field
    * Comment: string corresponding to GCS response location string
    *
    * @param location
    */
   public void setLocation(String location) {
      setFieldValue(8, 0, location, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get observed_at_time field
    *
    * @return observed_at_time
    */
   public DateTime getObservedAtTime() {
      return timestampToDateTime(getFieldLongValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
   }

   /**
    * Set observed_at_time field
    *
    * @param observedAtTime
    */
   public void setObservedAtTime(DateTime observedAtTime) {
      setFieldValue(9, 0, observedAtTime.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get observed_location_lat field
    * Units: semicircles
    *
    * @return observed_location_lat
    */
   public Integer getObservedLocationLat() {
      return getFieldIntegerValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set observed_location_lat field
    * Units: semicircles
    *
    * @param observedLocationLat
    */
   public void setObservedLocationLat(Integer observedLocationLat) {
      setFieldValue(10, 0, observedLocationLat, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get observed_location_long field
    * Units: semicircles
    *
    * @return observed_location_long
    */
   public Integer getObservedLocationLong() {
      return getFieldIntegerValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set observed_location_long field
    * Units: semicircles
    *
    * @param observedLocationLong
    */
   public void setObservedLocationLong(Integer observedLocationLong) {
      setFieldValue(11, 0, observedLocationLong, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get day_of_week field
    *
    * @return day_of_week
    */
   public DayOfWeek getDayOfWeek() {
      Short value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return DayOfWeek.getByValue(value);
   }

   /**
    * Set day_of_week field
    *
    * @param dayOfWeek
    */
   public void setDayOfWeek(DayOfWeek dayOfWeek) {
      setFieldValue(12, 0, dayOfWeek.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get high_temperature field
    * Units: C
    *
    * @return high_temperature
    */
   public Byte getHighTemperature() {
      return getFieldByteValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set high_temperature field
    * Units: C
    *
    * @param highTemperature
    */
   public void setHighTemperature(Byte highTemperature) {
      setFieldValue(13, 0, highTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get low_temperature field
    * Units: C
    *
    * @return low_temperature
    */
   public Byte getLowTemperature() {
      return getFieldByteValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set low_temperature field
    * Units: C
    *
    * @param lowTemperature
    */
   public void setLowTemperature(Byte lowTemperature) {
      setFieldValue(14, 0, lowTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

}
