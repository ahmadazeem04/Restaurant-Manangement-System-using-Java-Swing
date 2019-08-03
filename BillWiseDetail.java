import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
class BillWiseDetail extends JFrame implements ListSelectionListener,ActionListener
{
    
    JLabel detail,choose,sub_tot,gst_add,tot_amt;
    JTextField t1,t2,t3;
    JButton back;
    DefaultListModel billno;
    JList bn;
    JTable jt;
    String data[][];
    JPanel p1,p2,p3,p4,p5,p6;
    Connection con;
    Statement st,st1;
    ResultSet rs,rs1;
    JComboBox c1;
    JScrollPane jsp,jsp1;
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            bill b=new bill();
            this.dispose();
        }
    }
    public void valueChanged(ListSelectionEvent ie)
    {
        if(ie.getSource()==bn)
        {
            
            String xy=(billno.getElementAt(bn.getSelectedIndex())).toString();
            System.out.println("Selected item is"+xy);
            int bno=Integer.parseInt(xy);
            String arr[]={"item_id","bill_id","item_name","item_cat","item_qty","item_price"};
            try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Registered");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restra","restra1","restra1");
            System.out.println("connection Created");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
            String query = "Select item_id,bill_id,item_name,item_cat,item_qty,item_price from purchase Where bill_id="+"\'"+bno+"\';";
            
            rs = st.executeQuery(query);
            System.out.println("Result Fetched");
            rs.last();
            int count= rs.getRow();
            System.out.println("count= "+count);
            System.out.println("bill id is"+count);
            data=new String[count][6];
            rs.beforeFirst();
            int r=0;
               
            while(rs.next())
            {
                System.out.println("inside while loop..");
                String i=rs.getString("item_id");
                String bi=rs.getString("bill_id");
                String in=rs.getString("item_name");
                String ic=rs.getString("item_cat");
                String iq=rs.getString("item_qty");
                String ip=rs.getString("item_price");
                System.out.println("inside while loop..");
                data[r][0]=i;
                data[r][1]=bi;
                data[r][2]=in;
                data[r][3]=ic;
                data[r][4]=iq;
                data[r][5]=ip;
                r++;
                
            }
            
            DefaultTableModel dtm=new DefaultTableModel(data,arr);
            jt.setModel(dtm);
            
            
            String query1="Select bill_id,sub_tot,gst_add,grand_tot From gst";
            rs1=st.executeQuery(query1);
            rs1.last();
            rs1.beforeFirst();
            while(rs1.next())
            {
                String bil=rs1.getString("bill_id");
                int bid=Integer.parseInt(bil);
                if(bno==bid)
                {
                    String subt1=rs1.getString("sub_tot");
                    String gst1=rs1.getString("gst_add");
                    String gtot=rs1.getString("grand_tot");
                    t1.setText(subt1);
                    t2.setText(gst1);
                    t3.setText(gtot);
                }
            }
             
        }catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
    }
            
        }
    
    public BillWiseDetail()
    {
       
       detail=new JLabel("Bill Wise Detail");
       detail.setFont(new Font("Arial ",Font.BOLD,30));
       detail.setForeground(Color.red);
       choose=new JLabel("Select Any Bill Id");
       choose.setForeground(Color.red);
       choose.setFont(new Font("Arial ",Font.BOLD,24));
       sub_tot=new JLabel("Sub Total");
       sub_tot.setFont(new Font("Arial",Font.BOLD,18));
       gst_add=new JLabel("Gst Added");
       gst_add.setFont(new Font("Arial",Font.BOLD,18));
       tot_amt=new JLabel("Total Amount");
       tot_amt.setFont(new Font("Arial",Font.BOLD,18));
        
       back=new JButton("Back");
       
       t1=new JTextField();
       t2=new JTextField();
       t3=new JTextField();
       
       
       billno = new DefaultListModel();
        
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel(new GridLayout());
        p4=new JPanel();
        p5=new JPanel();
        p6=new JPanel();
                
        p1.setLayout(new GridLayout(2,1));
        p2.setLayout(new BorderLayout());
        p4.setLayout(new GridLayout(3,2));
        
        p1.setBackground(Color.PINK);
        p4.setBackground(Color.PINK);
        p5.setBackground(Color.PINK);
        p6.setBackground(Color.PINK);       
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Registered");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restra","restra1","restra1");
            System.out.println("connection Created");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
       
            String query = "select bill_id from purchase";
          
            rs = st.executeQuery(query);
            rs.last();
            int count= rs.getInt("bill_id");
            System.out.println("bill id is"+count);
           
            int r=0;
               
            bn=new JList(billno);
            
            //Components addition in panels
            p1.add(detail);
            p1.add(choose);
            p4.add(sub_tot);p4.add(t1);
            p4.add(gst_add);p4.add(t2);
            p4.add(tot_amt);p4.add(t3);
            
            p6.add(back);
                
            Container c=this.getContentPane();
            this.setLayout(new GridLayout(5,1));
            
            for(int i=1;i<=count;i++)
            {
               billno.addElement(""+i);
            
            }
            jsp1=new JScrollPane(bn);
         
            p2.add(jsp1);
            
            bn.addListSelectionListener(this);
            
             jt=new JTable();
             jsp=new JScrollPane(jt);
             jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
             p3.add(jsp);
             
             back.addActionListener(this);
             
             //Panels addition in container
            c.add(p1); 
            c.add(p2); 
            c.add(p3);
           
            c.add(p4); 
            c.add(p6);
            
             setTitle("Bill Wise Detail");
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
        BillWiseDetail bd=new BillWiseDetail();
    }
}
