package Cameras;

import javax.swing.JPanel;

import Characters.Player;
import Essentials.Window;

public class Camera {
	private int camX;
	private int camY;
	private JPanel panel;

	public Camera(int x, int y, JPanel panel){
		camX = x;
		camY = y;
		this.panel = panel;
	}

	public int getCamX() {
		return camX;
	}

	public void setCamX(int camX) {
		this.camX = camX;
	}

	public int getCamY() {
		return camY;
	}

	public void setCamY(int camY) {
		this.camY = camY;
	}
	
	public void reposition(Player player){
		double playerRelativeX = player.getX()-camX;
		double playerRelativeY = player.getY()-camY;
		int rightLimit = panel.getWidth() / 10 * 8;
		int leftLimit = panel.getWidth() / 10 * 2;
		int topLimit = panel.getHeight() / 10 * 2;
		int bottomLimit = panel.getHeight() / 10 * 8;
		if(playerRelativeX > rightLimit){
			camX += playerRelativeX - rightLimit;
		}
		else if(playerRelativeX < leftLimit){
			camX += playerRelativeX - leftLimit;
		}
		
		if(playerRelativeY < topLimit){
			camY += playerRelativeY - topLimit;
		}
		else if(playerRelativeY
				> bottomLimit){
			camY += playerRelativeY - bottomLimit;
		}
		//System.out.println(camY);
	}
}
