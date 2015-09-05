package Backgrounds;

import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Graphics.BackgroundGraphics;
import Graphics.EntityGraphics;

public class ParallaxBackgroundSet {
	String prefix;
	JPanel panel;
	int layers;
	
	public ParallaxBackgroundSet(String prefix, int layers, JPanel panel){
		this.prefix = prefix;
		this.panel = panel;
		this.layers = layers;
		
		for(int l = 0; l < layers; l++)
		if(!BackgroundGraphics.backgroundImages.containsKey(this.getClass().getSimpleName() + "_" + l)){
			try {
				BackgroundGraphics.backgroundImages.put(this.getClass().getSimpleName(), ImageIO.read(new URL("file:" + prefix + "_" + l +".png")));
			} catch (Exception e){}
		}
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
