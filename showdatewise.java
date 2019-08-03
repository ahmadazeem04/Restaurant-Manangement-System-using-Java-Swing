import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.swing.table.DefaultTableModel;
class showdatewise extends JFrame implements ActionListener
{
    JLabel heading,sub_tot,gst_add,tot_amt;
    JTextField t1,t2,t3;
    JButton back;
    JPanel p1,p2,p3,p4;
    JTable jt;
    Statement st;
    Connection con;
    ResultSet rs,rs1,rs2,rs3;
    String data[][];
    JScrollPane jsp;
    java.util.Date d;
    DateFormat fd;
    String date;
    
 public void actionPerformed(ActionEvent ae)
 {
         if(ae.getSource()==back)
         {
             bill h=new bill();
             this.dispose();
         }
 }
    
    public showdatewise(String dte)
    {
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        String dt=dte;
        
        String arr[]={"item_id","bill_id","item_name","item_cat","item_qty","item_price"};
        
        //Database Connection
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Registered");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restra","restra1","restra1");
            System.out.println("connection Created");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
            
            String query1="select sum(sub_tot) from gst where date="+"\'"+dt+"\';";
            rs1=st.executeQuery(query1);
            
            rs1.next();
            System.out.println("Result Fetched1");
            int subt1=rs1.getInt(1);
            System.out.println("Sub total is"+subt1);
            t1.setText(""+subt1);
            
            String query2="Select sum(gst_add) from gst where date="+"\'"+dt+"\'";
            rs2=st.executeQuery(query2);
            rs2.next();
            int tax=rs2.getInt(1);
            t2.setText(""+tax);
            
            String query3="Select sum(grand_tot) from gst where date="+"\'"+dt+"\'";
            rs3=st.executeQuery(query3);
            rs3.next();
            int gtot=rs3.getInt(1);
            t3.setText(""+gtot);
            
            
            String query = "select * from purchase Where date="+"\'"+dte+"\';" ;
            rs1 = st.executeQuery(query);
            System.out.println("Result Fetched");
            
            
            rs1.last();
            int count= rs1.getRow();
            
           data=new String[count][6];
           
           rs1.beforeFirst();
           int r=0;
           
            while(rs1.next())
            {
                String i=rs1.getString("item_id");
                
                String bi=rs1.getString("bill_id");
                String in=rs1.getString("item_name");
                String ic=rs1.getString("item_cat");
                String iq=rs1.getString("item_qty");
                String ip=rs1.getString("item_price");
                
                data[r][0]=i;
                data[r][1]=bi;
                data[r][2]=in;
                data[r][3]=ic;
                data[r][4]=iq;
                data[r][5]=ip;
                r++;
            }
            jt=new JTable();
            jsp=new JScrollPane(jt);
            DefaultTableModel dtm=new DefaultTableModel(data,arr);
            jt.setModel(dtm);
            jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            
        
        
         heading=new JLabel("Sale on  "+dt+"  is as follows");
         heading.setFont(new Font("Arial",Font.BOLD,32));
         sub_tot=new JLabel("Sub Total");
         sub_tot.setFont(new Font("Arial",Font.BOLD,20));
         gst_add=new JLabel("Gst Added");
         gst_add.setFont(new Font("Arial",Font.BOLD,20));
         tot_amt=new JLabel("Total Amount");
         tot_amt.setFont(new Font("Arial",Font.BOLD,20));
         
         back=new JButton("Back");
         p1=new JPanel();
         p1.setBackground(Color.CYAN);
         p2=new JPanel(new GridLayout());
         p2.setBackground(Color.CYAN);
         p3=new JPanel();
         p3.setBackground(Color.CYAN);
         p4=new JPanel(new GridLayout(3,2));
         p4.setBackground(Color.CYAN);
         
         p1.add(heading);
         p2.add(jsp);
         p3.add(back);
         p4.add(sub_tot);p4.add(t1);
         p4.add(gst_add);p4.add(t2);
         p4.add(tot_amt);p4.add(t3);
         
            Container c=this.getContentPane();
            this.setLayout(new GridLayout(4,1));
            
            c.add(p1);
            c.add(p2);
            c.add(p3);
            c.add(p4);
            
            back.addActionListener(this);
            this.setVisible(true);
            this.setSize(900,700);
             setLocation(250,10);
             this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }catch(Exception e)
        {
            System.out.println(e.toString());
        }
 
    }
    
    public static void main(String args[])
    {
        showdatewise sdw=new showdatewise("2017-07-15");
        
    }
}
