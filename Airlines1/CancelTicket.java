import java.io.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CancelTicket extends JFrame implements ActionListener 
{
       
  	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
  	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
  	JButton b1,b2,b3,b4,b5,b6;
	Connection con;
	Statement s;
	ResultSet r;
  	
public CancelTicket()
{      
	connection(); 
 	setLayout(null);
	String driver_class="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uid="system";
		String password="system";	

	try
  	   {
   	       Class.forName(driver_class);
     	       con=DriverManager.getConnection(url,uid,password);
     	       s=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
     }
     catch(Exception e)
     {
     //System.out.println(e);
     }

	
	l1=new JLabel("Passenger Id",JLabel.LEFT);
	add(l1);l1.setBounds(100,60,100,25);
	t1=new JTextField();
	t1.setBounds(220,60,150,25);add(t1);

		
	
	b1=new JButton("Delete");add(b1);
	b1.setBounds(80,500,100,25);
	b1.addActionListener(this);

	b2=new JButton("Clear");add(b2);
	b2.setBounds(200,500,100,25);
	b2.addActionListener(this);

       
        setTitle("Reservation Cancellation  Form... ");
        setVisible(true);
        setSize(500,700);
    	JLabel li=new JLabel(new ImageIcon("images/can.jpg"));add(li);
        li.setBounds(0,0,500,650);
         setResizable(false);
	
  }
public void actionPerformed(ActionEvent e)
{

if(e.getSource()==b1)
	{
 
     del();
}



if(e.getSource()==b2)
	{
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		t8.setText("");
		//t9.setText("");
		//t10.setText("");
              //  t11.setText("");
              //  t12.setText("");
              //  t13.setText("");
	}
	

}
public static void main(String args[])throws Exception
        {

   	new CancelTicket();
        }
 
public void del()
 {
    try

   {
//String x=JOptionPane.showInputDialog(null,"Enter the Passenger Id=");
String x=t1.getText();
s.executeUpdate("delete from Ticket where Passenger_Id="+x+" ");
JOptionPane.showMessageDialog(this,"ticket cancelled Successfully");   
  }
catch(Exception e)
{
    }
    }
public void connection()
{
        try
        {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        }
        catch(Exception er)
        {
        }
        try
        {
                con=DriverManager.getConnection("jdbc:odbc:Airline");
        s=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                r=s.executeQuery("select * from Pinfor");
 }
        catch(Exception e)
        {
        }
}
}

