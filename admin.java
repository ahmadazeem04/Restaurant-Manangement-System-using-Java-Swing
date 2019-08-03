import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
class admin extends JFrame implements ActionListener
{
    JLabel luser,lpassword,msg;
    JTextField tuser;
    JPasswordField tpassword;
    JPanel p1,p2,p3;
    Connection con;
    ResultSet rs,rs1;
    Statement st;
    JButton b1,b2;
    
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==b1)
       {
           String u=tuser.getText();
           
           String p=String.valueOf(tpassword.getPassword());
           
               
            String query = "Select user_id from login";
         
            String query1="Select password from login";
           try
           {
               
              rs = st.executeQuery(query);
              rs.next();
              String user=rs.getString("user_id");
              System.out.println(user);
              
              rs1=st.executeQuery(query1);
              rs1.next();
              String pass=rs1.getString("password");
              System.out.println(pass);
 
              
            if(u.equals(user) && p.equals(pass))
            {
                bill b=new bill();
              
                System.out.println("You have successfully logged in");
                p3.setVisible(false);
                this.dispose();
            }
            else
            {
                
                msg.setText("Incorrect Username Or Password");
                System.out.println("Wrong username or password");
                
            }
                System.out.println("Result Fetched");
          
           
            //rs.beforeFirst();
            //rs1.beforeFirst();
            
           }catch(Exception e)
           {
               System.out.println(e.toString());
           }
           
        
       }
        if(ae.getSource()==b2)
        {
            homepage h=new homepage();
            this.dispose();
        }
    }
    public admin()
    {
        luser=new JLabel("Enter Username");
        lpassword=new JLabel("Enter Password");
        msg=new JLabel("");
        msg.setForeground(Color.red);
        tuser=new JTextField();
        tpassword=new JPasswordField();
        
        b1=new JButton("Login");
        b2=new JButton("Go To Homepage");
        
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        
        p1.setLayout(new GridLayout(2,2));
        p1.add(luser);p1.add(tuser);
        p1.add(lpassword);p1.add(tpassword);
        p1.setBackground(Color.YELLOW);
        
        p2.add(b1);p2.add(b2);
        p2.setBackground(Color.yellow);
        p3.add(msg);
        p3.setBackground(Color.yellow);
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Registered");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restra","restra1","restra1");
            System.out.println("connection Created");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        }catch(Exception e)
           {
                System.out.println(e.toString());
            }

        Container c=this.getContentPane();
        c.setLayout(new GridLayout(3,1) );
        c.add(p1);c.add(p3);c.add(p2);
        setLocation(550,300);
        setTitle("Login Window");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        this.setVisible(true);
        this.setSize(300,200);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    public static void main(String args[])
    {
        admin a=new admin();
    }
}



        
        
