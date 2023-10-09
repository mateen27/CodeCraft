package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
public class SignUpOne extends JFrame implements ActionListener{
    
    long randomNo;
    JTextField txtName , txtFName , txtEmail , txtAddress , txtCity , txtState , txtPinCode;
    JDateChooser dateChooser;
    JRadioButton male , female , married , unmarried , other;
    JButton btnNext;
    
    SignUpOne(){
        //Layout of the Frame  
        setLayout(null);
        
        //Cursor on Button
        Cursor c = new Cursor(Cursor.HAND_CURSOR);
        
        //Resize of JFrame
        setResizable(false);
        
        //JFrame Title
        setTitle("Page 1: Personal Details");
        
        //Background Color
        getContentPane().setBackground(Color.WHITE);
        
        //Icon On JFrame
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons//bankicon.png"));
        setIconImage(icon.getImage());
        
        //for Generating RandomNumber
        Random ran = new Random();
        randomNo = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        //JLabel for Displaying Application Number
        JLabel formNo = new JLabel("APPLICATION FORM NO. " + randomNo);
        formNo.setFont(new Font("Raleway" , Font.BOLD , 38));
        formNo.setBounds(140 , 20 , 600 , 40); 
        add(formNo);
        
        //JLabel for Displaying Personal Detail Page 1
        JLabel personDetail = new JLabel("Page 1: Personal Details");
        personDetail.setFont(new Font("Raleway" , Font.BOLD , 22));
        personDetail.setBounds(290 , 80 , 400 , 30); 
        add(personDetail);
        
        //JLabel for Name
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raelway" , Font.BOLD , 20));
        name.setBounds(100 , 140 , 100 , 30);
        add(name);
        
        //JTextField for Name
        txtName = new JTextField();
        txtName.setFont(new Font("Raelway" , Font.BOLD , 14));
        txtName.setBounds(300 , 140 , 400 , 30);
        add(txtName);
        
        //JLabel for Father's Name
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raelway" , Font.BOLD , 20));
        fname.setBounds(100 , 190 , 200 , 30);
        add(fname);
        
        //JTextField for Father's Name
        txtFName = new JTextField();
        txtFName.setFont(new Font("Raelway" , Font.BOLD , 14));
        txtFName.setBounds(300 , 190 , 400 , 30);
        add(txtFName);
        
        //JLabel for date Of Birth
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raelway" , Font.BOLD , 20));
        dob.setBounds(100 , 240 , 200 , 30);
        add(dob);
        
        //JDateChooser (Class in JCalender Jar File) for date Of Birth
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300 , 240 , 400 , 30);
        dateChooser.setForeground(new Color(105 , 105 , 105));
        add(dateChooser);
        
        //JLabel for Gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raelway" , Font.BOLD , 20));
        gender.setBounds(100 , 290 , 200 , 30);
        add(gender);
        
        //JRadioButton for Male
        male = new JRadioButton("Male");
        male.setBounds(300 , 290 , 60 , 30);
        male.setBackground(Color.WHITE);
        male.setFocusable(false);
        add(male);
        
        //JRadioButton for Female
        female = new JRadioButton("Female");
        female.setBounds(450 , 290 , 120 , 30);
        female.setBackground(Color.WHITE);
        female.setFocusable(false);
        add(female);
        
        //grouping both Male and Female
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        //JLabel for Email Address
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raelway" , Font.BOLD , 20));
        email.setBounds(100 , 340 , 200 , 30);
        add(email);
        
        //JTextField for Email
        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Raelway" , Font.BOLD , 14));
        txtEmail.setBounds(300 , 340 , 400 , 30);
        add(txtEmail);
        
        //JLabel for Marital Status
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raelway" , Font.BOLD , 20));
        marital.setBounds(100 , 390 , 200 , 30);
        add(marital);
        
        //JRadioButton for Married
        married = new JRadioButton("Married");
        married.setBounds(300 , 390 , 100 , 30);
        married.setBackground(Color.WHITE);
        married.setFocusable(false);
        add(married);
        
