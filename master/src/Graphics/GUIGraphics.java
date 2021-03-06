package Graphics;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Cameras.Camera;
import Characters.Player;

public class GUIGraphics {
	JPanel panel;
	public static Map<String, Image> GUIImages;

	public GUIGraphics(JPanel panel){
		this.panel = panel;
		GUIImages = new HashMap<String, Image>();
		
		try{
			GUIImages.put("goldIcon", ImageIO.read(new URL("file:coin.png")));
			GUIImages.put("soulIcon", ImageIO.read(new URL("file:soul_15.png")));
			for(int i = 0; i <= 100; i++){
				GUIImages.put("manaBar_" + i, ImageIO.read(new URL("file:manaBar_" + i + ".png")));
			}
		} catch(Exception e){ e.printStackTrace(); }
	}
	
	public void drawGUI(Player player, Graphics2D g, Camera camera){
			Image soulImage = GUIImages.get("soulIcon");
			Image goldImage = GUIImages.get("goldIcon");
			Image manaBarImage = GUIImages.get("manaBar_" + (int) player.getPercentHealth());
			Image scaledSoulImage = soulImage;
			Image scaledGoldImage = goldImage;
			Image scaledManaBarImage = manaBarImage;
			
			double scale = (panel.getHeight() + panel.getWidth()) / 2 / 208;
			if(scale < 1.5) scale = 1.5;

			int manaBarY = (int) scale;
			scaledManaBarImage = manaBarImage.getScaledInstance((int) (manaBarImage.getWidth(panel)*scale), (int) (manaBarImage.getHeight(panel)*scale), 0);
			int manaBarImageHeight = scaledManaBarImage.getHeight(panel);
			int manaBarX = (int) (panel.getWidth() -  scaledManaBarImage.getWidth(panel) - scale);
			
			g.drawImage(scaledManaBarImage, manaBarX, manaBarY, panel);
			
			int soulImageY = (int) scale + manaBarImageHeight;
			scaledSoulImage = soulImage.getScaledInstance((int) (soulImage.getWidth(panel)*scale), (int) (soulImage.getHeight(panel)*scale), 0);
			int soulImageX = (int) (panel.getWidth() - scaledSoulImage.getWidth(panel) - scale);

			g.drawImage(scaledSoulImage, soulImageX, soulImageY, panel);

			Font fontHUD = new Font("Cambria", 0, (int) (scaledSoulImage.getHeight(panel) / 1.5));

			g.setFont(fontHUD);
			String soulDisplay = "" + player.getSouls();
			g.drawString(soulDisplay, (int) (soulImageX - g.getFontMetrics().stringWidth(soulDisplay) - scale), soulImageY + scaledSoulImage.getHeight(panel) / 2 + g.getFontMetrics().getAscent() / 2);
			
			
			
			g.setFont(fontHUD);
			String goldDisplay = "" + player.getGold();
			
			scaledGoldImage = goldImage.getScaledInstance((int) (goldImage.getWidth(panel)*scale), (int) (goldImage.getHeight(panel)*scale), 0);
			int goldImageY = (int) scale + scaledSoulImage.getHeight(panel) / 2 - scaledGoldImage.getHeight(panel) / 2 + scaledSoulImage.getHeight(panel) + manaBarImageHeight;
			int goldImageX = (int) ((panel.getWidth() - goldImage.getWidth(panel) * scale - scale));
			
			g.drawString(goldDisplay, (int) (goldImageX - g.getFontMetrics().stringWidth(goldDisplay) - scale), goldImageY + scaledGoldImage.getHeight(panel) / 2 + g.getFontMetrics().getAscent() / 2);

			g.drawImage(scaledGoldImage, goldImageX, goldImageY, panel);
		
			
//			g.drawString(fps + "", panel.getWidth() - g.getFontMetrics().stringWidth(fps + ""), panel.getHeight());
	}
}
