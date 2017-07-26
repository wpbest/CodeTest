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
    /// Implements the profile AutoActivityDetect type as a class
    /// </summary>
    public static class AutoActivityDetect 
    {
        public const uint None = 0x00000000;
        public const uint Running = 0x00000001;
        public const uint Cycling = 0x00000002;
        public const uint Swimming = 0x00000004;
        public const uint Walking = 0x00000008;
        public const uint Elliptical = 0x00000020;
        public const uint Sedentary = 0x00000400;
        public const uint Invalid = (uint)0xFFFFFFFF;


    }
}

