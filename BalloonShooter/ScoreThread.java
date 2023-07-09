import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class ScoreThread extends Thread{

	public void run(){

		for(int i = 10 ; i <= 600 ; i+=10){
			
			try{
				if(Game.ballon.getX()>=210 && Game.ballon.getX()<=230 && arrow.getY()>=10 && arrow.getY()<=30){
			
				Game.score.setText(""+i);
				Thread.sleep(100);
				}
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null , "Error");
				
			}
		}
	}
}