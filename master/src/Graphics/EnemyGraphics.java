package Graphics;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Cameras.Camera;
import Characters.Enemy;
import Characters.Player;

public class EnemyGraphics {
	JPanel panel;
	public static Map<String, Image> enemyRightImages;
	public static Map<String, Image> enemyLeftImages;
	public static Map<String, Image> enemyIdleImages;
	
	private Image enemyImage;
	
	int fps;

	//Draws the player
	//
	//Will pass in Player object
	public EnemyGraphics(JPanel panel){
		this.panel = panel;
		enemyRightImages = new HashMap<String, Image>();
		enemyLeftImages = new HashMap<String, Image>();
		enemyIdleImages = new HashMap<String, Image>();
	}

	public void drawPlayer(Enemy enemy, Graphics2D g, Camera camera){
		g.drawRect((int) (enemy.getX() - camera.getCamX()), ((int) (enemy.getY() - enemy.getHeight()) - camera.getCamY()), enemy.getWidth(), enemy.getHeight());
		//g.drawImage(enemyImage, (int) enemy.getX() - camera.getCamX(), (int) enemy.getY() - enemyImage.getHeight(panel) - camera.getCamY(), panel);
	}

	public void giveFPS(int fps) {
		this.fps = fps;
	}
}
