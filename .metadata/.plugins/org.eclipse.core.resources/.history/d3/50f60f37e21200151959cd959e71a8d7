package Levels;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import Cameras.Camera;
import Characters.Player;
import Graphics.EntityGraphics;
import Graphics.InventoryGraphics;
import Graphics.ItemGraphics;
import Graphics.PlatformGraphics;
import Graphics.PlayerGraphics;
import Items.Item;
import Items.SoulItem;
import Physics.ItemPhysics;
import Physics.PlayerPhysics;
import Platforms.Platform;

public class Level1 extends Level{

	private int levelNum;
	private Player player;
	private JPanel panel;

	public Level1(int levelNum, Player player, JPanel panel) {
		super(levelNum, player, panel);
	}
	
	@Override
	public void levelCustomization(){
		addPlatform(25, 200, 500, 30, "stuff");
		addSoul(350, 170);
	}
}
