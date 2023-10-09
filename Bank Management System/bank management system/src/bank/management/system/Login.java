package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField txtcardno;
    JPasswordField txtpin;
    JButton signIn , clear , signUp;
    
    Login(){
        
        setTitle("AUTOMATED TELLER MACHINE");
        //For The Icon Image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/bankicon.png"));
	setIconImage(icon.getImage());
        //Cursor on Buttons
            Cursor c = new Cursor(Cursor.HAND_CURSOR);
        setLayout(null);
        
        //Setting the Logo on the JFrame
        //ForLoading the Image from the System{Desired Location}
        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        //For Image Width and Height
        Image imglogo = logo.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon logoimg = new ImageIcon(imglogo);
        JLabel lblLogo = new JLabel(logoimg);
        lblLogo.setBounds(70 , 10 , 100 , 100);
        add(lblLogo);
        
        //JLabel for Heading on JFrame
        JLabel heading = new JLabel("Welcome to ATM");
        heading.setFont(new Font("Osward" , Font.BOLD , 38));
        heading.setBounds(200 , 40 , 400 , 40);
        add(heading);
        
        //JLabel for Card Number
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway" , Font.BOLD , 28));
        cardno.setBounds(120 , 150 , 150 , 30);
        add(cardno);
        
        //JTextField for CardNumber
        txtcardno = new JTextField();
        txtcardno.setBounds(300 , 150 , 230 , 30);
        txtcardno.setFont(new Font("Arial" , Font.BOLD , 14));
        add(txtcardno);
        
        //JLabel for PIN
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway" , Font.BOLD , 28));
        pin.setBounds(120 , 220 , 150 , 30);
        add(pin);
        
        //JPasswordField for PIN
        txtpin = new JPasswordField();
        txtpin.setBounds(300 , 220 , 230 , 30);
        txtpin.setFont(new Font("Arial" , Font.BOLD , 14));
        add(txtpin);
        
        //SignIn Button on JFrame
        signIn = new JButton("SIGN IN");
        signIn.setBounds(300 , 300 , 100 , 30);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.setFocusable(false);
        signIn.setCursor(c);
        signIn.addActionListener(this);
        add(signIn);
        
        //Clear Button on JFrame
        clear = new JButton("CLEAR");
        clear.setBounds(430 , 300 , 100 , 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setFocusable(false);
        clear.setCursor(c);
        clear.addActionListener(this);
        add(clear);
        
        //SignUp Button on JFrame
        signUp = new JButton("SIGN UP");
        signUp.setBounds(300 , 350 , 230 , 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.setFocusable(false);
        signUp.setCursor(c);
        signUp.addActionListener(this);
        add(signUp);
        
        //Frame Properties
        //for Background Color
        getContentPane().setBackground(Color.WHITE);
        setSize(800 , 480);
        setVisible(true);
        setLocation(350 , 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == signIn){
            Conn conn = new Conn();
            String cardNumber = txtcardno.getText();
            String pinNumber = txtpin.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pin = '"+pinNumber+"'";
            try{
            //can throw an error so using try catch
            ResultSet rs = conn.st.executeQuery(query);
            if(rs.next()){
                //Close current Login JFrame
                dispose();
                //Open Transaction JFrame
                new Transactions(cardNumber , pinNumber).setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
            }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
        else if(e.getSource() == clear){
            txtcardno.setText("");
            txtpin.setText("");
        }
        else if(e.getSource() == signUp){
            dispose();
            //SignUp Page One Object
            new SignUpOne().setVisible(true);
        }
        
    }
    
    public static void main(String args[]){
        new Login();
    }
}
