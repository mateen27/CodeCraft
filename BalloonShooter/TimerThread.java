import java.awt.*;
import javax.swing.*;
class TimerThread extends Thread{

	public void run(){

		
		for(int i = 60 ; i >= 0 ; i--){
			
			try{
				Game.timer.setText(""+i);
				Thread.sleep(1000);
				if(i == 0){
					Game.f.dispose();
				}
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null , "Error");
			}
		}
	}
}