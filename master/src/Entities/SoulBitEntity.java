package Entities;

import java.awt.Color;

import javax.swing.JPanel;

public class SoulBitEntity extends Entity{
	Color color = Color.decode("#1592c4");
	long startTime;
	
	public SoulBitEntity(int x, int y, JPanel panel){
		super(x, y, 2, 2, "soulBit", panel);
		
		//startAging();
	}
	
	public void startAging(){
		startTime = System.currentTimeMillis();
	}
	
	public void startAgeAt(int age){
		startTime = age;
	}
	
	public int getAge(){
		return (int) (System.currentTimeMillis() - startTime);
	}
}
