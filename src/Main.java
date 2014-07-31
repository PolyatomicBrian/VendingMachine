import java.awt.Container;

import javax.swing.JFrame;


public class Main {

	private final static String name = "Vending Machine";
	private final static int resWidth = 400;
	private final static int resHeight = 550;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setTitle(name);
		f.setSize(resWidth, resHeight);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = f.getContentPane();
		
		GamePanel gp = new GamePanel();
		pane.add(gp);
		
		f.setVisible(true);
	}

}
