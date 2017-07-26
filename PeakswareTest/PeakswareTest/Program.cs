using System;

namespace PeakswareTest
{
    class Program
    {
        static void Main(string[] args)
        {
            var fit = new FIT();
            var average = fit.CalculateAverage();
            Console.WriteLine("Average = {0:f20}", average);
            Console.WriteLine("Press any key to continue...");
            Console.ReadLine();
        }
    }
}