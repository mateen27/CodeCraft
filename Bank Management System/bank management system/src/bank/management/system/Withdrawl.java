package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JButton btnWithdrawl , btnBack;
    String pinNumber , cardNumber;
    JTextField tfAmount;
    int accountBalance;
    
    Withdrawl(String cardNumber , String pinNumber){
        
        //pinNumber & cardNumber
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        
        //JFrame icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/bankicon.png"));
        setIconImage(icon.getImage());
        
        //Layout o fthe Frame
        setLayout(null);
        
        //Title of the Frame
        setTitle("Withdraw Cash");
        
        //Image over the JLabel
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i = img.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon Img = new ImageIcon(i);
        JLabel lblImg = new JLabel(Img);
        lblImg.setBounds(0 , 0 , 900 , 900);
        add(lblImg);
        
        //JLabel Heading 
        JLabel lblHeading = new JLabel("Enter the amount you want to Withdraw");
        lblHeading.setForeground(Color.WHITE);
        lblHeading.setFont(new Font("Raelway" , Font.BOLD , 16));
        lblHeading.setBounds(150 , 300 , 400 , 30);
        lblImg.add(lblHeading);
        
        //JTextField for Amount 
        tfAmount = new JTextField();
        tfAmount.setForeground(Color.BLACK);
        tfAmount.setFont(new Font("Raelway" , Font.BOLD , 22));
        tfAmount.setBounds(150 , 350 , 320 , 25);
        lblImg.add(tfAmount);
        
        //JButton for Withdrawl
        btnWithdrawl = new JButton("Withdraw");
        btnWithdrawl.setFocusable(false);
        btnWithdrawl.setBounds(355 , 492 , 150 , 30);
        btnWithdrawl.addActionListener(this);
        lblImg.add(btnWithdrawl);
        
        //JButton for Back
        btnBack = new JButton("Back");
        btnBack.setFocusable(false);
        btnBack.setBounds(355 , 530 , 150 , 30);
        btnBack.addActionListener(this);
        lblImg.add(btnBack);
        
        //Checking the Balance in the Account
        Conn conn = new Conn();
        accountBalance = 0;
        try{
        ResultSet rs = conn.st.executeQuery("select * from accountinfo where cardNumber = '"+cardNumber+"'");
        while(rs.next()){
            if(rs.getString("type").equals("Deposit")){
                accountBalance += Integer.parseInt(rs.getString("amount"));
            }
            else{
                accountBalance -= Integer.parseInt(rs.getString("amount"));
            }
        }
    }
        catch(Exception e){
            System.out.println(e);
        }
        //Frame Properties
        setSize(900 , 900);
        setLocation(300 , 0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnWithdrawl){
            String amount = tfAmount.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw!");
            }
            else{
                try{
                    //Checking for the Balance
                    if(e.getSource() != btnBack && Integer.parseInt(amount) > accountBalance){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                    }  
                    else{
                    Conn conn = new Conn();
                    String query = "insert into accountinfo values('"+cardNumber+"' , '"+pinNumber+"' , '"+date+"' , 'Withdrawl' , '"+amount+"')";
                    conn.st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+ amount + " Withdraw Successfully");
                    setVisible(false);
                    new Transactions(cardNumber , pinNumber).setVisible(true);
                    }
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            }
            
            
        }
        else if(e.getSource() == btnBack){
            dispose();
            new Transactions(cardNumber , pinNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Withdrawl("" , "");
    }
}
