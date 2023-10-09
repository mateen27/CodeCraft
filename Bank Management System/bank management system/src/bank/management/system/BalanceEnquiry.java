package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton btnBack;
    String cardNumber , pinNumber;
    
    BalanceEnquiry(String cardNumber , String pinNumber){
        
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        
        //Layout of the JFrame
        setLayout(null);
        
        //JFrame icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/bankicon.png"));
        setIconImage(icon.getImage());
        
        //Adding Image over the Frame
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i = img.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon imgMain = new ImageIcon(i);
        JLabel lblImg = new JLabel(imgMain);
        lblImg.setBounds(0 , 0 , 900 , 900);
        add(lblImg);
        
        //Adding BACK Button over JFrame
        btnBack = new JButton("BACK");
        btnBack.setForeground(Color.BLACK);
        btnBack.setFocusable(false);
        btnBack.setBounds(395 , 530 , 120 , 30);
        btnBack.addActionListener(this);
        lblImg.add(btnBack);
        
        //Getting balance from the Database
        Conn conn = new Conn();
        int balance = 0;
        try{
            ResultSet rs = conn.st.executeQuery("select * from accountinfo where cardNumber = '"+cardNumber+"' and pin = '"+pinNumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        //JLabel for Balance
        JLabel lblBalance = new JLabel("Your current Account Balance is Rs: " + balance);
        lblBalance.setForeground(Color.WHITE);
        lblBalance.setFont(new Font("Raelway" , Font.BOLD , 16));
        lblBalance.setBounds(140 , 320 , 400 , 30);
        lblImg.add(lblBalance);
        
        //properties for JFrame
        setUndecorated(true);
        setSize(900 , 900);
        setLocation(300 , 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnBack){
            setVisible(false);
            new Transactions(cardNumber, pinNumber).setVisible(true);
        }
    }

    public static void main(String args[]){
        new BalanceEnquiry("" , "");
    }
}
