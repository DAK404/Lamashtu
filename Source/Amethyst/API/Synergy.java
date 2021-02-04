package Amethyst.API;

public final class Synergy
{
	public void Information()throws Exception
	{
		clearScreen();
		System.gc();
		System.out.println("+----------------------------+");
		System.out.println("|      - Lamatshu 1.3 -      |");
		System.out.println("+----------------------------+");
		System.out.println("| Powered by Synergy Kernel. |");
		System.out.println("+----------------------------+");
		System.out.println("|                            |");
		System.out.println("| VERSION     : 1.3.X        |");
		System.out.println("| BUILD DATE  : 7-JAN-20     |");
		System.out.println("|                            |");
		System.out.println("+----------------------------+");
		debugMemoryInformation();
		System.gc();
		return;
	}
	
	public void clearScreen()throws Exception
	{
		try
		{
			if(System.getProperty("os.name").contains("Windows"))
			{
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			else
			{
				new ProcessBuilder("/bin/bash", "-c" ,"clear").inheritIO().start().waitFor();
			}		
			System.gc();
			return;
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	
	private void debugMemoryInformation()
	{
		// get Runtime instance
		Runtime instance = Runtime.getRuntime();
		System.out.println("*****************************************");
		System.out.println("      ---   DEBUG INFORMATION   ---      ");
		System.out.println("*****************************************");
		System.out.println("\n  - Heap utilization statistics -  \n ");
		System.out.println(" [*]  Process ID   : " + ProcessHandle.current().pid());
 		// available memory
		System.out.println(" [*]  Total Memory : " + instance.totalMemory()  + " Bytes");
		// free memory
		System.out.println(" [*]  Free Memory  : " + instance.freeMemory()  + " Bytes");
		// used memory
		System.out.println(" [*]  Used Memory  : " + (instance.totalMemory() - instance.freeMemory())  + " Bytes"); 
		// Maximum available memory
		System.out.println(" [*]  Max Memory   : " + instance.maxMemory()  + " Bytes");
		System.out.println("\n*****************************************\n\n");
	}
}