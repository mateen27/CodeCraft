package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener{
    
    JRadioButton rbSavingAccount , rbFixedDepositAccount , rbCurrentAccount , rbRecurringDepositAccount;
    JCheckBox cbAtmCard , cbInternetBanking , cbMobileBanking , cbAlerts , cbChequeBook , cbEStatement , cbDeclaration;
    JButton submit , cancel;
    String formno;
    
    SignUpThree(String formno){
        //formno
        this.formno = formno;
        
        //Icon for JFrame
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/bankicon.png"));
        setIconImage(icon.getImage());
        
        //JFrame Title
        setTitle("Page 3: Account Details");
        
        //Cursor on Button
        Cursor c = new Cursor(Cursor.HAND_CURSOR);
        
        //Layout of The JFrame
        setLayout(null);
        
        //JLabel for Heading
        JLabel heading = new JLabel("Page 3: Account Details");
        heading.setFont(new Font("Raelway" , Font.BOLD , 22));
        heading.setBounds(280 , 40 , 400 , 40);
        add(heading);
        
        //JLabel for Account Type
        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Raelway" , Font.BOLD , 22));
        accountType.setBounds(100 , 140 , 200 , 30);
        add(accountType);
        
        //JRadioButton for Saving Account
        rbSavingAccount = new JRadioButton("Saving Account");
        rbSavingAccount.setBackground(Color.WHITE);
        rbSavingAccount.setFont(new Font("Raelway" , Font.BOLD , 16));
        rbSavingAccount.setFocusable(false);
        rbSavingAccount.setBounds(100 , 180 , 250 , 20);
        add(rbSavingAccount);
        
        //JRadioButton for Fixed Deposit Accunt
        rbFixedDepositAccount = new JRadioButton("Fixed Deposit Account");
        rbFixedDepositAccount.setFocusable(false);
        rbFixedDepositAccount.setFont(new Font("Raelway" , Font.BOLD , 16));
        rbFixedDepositAccount.setBackground(Color.WHITE);
        rbFixedDepositAccount.setBounds(350 , 180 , 250 , 20);
        add(rbFixedDepositAccount);
        
        //JRadioButton for Current Account
        rbCurrentAccount = new JRadioButton("Current Account");
        rbCurrentAccount.setFocusable(false);
        rbCurrentAccount.setFont(new Font("Raelway" , Font.BOLD , 16));
        rbCurrentAccount.setBackground(Color.WHITE);
        rbCurrentAccount.setBounds(100 , 220 , 250 , 20);
        add(rbCurrentAccount);
        
        //JRadioButton for Recurring Deposit Account
        rbRecurringDepositAccount = new JRadioButton("Recurring Deposit Account");
        rbRecurringDepositAccount.setFocusable(false);
        rbRecurringDepositAccount.setFont(new Font("Raelway" , Font.BOLD , 16));
        rbRecurringDepositAccount.setBackground(Color.WHITE);
        rbRecurringDepositAccount.setBounds(350 , 220 , 250 , 20);
        add(rbRecurringDepositAccount);
        
        //ButtonGroup AccountType
        ButtonGroup bgAccountType = new ButtonGroup();
        bgAccountType.add(rbSavingAccount);
        bgAccountType.add(rbFixedDepositAccount);
        bgAccountType.add(rbCurrentAccount);
        bgAccountType.add(rbRecurringDepositAccount);
        
        //JLabel for CardNumber
        JLabel cardNumber = new JLabel("Card Number");
        cardNumber.setFont(new Font("Raelway" , Font.BOLD , 22));
        cardNumber.setBounds(100 , 300 , 200 , 30);
        add(cardNumber);
        
        //JLabel for Dumy Card Number
        JLabel dumyCardNumber = new JLabel("XXXX-XXXX-XXXX-4184");
        dumyCardNumber.setFont(new Font("Raelway" , Font.BOLD , 22));
        dumyCardNumber.setBounds(330 , 300 , 300 , 30);
        add(dumyCardNumber);
        
        //JLabel for 16-Digit Number
        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raelway" , Font.BOLD , 12));
        cardDetail.setBounds(100 , 330 , 300 , 20);
        add(cardDetail);
        
        //JLabel for PIN
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raelway" , Font.BOLD , 22));
        pin.setBounds(100 , 370 , 370 , 30);
        add(pin);
        
        //JLabel for PIN Number
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raelway" , Font.BOLD , 22));
        pinNumber.setBounds(330 , 370 , 300 , 30);
        add(pinNumber);
        
        //JLabel for 4 Digit Password
        JLabel pinDetail = new JLabel("Your 4 Digit Password");
        pinDetail.setFont(new Font("Raelway" , Font.BOLD , 12));
        pinDetail.setBounds(100 , 400 , 300 , 20);
        add(pinDetail);
        
        //JLabel for Services Required
        JLabel servicesRequired = new JLabel("Services Required");
        servicesRequired.setFont(new Font("Raelway" , Font.BOLD , 22));
        servicesRequired.setBounds(100 , 450 , 300 , 22);
        add(servicesRequired);
        
        //JCheckBox for Atm Card
        cbAtmCard = new JCheckBox("ATM CARD");
        cbAtmCard.setFont(new Font("Raelway" , Font.BOLD , 16));
        cbAtmCard.setBounds(100 , 500 , 200 , 30);
        cbAtmCard.setFocusable(false);
        cbAtmCard.setBackground(Color.WHITE);
        add(cbAtmCard);
        
        //JCheckBox for Internet Banking
        cbInternetBanking = new JCheckBox("Internet Banking");
        cbInternetBanking.setBackground(Color.WHITE);
        cbInternetBanking.setFont(new Font("Raelway" , Font.BOLD , 16));
        cbInternetBanking.setFocusable(false);
        cbInternetBanking.setBounds(350 , 500 , 200 , 30);
        add(cbInternetBanking);
        
        //JCheckBox for Mobile Banking
        cbMobileBanking = new JCheckBox("Mobile Banking");
        cbMobileBanking.setBackground(Color.WHITE);
        cbMobileBanking.setFont(new Font("Raelway" , Font.BOLD , 16));
        cbMobileBanking.setFocusable(false);
        cbMobileBanking.setBounds(100 , 550 , 200 , 30);
        add(cbMobileBanking);
        
        //JCheckBox for Alerts
        cbAlerts = new JCheckBox("EMAIL & SMS Alerts");
        cbAlerts.setBackground(Color.WHITE);
        cbAlerts.setFont(new Font("Raelway" , Font.BOLD , 16));
        cbAlerts.setFocusable(false);
        cbAlerts.setBounds(350 , 550 , 200 , 30);
        add(cbAlerts);
        
        //JCheckBox for Cheque Book
        cbChequeBook = new JCheckBox("Cheque Book");
        cbChequeBook.setBackground(Color.WHITE);
        cbChequeBook.setFont(new Font("Raelway" , Font.BOLD , 16));
        cbChequeBook.setFocusable(false);
        cbChequeBook.setBounds(100 , 600 , 200 , 30);
        add(cbChequeBook);
        
        //JCheckBox for E-Statement
        cbEStatement = new JCheckBox("E-Statement");
        cbEStatement.setBackground(Color.WHITE);
        cbEStatement.setFont(new Font("Raelway" , Font.BOLD , 16));
        cbEStatement.setFocusable(false);
        cbEStatement.setBounds(350 , 600 , 200 , 30);
        add(cbEStatement);
        
        //JCheckBox for Declaration
        cbDeclaration = new JCheckBox("I Hereby declares that the above entered details are correct to the best of my knowledge");
        cbDeclaration.setBackground(Color.WHITE);
        cbDeclaration.setFont(new Font("Raelway" , Font.BOLD , 12));
        cbDeclaration.setFocusable(false);
        cbDeclaration.setBounds(100 , 660 , 600 , 30);
        add(cbDeclaration);
        
        //JButton for Submit
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFocusable(false);
        submit.setBounds(220 , 700 , 100 , 30);
        submit.setFont(new Font("Raleway" , Font.BOLD , 14));
        submit.addActionListener(this);
        submit.setCursor(c);
        add(submit);
        
        //JButton for Cancel
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFocusable(false);
        cancel.setBounds(420 , 700 , 100 , 30);
        cancel.setFont(new Font("Raleway" , Font.BOLD , 14));
        cancel.addActionListener(this);
        cancel.setCursor(c);
        add(cancel);
        
        //Frame Properties
        getContentPane().setBackground(Color.WHITE);
        setSize(850 , 820);
        setLocation(350 , 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit){
            if(formno.equals("")){
                dispose();
                return;
                }
            String accountType = "";
            if(rbSavingAccount.isSelected()){
                accountType = "Saving Account";
            }
            else if(rbFixedDepositAccount.isSelected()){
                accountType = "Fixed Deposit Account";
            }
            else if(rbCurrentAccount.isSelected()){
                accountType = "Current Account";
            }
            else if(rbRecurringDepositAccount.isSelected()){
                accountType = "Recurring Deposit Account";
            }
            
            //for Generating RandomNumber
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String services = "";
            if(cbAtmCard.isSelected()){
                services = services + " ATM CARD";
            }
            else if(cbInternetBanking.isSelected()){
                services = services + " Internet Banking";
            }
            else if(cbMobileBanking.isSelected()){
                services = services + " Mobile Banking";
            }
            else if(cbAlerts.isSelected()){
                services = services + " EMAIL & SMS Alerts";
            }
            else if(cbChequeBook.isSelected()){
                services = services + " Cheque Book";
            }
            else if(cbEStatement.isSelected()){
                services = services + " E-Statement";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null , "Account Type is Required!");
                    return;
                }
                if(services.equals("")){
                    JOptionPane.showMessageDialog(null, "Services needs to be selected!");
                    return;
                }
                //CheckBox for Validation check
                //Declaration Warning
                String validation = "";
                if(cbDeclaration.isSelected()){
                 validation = "Selected";
                }
                if(validation.equals("")){
                JOptionPane.showMessageDialog(null, "Declaration must be checked!");
                return;
                }
                else{
                Conn conn = new Conn();
                String query = "insert into signupthree values('"+formno+"' , '"+accountType+"' , '"+services+"' , '"+cardnumber+"' , '"+pinnumber+"')";
                String query1 = "insert into login values('"+formno+"' , '"+cardnumber+"' , '"+pinnumber+"')";
                conn.st.executeUpdate(query);
                conn.st.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + pinnumber);
                }
                setVisible(false);
                new Transactions(cardnumber , pinnumber).setVisible(true);
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            
        }
        else if(e.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[]){
        new SignUpThree("");
    }
}
