ECHO OFF
:MENU
CLS
ECHO  **********************************************
ECHO  *    AMETHYST Tools : Unified Toolset 2.0    *
ECHO  **********************************************
ECHO  *                                            *
ECHO  *     1 - Compile Program                    *
ECHO  *     2 - Compile Launcher                   *
ECHO  *     3 - Compile DebugLauncher              *
ECHO  *     4 - Compile Program Documentation      *
ECHO  *     5 - Open Command Prompt Here           *
ECHO  *     6 - Help                               *
ECHO  *     7 - Exit Tools.bat                     *
ECHO  *                                            *
ECHO  **********************************************
ECHO.
choice /N /C 1234567 /M "Enter an option [1-7] : "
IF errorlevel == 7 GOTO :EOF
IF errorlevel == 6 GOTO HELP
IF errorlevel == 5 GOTO RUN_P
IF errorlevel == 4 GOTO C_DOC
IF errorlevel == 3 GOTO C_DLNCH
IF errorlevel == 2 GOTO C_LNCH
IF errorlevel == 1 GOTO C_PRG

:C_PRG
javac -d ../Binaries ./Amethyst/Core/Boot.java
ECHO Tip: Compile the Launcher for launching the program.
pause
GOTO MENU

:C_LNCH
javac -d ../Binaries/ Launcher.java
ECHO Tip: Compile the Program to run the program.
pause
GOTO MENU

:C_DLNCH
javac -d ../Binaries/ DebugLauncher.java
ECHO Tip: Compile the Program to debug the program.
pause
GOTO MENU

:C_DOC
dir /s /B *.java > sources.txt
javadoc -d ../Documentation/Program_Documentation @sources.txt > DocumentationLog.log
del /s /q sources.txt
echo Note: Documentation can be accessed via the "Index.html" in the root of project folder
pause
GOTO MENU

:RUN_P
START cmd.exe
GOTO MENU

:HELP
CLS
ECHO _______________________________
ECHO.
ECHO    RunTools.bat Help Section 
ECHO _______________________________
ECHO.
ECHO.
ECHO HELP DOCUMENT: 1.0
ECHO TIME TO READ : 2 MINUTES
ECHO.
ECHO *******************************
ECHO.
ECHO THIS TOOL WILL HELP IN COMPILING THE PROGRAM AND THE LAUNCHERS.
ECHO IT CONTAINS COMMANDS WHICH CAN BE EASILY ACCESSIBLE WHEN MODIFYING, OPTIMIZING AND BUILDING THE PROGRAM.
ECHO NEW USERS ARE RECOMMENDED TO READ THE DEVELOPER DOCUMENTATION FIRST.
ECHO.
ECHO *******************************
ECHO.
ECHO THE TOOL CONTAINS THE FOLLOWING SECTIONS:
ECHO.
ECHO 1 - COMPILE RELEASE BUILD
ECHO     THE TOOL WILL COMPILE BINARIES FROM AMETHYST'S SOURCE CODE.
ECHO.
ECHO 2 - COMPILE LAUNCHER
ECHO     THE TOOL WILL COMPILE THE RELEASE READY LAUNCHER FOR THE PROGRAM.
ECHO.
ECHO 3 - COMPILE DEBUGLAUNCHER
ECHO     THE TOOL WILL COMPILE THE DEBUG LAUNCHER (AND DEBUGGER) FOR THE PROGRAM.
ECHO.
ECHO 4 - COMPILE DOCUMENTATION
ECHO     THE TOOL WILL COMPILE THE PROGRAM DOCUMENTATION (AND DISPLAY ERRORS IF ANY)
ECHO.
ECHO 5 - OPEN COMMAND PROMPT HERE
ECHO     THE TOOL WILL BEGIN A NEW INSTANCE OF CMD IN THE CURRENT DIRECTORY.
ECHO.
ECHO 6 - HELP : WILL DISPLAY THIS HELP SECTION.
ECHO     THE TOOL WILL DISPLAY THIS HELP SECTION.
ECHO.
ECHO 7 - EXIT : EXIT THIS TOOL.
ECHO     EXIT THE TOOL AND RETURN TO WINDOWS.
ECHO.
ECHO *******************************
pause
GOTO MENU