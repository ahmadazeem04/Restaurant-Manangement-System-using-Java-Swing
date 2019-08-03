import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
class datewise extends JFrame implements ActionListener 
{
    JLabel heading,lenter;
    JTextField tenter;
    JButton submit;
    JPanel p1,p2,p3;
 
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String d=tenter.getText();
            showdatewise s=new showdatewise(d);
            this.dispose();
        }
    }
    
    public datewise()
    {
        heading=new JLabel("Welcome To Snack Rack");
        lenter=new JLabel("Enter Date(yyyy/mm/dd)");
        tenter=new JTextField();
        
        submit=new JButton("Submit");
        
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p1.add(heading);
        p2.setLayout(new GridLayout(1,2));
        p2.add(lenter);p2.add(tenter);
        p3.add(submit);
        
        p1.setBackground(Color.ORANGE);
        p2.setBackground(Color.ORANGE);
        p3.setBackground(Color.ORANGE);
        
        submit.addActionListener(this);
        Container c=this.getContentPane();
        c.setLayout(new GridLayout(3,1));
        c.add(p1);
        c.add(p2);
        c.add(p3);
        this.setSize(300,170);
        setLocation(500,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public static void main(String args[])
    {
        datewise d=new datewise();
    }
    
}    
