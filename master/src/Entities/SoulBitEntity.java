package Entities;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Cameras.Camera;

public class SoulBitEntity extends Entity{
	Color color = Color.decode("#99E2FF");
	
	public SoulBitEntity(int x, int y, JPanel panel){
		super(x, y, 2, 2, panel);
	}
	
	@Override
	public void drawEntity(Graphics g, Camera camera){
		int relativeX = (int) xPos - camera.getCamX();
		int relativeY = ((int) yPos - height - camera.getCamY());
		
		g.setColor(color);
		g.fillRect(relativeX, relativeY, width, height);
	}
}