package Vehicle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Login_Options implements ActionListener {

	JFrame frame;
	MyPanel panel;
	JButton loginbutton,registerbutton;
	GridBagLayout gbl;
	GridBagConstraints gbc;
		public Login_Options() {
		frame=new JFrame("Service Station");
		panel=new MyPanel();
		loginbutton=new JButton("Login");
		registerbutton=new JButton("Register");
		
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		
		
		gbc.insets=new Insets(5,5,5,5);
		gbc.anchor=GridBagConstraints.CENTER;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
		gbc.gridx=0;
		gbc.gridy=0;
		//gbc.weightx=
		gbl.setConstraints(loginbutton, gbc);
		panel.add(loginbutton);
		
		gbc.gridx=0;
		gbc.gridy=10;
		
		gbl.setConstraints(registerbutton, gbc);
		panel.add(registerbutton);
		
		panel.setLayout(gbl);
		frame.add(panel);
		
		loginbutton.addActionListener(this);
		registerbutton.addActionListener(this);
		
		frame.setVisible(true);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((d.width-1400)/2, (d.height-850)/2);
		frame.setResizable(false);
		frame.setSize(1400,850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String args[])
	{
		new Login_Options();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginbutton) {
			new LoginPage();
			frame.dispose();
			
		}
		else if(e.getSource()==registerbutton)
		{
			new registerpage();
			frame.dispose();
		}
	}

}
