package Characters;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import Graphics.EnemyGraphics;

public class Enemy {
	BufferedImage playerImage;
	private double xPos;
	private double yPos;
	private int healthMax;
	private int health;
	private int gold;
	private int width;
	private int height;
	private int souls;
	private boolean movingRight;
	private boolean movingLeft;
	private boolean canJump;
	private String direction;
	
	protected final int RIGHT_IMAGE_NUM;
	protected final String RIGHT_PREFIX;
	protected final int LEFT_IMAGE_NUM;
	protected final String LEFT_PREFIX;
	protected final int IDLE_IMAGE_NUM;
	protected final String IDLE_PREFIX;

	public Enemy(BufferedImage playerImage, double x, double y, int healthMax, int health, int gold, int souls, int width, int height){
		this.playerImage = playerImage;
		xPos = x;
		yPos = y;
		this.healthMax = healthMax;
		this.health = health;
		this.gold = gold;
		this.width = width;
		this.height = height;
		this.souls = souls;
		movingRight = false;
		movingLeft = false;
		canJump = false;
		direction = "right";
		
		RIGHT_IMAGE_NUM = 0;
		RIGHT_PREFIX = "";
		LEFT_IMAGE_NUM = 0;
		LEFT_PREFIX = "";
		IDLE_IMAGE_NUM = 0;
		IDLE_PREFIX = "";
	}

	public void loadImages(){
		if(EnemyGraphics.enemyRightImages.get(RIGHT_PREFIX + "_0") == null)
			for(int j = 0; j < 3; j++){
				int images = 0;
				String prefix = "";
				if(j == 0){
					images = RIGHT_IMAGE_NUM;
					prefix = RIGHT_PREFIX;
				}
				else if(j == 1){
					images = LEFT_IMAGE_NUM;
					prefix = LEFT_PREFIX;
				}
				else{
					images = IDLE_IMAGE_NUM;
					prefix = IDLE_PREFIX;
				}
				for(int i = 0; i < images; i++){
					try{
						Image image = (Image) ImageIO.read(new URL("file:" + prefix + "_" + i + ".png"));
						if(j == 0)
							EnemyGraphics.enemyRightImages.put(prefix + "_" + i, image);
						else if(j == 1)
							EnemyGraphics.enemyLeftImages.put(prefix + "_" + i, image);
						else EnemyGraphics.enemyIdleImages.put(prefix + "_" + i, image);
					} catch (Exception e){ e.printStackTrace(); }
				}
			}
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
