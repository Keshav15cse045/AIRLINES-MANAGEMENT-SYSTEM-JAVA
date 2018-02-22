import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class aboutus extends JFrame implements ActionListener
{   
     public aboutus()
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
	setSize(837,524);
    
	
	JLabel img=new JLabel(new ImageIcon("images/dip.jpg"));
	img.setBounds(0,0,837,524);
	c.add(img);
	
 }   

     public void actionPerformed(ActionEvent event)
 { }
      public void itemStateChanged(ItemEvent e)
{    
}
	public static void main(String args[])
	{
	new aboutus();
	}
}