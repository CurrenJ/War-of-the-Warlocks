package Essentials;
import java.util.Random;

public class Main {
  
  public static void main(String args[]) throws Exception {
	  
    Window window = new Window("Edit title in \"Main.java\"");
    WotWExecution area = new WotWExecution(window);
    window.requestFocus();
    window.add(area);
    window.pack();
    window.setVisible(true);
    area.start(window); 
  }
  
}
