package Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import Backgrounds.ParallaxBackgroundSet;
import Cameras.Camera;

public class BackgroundGraphics {
	JPanel panel;
	public static Map<String, Image> backgroundImages;
	
	public BackgroundGraphics(JPanel panel){
		this.panel = panel;
		backgroundImages = new HashMap<String, Image>();
	}

	public void drawBackground(ParallaxBackgroundSet background, Graphics2D g, Camera camera){

		if(!background.getPrefix().isEmpty())
			g.drawImage((Image) EntityGraphics.entityImages.get(background.getClass().getSimpleName()), 0, 0, panel);
	}
}
