package Entities;

import java.awt.Color;

import javax.swing.JPanel;

public class SoulBitEntity extends FadingBitEntity{
	Color color;
	int fadeStart;
	public final static int LIFE_SPAN = 1800;
	
	public SoulBitEntity(int x, int y, JPanel panel){
		super(x, y, 2, 2, "soulBit", LIFE_SPAN, 10, panel);
		
		color = Color.decode("#1592c4");
		fadeStart = (int) (Math.random() * LIFE_SPAN);
	}

}
