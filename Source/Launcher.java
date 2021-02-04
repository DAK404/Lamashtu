// ================================================= //
// ! DO NOT DELETE ! DO NOT DELETE ! DO NOT DELETE !
// ================================================= //

/*
*           THIS CODE HAS NOT BEEN TESTED.
*       DO NOT INCLUDE THIS CODE IN RELEASES
*      COMPILE WITH DEBUG BUILDS AND CHECK FOR
*                  ISSUES AND BUGS.
*/

// ================================================= //
// ! DO NOT DELETE ! DO NOT DELETE ! DO NOT DELETE !
// ================================================= //


public class Launcher
{
	public static void main(String[] Args)throws Exception
	{
		try
		{
			//Infinite loop to spawn program until exit condition is met
			while(true)
			{				
				//Clean up before execution
				System.gc();
				
				
				//Spawn a ProcessBuilder called session_monitor to track the process's exit code
				ProcessBuilder session_monitor=new ProcessBuilder("java", "Amethyst.Core.Boot", Args[0]);
				//Spawn a process with  called process_monitor to start the new process
				Process process_monitor= session_monitor.inheritIO().start();
				//Wait for the process to complete its execution before it passes on to shunt logic
				process_monitor.waitFor();
				
				
				
				//Monitor and determine the type of program's exit, along with the consequence of each process's exit.
				/* 
				* +---------------------------------------------------------------------------------------------------+
				* |                                   --- EXIT CODE TABLE ---                                         |
				* +-------------+----------------------------+--------------------------------------------------------+
				* | ERROR CODE  |       MEANING              |      DESCRIPTION                                       |
				* +-------------+----------------------------+--------------------------------------------------------+
				* |     0       |   NORMAL EXIT MODE         |  Instructs the SessionManager to quit the program      |
				* |     1       |   RESTART MODE             |  Instructs the program to respawn the process          |
				* |     2       |   ERROR EXIT MODE          |  Instructs the program to exit due to an error         |
				* |     3       |   ERROR RESTART MODE       |  Instructs the program to restart due to an error      |
				* |    101      |   INVALID BOOT MODE        |  Exits the system when the bootmode is not correct     |
				* |    400      |   RESERVED EXIT MODE       |  Reserved here to implement future functionalities     |
				* +-------------+----------------------------+--------------------------------------------------------+
				* 
				* *DEBUGGER CODE NOT AVAILABLE TO THE PUBLIC
				*/
					
				switch(process_monitor.exitValue())
				{
					case 0:
							//Normal exit mode
							System.exit(0);
							
					case 1:
							//Restart mode
							break;
					
					case 2:
							//Error exit mode
							System.out.println("[ ATTENTION ] : THE PROGRAM HAS ENDED WITH AN ERROR AND IS UNABLE TO CONTINUE. EXITING IN 10 SECONDS...");
							Thread.sleep(10000);
							System.exit(2);
							
					case 3:
							//Error restart mode
							System.out.println("[ ATTENTION ] : AN ERROR DURING THE LAST INSTANCE. RESTARTING IN 5 SECONDS...");
							Thread.sleep(5000);
							break;
							
					case 101:
							//Invalid boot mode 
							System.out.println("[ ERROR ] : INVALID BOOT MODE. EXITNG PROGRAM...");
							Thread.sleep(5000);
							System.exit(101);
							
					default:
							//Generic error output
							System.out.println("[ ERROR ] : FATAL ERROR. PROGRAM CANNOT CONTINUE EXECUTION. EXITING...");
							System.exit(400);
				}
				
				
				//Clean up resources after execution
				System.gc();
			}
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
}

// --- PROGRAM INFORMATION --- //

/* 
* iNFORMATION:
*/

/*
* LOGIC:
*/

/*
* ALGORITHM:
*/

/*
* TODO/NOTES
*/

// --- PROGRAM INFORMATION --- //