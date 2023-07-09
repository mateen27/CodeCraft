import java.awt.*;
import javax.swing.*;
class ArrowThread extends Thread{
	JLabel arrow;
	JLabel burstBalloon;
	public void run(){
		Icon icon = new ImageIcon("arrow.png");
		arrow=new JLabel(icon);
	
		for(int i = 360 ; i >= -30 ; i-=10){

			try{
				arrow.setBounds(195,i,70,40);
				Game.f.add(arrow);
				Thread.sleep(20);
				if(Game.ballon.getX()>=210 && Game.ballon.getX()<=230 && arrow.getY()>=10 && arrow.getY()<=30){
					Game.f.remove(arrow);
					icon = new ImageIcon("ballonburst.png");
					burstBalloon = new JLabel(icon);
					burstBalloon.setBounds(Game.ballon.getX() , Game.ballon.getY() ,40 , 35);
					Game.f.remove(Game.ballon);
					Game.f.add(burstBalloon);
					Thread.sleep(700);
					Game.f.remove(burstBalloon);
					Game.ballon.setBounds(10,10,40,35);
					Game.scoreEarned+=10;
					Game.f.add(Game.ballon);
				}
					Game.score.setText(""+Game.scoreEarned);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null , "Error");
			}
		}
		Game.f.remove(arrow);
	}
}