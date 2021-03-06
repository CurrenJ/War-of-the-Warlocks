package Backgrounds;

import javax.swing.JPanel;

import Graphics.BackgroundGraphics;

public class DarkCitySkylineBackground extends ParallaxBackgroundSet{

	public DarkCitySkylineBackground(JPanel panel){
		super("darkSkyline", 3, panel);
	}

	@Override
	public void addToBackgrounds(){
			BackgroundGraphics.backgrounds.put(prefix, new DarkCitySkylineBackground(panel));
	}
}
