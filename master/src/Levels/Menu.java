package Levels;

import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import Backgrounds.DarkCitySkylineBackground;
import Backgrounds.ParallaxBackgroundSet;
import Cameras.Camera;
import Characters.Player;
import Entities.Entity;
import Graphics.BackgroundGraphics;
import Graphics.EntityGraphics;
import Graphics.GUIGraphics;
import Graphics.InventoryGraphics;
import Graphics.ItemGraphics;
import Graphics.PlatformGraphics;
import Graphics.PlayerGraphics;
import Items.CoinItem;
import Items.Item;
import Items.OrbItem;
import Items.SoulItem;
import Physics.EntityPhysics;
import Physics.ItemPhysics;
import Physics.PlayerPhysics;
import Platforms.Platform;



public class Menu {
	private ParallaxBackgroundSet background;
	protected JPanel panel;
	
	private BackgroundGraphics backgroundGraphics;

	private DarkCitySkylineBackground darkSkyline;

	private Camera camera;

	private boolean backgroundSizeAdjusted;

	public Menu(JPanel panel){
		this.panel = panel;
	}

	public void levelCustomization(){}

	public void initialize(){
		backgroundGraphics = new BackgroundGraphics(panel);
		
		camera = new Camera(0, 0, panel);

		darkSkyline = new DarkCitySkylineBackground(panel);
		darkSkyline.addToBackgrounds();

		backgroundSizeAdjusted = false;
		background = BackgroundGraphics.backgrounds.get("darkSkyline"); //sets as default

		levelCustomization();
	}

	public void paint(Graphics2D g) {
		try {
			backgroundGraphics.drawBackground(background, g, camera);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		if(!backgroundSizeAdjusted){
			for(int b = 0; b < BackgroundGraphics.backgrounds.size(); b++){
				BackgroundGraphics.backgrounds.get(BackgroundGraphics.backgrounds.keySet().iterator().next()).scaleToHeight((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());			}
			backgroundSizeAdjusted = true;
		}
	}

	public void end() {}


	public void resize() {
		backgroundGraphics.resize();
	}
}