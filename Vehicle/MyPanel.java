package Vehicle;
import java.awt.*;


import javax.swing.*;

public class MyPanel extends JPanel {
	ImageIcon image;
	

	public MyPanel() {
		// TODO Auto-generated constructor stub
		image= new ImageIcon("13.jpg");
		
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(image.getImage(), 0, 0, 1400,850, null);
	}

}
