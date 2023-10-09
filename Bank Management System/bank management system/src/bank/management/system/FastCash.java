package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton btnRs100 , btnRs500 , btnRs1000 , btnRs2000 , btnRs5000 , btnRs10000 , btnBack;
    String pinNumber , cardNumber;
    FastCash(String cardNumber , String pinNumber){
        
        this.pinNumber = pinNumber;
        this.cardNumber = cardNumber;
        
        //JFrame icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/bankicon.png"));
        setIconImage(icon.getImage());
        
        //Title Frame
        setTitle("ATM MACHINE");
        
        //Layout of Frame
        setLayout(null);
        
        //Image on JFrame
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i = img.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon imgMain = new ImageIcon(i);
        JLabel lblImg = new JLabel(imgMain);
        lblImg.setBounds(0 , 0 , 900 , 900);
        add(lblImg);
        
        //JLabel over Image
        JLabel lblText = new JLabel("SELECT WITHDRAWL AMOUNT");
        lblText.setBounds(210 , 300 , 700 , 30);
        lblText.setForeground(Color.WHITE);
        lblText.setFont(new Font("Raelway" , Font.BOLD , 16));
        lblImg.add(lblText);
        
        //JButton for Deposit
        btnRs100 = new JButton("Rs 100");
        btnRs100.setBounds(140 , 415 , 150 , 30);
        btnRs100.setFocusable(false);
        btnRs100.addActionListener(this);
        lblImg.add(btnRs100);
        
        //JButton for Fast cash
        btnRs500 = new JButton("Rs 500");
        btnRs500.setBounds(140 , 452 , 150 , 30);
        btnRs500.setFocusable(false);
        btnRs500.addActionListener(this);
        lblImg.add(btnRs500);
        
        //JButton for Withdrawl
        btnRs1000 = new JButton("Rs 1000");
        btnRs1000.setBounds(355 , 418 , 150 , 30);
        btnRs1000.setFocusable(false);
        btnRs1000.addActionListener(this);
        lblImg.add(btnRs1000);
        
        //JButton for Mini Statement
        btnRs2000 = new JButton("Rs 2000");
        btnRs2000.setBounds(355 , 455 , 150 , 30);
        btnRs2000.setFocusable(false);
        btnRs2000.addActionListener(this);
        lblImg.add(btnRs2000);
        
        //JButton for Pin Change
        btnRs5000 = new JButton("Rs 5000");
        btnRs5000.setBounds(355 , 492 , 150 , 30);
        btnRs5000.setFocusable(false);
        btnRs5000.addActionListener(this);
        lblImg.add(btnRs5000);
        
        //JButton for Balance Enquiry
        btnRs10000 = new JButton("Rs 10000");
        btnRs10000.setBounds(140 , 490 , 150 , 30);
        btnRs10000.setFocusable(false);
        btnRs10000.addActionListener(this);
        lblImg.add(btnRs10000);
        
        //JButton for Exit
        btnBack = new JButton("BACK");
        btnBack.setBounds(355 , 528 , 150 , 30);
        btnBack.setFocusable(false);
        btnBack.addActionListener(this);
        lblImg.add(btnBack);
        
        setSize(900 , 900);
        setLocation(300 , 0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnBack){
            setVisible(false);
            new Transactions(cardNumber, pinNumber).setVisible(true);
        }
        else{
            //Picking the value from the Button
            String amount = ((JButton)e.getSource()).getText().substring(3); // -->500
            Conn conn = new Conn();
            try{
                //for Checking the current Balance of the Account Holder
                ResultSet rs = conn.st.executeQuery("select * from accountinfo where cardNumber = '"+cardNumber+"' and pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    //to check the type of category choosed by the user
                    if(rs.getString("type").equals("Deposit")){
                        //for adding the amount
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                //checking if the balance of the USER
                if(e.getSource() != btnBack && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null , "Insufficient Balance!");
                    return;
                }
                
            Date date = new Date();
            String query = "insert into accountinfo values('"+cardNumber+"' , '"+pinNumber+"' , '"+date+"' , 'Withdrawl' , '"+amount+"')";
            conn.st.executeUpdate(query);
            JOptionPane.showMessageDialog(null , "Rs " + amount + " Debited Succesfully");
            
            setVisible(false);
            new Transactions(cardNumber, pinNumber).setVisible(true);
            
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
    }

    public static void main(String args[]){
        new FastCash("", "");
    }
}
