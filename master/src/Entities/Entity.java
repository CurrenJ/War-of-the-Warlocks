package Entities;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import Cameras.Camera;

public class Entity {
	ArrayList<String> names;
	ArrayList<Double> speeds;
	ArrayList<Double> angles;
	
	double xPos;
	double yPos;
	int width;
	int height;
	JPanel panel;
	
	public Entity(int x, int y, int width, int height, JPanel panel){
		//Initializes movement arraylists
		names = new ArrayList();
		speeds = new ArrayList();
		angles = new ArrayList();
	
		//Store passed in variables
		xPos = x;
		yPos = y;
		this.width = width;
		this.height = height;
		this.panel = panel; //Needed for some graphics
	}
	
	public void drawEntity(Graphics g, Camera camera){
		int relativeX = (int) xPos - camera.getCamX();
		int relativeY = ((int) yPos - height - camera.getCamY());
		g.drawRect(relativeX, relativeY, width, height);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ArrayList<String> getNames() {
		return names;
	}

	public void setNames(ArrayList<String> names) {
		this.names = names;
	}

	public ArrayList<Double> getSpeeds() {
		return speeds;
	}

	public void setSpeeds(ArrayList<Double> speeds) {
		this.speeds = speeds;
	}

	public ArrayList<Double> getAngles() {
		return angles;
	}

	public void setAngles(ArrayList<Double> angles) {
		this.angles = angles;
	}

	public double getX() {
		return xPos;
	}

	public void setX(double xPos) {
		this.xPos = xPos;
	}

	public double getY() {
		return yPos;
	}

	public void setY(double yPos) {
		this.yPos = yPos;
	}
	
	
}
