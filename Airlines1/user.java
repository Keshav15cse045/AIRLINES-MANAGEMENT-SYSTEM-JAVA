import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class user extends JFrame implements ActionListener
{   
     public user()
    {   
       Container c=getContentPane();
                 c.setLayout(null);
	setBackground(new Color(35,35,71));
	setResizable(false);

                 	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension ssize=kit.getScreenSize();
	int sheight=ssize.height;
	int swidth=ssize.width;
	setVisible(true);
	setLocation(200,200);
	setSize(605,432);
     	
	
	JLabel img=new JLabel(new ImageIcon("images/dip1.jpg"));
	img.setBounds(0,0,600,400);
	c.add(img);
	
 }   

     public void actionPerformed(ActionEvent event)
 { }
      public void itemStateChanged(ItemEvent e)
{    
}
	public static void main(String args[])
	{
	new user();
	}
}