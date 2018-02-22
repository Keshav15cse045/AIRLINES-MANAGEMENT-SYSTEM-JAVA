import java.io.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddTicket extends JFrame implements ActionListener 
{
 	
  	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
  	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
  	JButton b1,b2,b3,b4,b5,b6,b7;
	Connection con;
	Statement s;
	ResultSet r;
  	
public AddTicket()
{
	String driver_class="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uid="system";
		String password="system";
	
	connection(); 
 	setLayout(null);	

	try
  	   {
   	       Class.forName(driver_class);
     	       con=DriverManager.getConnection(url,uid,password);
     	       s=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
     }
     catch(Exception e)
     {
     System.out.println(e);
     }

	
	l1=new JLabel("Passenger Name",JLabel.LEFT);
	add(l1);l1.setBounds(100,60,100,25);
	t1=new JTextField();
	t1.setBounds(220,60,150,25);add(t1);

	l2=new JLabel("Passenger Id",JLabel.LEFT);
	add(l2);l2.setBounds(100,100,100,25);
	t2=new JTextField(10);add(t2);
	t2.setBounds(220,100,150,25);
	
      	  l3=new JLabel("Flight No",JLabel.LEFT);
	add(l3);l3.setBounds(100,140,100,25);
	t3=new JTextField(10);	add(t3);
	t3.setBounds(220,140,150,25);

	l4=new JLabel("Select Class ",JLabel.LEFT);
	add(l4);l4.setBounds(100,180,100,25);
	t4=new JTextField(10);add(t4);
	t4.setBounds(220,180,150,25);

   	l5=new JLabel("Source",JLabel.LEFT);
	add(l5);l5.setBounds(100,220,100,25);
	t5=new JTextField(10);add(t5);
	t5.setBounds(220,220,150,25);
        
	l6=new JLabel("Destination",JLabel.LEFT);
	add(l6);l6.setBounds(100,260,100,25);
	t6=new JTextField(10);add(t6);
	t6.setBounds(220,260,150,25);

	l7=new JLabel("No of Seat",JLabel.LEFT);
	add(l7);l7.setBounds(100,300,100,25);
	t7=new JTextField(10);add(t7);
	t7.setBounds(220,300,150,25);

	l8=new JLabel("Total Amount",JLabel.LEFT);
	add(l8);l8.setBounds(100,340,100,25);
	t8=new JTextField(10);add(t8);
	t8.setBounds(220,340,150,25);
	
	
	/*l9=new JLabel("",JLabel.LEFT);
	add(l9);l9.setBounds(100,380,100,25);
	t9=new JTextField(10);add(t9);
	t9.setBounds(220,380,150,25);*/

	/*l10=new JLabel("Total_Amount",JLabel.LEFT);
	add(l10);l10.setBounds(100,420,100,25);
	t10=new JTextField(10);add(t10);
	t10.setBounds(220,420,150,25);*/
	

	/*l11=new JLabel("No. of Seat",JLabel.LEFT);
	add(l11);l11.setBounds(100,460,100,25);
	t11=new JTextField(10);add(t11);
        	t11.setBounds(220,460,150,25);*/
	

	/*l12=new JLabel("Amount",JLabel.LEFT);
	add(l12);l12.setBounds(100,500,100,25);
	t12=new JTextField(10);add(t12);
	t12.setBounds(220,500,150,25);*/


	
	/*l13=new JLabel("Total Amount",JLabel.LEFT);
	add(l13);l13.setBounds(100,540,100,25);
	t13=new JTextField(10);add(t13);
	t13.setBounds(220,540,150,25);*/

	b1=new JButton("Save");add(b1);
	b1.setBounds(80,600,100,25);
	b1.addActionListener(this);

	b2=new JButton("Clear");add(b2);
	b2.setBounds(200,600,100,25);
	b2.addActionListener(this);

	b3=new JButton ("Close");add(b3);
	b3.setBounds(320,600,100,25);
	b3.addActionListener(this);

		setTitle("Reservation Entry Form... ");
    	setVisible(true);
    	setSize(500,760);
    	JLabel li=new JLabel(new ImageIcon("images/res.jpg"));add(li);
    	 li.setBounds(0,0,500,760);
	 setResizable(false);
	
  }

public void actionPerformed(ActionEvent e)
{

if(e.getSource()==b1)
	{
 
     ins();
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
        //t11.setText("");
        //t12.setText("");
        //t13.setText("");
	}

if(e.getSource()==b3)
	{
	JOptionPane.showMessageDialog(null,"you are select close the current Form","Warning...",JOptionPane.WARNING_MESSAGE);
     	dispose();
	}

}

          
public static void main(String args[])throws Exception
        {
   	new AddTicket();
        }
public void ins()
{ 
connection();
 try
 {
   	 String a1=t1.getText();
  	 int  a2=Integer.parseInt(t2.getText());
 	 String  a3=t3.getText();     
   	 String a4=t4.getText();
 	 String  a5=t5.getText();
	 String a6=t6.getText();
	 String a7=t7.getText();
  	 String a8=t8.getText();
  	// String a9=t9.getText();
  	// String a10=t10.getText();
      //   int a11=Integer.parseInt(t11.getText());
      //   int a12=Integer.parseInt(t12.getText());
      //   int a13=Integer.parseInt(t13.getText());
int i=s.executeUpdate("insert into Ticket values('"+a1+"',"+a2+",'"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"')");
if(i>0)
{
JOptionPane.showMessageDialog(this,"Record Saved Successfully");	
}
  }

catch(Exception e)
{
System.out.println("Program Error........");        
}
        }
  
public void connection()
{
	String driver_class="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uid="system";
		String password="system";
        try
        {
                Class.forName(driver_class);
        }
        catch(Exception er)
        {
        }
        try
        {
               	  con=DriverManager.getConnection(url,uid,password);
        	  s=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                  r=s.executeQuery("select * from Ticket");
       }
        catch(Exception e)
        {
        }
}
}

