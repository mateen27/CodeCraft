import java.awt.*;
import java.awt.event.*;
import java.sql.*; 
class db
{
Frame f;
TextField t1,t2,t3;
Button b1;
db()
{
//Title of the Frame
f=new Frame("Result Management System");
//below code if for the TextFields
t1=new TextField();
t2=new TextField();
t3=new TextField();
b1=new Button("Save");
b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
try
{
int rno=Integer.parseInt(t1.getText());
String name=t2.getText();
float marks=Float.parseFloat(t3.getText());

//load driver
Class.forName("com.mysql.cj.jdbc.Driver");
//establish connection
Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/resultmanagement?user=root&password=root");
//prepare query
String query="insert into students values(?,?,?)";
PreparedStatement st=cn.prepareStatement(query);
st.setInt(1,rno);
st.setString(2,name);
st.setFloat(3,marks);
//execute query
st.executeUpdate();
//close connection
cn.close();
javax.swing.JOptionPane.showMessageDialog(null,"Data Saved");
}
catch(Exception e1)
{
javax.swing.JOptionPane.showMessageDialog(null,e1.getMessage());
}
}
});
f.setLayout(new GridLayout(4,1));
f.add(t1);
f.add(t2);
f.add(t3);
f.add(b1);
f.setSize(400,400);
f.setVisible(true);
}
public static void main(String ar[])
{
db frame = new db();
}
}