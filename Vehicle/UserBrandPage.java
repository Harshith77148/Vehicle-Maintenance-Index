package Vehicle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import java.sql.*;

public class UserBrandPage implements PopupMenuListener,ActionListener {
JFrame frame;
JPanel panel;
JLabel brandname,modelname,enginename,rangename;
JComboBox brandcombo,modelcombo,enginecombo,rangecombo;
JButton button1,button2;
GridBagLayout gbl;
GridBagConstraints gbc;
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null,rs1=null;
int i=1;
	public UserBrandPage() {
		
		frame =new JFrame(" ");
		panel=new JPanel();
		brandname=new JLabel("Brand");
		modelname=new JLabel("Model");
		enginename=new JLabel("Engine");
		//rangename=new JLabel("Range");
		button1=new JButton("Click Me After You Select Brand");
		button2=new JButton("Submit");
		
		String brand[]={"please select your Brand"};
		String model[]={"please select your Model"};
		String engine[]={"please select your Engine","petrol","diesel","CNG","LPG","electric"};
	//	String range[]={"please select your Range","2 lacs-5 lacs","6 lacs-10 lacs","10 lacs-20 lacs","21 lacs-40 lacs","more than 40 lacs"};
	
		brandcombo=new JComboBox(brand);
		modelcombo=new JComboBox(model);
		enginecombo=new JComboBox(engine);
	//	rangecombo=new JComboBox(range);
	
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		
		//brandcombo.addItem("Ford");
		panel.setLayout(gbl);
		
		gbc.insets=new Insets(10,10,10,10);
		gbc.anchor=GridBagConstraints.CENTER;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(brandname, gbc);
		panel.add(brandname);
		
		gbc.gridx=20;
		gbc.gridy=0;
		gbl.setConstraints(brandcombo, gbc);
		panel.add(brandcombo);
		
		gbc.gridx=20;
		gbc.gridy=20;
		gbl.setConstraints(button1, gbc);
		panel.add(button1);

		gbc.gridx=0;
		gbc.gridy=40;
		gbl.setConstraints(modelname, gbc);
		panel.add(modelname);
		
		gbc.gridx=20;
		gbc.gridy=40;
		gbl.setConstraints(modelcombo, gbc);
		panel.add(modelcombo);
		
		gbc.gridx=0;
		gbc.gridy=50;
		gbl.setConstraints(enginename, gbc);
		panel.add(enginename);
		
		gbc.gridx=20;
		gbc.gridy=50;
		gbl.setConstraints(enginecombo, gbc);
		panel.add(enginecombo);
		
//		gbc.gridx=0;
//		gbc.gridy=50;
//		gbl.setConstraints(rangename, gbc);
//		panel.add(rangename);
//		
//		gbc.gridx=20;
//		gbc.gridy=50;
//		gbl.setConstraints(rangecombo, gbc);
//		panel.add(rangecombo);
		
		
		
		gbc.gridx=20;
		gbc.gridy=90;
		gbl.setConstraints(button2, gbc);
		panel.add(button2);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		frame.add(panel);
		frame.setSize(1250, 650);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle1","root","system07");
			rs1=con.createStatement().executeQuery("select distinct brand from main");
			while(rs1.next()){
				brandcombo.addItem(rs1.getString("brand"));
				
			}
			//System.out.println("connected");
			
		}
		catch(Exception ee){}
		
	}
public static void main(String[] args){
	new UserBrandPage();
}
public void actionPerformed(ActionEvent evt) {
	// TODO Auto-generated method stub
	
	if(evt.getSource()==button1 && i==1){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle1","root","system07");
		//	rs=con.createStatement().executeQuery("select model from main where brand=" + (String)brandcombo.getSelectedItem());
			String temp=(String) brandcombo.getSelectedItem();
		//	String temp1=(String) enginecombo.getSelectedItem();
			String sql="select model from main where brand=?";
			//rs=con.createStatement().executeQuery("select')
			ps=con.prepareStatement(sql);
			ps.setString(1, temp);
			rs=ps.executeQuery();
			//System.out.println(temp);
			while(rs.next()){
				modelcombo.addItem(rs.getString("model"));
			}
			i++;
			//System.out.println("connected 2");
			
		}
		catch(Exception ee){}
	}
else if(evt.getSource()==button2){
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle1","root","system07");
	//	rs=con.createStatement().executeQuery("select model from main where brand=" + (String)brandcombo.getSelectedItem());
		String temp=(String) brandcombo.getSelectedItem();
		String temp1=(String) enginecombo.getSelectedItem();
		String temp2=(String) modelcombo.getSelectedItem();
		String sql="select summary from main where brand=? and model=? and engine=?";
		//rs=con.createStatement().executeQuery("select')
		ps=con.prepareStatement(sql);
		ps.setString(1, temp);
		ps.setString(2, temp2);
		ps.setString(3, temp1);
		rs=ps.executeQuery();
		//System.out.println(temp);
		while(rs.next()){
			//JOptionPane.showMessageDialog(frame, ""+rs.getString("summary"));
			
			
		}
		new UserResult(temp,temp2,temp1);
		//System.out.println("connected 2");
		
		
	}
	catch(Exception ee){}
	}
}
public void popupMenuCanceled(PopupMenuEvent arg0) {
	// TODO Auto-generated method stub
	
}
public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
	// TODO Auto-generated method stub
	
}
public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
