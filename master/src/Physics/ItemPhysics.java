package Physics;

import java.awt.Rectangle;
import java.util.ArrayList;

import Characters.Player;
import Items.Item;

public class ItemPhysics {

	public ItemPhysics(){}

	public boolean touchingPlayer(Player player, Item item){
		Rectangle itemRect = new Rectangle(item.getX(), item.getY() - item.getHeight(), item.getWidth(), item.getHeight());
		Rectangle playerRect = new Rectangle((int) player.getX(), (int) (player.getY() - player.getHeight()), player.getWidth(), player.getHeight());

		if(itemRect.intersects(playerRect)) return true;
		else return false;
	}

	public boolean playerInteraction(Player player, Item item){
		//System.out.println("You're touching " + item.getClass().getSimpleName());
		if(item.getClass().getSimpleName().equals("SoulItem")){
			//System.out.println("It's a soul you're touching!");
			player.addSoul();
			return true;
		}
		else if(item.getClass().getSimpleName().equals("CoinItem")){
			player.setGold(player.getGold() + 1);
			return true;
		}
		else return false;
	}

	public ArrayList<Item> doActions(Player player, ArrayList<Item> items){
		for(int i = 0; i < items.size(); i++){
			Item item = items.get(i);
			if(touchingPlayer(player, item)){
				if(playerInteraction(player, item)){
					items.remove(i);
					i++;
				}
			}
		}
		return items;
	}
}
