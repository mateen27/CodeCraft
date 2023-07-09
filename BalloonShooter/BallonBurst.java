import java.awt.*;
import javax.swing.*;
class BallonBurst extends Thread{
	public void run(){

		try{
			if(Game.ballon.getX()==210 && Game.arrow.getY()==10){
				
				ImageIcon icon = new ImageIcon("ballonburst.png");
				Game.ballon = new JLabel(icon);
				Game.ballon.setBounds(10 , 10 ,40 , 35 );
				Game.f.add(Game.ballon);
				
			}
			Thread.sleep(20);
		}

		catch(Exception e){
			JOptionPane.showMessageDialog(null , "Error");
		}
	}
}