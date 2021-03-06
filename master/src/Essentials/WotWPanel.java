package Essentials;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Cameras.Camera;
import Characters.Player;
import Graphics.EntityGraphics;
import Graphics.InventoryGraphics;
import Graphics.ItemGraphics;
import Graphics.PlatformGraphics;
import Graphics.PlayerGraphics;
import Items.Item;
import Items.SoulItem;
import Levels.Level;
import Levels.Level1;
import Physics.ItemPhysics;
import Physics.PlayerPhysics;
import Platforms.Platform;


public class WotWPanel extends JPanel implements KeyListener, MouseListener, ComponentListener{
	JTextField typingArea;
	static Window window;
	ArrayList<Level> levels;
	int levelNum = 0;
	Graphics2D g = null;

	Level1 level1;
	Player player;
	Level level;

	public WotWPanel(Window window) throws Exception{
		this.window = window;

		typingArea = new JTextField();
		typingArea.addKeyListener(this);
		addMouseListener(this);
		add(typingArea, BorderLayout.PAGE_START);
		this.window.addComponentListener(this);

		setBackground(Color.decode("#FFFFFF"));
		setPreferredSize(new Dimension(window.WIDTH, window.HEIGHT));
		setDoubleBuffered(true);

		player = new Player(null, 10, getHeight(), 50, 25, 0, 0, 0, 24, 44);
		levels = new ArrayList();

		level1 = new Level1(player, this);
		levels.add(level1);

		loadLevel();
	}

	public void loadLevel(){
		level = levels.get(levelNum);

		level.initialize();
	}

	public void paint(Graphics graphics){
		super.paint(graphics);
		g = (Graphics2D)graphics;
		
		level.paint(g);
	}

	public int getMouseX(){
		return (int) (MouseInfo.getPointerInfo().getLocation().getX()-window.getX());
	}

	public int getMouseY(){
		return (int) (MouseInfo.getPointerInfo().getLocation().getY()-window.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		level.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		level.keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		level.resize();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
