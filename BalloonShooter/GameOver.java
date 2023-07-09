import java.awt.*;
import javax.swing.*;
class GameOver{

	public static void main(String args[]){

		JFrame f = new JFrame("Game Over");
		
		Container c = f.getContentPane();
		c.setBackground(Color.BLACK);
		ImageIcon icon3 = new ImageIcon("GameOver.png");
		JLabel label = new JLabel(icon3);
		label.setBounds(50, 30 , 200 , 200);
		f.add(label);

		//JLabel Score = new JLabel("Score: ");
		


		f.setVisible(true);
		f.setSize(600 , 400);
		//f.setDefaultCloseOeration(JFrame.EXIT_ON_CLOSE);


	}




}