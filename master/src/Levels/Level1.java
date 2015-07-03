package Levels;

import javax.swing.JPanel;

import Characters.Player;
import Items.CoinItem;
import Items.Item;
import Items.SoulItem;
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
		addPlatform(new Platform(25, 200, 500, 30, "stuff"));
		addSoul(new SoulItem(350, 165, panel));
		addCoin(new CoinItem(335, 100, panel));
	}
}
