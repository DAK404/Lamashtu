package Amethyst.Core;

import java.io.File;
import java.io.Console;

public class Boot
{
	Console console=System.console();
	
	public static void main(String[] Args)throws Exception
	{
		try
		{
			System.out.println(Args[0]);
			Thread.sleep(5000);
			switch(Args[0])
			{
				case "normal":
								//Normal boot, break and move to boot logic
								break;
								
				case "safemode":
								//set variables to denote bootmode as safemode, break to bootlogic
								break;
								
				default:
								System.exit(101);
			}
			new Boot().bootMenu();
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	
	
	/**
	* Boots the program up after checking the asserts to the specified bootmode
	*/
	private void bootMenu()throws Exception
	{
		new Amethyst.API.Synergy().Information();
		asserts();
		Thread.sleep(5000);

		System.gc();
		
		menuLogic();
	}
	
	
	private void menuLogic()throws Exception
	{
		try
		{
			while(true)
			{
				new Amethyst.API.Synergy().Information();
				
				System.gc();
				
				Runtime instance = Runtime.getRuntime();
				System.out.println("Module Memory Usage  : " + (instance.totalMemory() - instance.freeMemory())  + " Bytes"); 
				
				switch(console.readLine("Guest@system> "))
				{
					case "exit":
								System.exit(0);
								
					case "restart":
								System.exit(1);
					
					default:
								System.out.println("Unrecognized command. Please try again.");
				}
			}
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	
	private void asserts()throws Exception
	{
		//Read a file to ensure md5 integrity of binaries
		
		/*
		* ---  TODO  ---
		*
		* 1) Create actual asserts for file integrity check
		* 2) Create a method which will help in downloading individual files which are corrupt
		* 3) Create the setup program which will help in setting up the program if it hasnt been setup
		* ---  ----  ---
	}
}