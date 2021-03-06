package Backgrounds;

import java.awt.Point;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Cameras.Camera;
import Graphics.BackgroundGraphics;

public class ParallaxBackgroundSet {
	String prefix;
	JPanel panel;
	int layers;
	ArrayList<Point> horizontalDuplications;
	int dupesPossibleOnScreen;

	public ParallaxBackgroundSet(String prefix, int layers, JPanel panel){
		this.prefix = prefix;
		this.panel = panel;
		this.layers = layers;
		horizontalDuplications = new ArrayList<Point>();

		for(int l = 0; l < layers; l++)
			if(!BackgroundGraphics.backgroundImages.containsKey(prefix + "_" + l)){
				try {
					BackgroundGraphics.backgroundImages.put(prefix + "_" + l, ImageIO.read(new URL("file:" + prefix + "_" + l +".png")));
				} catch (Exception e){}
			}
	}

	public void scaleToWindow(boolean printInfo){
		if(printInfo)
			System.out.print("Resizing background \"" + prefix + "\" to fit window size ");
		int imgWidth = BackgroundGraphics.backgroundImages.get(prefix + "_0").getWidth(panel);
		int imgHeight = BackgroundGraphics.backgroundImages.get(prefix + "_0").getHeight(panel);

		int windowWidth = panel.getWidth();
		int windowHeight = panel.getHeight();

		if(printInfo)
			System.out.print(windowWidth + " x " + windowHeight);

		double ratio = ((double) windowHeight) / ((double) imgHeight);
		imgWidth = (int) (imgWidth * ratio);
		imgHeight = (int) (imgHeight * ratio);

		if(printInfo){
			System.out.println(" at ratio " + ratio + " (" + windowHeight + " / " + imgHeight + ")");
			System.out.println("Result: " + imgWidth + " x " + imgHeight);
		}

		dupesPossibleOnScreen = panel.getWidth() / imgWidth + 2;

		for(int s = 0; s < layers; s++){
			BackgroundGraphics.backgroundImages.put(prefix + "_" + s, BackgroundGraphics.backgroundImages.get(prefix + "_" + s).getScaledInstance(imgWidth, imgHeight, 0));			}

	}

	public void scaleToHeight(int height){
		int imgWidth = BackgroundGraphics.backgroundImages.get(prefix + "_0").getWidth(panel);
		int imgHeight = BackgroundGraphics.backgroundImages.get(prefix + "_0").getHeight(panel);

		double ratio = ((double) height) / ((double) imgHeight);
		imgWidth = (int) (imgWidth * ratio);
		imgHeight = (int) (imgHeight * ratio);
		
		dupesPossibleOnScreen = panel.getWidth() / imgWidth + 2;

		for(int s = 0; s < layers; s++){
			BackgroundGraphics.backgroundImages.put(prefix + "_" + s, BackgroundGraphics.backgroundImages.get(prefix + "_" + s).getScaledInstance(imgWidth, imgHeight, 0));			}
	}

	public void addToBackgrounds(){

	}

	public void beginScrolling(Camera camera){
		horizontalDuplications.add(new Point(camera.getCamX(), camera.getCamY()-BackgroundGraphics.backgroundImages.get(prefix + "_" + 0).getHeight(panel)));
	}

	public ArrayList<Point> getHorDupes(){
		return horizontalDuplications;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public int getDupesPossibleOnScreen() {
		return dupesPossibleOnScreen;
	}

	public void setDupesPossibleOnScreen(int dupesPossibleOnScreen) {
		this.dupesPossibleOnScreen = dupesPossibleOnScreen;
	}

	public int getLayers() {
		return layers;
	}

	public void setLayers(int layers) {
		this.layers = layers;
	}
}
