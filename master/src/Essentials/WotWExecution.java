package Essentials;

import Items.Item;
import Levels.Level;

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
				Level level = levels.get(levelNum);
				
				level.run();
				
				repaint(); 
			}catch(Exception e) 
			{ 
				e.printStackTrace(); 
			} 
		} 

	}



}
