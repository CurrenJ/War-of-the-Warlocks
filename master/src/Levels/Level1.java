package Levels;

import javax.swing.JPanel;

import Characters.Player;
import Entities.SoulBitEntity;
import Items.CoinItem;
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
		addSoul(new SoulItem(360, 165, panel));
		addSoul(new SoulItem(370, 165, panel));
		addCoin(new CoinItem(335, 100, panel));
		addEntity(new SoulBitEntity(330, 110, panel));
	}
}
