package Graphics;

import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Image;

import Cameras.Camera;
import Characters.Player;
import Essentials.Window;

public class PlayerGraphics {
	JPanel panel;
	Image soulImage = null;
	double scale;
	Image scaledSoulImage;
	Image[] playerLeftImages;
	Image[] playerRightImages;
	Image playerIdleImage;
	int soulImageX;
	int soulImageY;
	Font fontHUD;
	int playerAnimationFrame;
	int playerAnimationPauseTicks;
	int playerAnimationPauseTicksMax;
	
	int fps;

	//Draws the player
	//
	//Will pass in Player object
	public PlayerGraphics(JPanel panel){
		this.panel = panel;
		playerLeftImages = new Image[4];
		playerRightImages = new Image[4];
		
		playerAnimationPauseTicks = 0;
		playerAnimationPauseTicksMax = 75;

		try {
			soulImage = ImageIO.read(new URL("file:soul_15.png"));
			
			for(int i = 0; i < playerLeftImages.length; i++){
				playerLeftImages[i] = ImageIO.read(new URL("file:warlockleft_" + i + ".png"));
			}
			for(int i = 0; i < playerRightImages.length; i++){
				playerRightImages[i] = ImageIO.read(new URL("file:warlockright_" + i + ".png"));
			}
			playerIdleImage = ImageIO.read(new URL("file:warlockidle.png"));
		} catch (Exception e) {}
	}

	public void drawPlayer(Player player, Graphics g, Camera camera){
		//g.drawRect((int) (player.getX() - camera.getCamX()), ((int) (player.getY() - player.getHeight()) - camera.getCamY()), player.getWidth(), player.getHeight());
		
		Image playerImage = null;
		
		if(player.isMovingLeft()){
			if(playerAnimationPauseTicks == playerAnimationPauseTicksMax){
				playerAnimationPauseTicks = 0;
				playerAnimationFrame++;
			}
			else playerAnimationPauseTicks++;
			
			if(playerAnimationFrame == playerLeftImages.length)
				playerAnimationFrame = 0;
		
			//System.out.println(playerAnimationFrame);
			playerImage = playerLeftImages[playerAnimationFrame];
		}
		else if(player.isMovingRight()){
			if(playerAnimationPauseTicks == playerAnimationPauseTicksMax){
				playerAnimationPauseTicks = 0;
				playerAnimationFrame++;
			}
			else playerAnimationPauseTicks++;
			
			if(playerAnimationFrame == playerRightImages.length)
				playerAnimationFrame = 0;
		
			//System.out.println(playerAnimationFrame);
			playerImage = playerRightImages[playerAnimationFrame];
		}
		else playerImage = playerRightImages[0];
		
		g.drawImage(playerImage, (int) player.getX() - camera.getCamX(), (int) player.getY() - playerImage.getHeight(panel) - camera.getCamY(), panel);
	}

	public void drawHUD(Player player, Graphics g){
		scale = (panel.getHeight() + panel.getWidth()) / 2 / 192;
		if(scale < 1.5) scale = 1.5;

		soulImageY = (int) scale;
		scaledSoulImage = soulImage.getScaledInstance((int) (soulImage.getWidth(panel)*scale), (int) (soulImage.getHeight(panel)*scale), 0);
		soulImageX = (int) (panel.getWidth() - soulImage.getWidth(panel) * scale - scale);

		g.drawImage(scaledSoulImage, soulImageX, soulImageY, panel);

		fontHUD = new Font("Cambria", 0, (int) (scaledSoulImage.getHeight(panel) / 1.5));

		g.setFont(fontHUD);
		String soulDisplay = "" + player.getSouls();
		g.drawString(soulDisplay, (int) (soulImageX - g.getFontMetrics().stringWidth(soulDisplay) - scale), soulImageY + scaledSoulImage.getHeight(panel) / 2 + g.getFontMetrics().getAscent() / 2);
	
		g.drawString(fps + "", panel.getWidth() - g.getFontMetrics().stringWidth(fps + ""), panel.getHeight());
	}

	public void giveFPS(int fps) {
		this.fps = fps;
	}
}