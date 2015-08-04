package Graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Cameras.Camera;
import Entities.Entity;

public class EntityGraphics {
	JPanel panel;
	public static Map<String, Image> entityImages;

	//Draws entities, such as:
	//Fireballs
	//Lightning
	//Other Projectiles
	//Particles
	//Etc.
	//
	//Will pass in Entity object
	public EntityGraphics(JPanel panel){
		this.panel = panel;
		entityImages = new HashMap<String, Image>();
	}

	public void drawEntity(Entity entity, Graphics g, Camera camera){
		entity.drawEntity(g, camera);
	}
}
