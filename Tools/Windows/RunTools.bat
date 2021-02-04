ECHO OFF
:MENU
CLS
ECHO  ##############################################
echo  #       Amethyst Unified Toolset : 1.0       #
ECHO  ##############################################
ECHO  #                                            #
ECHO  #     1 - RUN RELEASE BUILD                  #
ECHO  #     2 - RUN DEBUG BUILD                    #
ECHO  #     3 - RUN DEBUG BUILD (DEBUGGER)         #
ECHO  #     4 - RESET PROGRAM                      #
ECHO  #     5 - REMOVE PROGRAM BINARIES            #
ECHO  #     6 - OPEN COMMAND PROMPT HERE           #
ECHO  #     7 - HELP                               #
ECHO  #     8 - Exit RunTools.bat                  #
ECHO  #                                            #
ECHO  ##############################################
ECHO.
choice /N /C 12345678 /M "Enter an option [1-8] : "
IF errorlevel == 8 GOTO :EOF
IF errorlevel == 7 GOTO HELP
IF errorlevel == 6 GOTO RUN_P
IF errorlevel == 5 GOTO CLEAN_Prog
IF errorlevel == 4 GOTO CLEAN
IF errorlevel == 3 GOTO DEBUG
IF errorlevel == 2 GOTO DEBUG_N
IF errorlevel == 1 GOTO RELEASE

:RELEASE
start "Lamatshu: Release Build" java Launcher normal
ECHO Started the Release Build Successfully.
pause
GOTO MENU

:DEBUG_N
start "Lamatshu: Debug Build" java DebugLauncher normal
ECHO Started the Debug Build Successfully.
pause
GOTO MENU

:DEBUG
start "Amethyst: Debugger" java DebugLauncher debug
ECHO Started the Debugger Successfully.
pause
GOTO MENU

:CLEAN
@RD /s /q System
@RD /s /q Users
ECHO Cleaned up installation successfully!
pause
GOTO MENU

:CLEAN
@RD /s /q Amethyst
@RD /s /q *.java
ECHO Removed the Program Binaries Successfully!
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
ECHO THIS TOOL WILL HELP IN RUNNING AND DEBUGGING THE PROGRAM.
ECHO IT CONTAINS COMMANDS WHICH CAN BE EASILY ACCESSIBLE WHILE TESTING OR DEBUGGING.
ECHO NEW USERS ARE RECOMMENDED TO READ THE DEVELOPER DOCUMENTATION FIRST.
ECHO.
ECHO *******************************
ECHO.
ECHO THE TOOL CONTAINS THE FOLLOWING SECTIONS:
ECHO.
ECHO 1 - RUN RELEASE BUILD
ECHO     THE TOOL WILL BEGIN A NEW INSTANCE OF AMETHYST'S RELEASE BUILD.
ECHO.
ECHO 2 - RUN DEBUG BUILD
ECHO     THE TOOL WILL BEGIN A NEW INSTANCE OF AMETHYST'S DEBUG BUILD.
ECHO.
ECHO 3 - RUN DEBUG BUILD (DEBUGGER)
ECHO     THE TOOL WILL BEGIN A NEW INSTANCE OF AMETHYST'S DEBUGGER.
ECHO.
ECHO 4 - RESET PROGRAM
ECHO     THE "SYSTEM" AND "USERS" FOLDERS WILL BE DELETED IN BINARIES FOLDER.
ECHO.
ECHO 5 - REMOVE PROGRAM BINARIES
ECHO     THE FOLDER AMETHYST AND ALL JAVA FILES WILL BE DELETED.
ECHO.
ECHO 6 - OPEN COMMAND PROMPT HERE
ECHO     THE TOOL WILL BEGIN A NEW INSTANCE OF CMD IN THE CURRENT DIRECTORY.
ECHO.
ECHO 7 - HELP : WILL DISPLAY THIS HELP SECTION.
ECHO     THE TOOL WILL DISPLAY THIS HELP SECTION.
ECHO.
ECHO 8 - EXIT : EXIT THIS TOOL.
ECHO     EXIT THE TOOL AND RETURN TO WINDOWS.
ECHO.
ECHO *******************************
pause
GOTO MENU
