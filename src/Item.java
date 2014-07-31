import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Item extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int row;
	private int col;
	private ImageIcon itemIcon;
	
	public Item(int id, int row, int col){ //NOTE: id will be a value between 1(inclusive) and 9(inclusive).
		this.id = id;
		this.row = row;
		this.col = col;
		setImage();
	}
	
	public void setImage(){
		itemIcon = new ImageIcon("assets/img_0" + id + ".png"); //Hehe.
	}
	
	
	public void drawItem(Graphics g){
		int x = 75 * col;
		int y = 75 * row;
		itemIcon.paintIcon(this, g, x, y);
		System.out.println(id + " , " + x + " , " + y);
	}

}
