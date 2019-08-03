import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class homepage extends JFrame implements ActionListener
{
    JLabel heading1,heading2,logo;
    JButton b1,b2,b3;
    JPanel hp1,hp2,hp3,hp4,hp5,hp6,hp7;
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            menu m=new menu();
            this.dispose();
        
        }
        if(ae.getSource()==b2)
        {
            makeasalecheck m= new makeasalecheck();   
            this.dispose();
        }
        if(ae.getSource()==b3)
        {
            admin ad=new admin();
            this.dispose();
        }
    
    }
    public homepage()
    {
        
        heading1=new JLabel("Welcome To Snack Rack");
        heading1.setFont(new Font("Arial",Font.BOLD,24));
        heading2=new JLabel("Restra For You");
        heading2.setFont(new Font("Arial",Font.BOLD,24));
        logo=new JLabel();
        b1=new JButton("Menu");
        b2=new JButton("Make a sell");
        b3=new JButton("Administration");
        hp1=new JPanel();
        hp2=new JPanel();
        hp3=new JPanel();
        hp1.setLayout(new FlowLayout());
        //hp2.setLayout(new FlowLayout());
        hp3.setLayout(new FlowLayout());
        
        Container c=this.getContentPane();
        c.setLayout(new GridLayout(3,1));
        
        //ImageIcon i1=new ImageIcon("C:\\Users\\user\\Desktop\\image.jpg");
        ImageIcon i1=new ImageIcon(".\\Images\\img.png");
        Image img1=i1.getImage();
        Image img2=img1.getScaledInstance(120,110,Image.SCALE_SMOOTH);
        ImageIcon i2=new ImageIcon(img2);
        logo=new JLabel("",i2,SwingConstants.LEFT);
        hp1.add(heading1);
        hp1.add(heading2);
        hp2.add(logo);
        heading1.setForeground(Color.red);
        heading2.setForeground(Color.red);
        hp1.setBackground(Color.PINK);
        hp2.setBackground(Color.PINK);
        hp3.setBackground(Color.PINK);
        hp3.add(b1);hp3.add(b2);hp3.add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        c.add(hp1);
        c.add(hp2);  
        c.add(hp3);
        setTitle("Home Page");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(400,400);
        setLocation(250,10);
    
    }
    public static void main(String args[])
    {
        homepage h=new homepage();
    
    }

}

