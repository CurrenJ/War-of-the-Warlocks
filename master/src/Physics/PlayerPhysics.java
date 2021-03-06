package Physics;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

import Characters.Player;
import Platforms.Platform;

public class PlayerPhysics extends Physics{
	ArrayList<Double> speeds;
	ArrayList<Double> angles;
	ArrayList<String> names;
	
	EntityPhysics entityPhysics;
	ItemPhysics itemPhysics;

	boolean gravityEnabled;
	JPanel panel;

	public static final double FRICTION_FACTOR = 15;
	public static final double FRICTION_VAR = FRICTION_FACTOR / 500 + 1;

	public PlayerPhysics(JPanel panel, boolean gravityEnabled){
		super(panel);
		this.panel = panel;
		
		this.gravityEnabled = gravityEnabled;

		speeds = new ArrayList();
		angles = new ArrayList();
		names = new ArrayList();
	}

	public void gravityEnabled(boolean enabled){
		if(enabled)
			gravityEnabled = true;
		else gravityEnabled = false;
	}

	public double distanceFormula(double x1, double y1, double x2, double y2){
		return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
	}

	public void addVelocity(double speed, double angle, String name){
		boolean foundMatch = false;
		for(int n = 0; n < names.size() && !foundMatch; n++){
			if(names.get(n).equals(name)){
				int index = n;

				speeds.set(index, speed);
				angles.set(index, angle);
				names.set(index, name);

				foundMatch = true;
			}
		}
		if(!foundMatch){
			speeds.add(speed);
			angles.add(angle);
			names.add(name);
		}
	}
	
	public void doMovement(Player player, ArrayList<Platform> platforms){
		if(player.isMovingRight())
			addVelocity(1.5, 89, "move right");
		if(player.isMovingLeft())
			addVelocity(1.5, 271, "move left");
		
		if(gravityEnabled)
			addVelocity(4, 180, "gravity");

		for(int n = 0; n < names.size(); n++){
			player.setCanJump(false);
			
			//System.out.println("Apply \"" + names.get(n) + "\" with a speed of " + speeds.get(n) + " at " + angles.get(n) + " degrees.");

			double angle = (2) * Math.PI + ((angles.get(n) - 90) * ((2) * Math.PI / 360));
			double ptX = (player.getX() + speeds.get(n) * Math.cos(angle));
			double ptY = (player.getY() + speeds.get(n) * Math.sin(angle));
			
			for(int p = 0; p < platforms.size(); p++){
				Platform platform = platforms.get(p);

				Rectangle platformRect = new Rectangle(platform.getX(), platform.getY() - platform.getHeight(), platform.getWidth(), platform.getHeight());
				Rectangle playerRect = new Rectangle((int) ptX, (int) (ptY - player.getHeight()), player.getWidth(), player.getHeight());

				if(playerRect.intersects(platformRect)){
					//System.out.println("Intersection detected");
					speeds.set(n, 0.0);
					boolean top = false;
					boolean left = false;

					boolean absoluteNotHorizontalEdge = false;

					int intersectionX = (int) playerRect.intersection(platformRect).getX();
					int intersectionY = (int) playerRect.intersection(platformRect).getY();

					if(intersectionX < platform.getX() + platform.getWidth() / 2){
						left = true;
					}
					else if(intersectionX > platform.getX() + platform.getWidth() / 2 && player.getX() > platform.getX() + platform.getWidth()){
						left = false;
					}

					if(player.getX() > platform.getX() && player.getX() < platform.getX()+ platform.getWidth()){
						absoluteNotHorizontalEdge = true;
					}

					if(intersectionY < platform.getY() - platform.getHeight() / 2){
						top = true;
					}
					else if(intersectionY > platform.getY() - platform.getHeight() / 2){
						top = false;
					}
				
					double xSpeed = Math.abs(ptX - player.getX());
					double ySpeed = Math.abs(ptY - player.getY());
					//System.out.println(xSpeed + " : " + ySpeed);

					
					if(xSpeed == 1 || xSpeed < .25)
						xSpeed = 0;
					
					if(ySpeed == 1 || ySpeed < .25)
						ySpeed = 0;

					if(Math.abs(xSpeed) < Math.abs(ySpeed) || absoluteNotHorizontalEdge){
						if(top){
							ptY = platformRect.getY();
							player.setCanJump(true);
						}
						else{
							ptY = platformRect.getY() + platformRect.getHeight() + player.getHeight();
						}
					}
					else if((Math.abs(xSpeed) > Math.abs(ySpeed) && !absoluteNotHorizontalEdge)){
						if(left){
							ptX = platformRect.getX() - player.getWidth();
						}
						else ptX = platformRect.getX() + platformRect.getWidth();
					}
				}
			}

			player.setX(ptX);
			player.setY(ptY);

			if(speeds.get(n) / FRICTION_VAR > -1 && speeds.get(n) / FRICTION_VAR < 1){
				speeds.set(n, (double) 0);
				angles.set(n, (double) 0);
				names.set(n, "");
				n++;
			}
			else addVelocity(speeds.get(n) / FRICTION_VAR, angles.get(n), names.get(n));
		}
		for(int n = 0; n < names.size(); n++){
			if(names.get(n).equals("")){
				speeds.remove(n);
				angles.remove(n);
				names.remove(n);
			}
		}
	}

	public void setPhysics(EntityPhysics entityPhysics, ItemPhysics itemPhysics){
		this.entityPhysics = entityPhysics;
		this.itemPhysics = itemPhysics;
	}

	public EntityPhysics getEntityPhysics(){
		return entityPhysics;
	}

	public ItemPhysics getItemPhysics(){
		return itemPhysics;
	}
}
