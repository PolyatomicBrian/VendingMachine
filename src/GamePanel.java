
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class GamePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon machine;
	private int[] items;
	private int range = 9;
	private ArrayList<Item> listItem;
	
	public GamePanel(){
		listItem = new ArrayList<Item>();
		panelSetup();
		runGP();
	}
	
	public void panelSetup(){
		setLayout(new GridLayout());
		setFocusable(true);
		setBackground(Color.BLACK);
	}
	
	public void runGP(){
		setMachineIcon();
		createItems();
	}
	
	public void setMachineIcon(){
		machine = new ImageIcon("assets/img_machine.png");
	}
	
	public void createItems(){
		items = new int[9];
		for (int i = 0; i<items.length; i++){
			items[i] = i+1;
		}
		shuffleItems();
		createItemObjects();
	}
	
	public void shuffleItems(){
		int rndIndex = (int)(range * Math.random());
		int temp1 = items[rndIndex];
		int temp2 = items[items.length-1];
		items[items.length-1] = temp1;
		items[rndIndex] = temp2;
		range--;
		if (range > 1)
			shuffleItems();
	}
	
	public void createItemObjects(){
		int col = 1;
		for (int i = 0; i<items.length; i++){
			if (col > 3)
				col = 1;
			Item oitem;
			if (i <= 2)
				oitem = new Item(items[i], 1, col);
			else if (i <= 5)
				oitem = new Item(items[i], 2, col);
			else
				oitem = new Item(items[i], 3, col);
			listItem.add(oitem);
			col++;
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		drawMachine(g);
		drawItems(g);
	}
	
	public void drawMachine(Graphics g){
		int x = 0;
		int y = 0;
		machine.paintIcon(this, g, x, y);
	}
	
	public void drawItems(Graphics g){
		for (int i = 0; i<listItem.size(); i++){
			listItem.get(i).drawItem(g);
		}
	}
	
	
}
