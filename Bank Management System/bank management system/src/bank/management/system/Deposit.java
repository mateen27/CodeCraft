package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JButton btnDeposit , btnBack;
    String pinNumber , cardNumber;
    JTextField tfAmount;
    
    Deposit(String cardNumber , String pinNumber){
        
        //pinNumber & cardNumber
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        
        //JFrame icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/bankicon.png"));
        setIconImage(icon.getImage());
        
        //Title of the Frame
        setTitle("Deposit Cash");
        
        //Layout of the Frame
        setLayout(null);
        
        //Image over the JLabel
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i = img.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon Img = new ImageIcon(i);
        JLabel lblImg = new JLabel(Img);
        lblImg.setBounds(0 , 0 , 900 , 900);
        add(lblImg);
        
        //JLabel Heading 
        JLabel lblHeading = new JLabel("Enter the amount you want to deposit");
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
        
        //JButton for Deposit
        btnDeposit = new JButton("Deposit");
        btnDeposit.setFocusable(false);
        btnDeposit.setBounds(355 , 492 , 150 , 30);
        btnDeposit.addActionListener(this);
        lblImg.add(btnDeposit);
        
        //JButton for Back
        btnBack = new JButton("Back");
        btnBack.setFocusable(false);
        btnBack.setBounds(355 , 530 , 150 , 30);
        btnBack.addActionListener(this);
        lblImg.add(btnBack);
        
        //Frame Properties
        setSize(900 , 900);
        setLocation(300 , 0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnDeposit){
            String amount = tfAmount.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Deposit!");
            }
            else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into accountinfo values('"+cardNumber+"' , '"+pinNumber+"' , '"+date+"' , 'Deposit' , '"+amount+"')";
                    conn.st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+ amount + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(cardNumber , pinNumber).setVisible(true);
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
        new Deposit("" , "");
    }
}
