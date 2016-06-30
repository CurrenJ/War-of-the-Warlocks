package Essentials;

import Levels.Level;
import Levels.Menu;

public class WotWExecution extends WotWPanel  {

	public WotWExecution(Window window) throws Exception 
	{
		super(window);
	}

	//Method that will continually run until we exit the program 
	public void start(Window window) 
	{
		while(true) 
		{ 
			try 
			{ 
				Thread.sleep(8);
				if(!titleScreen){
				Level level = levels.get(levelNum);
				
				level.run();
				}
				else{		
					menu.run();
				}
				
				repaint(); 
			}catch(Exception e) 
			{ 
				e.printStackTrace(); 
			} 
		} 

	}



}
