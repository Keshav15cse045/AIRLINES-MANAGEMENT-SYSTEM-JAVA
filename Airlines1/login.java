

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout.*;

public class login extends JPanel implements ActionListener
{
     Image img;
     JTextField t1;
     JPasswordField t2;
     JButton b1;
     JButton b2;
     int r;
     String  name, p;
     String n="KESHAV";
     String pa="2424";
     personinfo h;

public login()
{     

     img=Toolkit.getDefaultToolkit().getImage("images/airplane.jpg");
     Panel p=new Panel();
     Panel p1=new Panel();
     Panel p2=new Panel(); 
     Panel p3=new Panel(); 

     setLayout(null);
     p.setBounds(1,0,136,22);
     p.setLayout(new GridLayout(1,0));
     p.setLocation(400,199);

     p1.setBounds(1,0,136,22);
     p1.setLayout(new GridLayout(1,0));
     p1.setLocation(400,245);

     p2.setBounds(1,0,130,25);
     p2.setLayout(new GridLayout(1,0));
     p2.setLocation(240,306);

     p3.setBounds(1,0,130,25);
     p3.setLayout(new GridLayout(1,0));
     p3.setLocation(405,306);

     t1=new JTextField(10);
     t2=new JPasswordField(10);
     t2.setEchoChar('');
     b1=new JButton("Login");
     //b1.setBackground(Color.cyan);
     b1.setFont(new Font("Times New Roman",Font.BOLD,14));
     b2=new JButton("Cancel");
     //b2.setBackground(Color.cyan);
     b2.setFont(new Font("Times New Roman",Font.BOLD,14));
     t1.setToolTipText("valid user name");
     t2.setToolTipText("valid password");

     p.add(t1);
     p1.add(t2);
     p2.add(b1);
     p3.add(b2);

     add(p);
     add(p1);
     add(p2);
     add(p3); 

     b1.addActionListener(this);
     b2.addActionListener(this);

}

public void actionPerformed(ActionEvent e)
{
     if(e.getSource()==b1)
     {
      name=t1.getText();
      p=t2.getText();
     if(name.equalsIgnoreCase(n) && p.equalsIgnoreCase(pa))
     {
          JOptionPane.showMessageDialog(null,"WEL-COME TO GLOBAL AIRLINES RESERVATION SYSTEM","Information..",JOptionPane.INFORMATION_MESSAGE);
          personinfo h=new personinfo();
          //h.setBounds(0,0,200,300);
          h.setVisible(true);
          //h.setResizable(false);
          h.setSize(1024,768);

     }
     else
     {
          int r=JOptionPane.showConfirmDialog(null,"Not valid Login name or Password try again","Information..",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
          if(r==0)
          {
               t1.requestFocus();
               t1.setText("");
               t2.requestFocus();
               t2.setText("");
          }
     else
     {
          System.exit(0);
     }
     }
}

if(e.getSource()==b2)
{
     JOptionPane.showMessageDialog(null,"you are select , close the application","Warning...",JOptionPane.WARNING_MESSAGE);
     System.exit(0);
}


}
public static void main(String args[])throws Exception
{
     login d=new login();
     JFrame f=new JFrame("login form...");
     f.setLocation(115,180);
     f.setSize(620,413);
     f.setContentPane(d);
     f.setVisible(true);
     f.setResizable(false);

WindowListener LI=new WindowAdapter()
{
public void windowClosing(WindowEvent m)
{
     System.exit(0);
}};
     f.addWindowListener(LI);

}

public void update(Graphics n)
{
     paint(n);
}
public void paint(Graphics n)

{
     n.drawImage(img,0,0,this);

}
}
 
