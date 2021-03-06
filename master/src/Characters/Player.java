package Characters;

import java.awt.image.BufferedImage;

public class Player {
	BufferedImage playerImage;
	private double xPos;
	private double yPos;
	private int healthMax;
	private int health;
	private int gold;
	private int soulMax;
	private int width;
	private int height;
	private int souls;
	private boolean movingRight;
	private boolean movingLeft;
	private boolean canJump;
	private String direction;

	public Player(BufferedImage playerImage, double x, double y, int healthMax, int health, int gold, int soulMax, int souls, int width, int height){
		this.playerImage = playerImage;
		xPos = x;
		yPos = y;
		this.healthMax = healthMax;
		this.health = health;
		this.gold = gold;
		this.soulMax = soulMax;
		this.width = width;
		this.height = height;
		this.souls = souls;
		movingRight = false;
		movingLeft = false;
		canJump = false;
		direction = "right";
	}
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public boolean canJump() {
		return canJump;
	}

	public void setCanJump(boolean canJump) {
		this.canJump = canJump;
	}

	public void addSoul(){
		souls += 1;
	}
	
	public int getSouls() {
		return souls;
	}

	public void setSouls(int souls) {
		this.souls = souls;
	}

	public BufferedImage getImage(){
		return playerImage;
	}
	
	public void setImage(BufferedImage image){
		playerImage = image;
	}

	public double getX() {
		return xPos;
	}

	public void setX(double ptX) {
		this.xPos = ptX;
	}

	public double getY() {
		return yPos;
	}

	public void setY(double ptY) {
		this.yPos = ptY;
	}

	public int getHealthMax() {
		return healthMax;
	}

	public void setHealthMax(int healthMax) {
		this.healthMax = healthMax;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getSoulMax() {
		return soulMax;
	}

	public void setSoulMax(int soulMax) {
		this.soulMax = soulMax;
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

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}
	
	public double getPercentHealth(){
		return ((double) healthMax / ((double) health)) * 100;
	}
}
