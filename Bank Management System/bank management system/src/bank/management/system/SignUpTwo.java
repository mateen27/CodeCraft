package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class SignUpTwo extends JFrame implements ActionListener{
    
    JTextField txtPanNumber , txtAadharNumber;
    JRadioButton rbYes , rbNo , eYes , eNo;
    JButton btnNext;
    JComboBox cbReligion , cbCategory , cbIncome , cbEducation , cbOccupation;
    //Primary key to interRelate SignUpOne and SignUpTwo Data
    String formNo;
    
    SignUpTwo(String formNo){
        this.formNo = formNo;
        
        //Layout of the Frame  
        setLayout(null);
        
        //Cursor on Button
        Cursor c = new Cursor(Cursor.HAND_CURSOR);
        
        //Resize of JFrame
        setResizable(false);
        
        //JFrame Title
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        //Background Color
        getContentPane().setBackground(Color.WHITE);
        
        //Icon On JFrame
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons//bankicon.png"));
        setIconImage(icon.getImage());
        
        //JLabel for Displaying Personal Detail Page 1
        JLabel additionalDetail = new JLabel("Page 2: Additional Details");
        additionalDetail.setFont(new Font("Raleway" , Font.BOLD , 22));
        additionalDetail.setBounds(290 , 80 , 400 , 30); 
        add(additionalDetail);
        
        //JLabel for Religion
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raelway" , Font.BOLD , 20));
        religion.setBounds(100 , 140 , 100 , 30);
        add(religion);
        
        //JComboBox for Religion
        String valReligion[] = {"Please Select Religion" , "Hindu" , "Muslim" , "Christian" , "Sikh" , "Other"};
        cbReligion = new JComboBox(valReligion);
        cbReligion.setBounds(300 , 140 , 400 , 30);
        cbReligion.setBackground(Color.WHITE);
        add(cbReligion);
        
        //JLabel for Category
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raelway" , Font.BOLD , 20));
        category.setBounds(100 , 190 , 200 , 30);
        add(category);
        
        //JComboBox for Category
        String valCategory[] = {"Please Select Category" , "General" , "OBC" , "SC" , "ST" , "Other"};
        cbCategory = new JComboBox(valCategory);
        cbCategory.setBackground(Color.WHITE);
        cbCategory.setBounds(300 , 190 , 400 , 30);
        add(cbCategory);
        
        //JLabel for Income
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raelway" , Font.BOLD , 20));
        income.setBounds(100 , 240 , 200 , 30);
        add(income);
        
        //JComboBox for Income
        String valIncome[] = {"Please Select your Income" , "Null" , "< 1,50,000" , "< 2,50,000" , "< 5,00,000" , "Upto 10,00,000"};
        cbIncome = new JComboBox(valIncome);
        cbIncome.setBackground(Color.WHITE);
        cbIncome.setBounds(300 , 240 , 400 , 30);
        add(cbIncome);
        
        //JLabel for Education
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raelway" , Font.BOLD , 20));
        education.setBounds(100 , 290 , 200 , 30);
        add(education);
        
        //JLabel for Qualification
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raelway" , Font.BOLD , 20));
        qualification.setBounds(100 , 315 , 200 , 30);
        add(qualification);
        
        //JComboBox for Educational Qualification
        String educationValues[] = {"Please Select Educational Qualification" ,"Non-Graduation" , "Graduate" , "Post-Graduation" , "Doctrate" , "Others"};
        cbEducation = new JComboBox(educationValues);
        cbEducation.setBackground(Color.WHITE);
        cbEducation.setBounds(300 , 315 , 400 , 30);
        add(cbEducation);
        
        //JLabel for Occupation
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raelway" , Font.BOLD , 20));
        occupation.setBounds(100 , 390 , 200 , 30);
        add(occupation);
        
        //JComboBox for Occupation
        String OccupationValues[] = {"Please Select Occupation" ,"Salaried" , "Self-Employed" , "Buisness" , "Student" , "Retired" , "Others"};
        cbOccupation = new JComboBox(OccupationValues);
        cbOccupation.setBackground(Color.WHITE);
        cbOccupation.setBounds(300 , 390 , 400 , 30);
        add(cbOccupation);
        
        //JLabel for Pan Number
        JLabel panNumber = new JLabel("PAN Number:");
        panNumber.setFont(new Font("Raelway" , Font.BOLD , 20));
        panNumber.setBounds(100 , 440 , 200 , 30);
        add(panNumber);
        
        //JTextField for Address
        txtPanNumber = new JTextField();
        txtPanNumber.setFont(new Font("Raelway" , Font.BOLD , 14));
        txtPanNumber.setBounds(300 , 440 , 400 , 30);
        add(txtPanNumber);
        
        //JLabel for AADHAR Number
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raelway" , Font.BOLD , 20));
        aadhar.setBounds(100 , 490 , 200 , 30);
        add(aadhar);
        
        //JTextField for txtAadharNumber
        txtAadharNumber = new JTextField();
        txtAadharNumber.setFont(new Font("Raelway" , Font.BOLD , 14));
        txtAadharNumber.setBounds(300 , 490 , 400 , 30);
        add(txtAadharNumber);
        
        //JLabel for Senior Citizen
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raelway" , Font.BOLD , 20));
        seniorCitizen.setBounds(100 , 540 , 200 , 30);
        add(seniorCitizen);
        
        //JRadioButton fo Yes
        rbYes = new JRadioButton("Yes");
        rbYes.setBackground(Color.WHITE);
        rbYes.setBounds(300 , 540 , 100 , 30);
        rbYes.setFocusable(false);
        add(rbYes);
        
        //JRadioButton for No
        rbNo = new JRadioButton("No");
        rbNo.setBackground(Color.WHITE);
        rbNo.setBounds(450 , 540 , 100 , 30);
        rbNo.setFocusable(false);
        add(rbNo);
        
        //ButtonGroup for Yes and No for Senior Citizen
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(rbYes);
        seniorGroup.add(rbNo);
        
        //JLabel for Existing Account
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raelway" , Font.BOLD , 20));
        existingAccount.setBounds(100 , 590 , 200 , 30);
        add(existingAccount);
        
        //JRadioButton fo Yes
        eYes = new JRadioButton("Yes");
        eYes.setBackground(Color.WHITE);
        eYes.setBounds(300 , 590 , 100 , 30);
        eYes.setFocusable(false);
        add(eYes);
        
        //JRadioButton for No
        eNo = new JRadioButton("No");
        eNo.setBackground(Color.WHITE);
        eNo.setBounds(450 , 590 , 100 , 30);
        eNo.setFocusable(false);
        add(eNo);
        
        //ButtonGroup for Yes and No for Senior Citizen
        ButtonGroup ExistingGroup = new ButtonGroup();
        ExistingGroup.add(eYes);
        ExistingGroup.add(eNo);
        
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
        String formno = "" + formNo; //long
        //getSelectedItem() used to get value from the DropDown in the form of Object.
        String religion = (String)cbReligion.getSelectedItem();
        String category = (String)cbCategory.getSelectedItem();
        String income = (String)cbIncome.getSelectedItem();
        String educationQualification = (String)cbEducation.getSelectedItem();
        String occupation = (String)cbOccupation.getSelectedItem();
        String pan = txtPanNumber.getText();
        String aadhar = txtAadharNumber.getText();
        String seniorCitizen = "";
        if(rbYes.isSelected()){
            seniorCitizen = "Yes";
        }
        else if(rbNo.isSelected()){
            seniorCitizen = "No";
        }
        String existingAccount = "";
        if(eYes.isSelected()){
            existingAccount = "Yes";
        }
        else if(eNo.isSelected()){
            existingAccount = "No";
        }
        try{
            if(seniorCitizen.equals("")){
                JOptionPane.showMessageDialog(null, "Please check one of the option from the Senior Citizen Category!");
            }
            else if(existingAccount.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please check one of the option from the Existing Account Category!");
            }
            else if(formno.equals("")){
                dispose();
            }
            else{
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"' , '"+religion+"' , '"+category+"' , '"+income+"' , '"+educationQualification+"' , '"+occupation+"' , '"+pan+"' , '"+aadhar+"' , '"+seniorCitizen+"' , '"+existingAccount+"')";
            c.st.executeUpdate(query);
            JOptionPane.showMessageDialog(null , "Information Saved"); 
            dispose();
            //SignUp Page Three Object
            new SignUpThree(formno).setVisible(true);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public static void main(String args[]){
        new SignUpTwo("");
    }
}
