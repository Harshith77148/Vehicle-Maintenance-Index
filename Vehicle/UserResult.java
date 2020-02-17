package Vehicle;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
public class UserResult {
	
	JFrame frame;
	JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14,label15,label16,label17,label18,label19;
	JPanel panel;
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	
	public UserResult(String s1,String s2,String s3 ) {
		
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle1","root","system07");
			String sql="select year from main where brand=? and model=? and engine=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
			rs=ps.executeQuery();
			while(rs.next()){
				label12=new JLabel(rs.getString("year"));
			}
			
		}
		catch(Exception ee){}
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle1","root","system07");
			String sql1="select price from main where brand=? and model=? and engine=?";
			ps=con.prepareStatement(sql1);
			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
			rs=ps.executeQuery();
			while(rs.next()){
				label13=new JLabel(rs.getString("price"));
			}
			
		}
		catch(Exception ee){}
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle1","root","system07");
			String sql2="select mileage from main where brand=? and model=? and engine=?";
			ps=con.prepareStatement(sql2);
			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
			rs=ps.executeQuery();
			while(rs.next()){
				label14=new JLabel(rs.getString("mileage"));
			}
			
		}
		catch(Exception ee){}
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle1","root","system07");
			String sql3="select transmission from main where brand=? and model=? and engine=?";
			ps=con.prepareStatement(sql3);
			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
			rs=ps.executeQuery();
			while(rs.next()){
				label15=new JLabel(rs.getString("transmission"));
			}
			
		}
		catch(Exception ee){}
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle1","root","system07");
			String sql4="select summary from main where brand=? and model=? and engine=?";
			ps=con.prepareStatement(sql4);
			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
			rs=ps.executeQuery();
			while(rs.next()){
				label16=new JLabel(rs.getString("summary"));
			}
			
		}
		catch(Exception ee){}
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle1","root","system07");
			String sql6="select count(parts),parts from service_station group by parts,model,engine having model=? and engine=?";
			
			
			//String sql5="select parts from service_station where brand=? and model=? and engine=?";
			ps=con.prepareStatement(sql6);
			//ps.setString(1, s1);
			ps.setString(1, s2);
			ps.setString(2, s3);
			rs=ps.executeQuery();
			while(rs.next()){
				
				if(rs.getInt("count(parts)")>2)
					
				{
				//System.out.println(rs.getString("parts"));
				label18=new JLabel(rs.getString("parts")+" is diagonaised to be problematic");
//				rs.next();
//				label19=new JLabel(rs.getString("parts")+" is diagonaised to be problematic");
//				
				
//					int i=50;
				
				
//					panel.add( new JLabel(rs.getString("parts")+" is diagonaised to be problematic").setBounds(150,452+i, 500, 100));
//                    panel.validate();
//                    i=i+50;
				
					break;
				}
				else
				{
					//System.out.println("No part cause any maintenance issue, this vehicle is good to go");
					label18=new JLabel("No part cause any maintenance issue, this vehicle is good to go!");
				}
				
				
				//label16=new JLabel(rs.getString("summary"));
			}
			
			
		}
		catch(Exception ee){}
		
		frame=new JFrame();
		label1=new JLabel("Brand :");
		label2=new JLabel("Model :");
		label3=new JLabel("Engine :");
		label4=new JLabel("Year :");
		label5=new JLabel("Price :");
		label6=new JLabel("Mileage :");
		label7=new JLabel("Transmission :");
		label8=new JLabel("Summary :");
		label17=new JLabel("Maintenance Index :");
		label9=new JLabel(s1);
		label10=new JLabel(s2);
		label11=new JLabel(s3);

		
		panel=new JPanel();
		label1.setBounds(1, 1,100,100);
		panel.add(label1);
		label9.setBounds(150, 1,500,100);
		panel.add(label9);
		label2.setBounds(1,52,100,100);
		panel.add(label2);
		label10.setBounds(150, 52,500,100);
		panel.add(label10);
		label3.setBounds(1,102,100,100);
		panel.add(label3);
		label11.setBounds(150, 102,500,100);
		panel.add(label11);
		label4.setBounds(1,152,100,100);
		panel.add(label4);
		label12.setBounds(150, 152,500,100);
		panel.add(label12);
		label5.setBounds(1,202,100,100);
		panel.add(label5);
		label13.setBounds(150, 202,500,100);
		panel.add(label13);
		label6.setBounds(1,252,100,100);
		panel.add(label6);
		label14.setBounds(150, 252,500,100);
		panel.add(label14);
		label7.setBounds(1,302,100,100);
		panel.add(label7);
		label15.setBounds(150, 302,500,100);
		panel.add(label15);
		label8.setBounds(1,352,100,100);
		panel.add(label8);
		label16.setBounds(150, 352,500,100);
		panel.add(label16);
		label17.setBounds(1,402,150,100);
		panel.add(label17);
		label18.setBounds(150,402,500,100);
		panel.add(label18);
		label19.setBounds(1, 452, 100, 100);
		panel.add(label19);
		
		frame.add(panel);
		panel.setLayout(null);
		
		frame.setVisible(true);
		frame.setSize(1250, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}
	
	public static void main(String args[])
	{
		//new UserResult("skoda","rapid","diesel");
	}
	

}
