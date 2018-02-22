import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
 
public class PassengerDetail extends JFrame 
{
	static Connection cn=null;
	Statement st=null;
	ResultSet rs=null;
        JButton b;

public    PassengerDetail()
    {
Container contentPane = getContentPane();
contentPane.setLayout(new BorderLayout());
        Vector columnNames = new Vector();
        Vector data = new Vector();
         b=new JButton();
 
        try
        {
            //  Connect to the Database
		String driver_class="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uid="system";
		String password="system";

 
//String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
 
//String url = "jdbc:odbc:Teenergy"; 
//if using ODBC Data Source name
//String url = "jdbc:odbc:Driver={Microsoft
//r={Microsoft Access Driver
//(*.mdb)};DBQ=c:/Project/database/patientinfo.mdb";
  //        String userid = "";
//         String password = "";
 
//     Class.forName( driver );
//Connection connection = DriverManager.getConnection( url,userid, password );

	try{
	
	Class.forName(driver_class);
        cn=DriverManager.getConnection(url,uid,password);
	}

	catch(Exception e)
		{
			System.out.println(e);
		}	

 
            //  Read data from a table
 
            String sql = "Select * from Pinfor";
			Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
 
            //  Get column names
 
            for (int i = 1; i <= columns; i++)
            {
				columnNames.addElement(md.getColumnName(i));
            }
 
            //  Get row data
 
            while (rs.next())
            {
                Vector row = new Vector(columns);
 
                for (int i = 1; i <= columns; i++)
                {
				row.addElement(rs.getObject(i)); 

                }
 
                data.addElement( row );
            }
 
           // rs.close();
            //stmt.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }
 
        //  Create table with database data
//JTable table = new JTable(data, colHeads);
JTable table = new JTable(data, columnNames);
// Add table to a scroll pane
int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
JScrollPane jsp = new JScrollPane(table, v, h);
// Add scroll pane to the content pane
contentPane.add(jsp, BorderLayout.CENTER);
 


 
JScrollPane scrollPane = new JScrollPane(table);
      getContentPane().add( scrollPane );
    //  b.addActionListener(this);
 
       JPanel buttonPanel = new JPanel();
getContentPane().add( buttonPanel, BorderLayout.SOUTH );
    }

 
    public static void main(String[] args)
    {
                PassengerDetail frame = new PassengerDetail();
		frame.setDefaultCloseOperation( EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

