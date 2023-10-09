package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JTextField txtFieldPin , txtFieldRPin;
    JButton btnchangePin , btnBack;
    String cardNumber , pinNumber;

    PinChange(String cardNumber , String pinNumber){
        
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        
        //JFrame icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/bankicon.png"));
        setIconImage(icon.getImage());
        
        //Layout 
        setLayout(null);
        
        //Adding Image over the Frame
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i = img.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon imgMain = new ImageIcon(i);
        JLabel lblImg = new JLabel(imgMain);
        lblImg.setBounds(0 , 0 , 900 , 900);
        add(lblImg);
        
        //Pin Label 
        JLabel lblPin = new JLabel("CHANGE YOUR PIN");
        lblPin.setBounds(250 , 280 , 200 , 30);
        lblPin.setForeground(Color.WHITE);
        lblPin.setFont(new Font("Raelway" , Font.BOLD , 16));
        lblImg.add(lblPin);
        
        //New Pin Label 
        JLabel lblNewPin = new JLabel("NEW PIN");
        lblNewPin.setBounds(140 , 340 , 200 , 30);
        lblNewPin.setForeground(Color.WHITE);
        lblNewPin.setFont(new Font("Raelway" , Font.BOLD , 14));
        lblImg.add(lblNewPin);
        
        //JTextField for the Pin
        txtFieldPin = new JTextField();
        txtFieldPin.setFont(new Font("Raelway" , Font.BOLD , 20));
        txtFieldPin.setForeground(Color.BLACK);
        txtFieldPin.setBounds(280 , 340 , 200 , 25);
        lblImg.add(txtFieldPin);
        
        //Confirm New Pin Label 
        JLabel lblCNewPin = new JLabel("RE-ENTER PIN");
        lblCNewPin.setBounds(140 , 390 , 200 , 30);
        lblCNewPin.setForeground(Color.WHITE);
        lblCNewPin.setFont(new Font("Raelway" , Font.BOLD , 14));
        lblImg.add(lblCNewPin);
        
        //JTextField for the Re Enter Pin
        txtFieldRPin = new JTextField();
        txtFieldRPin.setFont(new Font("Raelway" , Font.BOLD , 20));
        txtFieldRPin.setForeground(Color.BLACK);
        txtFieldRPin.setBounds(280 , 390 , 200 , 25);
        lblImg.add(txtFieldRPin);
        
        //JButton for changing the PIN
        btnchangePin = new JButton("Change PIN");
        btnchangePin.setFont(new Font("Raelway" , Font.BOLD , 12));
        btnchangePin.setForeground(Color.BLACK);
        btnchangePin.setBounds(360 , 492 , 150 , 30);
        btnchangePin.setFocusable(false);
        btnchangePin.addActionListener(this);
        lblImg.add(btnchangePin);
        
        //JButton for BACK
        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Raelway" , Font.BOLD , 12));
        btnBack.setForeground(Color.BLACK);
        btnBack.setFocusable(false);
        btnBack.setBounds(360 , 530 , 150 , 30);
        btnBack.addActionListener(this);
        lblImg.add(btnBack);
        
        
        //Frame properties
        setUndecorated(true);
        setSize(900 , 900);
        setLocation(300 , 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnBack){
            setVisible(false);
            new Transactions(cardNumber , pinNumber).setVisible(true);
        }
        if(e.getSource() == btnchangePin){
        try{
            String Pin = txtFieldPin.getText();
            String rePin = txtFieldRPin.getText();
            if(!Pin.equals(rePin)){
                JOptionPane.showMessageDialog(null , "The Entered PIN's does not Match!");
                return;
            }
            
            //Validation for Empty Field
            if(Pin.equals("")){
                JOptionPane.showMessageDialog(null , "PIN Field is empty!");
                return;
            }
            if(rePin.equals("")){
                JOptionPane.showMessageDialog(null, "Re-Enter Field is empty!");
                return;
            }
            try{
            //Update in the DataBase
            Conn conn = new Conn();
            String query = "update accountinfo set pin = '"+rePin+"' where pin = '"+pinNumber+"'";
            String query2 = "update login set pin = '"+rePin+"' where pin = '"+pinNumber+"'";
            String query3 = "update signupthree set pin = '"+rePin+"' where pin = '"+pinNumber+"'";
            conn.st.executeUpdate(query);
            conn.st.executeUpdate(query2);
            conn.st.executeUpdate(query3);
            JOptionPane.showMessageDialog(null, "PIN Updated!");
            //Closing the Frame
            setVisible(false);
            new Transactions(cardNumber , pinNumber).setVisible(true);
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    }

    public static void main(String args[]){
        new PinChange("" , "");
    }
}
