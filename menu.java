 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class menu extends JFrame implements ActionListener
{
    JLabel heading,item[],price[],burger,pizza,drinks;
    JButton b4,b5;
    JPanel p1,p2,p2a,p3,p3a,p4,p4a,p5,p6,p7,p8;
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b4)
        {
            homepage h=new homepage();
            this.dispose();
        }
        if(ae.getSource()==b5)
        {
            makeasalecheck m=new makeasalecheck();
            this.dispose();
        }
    }
    public menu()
    {
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p5=new JPanel();
        p6=new JPanel();
        p7=new JPanel();
        p8=new JPanel();
        p2a=new JPanel();
        p3a=new JPanel();
        p4a=new JPanel();
        
        burger=new JLabel();
        pizza=new JLabel();
        drinks=new JLabel();
       
        ImageIcon i1=new ImageIcon(".\\Images\\pizza.jpg");
        Image img1=i1.getImage();
        Image img2=img1.getScaledInstance(160,160,Image.SCALE_SMOOTH);
        ImageIcon i2=new ImageIcon(img2);
        pizza=new JLabel("",i2,SwingConstants.LEFT);
        p6.add(pizza);
        p6.setBackground(Color.pink);
        
        ImageIcon i3=new ImageIcon(".\\Images\\images.jpg");
        Image img3=i3.getImage();
        Image img3a=img3.getScaledInstance(160,160,Image.SCALE_SMOOTH);
        ImageIcon i3a=new ImageIcon(img3a);
        burger=new JLabel("",i3a,SwingConstants.LEFT);
        p7.add(burger);
        p7.setBackground(Color.pink);
        
        ImageIcon i4=new ImageIcon(".\\Images\\Canned-Soft-Drinks2.jpg");
        Image img4=i4.getImage();
        Image img4a=img4.getScaledInstance(160,160,Image.SCALE_SMOOTH);
        ImageIcon i4a=new ImageIcon(img4a);
        drinks=new JLabel("",i4a,SwingConstants.LEFT);
        p8.add(drinks);
        p8.setBackground(Color.pink);
        
        b4=new JButton("Go To HomePage");
        b5=new JButton("Make A Sell");
        heading=new JLabel("WELCOME TO SNACK RACK");
      
        heading.setFont(new Font("Arial",Font.BOLD,36));
      
        p1.add(heading);
        heading.setForeground(Color.RED);
        p1.setBackground(Color.PINK);
        item=new JLabel[17];
        price=new JLabel[17];
        p1.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(5,2));
        p2.setBackground(Color.pink);
        item[0]=new JLabel("PIZZA");
        item[0].setForeground(Color.red);
        price[0]=new JLabel("");
        item[0].setFont(new Font("Arial",Font.BOLD,28));
        item[1]=new JLabel("1.Viggie Pizza");
        item[1].setFont(new Font("Arial",Font.BOLD,18));
       
        price[1]=new JLabel("Rs.150"); 
        item[2]=new JLabel("2.Exotic Veg Pizza");
        item[2].setFont(new Font("Arial",Font.BOLD,18));
        price[2]=new JLabel("Rs.160");
        item[3]=new JLabel("3.Cottage Cheese Pizza");
        item[3].setFont(new Font("Arial",Font.BOLD,18));
        price[3]=new JLabel("Rs.200");
        item[4]=new JLabel("4.Mashroom Corn Pizza");
        item[4].setFont(new Font("Arial",Font.BOLD,18));
        price[4]=new JLabel("Rs.250");
       
        for(int i=0;i<5;i++)
        {
            p2.add(item[i]);
            p2.add(price[i]);
        }
        p3.setLayout(new GridLayout(5,2));
         p3.setBackground(Color.pink);
        item[5]=new JLabel("BURGER");
        item[5].setForeground(Color.red);
        price[5]=new JLabel("");
        item[5].setFont(new Font("Arial",Font.BOLD,28));
        item[6]=new JLabel("1.Veg Cheese Burger");
        item[6].setFont(new Font("Arial",Font.BOLD,18));
        price[6]=new JLabel("Rs.120");
        item[7]=new JLabel("2.Double Cheese Burger");
        item[7].setFont(new Font("Arial",Font.BOLD,18));
        price[7]=new JLabel("Rs.110");
        item[8]=new JLabel("3.Cottage Cheese Burger");
        item[8].setFont(new Font("Arial",Font.BOLD,18));
        price[8]=new JLabel("Rs.140");
        item[9]=new JLabel("4.Jumbo King Burger");
        item[9].setFont(new Font("Arial",Font.BOLD,18));
        price[9]=new JLabel("Rs.150");
        for(int i=5;i<10;i++)
        {
            
            p3.add(item[i]); 
            p3.add(price[i]);
        }
        
        p4.setLayout(new GridLayout(6,2));
        p4.setBackground(Color.pink);
        
        item[10]=new JLabel("REFRESHMENTS");
        item[10].setForeground(Color.red);
        price[10]=new JLabel("");
        item[10].setFont(new Font("Arial",Font.BOLD,28));
        item[11]=new JLabel("1.Coca Cola");
        item[11].setFont(new Font("Arial",Font.BOLD,18));
        price[11]=new JLabel("Rs.50");
        item[12]=new JLabel("2.Mirinda");
        item[12].setFont(new Font("Arial",Font.BOLD,18));
        price[12]=new JLabel("Rs.50");
        item[13]=new JLabel("3.Sprite");
        item[13].setFont(new Font("Arial",Font.BOLD,18));
        price[13]=new JLabel("Rs.50");
        item[14]=new JLabel("4.Limca");
        item[14].setFont(new Font("Arial",Font.BOLD,18));
        price[14]=new JLabel("Rs.50");
       

        for(int i=10;i<15;i++)
        {
            p4.add(item[i]); 
            p4.add(price[i]);
        }
        p2a.setLayout(new GridLayout(1,2));
        
        p3a.setLayout(new GridLayout(1,2));
        
        p4a.setLayout(new GridLayout(1,2));
        
        p5.add(b4);
        p5.add(b5);
        p5.setLayout(new FlowLayout());
        p5.setBackground(Color.pink);
        Container c=this.getContentPane();
        c.setLayout(new GridLayout(5,1));
        p2a.add(p2);p2a.add(p6);
        p3a.add(p3);p3a.add(p7);
        p4a.add(p4);p4a.add(p8);
        c.add(p1);
        c.add(p2a);
        c.add(p3a);
        c.add(p4a);
        c.add(p5);
        b4.addActionListener(this);
        b5.addActionListener(this);
        setTitle("Menu");
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(960,700);
        setLocation(250,10);
    }
    public static void main(String args[])
    {
     menu m=new menu();   
    }
}
