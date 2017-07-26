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

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.zip.CheckedOutputStream;

/**
 * Encodes message objects into a FIT binary file.
 *
 */
public class FileEncoder implements MesgListener, MesgDefinitionListener {
   private File file;
   private CheckedOutputStream out;
   private CRC16 crc16;
   private MesgDefinition lastMesgDefinition[] = new MesgDefinition[Fit.MAX_LOCAL_MESGS];
   private Fit.ProtocolVersion version;
   private Validator validator;

   public FileEncoder() {
   }

   /**
    * Constructs a new File Encoder for specified file. Forces
    * ProtocolVersion.V1_0
    *
    * @deprecated Encoder now supports encoding files of differing protocol
    * versions, use {@link #FileEncoder(File, Fit.ProtocolVersion)} to ensure
    * the encoder is validating your files correctly
    *
    * @param file
    *           File to write
    */
   @Deprecated
   public FileEncoder(File file) {
      // Default the Version to 1.0 for backwards compatibility
      this.version = Fit.ProtocolVersion.V1_0;
      validator = new ProtocolValidator(version);
      open(file);
   }

   /**
    * Constructs a new File Encoder for specified file
    *
    * @param file
    *           File to write
    * @param version
    *           Fit Protocol Version to use when writing files
    */
   public FileEncoder(File file, Fit.ProtocolVersion version) {
      this.version = version;
      validator = new ProtocolValidator(version);
      open(file);
   }

   /**
    * Opens file for writing. If the file already exists it will be overwritten.
    *
    * @param file
    *           file to write
    */
   public void open(File file) {

      file.delete();
      crc16 = new CRC16();
      this.file = file;

      writeFileHeader();
      try {
         out = new CheckedOutputStream(new FileOutputStream(this.file, true), crc16); // Open output stream to write messages.
      } catch (java.io.IOException e) {
         throw new FitRuntimeException(e);
      }
   }

   /**
    * Writes the file header.
    */
   private void writeFileHeader() {
      if (file == null)
         throw new FitRuntimeException("File not open.");

      try {
         RandomAccessFile raf = new RandomAccessFile(file, "rw");
         long dataSize = file.length() - Fit.FILE_HDR_SIZE;
         int nextByte = 0;
         int crc = 0;

         if (dataSize < 0)
            dataSize = 0;

         for (int i = 0; i < (Fit.FILE_HDR_SIZE - 2); i++) {
            switch (i) {
               case 0:  nextByte = Fit.FILE_HDR_SIZE;                break;
               case 1:  nextByte = version.getVersion();             break;
               case 2:  nextByte = (Fit.PROFILE_VERSION & 0xFF);     break;
               case 3:  nextByte = (Fit.PROFILE_VERSION >> 8);       break;
               case 4:  nextByte = (int) (dataSize & 0xFF);          break;
               case 5:  nextByte = (int) ((dataSize >> 8) & 0xFF);   break;
               case 6:  nextByte = (int) ((dataSize >> 16) & 0xFF);  break;
               case 7:  nextByte = (int) ((dataSize >> 24) & 0xFF);  break;
               case 8:  nextByte = '.';                              break;
               case 9:  nextByte = 'F';                              break;
               case 10: nextByte = 'I';                              break;
               case 11: nextByte = 'T';                              break;
               default:                                              break;
            }

            raf.write(nextByte);
            crc = CRC.get16(crc, (byte) nextByte);
         }

         raf.write(crc & 0xFF);
         raf.write((crc >> 8) & 0xFF);
         raf.close();
      } catch (java.io.IOException e) {
         throw new FitRuntimeException(e);
      }
   }

   /**
    * MesgListener interface.
    */
   public void onMesg(Mesg mesg) {
      write(mesg);
   }

   /**
    * MesgDefinitionListener interface.
    */
   public void onMesgDefinition(MesgDefinition mesgDefinition) {
      write(mesgDefinition);
   }

   /**
    * Writes a message definition to the file.
    *
    * @param mesgDefinition
    *           message definition object to write
    */
   public void write(MesgDefinition mesgDefinition) {
      if (file == null)
         throw new FitRuntimeException("File not open.");

      if(!validator.validateMesgDefn(mesgDefinition))
         throw new FitRuntimeException("Incompatible Protocol Features");

      mesgDefinition.write(out);
      lastMesgDefinition[mesgDefinition.localNum] = mesgDefinition;
   }

   /**
    * Writes a message to the file.
    * Automatically writes message definition if required.
    *
    * @param mesg
    *           message object to write
    */
   public void write(Mesg mesg) {
      if (file == null)
         throw new FitRuntimeException("File not open.");

      if(!validator.validateMesg(mesg))
         throw new FitRuntimeException("Incompatible Protocol Features");

      if ((lastMesgDefinition[mesg.localNum] == null) || !lastMesgDefinition[mesg.localNum].supports(mesg)) {
         write(new MesgDefinition(mesg));
      }

      mesg.write(out, lastMesgDefinition[mesg.localNum]);
   }

   /**
    * Writes a list of messages to the file.
    *
    * @param mesgs
    *           list message objects to write
    */
   public void write(List<Mesg> mesgs) {
      for (Mesg mesg : mesgs) {
         write(mesg);
      }
   }

   /**
    * Updates the data size in the file header, writes the CRC, and closes the file.
    */
   public void close() {
      if (file == null)
         throw new FitRuntimeException("File not open.");

      try {
          // Set the data size in the file header.
          writeFileHeader();

         // Write the CRC.
         long crc = out.getChecksum().getValue();
         out.write((int) (crc & 0xFF));
         out.write((int) ((crc >> 8) & 0xFF));

         out.close();
         file = null;
      } catch (java.io.IOException e) {
         throw new FitRuntimeException(e);
      }
   }
}
