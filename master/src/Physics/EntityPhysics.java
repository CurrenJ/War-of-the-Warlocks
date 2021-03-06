package Physics;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

import Characters.Player;
import Entities.Entity;
import Entities.FadingBitEntity;
import Platforms.Platform;

public class EntityPhysics extends Physics{

	public static final double FRICTION_COEFFICIENT = 5;
	public static double frictionVar;

	PlayerPhysics playerPhysics;
	ItemPhysics itemPhysics;

	ArrayList<String> names;
	ArrayList<Double> speeds;
	ArrayList<Double> angles;

	JPanel panel;

	public EntityPhysics(JPanel panel){
		super(panel);
		this.panel = panel;
	}

	public double distanceFormula(double x1, double y1, double x2, double y2){
		return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
	}

	public double angleBetweenPoints(double x1, double y1, double x2, double y2){
		double deltaY = (y2 - y1);
		double deltaX = (x2 - x1);
		return Math.atan2(deltaY, deltaX) * 180 / Math.PI;
	}

	public void attractToPlayer(Entity entity, Player player, int multiplier){
		double dist = distanceFormula(entity.getX(), entity.getY(), player.getX() + player.getWidth() / 2, player.getY() - player.getHeight() / 2);
		addVelocity(0.1 * multiplier, angleBetweenPoints(player.getX() + player.getWidth() / 2, player.getY() - player.getHeight() / 2, entity.getX(), entity.getY()) + 270,"attraction to player", entity);
	}

	public void addVelocity(double speed, double angle, String name, Entity entity){
		names = entity.getNames();
		speeds = entity.getSpeeds();
		angles = entity.getAngles();

		boolean foundMatch = false;
		for(int n = 0; n < names.size() && !foundMatch; n++){
			if(names.get(n).equals(name)){

				speeds.set(n, speed);
				angles.set(n, angle);
				names.set(n, name);

				foundMatch = true;
			}
		}
		if(!foundMatch){
			speeds.add(speed);
			angles.add(angle);
			names.add(name);
		}

		entity.setNames(names);
		entity.setSpeeds(speeds);
		entity.setAngles(angles);
	}

	public void doMovement(Entity entity, ArrayList<Platform> platforms, Player player, int index){
		ArrayList<String> names = entity.getNames();
		ArrayList<Double> speeds = entity.getSpeeds();
		ArrayList<Double> angles = entity.getAngles();
		
		frictionVar = (FRICTION_COEFFICIENT + entity.getFrictionCoefficient()) / 500 + 1;

		if(entity.isGravityEnabled()){
			if(entity.getClass().getSimpleName().equals("GoldBitEntity") || entity.getClass().getSimpleName().equals("OrbBitEntity"))
				addVelocity(1, 180, "gravity", entity);
			else
				addVelocity(4, 180, "gravity", entity);
		}

		if(entity.getClass().getSuperclass().getSimpleName().equals("FadingBitEntity")){
			if(entity.getClass().getSimpleName().equals("SoulBitEntity"))
				attractToPlayer(entity, player, 6);

			FadingBitEntity fadingBit = (FadingBitEntity) entity;
			if(fadingBit.getAge() > fadingBit.LIFE_SPAN){
				entities.remove(index);
			}
		}

		for(int n = 0; n < names.size(); n++){

			//System.out.println("Apply \"" + names.get(n) + "\" with a speed of " + speeds.get(n) + " at " + angles.get(n) + " degrees.");

			double angle = (2) * Math.PI + ((angles.get(n) - 90) * ((2) * Math.PI / 360));
			double ptX = (entity.getX() + speeds.get(n) * Math.cos(angle));
			double ptY = (entity.getY() + speeds.get(n) * Math.sin(angle));

			for(int p = 0; p < platforms.size(); p++){
				Platform platform = platforms.get(p);

				Rectangle platformRect = new Rectangle(platform.getX(), platform.getY() - platform.getHeight(), platform.getWidth(), platform.getHeight());
				Rectangle playerRect = new Rectangle((int) ptX, (int) (ptY - entity.getHeight()), entity.getWidth(), entity.getHeight());

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
					else if(intersectionX > platform.getX() + platform.getWidth() / 2 && entity.getX() > platform.getX() + platform.getWidth()){
						left = false;
					}

					if(entity.getX() > platform.getX() && entity.getX() < platform.getX()+ platform.getWidth()){
						absoluteNotHorizontalEdge = true;
					}

					if(intersectionY < platform.getY() - platform.getHeight() / 2){
						top = true;
					}
					else if(intersectionY > platform.getY() - platform.getHeight() / 2){
						top = false;
					}

					double xSpeed = Math.abs(ptX - entity.getX());
					double ySpeed = Math.abs(ptY - entity.getY());
					//System.out.println(xSpeed + " : " + ySpeed);


					if(xSpeed == 1 || xSpeed < .25)
						xSpeed = 0;

					if(ySpeed == 1 || ySpeed < .25)
						ySpeed = 0;

					if(Math.abs(xSpeed) < Math.abs(ySpeed) || absoluteNotHorizontalEdge){
						if(top){
							ptY = platformRect.getY();
						}
						else{
							ptY = platformRect.getY() + platformRect.getHeight() + entity.getHeight();
						}
					}
					else if((Math.abs(xSpeed) > Math.abs(ySpeed) && !absoluteNotHorizontalEdge)){
						if(left){
							ptX = platformRect.getX() - entity.getWidth();
						}
						else ptX = platformRect.getX() + platformRect.getWidth();
					}
				}
			}

			entity.setX(ptX);
			entity.setY(ptY);

			if(speeds.get(n) / frictionVar > -0.01 && speeds.get(n) / frictionVar < 0.01){
				speeds.set(n, (double) 0);
				angles.set(n, (double) 0);
				names.set(n, "");
				n++;
			}
			else addVelocity(speeds.get(n) / frictionVar, angles.get(n), names.get(n), entity);
		}
		for(int n = 0; n < names.size(); n++){
			if(names.get(n).equals("")){
				speeds.remove(n);
				angles.remove(n);
				names.remove(n);
			}
		}
	}

	public void setPhysics(PlayerPhysics playerPhysics, ItemPhysics itemPhysics) {
		this.playerPhysics = playerPhysics;
		this.itemPhysics = itemPhysics;
	}

	public PlayerPhysics getPlayerPhysics(){
		return playerPhysics;
	}

	public ItemPhysics getItemPhysics(){
		return itemPhysics;
	}
}
