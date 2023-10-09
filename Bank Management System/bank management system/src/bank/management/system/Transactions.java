package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton btnDeposit , btnFastCash , btnWithdrawl , btnMiniStatement , btnPinChange , btnBalance , btnExit;
    String pinNumber , cardNumber;
    Transactions(String cardNumber , String pinNumber){
        
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
        JLabel lblText = new JLabel("Please select your Transaction");
        lblText.setBounds(210 , 300 , 700 , 30);
        lblText.setForeground(Color.WHITE);
        lblText.setFont(new Font("Raelway" , Font.BOLD , 16));
        lblImg.add(lblText);
        
        //JButton for Deposit
        btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(140 , 415 , 150 , 30);
        btnDeposit.setFocusable(false);
        btnDeposit.addActionListener(this);
        lblImg.add(btnDeposit);
        
        //JButton for Fast cash
        btnFastCash = new JButton("Fast Cash");
        btnFastCash.setBounds(140 , 452 , 150 , 30);
        btnFastCash.setFocusable(false);
        btnFastCash.addActionListener(this);
        lblImg.add(btnFastCash);
        
        //JButton for Withdrawl
        btnWithdrawl = new JButton("Cash Withdrawl");
        btnWithdrawl.setBounds(355 , 418 , 150 , 30);
        btnWithdrawl.setFocusable(false);
        btnWithdrawl.addActionListener(this);
        lblImg.add(btnWithdrawl);
        
        //JButton for Mini Statement
        btnMiniStatement = new JButton("Mini Statement");
        btnMiniStatement.setBounds(355 , 455 , 150 , 30);
        btnMiniStatement.setFocusable(false);
        btnMiniStatement.addActionListener(this);
        lblImg.add(btnMiniStatement);
        
        //JButton for Pin Change
        btnPinChange = new JButton("Pin Change");
        btnPinChange.setBounds(355 , 492 , 150 , 30);
        btnPinChange.setFocusable(false);
        btnPinChange.addActionListener(this);
        lblImg.add(btnPinChange);
        
        //JButton for Balance Enquiry
        btnBalance = new JButton("Balance Enquiry");
        btnBalance.setBounds(140 , 490 , 150 , 30);
        btnBalance.setFocusable(false);
        btnBalance.addActionListener(this);
        lblImg.add(btnBalance);
        
        //JButton for Exit
        btnExit = new JButton("Exit");
        btnExit.setBounds(355 , 528 , 150 , 30);
        btnExit.setFocusable(false);
        btnExit.addActionListener(this);
        lblImg.add(btnExit);
        
        setSize(900 , 900);
        setLocation(300 , 0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnExit){
            System.exit(0);
        }
        else if(e.getSource() == btnDeposit){
            setVisible(false);
            new Deposit(cardNumber , pinNumber).setVisible(true);
        }
        else if(e.getSource() == btnWithdrawl){
            setVisible(false);
            new Withdrawl(cardNumber , pinNumber).setVisible(true);
        }
        else if(e.getSource() == btnFastCash){
            setVisible(false);
            new FastCash(cardNumber, pinNumber).setVisible(true);
        }
        else if(e.getSource() == btnPinChange){
            setVisible(false);
            new PinChange(cardNumber , pinNumber).setVisible(true);
        }
        else if(e.getSource() == btnBalance){
            setVisible(false);
            new BalanceEnquiry(cardNumber , pinNumber).setVisible(true);
        }
        else if(e.getSource() == btnMiniStatement)
        {
            //setVisible(false);
            new MiniStatement(cardNumber, pinNumber).setVisible(true);
        }
    }

    public static void main(String args[]){
        new Transactions("", "");
    }
}
