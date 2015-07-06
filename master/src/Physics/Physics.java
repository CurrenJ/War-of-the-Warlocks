package Physics;

import java.util.ArrayList;

import Entities.Entity;
import Items.Item;

public class Physics {
	ArrayList<Entity> entities;
	ArrayList<Item> items;

	public Physics(){}
	
	public void setLists(ArrayList<Entity> entities, ArrayList<Item> items){
		this.entities = entities;
		this.items = items;
	}
	
	public ArrayList<Entity> getEntities(){
		return entities;
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
}
