package Entities;

import javax.swing.JPanel;

public class GoldBitEntity extends FadingBitEntity{
	int fadeStart;
	public final static int LIFE_SPAN = 3000;
	
	public GoldBitEntity(int x, int y, JPanel panel){
		super(x, y, 2, 2, "goldBit", LIFE_SPAN, 5, panel);
		
		setGravityEnabled(true);
		fadeStart = (int) (Math.random() * LIFE_SPAN);
	}
}
