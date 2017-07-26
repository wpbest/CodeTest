This application does the basic work of parsing a fit file, using the Dynastream C# SDK, 
to capture the power channel as an offset from start.

1. Write the most efficient method that finds the "best" 20 minute power effort.  
   "Best" as defined as highest continuous average for the given time period.

2. Find the 1, 5, 10, 15, and 20 minute "best" efforts using the method above using multiple threads.

3. This program was purposely written without best practices in mind. Rewrite and refactor to 
   use best practices, parse additional channels such as heart rate and speed, and
   use OO for a cleaner approach.

4. Bonus: See if you can find the subtle bug in this program.

5. If you have any questions on the code or what is being asked, please don't hesitate to email.

6. Please submit your complted test as a zip file, private dropbox or other file sharing link, 
   or using a private repo. Do not include compiled binaries.


FIT File Background
------------------------------------------------------------------------------------------
The FIT file format, developed by Dyanstream, is a common format used by fitness devices
to store fitness data. The format is message based, with each message having a timestamp
and one or more data "channels" depending on the device and accessories being used.

Channel data may include GPS, heart rate, power, distance or speed to name a few common
ones. When paired with a power meter, FIT messages are sampled at a constant rate, typically
once every second.

A single file will contain mulitple channels and each channel has different data and 
data structures (byte, ushort, etc.)