        //JRadioButton for UnMarried
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450 , 390 , 100 , 30);
        unmarried.setBackground(Color.WHITE);
        unmarried.setFocusable(false);
        add(unmarried);
        
        //JRadioButton for Other
        other = new JRadioButton("Other");
        other.setBounds(630 , 390 , 100 , 30);
        other.setBackground(Color.WHITE);
        other.setFocusable(false);
        add(other);
        
        //grouping both Married and Single And Other
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);
        
        //JLabel for Address
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raelway" , Font.BOLD , 20));
        address.setBounds(100 , 440 , 200 , 30);
        add(address);
        
        //JTextField for Address
        txtAddress = new JTextField();
        txtAddress.setFont(new Font("Raelway" , Font.BOLD , 14));
        txtAddress.setBounds(300 , 440 , 400 , 30);
        add(txtAddress);
        
        //JLabel for City
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raelway" , Font.BOLD , 20));
        city.setBounds(100 , 490 , 200 , 30);
        add(city);
        
        //JTextField for City
        txtCity = new JTextField();
        txtCity.setFont(new Font("Raelway" , Font.BOLD , 14));
        txtCity.setBounds(300 , 490 , 400 , 30);
        add(txtCity);
        
        //JLabel for State
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raelway" , Font.BOLD , 20));
        state.setBounds(100 , 540 , 200 , 30);
        add(state);
        
        //JTextField for State
        txtState = new JTextField();
        txtState.setFont(new Font("Raelway" , Font.BOLD , 14));
        txtState.setBounds(300 , 540 , 400 , 30);
        add(txtState);
        
        //JLabel for PinCode
        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raelway" , Font.BOLD , 20));
        pincode.setBounds(100 , 590 , 200 , 30);
        add(pincode);
        
        //JTextField for State
        txtPinCode = new JTextField();
        txtPinCode.setFont(new Font("Raelway" , Font.BOLD , 14));
        txtPinCode.setBounds(300 , 590 , 400 , 30);
        add(txtPinCode);
        
        //Button for Next Page
        btnNext = new JButton("Next");
        btnNext.setFont(new Font("Raelway" , Font.BOLD , 14));
        btnNext.setBounds(620 , 660 , 80 , 30);
        btnNext.setFocusable(false);
        btnNext.setBackground(Color.BLACK);
        btnNext.setForeground(Color.WHITE);
        btnNext.setCursor(c);
        btnNext.addActionListener(this);
        add(btnNext);
        
        //Frame Properties
        setSize(850 , 760);
        setLocation(350 , 10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e){
        String formNo = "" + randomNo;
        //getText() used for taking out the value fron TextField
        String name = txtName.getText();
        String fatherName = txtFName.getText();
        //getUiComponent return a TextField
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = "";
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        
        String email = txtEmail.getText();
        String marital = "";
        if(married.isSelected()){
            marital = "Married";
        }
        else if(unmarried.isSelected()){
            marital = "Unmarried";
        }
        else if(other.isSelected()){
            marital = "Other";
        }
        
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String state = txtState.getText();
        String pincode = txtPinCode.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name Field is Empty!");
            }
            else if(fatherName.equals("")){
                JOptionPane.showMessageDialog(null, "Father's Name Field is Empty!");
            }
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null , "Date of Birth Field is Empty!");
            }
            else if(email.equals("")){
                 JOptionPane.showMessageDialog(null , "Email-ID Field is Empty!");
            }
            else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Address Field is Empty!");
            }
            else if(city.equals("")){
                JOptionPane.showMessageDialog(null , "City Field is Empty!");
            }
            else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State Field is Empty!");
            }
            else if(pincode.equals("")){
                JOptionPane.showMessageDialog(null, "PinCode Field is Empty!");
            }
            else if(marital.equals("")){
                JOptionPane.showMessageDialog(null, "Marital Status is not Selected!");
            }
            else if(gender.equals("")){
                JOptionPane.showMessageDialog(null, "Gender is not Selected!");
            }
            else{
            Conn c = new Conn();
            String query = "insert into signup values('"+formNo+"' , '"+name+"' , '"+fatherName+"' , '"+dob+"' , '"+gender+"' , '"+email+"' , '"+marital+"' , '"+address+"' , '"+city+"' , '"+state+"' , '"+pincode+"')";
            c.st.executeUpdate(query);
            JOptionPane.showMessageDialog(null , "Information Saved"); 
            dispose();
            //SignUp Page Two Object
            new SignUpTwo(formNo).setVisible(true);
            }
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public static void main(String args[]){
        new SignUpOne();
    }
}
