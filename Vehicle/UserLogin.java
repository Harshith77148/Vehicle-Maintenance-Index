package Vehicle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class UserLogin implements ActionListener{
	private JFrame frmLoginSystem;

	MyPanel panel;
	JFrame frame;
	JLabel email,name;
	JTextField userfield,namefield;
	JButton submit,exit;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	
	public UserLogin() {
		// TODO Auto-generated constructor stub
		frame=new JFrame("User Login");
		panel=new MyPanel();
		//frame=new JFrame("Login");
		email=new JLabel("email id");
		name=new JLabel("Name");
		userfield=new JTextField(30);
		namefield=new JTextField(30);
		submit=new JButton("SUBMIT");
		exit=new JButton("EXIT");
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		panel.setLayout(gbl);
		gbc.insets=new Insets(5,5,5,5);
		gbc.anchor=GridBagConstraints.CENTER;
		gbc.fill=GridBagConstraints.VERTICAL;
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(email, gbc);
		panel.add(email);
		
		gbc.gridx=10;
		gbc.gridy=0;
		gbl.setConstraints(userfield, gbc);
		panel.add(userfield);
		
		gbc.gridx=0;
		gbc.gridy=10;
		gbl.setConstraints(name, gbc);
		panel.add(name);
		
		gbc.gridx=10;
		gbc.gridy=10;
		gbl.setConstraints(namefield, gbc);
		panel.add(namefield);
		
		gbc.gridx=0;
		gbc.gridy=20;
		gbl.setConstraints(submit, gbc);
		panel.add(submit);
		
		gbc.gridx=20;
		gbc.gridy=20;
		gbl.setConstraints(exit, gbc);
		panel.add(exit); 
		
		email.setForeground(Color.WHITE);
		name.setForeground(Color.WHITE);
		
		submit.addActionListener(this);
		exit.addActionListener(this);
		
		frame.add(panel);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(1400, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new UserLogin();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submit)
		{
	//		new UserBrandPage();
			frame.dispose();
		}
		if(e.getSource()==exit)
		{
			frmLoginSystem = new JFrame("Exit");
			if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit","Login Systems",JOptionPane.YES_NO_OPTION)
					== JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
		}
		
	}
	
}
