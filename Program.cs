using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Dynastream.Fit;
using System.IO;

namespace PeakswareTest
{
    class Program
    {
        private static Dictionary<double, ushort> _powerChannel;
        private static System.DateTime? _start;

        static void Main(string[] args)
        {
            Console.WriteLine("TrainingPeaks C# Code Test");

            if (args.Length != 1)
            {
                Console.WriteLine("Usage: PeakswareTest.exe <filename>");
                return;
            }

            // Attempt to open .FIT file
            using (var fitSource = new FileStream(args[0], FileMode.Open))
            {
                Console.WriteLine("Opening {0}", args[0]);

                _powerChannel = new Dictionary<double, ushort>();

                Decode decodeDemo = new Decode();
                MesgBroadcaster mesgBroadcaster = new MesgBroadcaster();

                // Connect the Broadcaster to our event source (in this case the Decoder)
                decodeDemo.MesgEvent += mesgBroadcaster.OnMesg;

                // Subscribe to message events of interest by connecting to the Broadcaster
                mesgBroadcaster.RecordMesgEvent += new MesgEventHandler(OnRecordMesg);
                mesgBroadcaster.FileIdMesgEvent += new MesgEventHandler(OnFileIDMesg);

                bool status = decodeDemo.IsFIT(fitSource);
                status = decodeDemo.CheckIntegrity(fitSource);
                // Process the file
                if (status == true)
                {
                    Console.WriteLine("Decoding...");
                    decodeDemo.Read(fitSource);

                    Console.WriteLine("Decoded FIT file {0}", args[0]);
                }
                else
                {
                    Console.WriteLine("Integrity Check Failed {0}", args[0]);
                    decodeDemo.Read(fitSource);
                }
            }
        }

        static void OnRecordMesg(object sender, MesgEventArgs e)
        {
            var record = (RecordMesg)e.mesg;

            var power = record.GetFieldValue("Power");

            if (power != null)
            {
                _powerChannel.Add(GetTimeOffset (record.GetTimestamp().GetDateTime()), (ushort)power);
            }
        }

        static double GetTimeOffset(System.DateTime date)
        {
            if (_start == null)
                return 0;

            return date.Subtract(_start.Value).TotalMilliseconds;
        }

        static void OnFileIDMesg(object sender, MesgEventArgs e)
        {
            FileIdMesg myFileId = (FileIdMesg)e.mesg;

            _start = myFileId.GetTimeCreated().GetDateTime();
        }
    }
}
