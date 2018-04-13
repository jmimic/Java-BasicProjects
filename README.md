# Java small projects
Assumes correct syntax. Simple and small projects. <br /> 
Applications were Exported from Eclipse, and wrapped into an Executable by Launch4j. <br />

## Bounce Application
Note: Uses Swing & AWT (Contains quite a few bugs, not going to bother fixing an animation application)<br />
Run BounceApp.exe  //src for source code <br />
Animations of Shapes bouncing around a window. (GUI)<br />
1) Set Shape
2) Set Animation type
3) Click on Start
4) Click on screen to have the animation begin

Optional: May only select a shape whilst the application has 'Started' <br />
* Right-click to open option to clear screen <br />
* Set Height, Width, Pen-width values of the shape (press Enter for every value change) <br />
* Set Colour of the Shape's Border <br />

## ConcurrentArraySum.java
Concurrency performance comparison <br />
Produces a list of values representing Runtime by Threads <br />
BASELINE: uses array, stores each cell the sm of an array slice <br />
SYNCHROINIZED: baseline but acquires lock before accessing array of sums <br />
VOLATILE: uses single volatile variable to sum up array values <br />
LOCAL: summing scheme that avoids majority of access of shared data <br />

## Coordinates Distance
Run Coordinates Distance.exe  //src for source code <br />
Note: JUnit testing files included  //src/JUnit testing files for source code <br />
Point-to-point location on Earth distance calculator using Haversine formula (CUI) <br />
Uses origin and destination longtitude and latitude coordinates <br />

## Foreign Exchange
Run forex.exe  //src for source code <br />
Currency exchange calculator (CUI)
1) List saved set of Currency abbreviations
2) Add a Currency 
3) Show an Exchange Rate
4) Convert an Amount

Note: Program is stateless/does not retain information from session, assumes correct input syntax. <br />

================================================================================= <br />
================================================================================= <br />

# Handling Exceptions in Java
https://stackify.com/best-practices-exceptions-java/ <br />
http://www.codinghell.ch/blog/2013/03/31/how-and-when-not-to-use-exceptions/ <br />
* Try & Catch for a series of functions <br />
* While(conditional/boolean) for a variable change in while-loop <br />
* Exceptions are not Errors, and may still get through thus instead of Exception e, do Throwable e <br />
# Building executable from .jar export
## Set path for Java in System Environment Variables
//Skip if already done previously <br /> 
//Assuming Java Runtime Environment is located in C:\ drive <br /> 
Open a command prompt window using "Run as administrator” <br /> 
Type the following: <br /> 
1) C:\>assoc .jar=jarfile
2) C:\>ftype jarfile="C:\Program Files\Java\jre\bin\javaw.exe" -jar "%1" %*
3) C:\>ftype jarfile="C:\path\to\your\javaw.exe" -jar "%1" %*
## Make a .bat file from notepad to execute .jar file
Open notepad, and type the following <br /> 
* java -jar jarFileName.jar <br />

Save the textfile as .bat file, in same directory as .jar file <br /> <br />
# Reverse engineering (view source code)
Open .exe with Winrar or 7zip <br />
Decompile <br />
## Slow down Reverse engineering
Chuck in crap code, confusing variable names (final version), Obfuscation, Server-side <br />
http://www.ssware.com/articles/protect-and-obfuscate-your-dotnet-code-against-reverse-engineering-using-crypto-obfuscator.htm <br />
or rely on the law <br />
