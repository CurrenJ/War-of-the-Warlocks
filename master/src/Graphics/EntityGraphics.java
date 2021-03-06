package Graphics;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

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

	public void drawEntity(Entity entity, Graphics2D g, Camera camera){
		int relativeX = (int) entity.getX() - camera.getCamX();
		int relativeY = ((int) entity.getY() - entity.getHeight() - camera.getCamY());
	
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, entity.getOpacity()));

		if(entity.getPrefix().isEmpty())
			g.drawRect(relativeX, relativeY, entity.getWidth(), entity.getHeight());
		else
			g.drawImage((Image) EntityGraphics.entityImages.get(entity.getClass().getSimpleName()), relativeX, relativeY, panel);
		
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, entity.BASE_OPACITY));
	}
}
