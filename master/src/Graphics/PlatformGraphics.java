package Graphics;

import java.awt.Graphics;

import javax.swing.JPanel;

import Cameras.Camera;
import Platforms.Platform;

public class PlatformGraphics {
	JPanel panel;
	
	//Draws platforms
	//
	//Will pass in Platform object
	public PlatformGraphics(JPanel panel){
		this.panel = panel;
	}
	
	public static void drawPlatform(Platform platform, Graphics g, Camera camera){
		g.drawRect(platform.getX() - camera.getCamX(), (platform.getY() - platform.getHeight()) - camera.getCamY(), platform.getWidth(), platform.getHeight());
		//g.drawImage(platform.getImage(), platform.getX() - camera.getCamX(), (platform.getY() - platform.getHeight()) - camera.getCamY(), panel);
	}
}