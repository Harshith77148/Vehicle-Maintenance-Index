package Vehicle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
public class LoginPage implements ActionListener {
MyPanel panel;
JFrame frame;
JPasswordField passwordfield;
JLabel username,password;
JTextField userfield;
JButton submit,back;
GridBagLayout gbl;
GridBagConstraints gbc;
int count=0;

Connection c=null;

	public LoginPage() {
		frame=new JFrame("Login");
		panel=new MyPanel();
		//frame=new JFrame("Login");
		username=new JLabel("Username");
		password=new JLabel("Password");
		userfield=new JTextField(30);
		passwordfield=new JPasswordField(30);
		submit=new JButton("SUBMIT");
		back=new JButton("BACK");
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		panel.setLayout(gbl);
		gbc.insets=new Insets(5,5,5,5);
		gbc.anchor=GridBagConstraints.CENTER;
		gbc.fill=GridBagConstraints.VERTICAL;
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(username, gbc);
		panel.add(username);
		
		gbc.gridx=10;
		gbc.gridy=0;
		gbl.setConstraints(userfield, gbc);
		panel.add(userfield);
		
		gbc.gridx=0;
		gbc.gridy=10;
		gbl.setConstraints(password, gbc);
		panel.add(password);
		
		gbc.gridx=10;
		gbc.gridy=10;
		gbl.setConstraints(passwordfield, gbc);
		panel.add(passwordfield);
		
		gbc.gridx=0;
		gbc.gridy=20;
		gbl.setConstraints(submit, gbc);
		panel.add(submit);
		
		gbc.gridx=20;
		gbc.gridy=20;
		gbl.setConstraints(back, gbc);
		panel.add(back);
		
		username.setForeground(Color.WHITE);
		password.setForeground(Color.WHITE);
		
		submit.addActionListener(this);
		back.addActionListener(this);
		
		frame.add(panel);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(1400, 850);
		
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		if(ev.getSource()==submit)
		{
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				c=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle1","root","system07");
				Statement stmt=c.createStatement();
				ResultSet rs=stmt.executeQuery("SELECT username,password FROM register1");
				
				while(rs.next())
				{
					System.out.println("username"+rs.getString("username"));
					if((userfield.getText().equals(rs.getString("username")))&&(passwordfield.getText().equals(rs.getString("password"))))
					{
						count=1;
					}
					
				}
				if(count==1)
				{
					JOptionPane.showMessageDialog(frame,"Login Successful");
					
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"Login Unsuccessful");
				}
				userfield.setText("");
				passwordfield.setText("");
				rs.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} 
			
		}
		else if(ev.getSource()==back)
		{
			new Login_Options();
			frame.dispose();
		}
	}

}
