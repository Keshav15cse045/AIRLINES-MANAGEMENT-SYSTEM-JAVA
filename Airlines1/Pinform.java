import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

 public class Pinform extends JFrame implements ActionListener
 {
	JLabel  l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JTextField  t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
	JButton b1,b2,b3,n1,la1,f1,p1;
	Connection con=null;
	Statement s=null;
	ResultSet r;

 public Pinform()
         {
	cnn1();     
 	setLayout(null);

	try
    	 {
         	   Class.forName("oracle.jdbc.driver.OracleDriver");
         	   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe");
           	   s=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    }
       	catch(Exception e1)
     	{
    	}

	l=new JLabel(" Passenger ID",JLabel.LEFT);
	add(l);l.setBounds(100,60,100,25);
	t=new JTextField();add(t);
	t.setBounds(220,60,150,25);

	l1=new JLabel("First Name",JLabel.LEFT);
	add(l1);l1.setBounds(100,100,100,25);
	t1=new JTextField();add(t1);
	t1.setBounds(220,100,150,25);

	l2=new JLabel("Last Name",JLabel.LEFT);
	add(l2);l2.setBounds(100,140,100,25);
	t2=new JTextField();add(t2);
	t2.setBounds(220,140,150,25);

	l3=new JLabel("Date Of  Birth",JLabel.LEFT);
	add(l3);l3.setBounds(100,180,100,25);
	t3=new JTextField();add(t3);
	t3.setBounds(220,180,150,25);

	l4=new JLabel("Mo. Number",JLabel.LEFT);
	add(l4);l4.setBounds(100,220,100,25);
	t4=new JTextField();add(t4);
	t4.setBounds(220,220,150,25);

	l5=new JLabel("Gender",JLabel.LEFT);
	add(l5);l5.setBounds(100,260,100,25);
	t5=new JTextField();add(t5);
	t5.setBounds(220,260,150,25); 

	l6=new JLabel("e-mail ID",JLabel.LEFT);
	add(l6);l6.setBounds(100,300,100,25);
	t6=new JTextField();add(t6);
	t6.setBounds(220,300,150,25);

	l7=new JLabel("Nationality",JLabel.LEFT);
	add(l7);l7.setBounds(100,340,100,25);
	t7=new JTextField();add(t7);
	t7.setBounds(220,340,150,25);

	/*l8=new JLabel("Gender",JLabel.LEFT);
	add(l8);l8.setBounds(100,380,100,25);
	t8=new JTextField();add(t8);
	t8.setBounds(220,380,150,25);*/

	/*l9=new JLabel("Passport No.",JLabel.LEFT);
	add(l9);l9.setBounds(100,420,100,25);
	t9=new JTextField();add(t9);
	t9.setBounds(220,420,150,25);*/

	/*l10=new JLabel("Passport Expiration",JLabel.LEFT);
	add(l10);l10.setBounds(100,460,100,25);
	t10=new JTextField();add(t10);
	t10.setBounds(220,460,150,25);*/

/*	l11=new JLabel("Reservation No.",JLabel.LEFT);
	add(l11);l11.setBounds(100,500,100,25);
	t11=new JTextField();add(t11);
	t11.setBounds(220,500,150,25);*/

	b1=new JButton("Save");add(b1);
	b1.setBounds(80,550,100,25);
	b1.addActionListener(this);

	b2=new JButton("Clear");add(b2);
	b2.setBounds(200,550,100,25);
	b2.addActionListener(this);

	b3=new JButton ("Close");add(b3);
	b3.setBounds(320,550,100,25);
	b3.addActionListener(this);

	
	
        

	setTitle("Passenger Entry Form... ");
    	setVisible(true);
    	setSize(500,750);
    	JLabel li=new JLabel(new ImageIcon("images/apd.jpg"));add(li);
      	li.setBounds(0,0,500,700);
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
		t.setText("");
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		//t8.setText("");
		//t9.setText("");
		//t10.setText("");
		//t11.setText("");
	}
	if(e.getSource()==b3)
	{
		JOptionPane.showMessageDialog(null,"you are select close the current Form","Warning...",JOptionPane.WARNING_MESSAGE);
                dispose();    
	}



}

public static void main(String args[])
{
new Pinform();

}
public void ins()
{
cnn1();
 try
 {

	

        String a=t.getText();   

        String a1=t1.getText();

        String a2=t2.getText();

        String  a3=t3.getText();

       	String  a4=t4.getText();

        String  a5=t5.getText();     

        String a6=t6.getText();

        String a7=t7.getText();

       // String a8=t8.getText();

      //  int a9=Integer.parseInt(t9.getText());

      //  int a10=Integer.parseInt(t10.getText());

      //  int a11=Integer.parseInt(t11.getText());


   int i= s.executeUpdate("insert into Pinfor values('"+a+"','"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"')");
 if (i>0)
{
 JOptionPane.showMessageDialog(this,"Record Saved Successfully");	
  }
   }

catch(Exception er)
{
System.out.println("Programming Error........");        
}
        }
  
public void cnn1()
{
	String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uid="system";
		String password="system";

        try
        {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        }
        catch(Exception er)
        {
        }
        try
        {
                con=DriverManager.getConnection(url,uid,password);
        s=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                r=s.executeQuery("select * from Pinfor");
        }
        catch(Exception e)
        {
        }
}
      
}


