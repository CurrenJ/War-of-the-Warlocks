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
import Graphics.InventoryGraphics;
import Graphics.ItemGraphics;
import Graphics.PlatformGraphics;
import Graphics.PlayerGraphics;
import Items.CoinItem;
import Items.Item;
import Items.SoulItem;
import Physics.EntityPhysics;
import Physics.ItemPhysics;
import Physics.PlayerPhysics;
import Platforms.Platform;



public class Level {
	private int levelNum;
	private Player player;
	private ParallaxBackgroundSet background;
	private JPanel panel;

	private ArrayList<Platform> platforms;
	private ArrayList<Item> items;
	private ArrayList<Entity> entities;

	private BackgroundGraphics backgroundGraphics;
	private EntityGraphics entityGraphics;
	private InventoryGraphics invGraphics;
	private ItemGraphics itemGraphics;
	private PlatformGraphics platformGraphics;
	private PlayerGraphics playerGraphics;

	private EntityPhysics entityPhysics;
	private PlayerPhysics playerPhysics;
	private ItemPhysics itemPhysics;

	private DarkCitySkylineBackground darkSkyline;

	private Camera camera;
	
	private boolean backgroundSizeAdjusted;

	long tempTime;
	int framesPassed;
	int fps;

	public Level(int levelNum, Player player, JPanel panel){
		this.levelNum = levelNum;
		this.player = player;
		this.background = background;
		this.panel = panel;
	}

	public void levelCustomization(){}

	public void addPlatform(Platform platform){
		platforms.add(platform);
	}

	public void addSoul(SoulItem soul){
		items.add(soul);
	}

	public void addItem(Item item){
		items.add(item);
	}

	public void addCoin(CoinItem coin){
		items.add(coin);
	}

	public void addEntity(Entity entity){
		entities.add(entity);
	}

	public void initialize(){
		platforms = new ArrayList();
		items = new ArrayList();
		entities = new ArrayList();

		backgroundGraphics = new BackgroundGraphics(panel);
		entityGraphics = new EntityGraphics(panel);
		invGraphics = new InventoryGraphics(panel);
		itemGraphics = new ItemGraphics(panel);
		platformGraphics = new PlatformGraphics(panel);
		playerGraphics = new PlayerGraphics(panel);
		camera = new Camera(0, 0, panel);
		entityPhysics = new EntityPhysics(panel);
		playerPhysics = new PlayerPhysics(panel, true);
		itemPhysics = new ItemPhysics(panel, true);
		platforms = new ArrayList();
		items = new ArrayList();
		
		darkSkyline = new DarkCitySkylineBackground(panel);
		darkSkyline.addToBackgrounds();
		
		backgroundSizeAdjusted = false;
		background = BackgroundGraphics.backgrounds.get("darkSkyline"); //sets as default

		levelCustomization();
	}

	public void paint(Graphics2D g) {
		try {
			backgroundGraphics.drawBackground(background, g, camera);
			
			for(int p = 0; p < platforms.size(); p++){
				Platform platform = platforms.get(p);
				platformGraphics.drawPlatform(platform, g, camera);
			}

			for(int i = 0; i < items.size(); i++){
				Item item = items.get(i);
				itemGraphics.drawItem(item, g, camera);
			}

			for(int i = 0; i < entities.size(); i++){
				Entity entity = entities.get(i);
				entityGraphics.drawEntity(entity, g, camera);
			}

			camera.reposition(player);
			playerGraphics.drawPlayer(player, g, camera);
			playerGraphics.drawHUD(player, g);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		//Does player interactions and passes and gets vars
		playerPhysics.setLists(entities, items);
		playerPhysics.setPhysics(entityPhysics, itemPhysics);

		playerPhysics.doMovement(player, platforms);

		entities = playerPhysics.getEntities();
		items = playerPhysics.getItems();
		entityPhysics = playerPhysics.getEntityPhysics();
		itemPhysics = playerPhysics.getItemPhysics();

		//Does item interactions and passes and gets vars
		itemPhysics.setLists(entities, items);
		itemPhysics.setPhysics(playerPhysics, entityPhysics);

		for(int i = 0; i < items.size(); i++)
			itemPhysics.doMovement(items.get(i), platforms, player);
		itemPhysics.doActions(player);

		items = itemPhysics.getItems();
		entities = itemPhysics.getEntities();
		playerPhysics = itemPhysics.getPlayerPhysics();
		entityPhysics = itemPhysics.getEntityPhysics();

		//Does entity interactions and passes and gets lists
		entityPhysics.setLists(entities, items);
		entityPhysics.setPhysics(playerPhysics, itemPhysics);

		for(int i = 0; i < entities.size(); i++)
			entityPhysics.doMovement(entities.get(i), platforms, player, i);

		items = entityPhysics.getItems();
		entities = entityPhysics.getEntities();
		playerPhysics = entityPhysics.getPlayerPhysics();
		itemPhysics = entityPhysics.getItemPhysics();

		//Calculates FPS and passed it to playerGraphics where HUD is drawn
		calculateFPS();
		playerGraphics.giveFPS(fps);

		if(!backgroundSizeAdjusted){
			for(int b = 0; b < BackgroundGraphics.backgrounds.size(); b++){
				BackgroundGraphics.backgrounds.get(BackgroundGraphics.backgrounds.keySet().iterator().next()).scaleToHeight((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());			}
			backgroundSizeAdjusted = true;
		}
	}

	public void end() {}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'd'){
			player.setMovingRight(true);
			player.setMovingLeft(false);
		}
		else if(e.getKeyChar() == 'w' && player.canJump()){
			playerPhysics.addVelocity(9, 0, "jump");
		}
		else if(e.getKeyChar() == 'a'){
			player.setMovingLeft(true);
			player.setMovingRight(false);
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == 'd')
			player.setMovingRight(false);
		else if(e.getKeyChar() == 'a')
			player.setMovingLeft(false);
	}

	public void calculateFPS(){
		int fps;

		framesPassed++;
		if(System.currentTimeMillis() - tempTime >= 1000){
			fps = framesPassed;
			framesPassed = 0;
			tempTime = System.currentTimeMillis();
			this.fps = fps;
		}
	}

	public void resize() {
		backgroundGraphics.resize();
		camera.reposition(player);
	}
}
