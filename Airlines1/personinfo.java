import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.GridLayout.*;

public class personinfo extends JFrame implements ActionListener
{
     Image img;
     JMenuBar mb;
     JMenu m1,m2,m3,m4,m5,m6;
     JMenuItem i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11;

public personinfo()
    { 
     mb=new JMenuBar();
     m1=new JMenu("Reservation");
     m1.setMnemonic('R');
     i1=new JMenuItem("Add Passenger Detail");
     i2=new JMenuItem("Reservation Entry");
     m1.add(i1);
     m1.add(i2);
     mb.add(m1);
     i1.addActionListener(this);   

     m2=new JMenu("Modify");
     m2.setMnemonic('M');
  
     i4=new JMenuItem("Cancellation");
   
     m2.add(i4);
     mb.add(m2);

     m3=new JMenu("Enquiry");
     m3.setMnemonic('E');
     
     i6=new JMenuItem("confirmation");
     
     m3.add(i6);
     mb.add(m3);

     m4=new JMenu("Report");
     m4.setMnemonic('r');
     
     i8=new JMenuItem("Passenger Detail");
   
     m4.add(i8);
     mb.add(m4);
     
     m5=new JMenu("Help");
     m5.setMnemonic('H');
     i9=new JMenuItem("User Instruction");
     i10=new JMenuItem("About us");
     m5.add(i9);
     m5.add(i10);
     mb.add(m5);
     
     m6=new JMenu("Exit");
     m6.setMnemonic('x');
     i11=new JMenuItem("Close"); 
     m6.add(i11); 
     mb.add(m6);

    
     i2.addActionListener(this);
     
     i4.addActionListener(this);
     
     i6.addActionListener(this);
     i8.addActionListener(this);
     i9.addActionListener(this);
     i10.addActionListener(this);
     i11.addActionListener(this);
     setJMenuBar(mb);
     setTitle("Global Airlines Reservation System..........");
     setLocation(0,0);
     setSize(1024,451);
     setResizable(true);
     JLabel l=new JLabel(new ImageIcon("images/111.jpg")); 
     add(l);
     l.setBounds(0,0,1020,300);	
    }

public void actionPerformed(ActionEvent e)
 {
     if(e.getSource()==i1)
     {
          //this.setVisible(false);
          Pinform ob=new Pinform();
          ob.setVisible(true);
     }
     if(e.getSource()==i8)
     {
          //this.setVisible(false);
            PassengerDetail h2=new PassengerDetail();
            h2.setVisible(true);
            h2.setSize(1024,300);

            //pinform ob=new pinform();
           // ob.setVisible(true);
     } 
     
if(e.getSource()==i2)
     {
          //this.setVisible(false);
          AddTicket o=new AddTicket();
          o.setVisible(true);
     }

if(e.getSource()==i4)
     {
          
         CancelTicket o=new CancelTicket();
          o.setVisible(true);
     }



if(e.getSource()==i6)
     {
          
         BookedTicket o=new BookedTicket();
          o.setVisible(true);
	  o.setSize(1024,300);

     }


if(e.getSource()==i9)
     {
          
         user o=new user();
          o.setVisible(true);
     }
if(e.getSource()==i10)
     {
          aboutus o1=new  aboutus();
          o1.setVisible(true);
     }

if(e.getSource()==i11)
     {  
          System.exit(0);  
     }   


 }
 public static void main(String args[])throws Exception
     {     
  personinfo a= new personinfo();
   //a.setBackground(Color.pink);
     }

}   


