package Entities;

import javax.swing.JPanel;

public class OrbBitEntity extends FadingBitEntity{
	int fadeStart;
	public final static int LIFE_SPAN = 1500;
	
	public OrbBitEntity(int x, int y, JPanel panel){
		super(x, y, 2, 1, "orbBit", LIFE_SPAN, 10, panel);
		
		setGravityEnabled(true);
		fadeStart = (int) (Math.random() * LIFE_SPAN);
	}
}
