package Graphics;

import java.awt.Graphics;

import javax.swing.JPanel;

import Cameras.Camera;
import Entities.Entity;

public class EntityGraphics {
	JPanel panel;
	
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
	}
	
	public void drawEntity(Entity entity, Graphics g, Camera camera){
		entity.drawEntity(g, camera);
	}
}
