import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
class bill extends JFrame implements ActionListener
{
    JLabel heading,msg,l1,l2,l3,l4,l6,l7;
    JPanel p1a,p1b,p2,p3;
    JButton clk1,clk2,clk3,clk4,hpage;
    JTextField t1,t2,t3,t4,t5;
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clk1)
        {
         NewClass3 nb=new NewClass3();  
         this.dispose();
        }
        if(ae.getSource()==clk2)
        {
            l3.setVisible(true);
            clk3.setVisible(true);
            l4.setVisible(true);
            clk4.setVisible(true);
        
        }
        if(ae.getSource()==clk3)
        {
            todaysale t=new todaysale();
            this.dispose();
        }
        if(ae.getSource()==clk4)
        {

            datewise d=new datewise();
            this.dispose();
        }
        
        if(ae.getSource()==hpage)
        {
            homepage h=new homepage();
            this.dispose();
        }
    }
    public bill()
    {
        heading=new JLabel("Welcome Admin");
        heading.setForeground(Color.red);
        heading.setFont(new Font("Arial",Font.BOLD,62));
        msg=new JLabel("You Have Successfully Logged In");
        msg.setFont(new Font("Arial",Font.BOLD,38));
        msg.setForeground(Color.WHITE);
        l1=new JLabel("View Bill Detail");
        l1.setFont(new Font("Arial",Font.BOLD,16));
        clk1=new JButton("Click Here");
        l2=new JLabel("View Sale");
        l2.setFont(new Font("Arial",Font.BOLD,16));
        clk2=new JButton("Click Here");
        l3=new JLabel("View Today's Sale");
        l3.setFont(new Font("Arial",Font.BOLD,16));
        clk3=new JButton("Click Here");
        l4=new JLabel("View Date Wise");
        l4.setFont(new Font("Arial",Font.BOLD,16));
        clk4=new JButton("Click Here");
                
        hpage=new JButton("Go To Homepage");
        p1a=new JPanel();
        p1b=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        
        p2.setLayout(new GridLayout(5,2));
        
        p1a.add(heading);
        p1a.setBackground(Color.PINK);
        p1b.add(msg);
        p1b.setBackground(Color.RED);
        p2.add(l1);p2.add(clk1);p2.add(l2);p2.add(clk2);p2.add(l3);p2.add(clk3);
        p2.add(l4);p2.add(clk4);
        p2.setBackground(Color.PINK);
        p3.add(hpage);
        p3.setBackground(Color.PINK);
        Container c=this.getContentPane();
        c.setLayout(new GridLayout(4,1));
        c.add(p1a);c.add(p1b);c.add(p2);c.add(p3);
        
            l3.setVisible(false);
            clk3.setVisible(false);
            l4.setVisible(false);
            clk4.setVisible(false);
            
            clk1.addActionListener(this);
            clk2.addActionListener(this);
            clk3.addActionListener(this);
            clk4.addActionListener(this);
        
            hpage.addActionListener(this);
        
        setTitle("Admin Window");
        this.setVisible(true);
        this.setSize(900,700);
        setLocation(250,10);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
    }
    public static void main(String args[])
    {
        bill b=new bill();
    }
}
