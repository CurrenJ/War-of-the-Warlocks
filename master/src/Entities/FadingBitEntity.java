package Entities;

import javax.swing.JPanel;

public class FadingBitEntity extends Entity{
	int fadeStart;
	public int LIFE_SPAN;
	
	public FadingBitEntity(int x, int y, int width, int height, String prefix, int lifespan ,JPanel panel){
		super(x, y, width, height, prefix, panel);
		
		LIFE_SPAN = lifespan;
		fadeStart = (int) (Math.random() * LIFE_SPAN);
	}
	
	@Override
	public int getAge(){
		int age = (int) (System.currentTimeMillis() - startTime);
		
		float temp = (LIFE_SPAN - age) / ((float) fadeStart);
		if(temp <= 1)
			opacity = temp;

		return age;
	}
	
	public int getLifespan(){
		return LIFE_SPAN;
	}
	
	public void setLifespan(int lifespan){
		LIFE_SPAN = lifespan;
	}
}