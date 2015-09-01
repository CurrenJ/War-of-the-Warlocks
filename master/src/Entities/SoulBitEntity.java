package Entities;

import java.awt.Color;

import javax.swing.JPanel;

public class SoulBitEntity extends Entity{
	Color color;
	int fadeStart;

	public SoulBitEntity(int x, int y, JPanel panel){
		super(x, y, 2, 2, "soulBit", panel);
		
		color = Color.decode("#1592c4");
		fadeStart = (int) (Math.random() * 1800);
	}

	@Override
	public int getAge(){
		int age = (int) (System.currentTimeMillis() - startTime);
		
		float temp = (1800 - age) / ((float) fadeStart);
		if(temp <= 1)
			opacity = temp;

		return age;
	}
}
