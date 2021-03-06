package Graphics;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Cameras.Camera;
import Items.Item;

public class ItemGraphics{
	JPanel panel;

	//Draw items, such as:
	//Soul Orbs
	//Gold
	//Health Orbs
	//Sellable Items
	//Artifacts?
	//
	//Will pass in Item object
	public ItemGraphics(JPanel panel){
		this.panel = panel;
	}

	public void drawItem(Item item, Graphics2D g, Camera camera) throws Exception{
		Image itemImage = item.getImage().getScaledInstance(item.getWidth(), item.getHeight(), 0);
		int relativeX = (int) item.getX() - camera.getCamX();
		int relativeY = ((int) item.getY() - item.getHeight()) - camera.getCamY();
		g.drawImage(itemImage, relativeX, relativeY, panel);
		//System.out.println("Drawing item");
		//System.out.println("Drew frame: " + item.getCurFrame());
		item.advanceFrame();
	}
}
