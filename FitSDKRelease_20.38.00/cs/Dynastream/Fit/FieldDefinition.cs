#region Copyright
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

#endregion

namespace Dynastream.Fit
{
    /// <summary>
    ///
    /// </summary>
    public class FieldDefinition
    {
        #region Fields

        #endregion

        #region Properties
        // Opt for the simpler form until we need a backing field
        public byte Num { get; private set; }
        public byte Size { get; private set; }
        public byte Type { get; private set; }
        #endregion

        #region Constructors
        public FieldDefinition()
        {

        }

        public FieldDefinition(Field field)
        {
            Num = field.Num;
            Size = field.GetSize();
            Type = field.Type;
        }

        public FieldDefinition(byte newNum, byte newSize, byte newType)
        {
            Num = newNum;
            Size = newSize;
            Type = newType;
        }

        public FieldDefinition(FieldDefinition fieldDef)
        {
            Num = fieldDef.Num;
            Size = fieldDef.Size;
            Type = fieldDef.Type;
        }
        #endregion

        #region Methods

        #endregion
    }
} // namespace
