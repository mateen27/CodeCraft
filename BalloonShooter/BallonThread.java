import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BallonThread extends Thread{

	public void run(){

		while(true){

			try{

				int x = Game.ballon.getX();
				if(x > 500)
					x = 10;
				else
				x+=4;
				Game.ballon.setBounds(x , 10 , 40, 35);
				Thread.sleep(20);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null , "Error");

			}
		}
	}
}