package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class MiniStatement extends JFrame{

    String cardNumber , pinNumber;
    MiniStatement(String cardNumber , String pinNumber){
        
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        
        //JFrame icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/bankicon.png"));
        setIconImage(icon.getImage());
        
        //Layout for JFrame
        setLayout(null);
        
        //Title of the Frame
        setTitle("MINI STATEMENT");
        
        //JLabel for Mini Statement
        JLabel lblMiniStatement = new JLabel();
        lblMiniStatement.setBounds(20 , 140 , 400 , 200);
        add(lblMiniStatement);
        
        //JLabel for BankName
        JLabel lblBankName = new JLabel("Indian Bank");
        lblBankName.setFont(new Font("Raelway" , Font.BOLD , 16));
        lblBankName.setForeground(Color.BLACK);
        lblBankName.setBounds(140 , 20 , 100 , 20);
        add(lblBankName);
        
        //JLabel for CardNumber
        //for getting first four Number we used substring(0,4) then used "XXXX" and after 8 digits i want all digits 4+8=12
        JLabel lblCardNumber = new JLabel();
        lblCardNumber.setFont(new Font("Raelway" , Font.BOLD , 14));
        lblCardNumber.setForeground(Color.BLACK);
        lblCardNumber.setBounds(20 , 80 , 300 , 20);
        add(lblCardNumber);
        
        //Jlabel for accountBalance
        JLabel lblAccountBalance = new JLabel();
        lblAccountBalance.setForeground(Color.BLACK);
        lblAccountBalance.setFont(new Font("Raelway" , Font.BOLD , 14));
        lblAccountBalance.setBounds(20 , 400 , 300 , 20);
        add(lblAccountBalance);
        
        //creating Connection with the DataBase
        
        //for CardNumber
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.st.executeQuery("select * from login where pin = '"+pinNumber+"'");
            while(rs.next()){
                lblCardNumber.setText("Card Number: " + rs.getString("cardNumber").substring(0 , 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        //for Account Statement
        try{
            Conn conn = new Conn();
            int bankBalance = 0;
            ResultSet rs = conn.st.executeQuery("select * from accountinfo where cardNumber = '"+cardNumber+"' and pin = '"+pinNumber+"'");
            while(rs.next()){
                lblMiniStatement.setText(lblMiniStatement.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bankBalance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bankBalance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            lblAccountBalance.setText("Your Account Balance is: " + bankBalance);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        //properties for JFrame
        setSize(400 , 600);
        setLocation(20 , 20);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
}

    public static void main(String args[]){
        new MiniStatement("" , "");
    }
}
