package Platforms;

public class Platform {
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private String type;

	public Platform(int x, int y, int width, int height, String type){
		xPos = x;
		yPos = y;
		this.width = width;
		this.height = height;
		this.type = type;
	}
	
	public boolean inPlatform(int x, int y){
		for(int platX = 0; platX < width; platX++){
			for(int platY = 0; platY < height; platY++){
				if(platX == x && platY == y){
					return true;
				}
			}
		}
		return false;
	}
	
	public int getPlatformTop(){
		return yPos - height;
	}
	
	public int getPlatformBottom(){
		return yPos;
	}
	
	public int getPlatformLeft(){
		return xPos;
	}
	
	public int getPlatformRight(){
		return xPos + width;
	}

	public int getX() {
		return xPos;
	}

	public void setX(int x) {
		this.xPos = x;
	}

	public int getY() {
		return yPos;
	}

	public void setY(int y) {
		this.yPos = y;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
