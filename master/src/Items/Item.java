package Items;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Item {
	private int xPos;
	protected int yPos;
	private BufferedImage image;
	private int width;
	private int height;
	protected int animationFrames = 1;
	protected int curFrame = 0;
	private String filePrefix;
	private ArrayList<Image> images = new ArrayList();
	private JPanel panel;
	protected int animationPause = 0;
	protected int curPauseNum = 0;

	public Item(int x, int y, String prefix, JPanel panel){
		xPos = x;
		yPos = y;
		filePrefix = prefix;
		this.panel = panel;

		loadImages();

		width = images.get(0).getWidth(panel);
		height = images.get(0).getHeight(panel);
	}

	public Item(int x, int y, int width, int height, String prefix, JPanel panel){
		xPos = x;
		yPos = y;
		this.width = width;
		this.height = height;
		filePrefix = prefix;
		this.panel = panel;
		
		loadImages();
	}

	public Item(int x, int y, int width, int height, int animationFrames, String prefix, JPanel panel, int pause){
		xPos = x;
		yPos = y;
		this.width = width;
		this.height = height;
		this.animationFrames = animationFrames;
		filePrefix = prefix;
		this.panel = panel;
		animationPause = pause;
		
		loadImages();
	}

	public Item(int x, int y, int animationFrames, String prefix, JPanel panel, int pause){
		xPos = x;
		yPos = y;
		this.animationFrames = animationFrames;
		filePrefix = prefix;
		this.panel = panel;
		animationPause = pause;

		loadImages();

		width = images.get(0).getWidth(panel);
		height = images.get(0).getHeight(panel);
	}

	public void loadImages(){
		try {
			for(int i = 0; i < animationFrames; i++){
				System.out.println("file:" + filePrefix + "_" + i + ".png");
				images.add(ImageIO.read(new URL("file:" + filePrefix + "_" + i + ".png")));
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public int getCurFrame(){
		return curFrame;
	}

	public void advanceFrame(){
		if(curPauseNum != animationPause){
			curPauseNum++;
		}
		else {
			curPauseNum = 0;
			
			if(curFrame + 1 != animationFrames){
				curFrame++;
			}
			else curFrame = 0;
		}
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

	public int getX() {
		return xPos;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

	public int getY() {
		return yPos;
	}

	public void setY(int yPos) {
		this.yPos = yPos;
	}

	public Image getImage() {
		return images.get(curFrame);
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
}