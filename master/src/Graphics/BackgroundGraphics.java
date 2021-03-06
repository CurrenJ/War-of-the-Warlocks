package Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import Backgrounds.ParallaxBackgroundSet;
import Cameras.Camera;
import Essentials.Window;

public class BackgroundGraphics {
	JPanel panel;
	public static Map<String, Image> backgroundImages;
	public static Map<String, ParallaxBackgroundSet> backgrounds;

	public BackgroundGraphics(JPanel panel){
		this.panel = panel;
		backgroundImages = new HashMap<String, Image>();
		backgrounds = new HashMap<String, ParallaxBackgroundSet>();
	}

	public void drawBackground(ParallaxBackgroundSet background, Graphics2D g, Camera camera){
		int backgroundImgWidth = BackgroundGraphics.backgroundImages.get(background.getPrefix()+ "_0").getWidth(panel);
		int xOffset = camera.getCamX() % backgroundImgWidth;
		for(int l = background.getLayers(); l > 0; l--)
			for(int d = 0; d < background.getDupesPossibleOnScreen()+1; d++)
				g.drawImage((Image) BackgroundGraphics.backgroundImages.get(background.getPrefix() + "_" + (l-1)), ((-1 * xOffset / (l)) + backgroundImgWidth * d) - backgroundImgWidth, 0, panel);

	}

	public void resize() {
		//		System.out.println(BackgroundGraphics.backgrounds.size());
		//		for(int b = 0; b < backgrounds.size(); b++){
		//			BackgroundGraphics.backgrounds.get(BackgroundGraphics.backgrounds.keySet().iterator().next()).scaleToWindow(true);
		//		}
	}
}
