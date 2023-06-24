//Calculator in Java Swing

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Calculator implements ActionListener{


JFrame f;

JLabel label;

//for textArea
JTextArea ta;

//for Button
JButton b1 , b2 , b3 , b4 , b5 , b6 , b7 ,b8 ,b9 ,b10 ,b11 ,b12 ,b13 ,b14 ,b15 ,b16 ,b17 ,b18 ,b19 ,b20 ,b21 ,b22 ,b23 ,b24 , b25 ,b26 ,b27 ,b28 ;

//for MenuBar
JMenuBar mb ;

//for menu
JMenu view , edit , help , Worksheets;

//for View
JMenuItem standard , scientific , programmer , statistics , history , digitGrouping , basic , unitConversion , dateCalculation ;

//for Worksheets
JMenuItem mortgage , vehicleLease , fuelEconomy , FuelEconomy ; 

//for Edit
JMenuItem copy , paste , copyValue , copyAllValues;

//for Help
JMenuItem viewHelp , aboutCalculator;

//for Font
Font fo;

//Float DataType
Float num1 , num2 , result;

//String 
String operator;

//Constructor
Calculator(){	

	f = new JFrame("Calculator");

	label = new JLabel();

	fo = new Font("Arial" , 1 , 24);	

	mb = new JMenuBar();

//-----------------------------------------------------------------------

//Menu 

	view = new JMenu("View");

	edit = new JMenu("Edit");

	help = new JMenu("Help");

	Worksheets = new JMenu("Worksheets");

//-----------------------------------------------------------------------

//MenuItems for View

	standard = new JMenuItem("Standard");

	scientific = new JMenuItem("Scientific");

	programmer = new JMenuItem("Programmer");

	statistics = new JMenuItem("Statistics");

	history = new JMenuItem("History");

	digitGrouping = new JMenuItem("Digit Grouping");

	basic = new JMenuItem("Basic");

	unitConversion = new JMenuItem("Unit Conversion");

	dateCalculation = new JMenuItem("Date Calculation");


	//Worksheets
		mortgage = new JMenuItem("Mortgage");
		vehicleLease = new JMenuItem("Vehicle Lease");
		fuelEconomy = new JMenuItem("Fuel economy (mpg)");
		FuelEconomy = new JMenuItem("Fuel economy (L/100 km)");

//MenuItems for Edit
	
	copy = new JMenuItem("Copy");

	paste = new JMenuItem("Paste");

	copyValue = new JMenuItem("Copy Value");

	copyAllValues = new JMenuItem("Copy All Values");

//MenuItems for Help

	viewHelp = new JMenuItem("View Help");

	aboutCalculator = new JMenuItem("About Calculator");
		
//--------------------------------------------------------------------------

//Adding MenuItems to Menu[View]	

	view.add(standard);

	view.add(scientific);

	view.add(programmer);

	view.add(statistics);

	view.add(new JSeparator());

	view.add(history);

	view.add(digitGrouping);

	view.add(new JSeparator());

	view.add(basic);

	view.add(unitConversion);

	view.add(dateCalculation);

	view.add(Worksheets);

	Worksheets.add(mortgage);
	
	Worksheets.add(vehicleLease);

	Worksheets.add(fuelEconomy);

	Worksheets.add(FuelEconomy);


//Edit Menu 
	
	edit.add(copy);
		
	edit.add(paste);

	edit.add(new JSeparator());

	edit.add(copyValue);

	edit.add(copyAllValues);

//Help Menu
	
	help.add(viewHelp);

	help.add(new JSeparator());

	help.add(aboutCalculator);

//---------------------------------------------------------------------------

//Adding Menu to the MenuBar

	mb.add(view);

	mb.add(edit);

	mb.add(help);

//---------------------------------------------------------------------------	

//Adding TextArea

	ta = new JTextArea();

	ta.setBounds(10,10,340,60);

	ta.setFont(fo);

//----------------------------------------------------------------------------

//Button's & Bounds

	  b1=new JButton("MC");
        b2=new JButton("MR");
        b3=new JButton("MS");
        b4=new JButton("M+");
        b5=new JButton("M-");
        b6=new JButton("<--");
        b7=new JButton("CE");
        b8=new JButton("C");
        b9=new JButton("+-");
        b10=new JButton("√");
        b11=new JButton("7");
        b12=new JButton("8");
        b13=new JButton("9");
        b14=new JButton("/");
        b15=new JButton("%");
        b16=new JButton("4");
        b17=new JButton("5");
        b18=new JButton("6");
        b19=new JButton("*");
        b20=new JButton("1/x");
        b21=new JButton("1");
        b22=new JButton("2");
        b23=new JButton("3");
        b24=new JButton("-");
        b25=new JButton("=");
        b26=new JButton("0");
        b27=new JButton(".");
        b28=new JButton("+");

	b8.addActionListener(this);
	b11.addActionListener(this);
	b12.addActionListener(this);
	b13.addActionListener(this);
	b14.addActionListener(this);
	b15.addActionListener(this);
	b16.addActionListener(this);
	b17.addActionListener(this);
	b18.addActionListener(this);
	b19.addActionListener(this);
	b21.addActionListener(this);
	b22.addActionListener(this);
	b23.addActionListener(this);
	b24.addActionListener(this);
	b25.addActionListener(this);
	b26.addActionListener(this);
	b27.addActionListener(this);
	b28.addActionListener(this);


	  label.setBounds(10 , 60 , 60 , 40);
   	  b1.setBounds(10,100,55,30);
        b2.setBounds(80,100,55,30);
        b3.setBounds(150,100,55,30);
        b4.setBounds(220,100,55,30);
        b5.setBounds(290,100,55,30);
        b6.setBounds(10,140,55,30);
        b7.setBounds(80,140,55,30);
        b8.setBounds(150,140,55,30);
        b9.setBounds(220,140,55,30);
        b10.setBounds(290,140,55,30);
        b11.setBounds(10,180,55,30);
        b12.setBounds(80,180,55,30);
        b13.setBounds(150,180,55,30);
        b14.setBounds(220,180,55,30);
        b15.setBounds(290,180,55,30);
        b16.setBounds(10,220,55,30);
        b17.setBounds(80,220,55,30);
        b18.setBounds(150,220,55,30);
        b19.setBounds(220,220,55,30);
        b20.setBounds(290,220,55,30);
        b21.setBounds(10,260,55,30);
        b22.setBounds(80,260,55,30);
        b23.setBounds(150,260,55,30);
        b24.setBounds(220,260,55,30);
        b25.setBounds(290,260,55,70);
        b26.setBounds(10,300,130,30);
        b27.setBounds(150,300,55,30);
        b28.setBounds(220,300,55,30);

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(b10);
        f.add(b11);
        f.add(b12);
        f.add(b13);
        f.add(b14);
        f.add(b15);
        f.add(b16);
        f.add(b17);
        f.add(b18);
        f.add(b19);
        f.add(b20);
        f.add(b21);
        f.add(b22);
        f.add(b23);
        f.add(b24);
        f.add(b25);
        f.add(b26);
        f.add(b27);
        f.add(b28);


//-----------------------------------------------------------------------------



//-----------------------------------------------------------------------------

//Frame Properties

	
	f.setLayout(null);

	 f.add(label);

	f.setJMenuBar(mb);

	f.add(ta);

	f.setVisible(true);

	f.setSize(375,400);

	f.setResizable(false);

	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


}



public static void main(String args[]){


	Calculator c = new Calculator();


}


//actionPerformed methods

	public void actionPerformed(ActionEvent e)

	{

		if(e.getSource() == b11)
		{
			ta.setText(ta.getText()+"7");
		}
		
		else if(e.getSource() == b12)
		{
			ta.setText(ta.getText()+"8");
		}

		else if(e.getSource() == b13)
		{
			ta.setText(ta.getText()+"9");
		}

		else if(e.getSource() == b16)
		{
			ta.setText(ta.getText()+"4");
		}
		
		else if(e.getSource() == b17)
		{
			ta.setText(ta.getText()+"5");
		}
	
		else if(e.getSource() == b18)
		{
			ta.setText(ta.getText()+"6");
		}
		
		else if(e.getSource() == b19)
		{
			String str = ta.getText();
			num1 = Float.parseFloat(ta.getText());
			operator = "*";
			ta.setText("");
			label.setText(str+" * ");
		}

		else if(e.getSource() == b21)
		{
			ta.setText(ta.getText()+"1");
		}

		else if(e.getSource() == b22)
		{
			ta.setText(ta.getText()+"2");
		}

		else if(e.getSource() == b23)
		{
			ta.setText(ta.getText()+"3");
		}

		else if(e.getSource() == b24)
		{
			String str = ta.getText();
			num1 = Float.parseFloat(ta.getText());
			ta.setText("");
			operator="-";
			label.setText(str + " - ");
		}	

		else if(e.getSource() == b26)
		{
			ta.setText(ta.getText()+ "0");
		}

		else if(e.getSource() == b28)
		{
			String str = ta.getText();
			num1 = Float.parseFloat(ta.getText());
			ta.setText("");
			operator = "+";
			label.setText(str+" + ");
		}

		else if(e.getSource() == b15)
		{
			String str = ta.getText();
			num1 = Float.parseFloat(ta.getText());
			ta.setText("");
			operator = "%";
			label.setText(str +" % ");
		}

		else if(e.getSource() == b14)
		{
			String str = ta.getText();
			num1 = Float.parseFloat(ta.getText());
			ta.setText("");
			operator = "/";
			label.setText(str + " / ");
		}	
		else if(e.getSource() == b8)
		{
			ta.setText("0");
		}
		
		else if(e.getSource() == b27)
		{
			ta.setText(ta.getText() + ".");
		}

		else if(e.getSource() == b25)
		{
			num2 = Float.parseFloat(ta.getText());


			if(operator == "+")
			{
				result =num1 +num2;
			}
	
			if(operator == "-")
			{
				result = num1 - num2;
			}
			
			if(operator == "*")
			{
				result = num1 * num2;
			}

			if(operator == "/")
			{
				result = (num1) / (num2);
			}

			if(operator == "%")
			{
				result = num1 % num2;
			}
			
			label.setText("");
			ta.setText(num1+" "+operator+" "+num2 +" = "+result);

			operator = null;
		}

	}
}