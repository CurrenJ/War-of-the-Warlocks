package Entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Cameras.Camera;
import Graphics.EntityGraphics;

public class Entity {
	ArrayList<String> names;
	ArrayList<Double> speeds;
	ArrayList<Double> angles;

	double xPos;
	double yPos;
	int width;
	int height;
	JPanel panel;
	boolean gravityEnabled = false;
	String prefix = "";
	long startTime;
	protected double FRICTION_COEFFICIENT;

	Image image = null;
	
	protected float opacity;
	public final float BASE_OPACITY = 1;

	public Entity(int x, int y, int width, int height, double FRICTION_COEFFICIENT, JPanel panel){
		//Initializes movement arraylists
		names = new ArrayList();
		speeds = new ArrayList();
		angles = new ArrayList();

		//Store passed in variables
		xPos = x;
		yPos = y;
		this.width = width;
		this.height = height;
		this.FRICTION_COEFFICIENT = FRICTION_COEFFICIENT;
		this.panel = panel; //Needed for some graphics
		
		opacity = BASE_OPACITY;
	}

	public Entity(int x, int y, int width, int height, String prefix, double FRICTION_COEFFICIENT, JPanel panel){
		//Initializes movement arraylists
		names = new ArrayList();
		speeds = new ArrayList();
		angles = new ArrayList();

		//Store passed in variables
		xPos = x;
		yPos = y;
		this.width = width;
		this.height = height;
		this.prefix = prefix;
		this.FRICTION_COEFFICIENT = FRICTION_COEFFICIENT;
		this.panel = panel; //Needed for some graphicsgra
		
		opacity = BASE_OPACITY;
		
		if(!EntityGraphics.entityImages.containsKey(this.getClass().getSimpleName())){
			try {
				EntityGraphics.entityImages.put(this.getClass().getSimpleName(), ImageIO.read(new URL("file:" + prefix + ".png")));
			} catch (Exception e){}
		}
	}
	
	public void startAging(){
		startTime = System.currentTimeMillis();
	}
	
	public void startAgeAt(int age){
		startTime = age;
	}
	
	public int getAge(){
		return (int) (System.currentTimeMillis() - startTime);
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

	public boolean isGravityEnabled(){
		return gravityEnabled;
	}

	public void setGravityEnabled(boolean grav){
		gravityEnabled = grav;
	}
	
	public String getPrefix(){
		return prefix;
	}

	public float getOpacity() {
		return opacity;
	}

	public double getFrictionCoefficient() {
		return FRICTION_COEFFICIENT;
	}
}
