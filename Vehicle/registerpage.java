package Vehicle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class registerpage implements ActionListener
{
	JFrame frame;
	MyPanel panel, headingpanel,formpanel,buttonpanel;
	JLabel headinglabel,namelabel,usernamelabel,passwordlabel,confirmlabel,addresslabel,citylabel,statelabel,contactlabel;
	JTextField namefield,usernamefield,addressfield,contactfield;
	JPasswordField passwordfield,confirmfield;
	JComboBox<String> city,state;
	JButton submitbutton,cancelbutton;
	
	BorderLayout bl;
	FlowLayout fl;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	Connection con=null;
	PreparedStatement ps=null;
	
	
	
	

	public registerpage() 
	{
		frame=new JFrame("Registration Form");
		
		panel=new MyPanel();
		
		headingpanel=new MyPanel();
		formpanel=new MyPanel();
		buttonpanel=new MyPanel();
		
		
		headinglabel=new JLabel("Registration Form");
		
		namelabel=new JLabel("Name");
		usernamelabel=new JLabel("Usrename");
		passwordlabel=new JLabel("Password");
		confirmlabel=new JLabel("Confirm Password");
		addresslabel=new JLabel("Address");
		citylabel=new JLabel("City");
		statelabel=new JLabel("State");
		contactlabel=new JLabel("Contact No.");

		
		namefield=new JTextField(15);
		usernamefield=new JTextField(15);
		addressfield=new JTextField(15);
		contactfield=new JTextField(15);
	//	city=new JTextField(15);
	//	state=new JTextField(15);
		
		passwordfield=new JPasswordField(15);
		confirmfield=new JPasswordField(15);
		
		submitbutton=new JButton("Submit");
		cancelbutton=new JButton("Cancel");
		
		city=new JComboBox<String>();
		
		state=new JComboBox<String>();
		
		submitbutton.addActionListener(this);
		cancelbutton.addActionListener(this);
		
		bl=new BorderLayout();
		fl=new FlowLayout(FlowLayout.CENTER);
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		
		panel.setLayout(bl);
		
		panel.add(headingpanel,BorderLayout.NORTH);
		panel.add(formpanel,BorderLayout.WEST);
		panel.add(buttonpanel,BorderLayout.SOUTH);
		
		headingpanel.setLayout(fl);
		headingpanel.add(headinglabel);
		
		formpanel.setLayout(gbl);
		
		city.addItem("-select-");
		city.addItem("Faridabad");
		city.addItem("Panipat");
		city.addItem("Karnal");
		city.addItem("Ambala");
		
		state.addItem("-select-");
		state.addItem("Haryana");
		state.addItem("Delhi");
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets=new Insets(0,15,15,0);
		gbl.setConstraints(namelabel, gbc);
		formpanel.add(namelabel);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(namefield, gbc);
		formpanel.add(namefield);


		gbc.gridx=0;
		gbc.gridy=1;
		gbl.setConstraints(usernamelabel, gbc);
		formpanel.add(usernamelabel);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbl.setConstraints(usernamefield, gbc);
		formpanel.add(usernamefield);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbl.setConstraints(passwordlabel, gbc);
		formpanel.add(passwordlabel);
		
		gbc.gridx=1;
		gbc.gridy=2;
		gbl.setConstraints(passwordfield, gbc);
		formpanel.add(passwordfield);
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbl.setConstraints(confirmlabel, gbc);
		formpanel.add(confirmlabel);
		
		gbc.gridx=1;
		gbc.gridy=3;
		gbl.setConstraints(confirmfield, gbc);
		formpanel.add(confirmfield);
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbl.setConstraints(addresslabel, gbc);
		formpanel.add(addresslabel);
		
		gbc.gridx=1;
		gbc.gridy=4;
		gbl.setConstraints(addressfield, gbc);
		formpanel.add(addressfield);
		
		gbc.gridx=0;
		gbc.gridy=5;
		gbl.setConstraints(statelabel, gbc);
		formpanel.add(statelabel);
		
		gbc.gridx=1;
		gbc.gridy=5;
		gbl.setConstraints(state, gbc);
		formpanel.add(state);


		gbc.gridx=0;
		gbc.gridy=6;
		gbl.setConstraints(citylabel, gbc);
		formpanel.add(citylabel);
		
		gbc.gridx=1;
		gbc.gridy=6;
		gbl.setConstraints(city, gbc);
		formpanel.add(city);
		
		gbc.gridx=0;
		gbc.gridy=7;
		gbl.setConstraints(contactlabel, gbc);
		formpanel.add(contactlabel);
		
		gbc.gridx=1;
		gbc.gridy=7;
		gbl.setConstraints(contactfield, gbc);
		formpanel.add(contactfield);
		
		buttonpanel.add(submitbutton);
		buttonpanel.add(cancelbutton);
		
		frame.add(panel);
		frame.setSize(1300,750);
		frame.setVisible(true);
		frame.setResizable(false);
		
		
		
		
		
		
	}
	
	
	public static void main(String ar[])
	{
		new registerpage();
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==submitbutton)
		{
			try
			{
				if(namefield.getText().equals("")||usernamefield.getText().equals("")||passwordfield.getText().equals("")||confirmfield.getText().equals("")||addressfield.getText().equals("")||contactfield.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frame, "* cannot be empty");
				}
				else if(passwordfield.getText().equals(confirmfield.getText()))
				{
					Class.forName("com.mysql.cj.jdbc.Driver");  
					//Connection con=DriverManager.getConnection(  
					//"jdbc:mysql://localhost:3306/sonoo","root","root");  
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle1","root","system07");
					Statement stmt=con.createStatement();
					ps=con.prepareStatement("insert into register1 values(?,?,?,?,?,?,?,?)");
					
					
					ps.setString(1, namefield.getText());
					ps.setString(2,usernamefield.getText());
					ps.setString(3, passwordfield.getText());
					ps.setString(4, confirmfield.getText());
					ps.setString(5, addressfield.getText());
					ps.setString(6, state.getSelectedItem().toString());
					ps.setString(7, city.getSelectedItem().toString());
					ps.setString(8, contactfield.getText());
					//System.out.println(city.getSelectedItem().toString());
					namefield.setText("");
					usernamefield.setText("");
					passwordfield.setText("");
					confirmfield.setText("");
					addressfield.setText("");
					contactfield.setText("");
					state.setSelectedIndex(0);
					city.setSelectedIndex(0);
					//city.setText("");
					//state.setText("");
					
					int i=ps.executeUpdate();
					//ps.executeQuery();
					if(i>0)
					{
						JOptionPane.showMessageDialog(frame, "Record Successfully inserted");
						
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"Problem in Server..!!");
					}
					ps.close();
					
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"Wrong values entered");
					namefield.setText("");
					usernamefield.setText("");
					passwordfield.setText("");
					confirmfield.setText("");
					addressfield.setText("");
					contactfield.setText("");
					state.setSelectedIndex(0);
					city.setSelectedIndex(0);
				}
				//stmt.close();
				//con.close();
			}
			catch(Exception ee)
			{
				
			}
		}
		else if(evt.getSource()==cancelbutton)
		{
			frame.dispose();
		}
	}
	
	

}
