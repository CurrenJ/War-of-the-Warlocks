package Essentials;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Window extends JFrame {
	static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
  // The width and height of the window (in pixels).
	
	public static int WIDTH =  gd.getDisplayMode().getWidth();
	public static int HEIGHT = gd.getDisplayMode().getHeight();
	Object[] modes = {(WIDTH / 3 * 2) + " x " + (HEIGHT / 3 * 2) + " (Recommended)", (WIDTH / 4 * 3) + " x " + (HEIGHT / 4 * 3), (WIDTH / 8 * 7) + " x " + (HEIGHT / 8 * 7), (WIDTH) + " x " + (HEIGHT) + " (Not recommended)", "50 x 100"};
	String size = (String)JOptionPane.showInputDialog(this, "Select a model: " , "", JOptionPane.PLAIN_MESSAGE, null, modes, "");
	
  // The constructor for the Window class.
  public Window(String title) {
    setTitle(title);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    System.out.println("Selected JPanel size: " + size);
    Scanner scanThing = new Scanner(size);
    WIDTH = scanThing.nextInt();
    System.out.println("Width of JPanel: " + WIDTH);
    scanThing.next();
    HEIGHT = scanThing.nextInt();
    System.out.println("Height of JPanel: " + HEIGHT);
    
    setSize(WIDTH, HEIGHT);
    setLocationRelativeTo(null);
    setResizable(true);
  }
  
}