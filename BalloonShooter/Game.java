import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
class Game{
		static JFrame f;
		static JLabel ballon;
		static JLabel ballonBurst;
		static JButton arrowUp;
		static JLabel arrow;
		static JLabel Bullet;
		static JLabel Timer;
		static JLabel timer;
		static JLabel Score;
		static JLabel score;
		static JLabel HighScore;
		static JLabel highScore;
		static Container c;
		static ImageIcon icon;
		static int scoreEarned = 0;
	Game() throws IOException{
			
		f = new JFrame("Game");

		//Background Color
		c = f.getContentPane();
		c.setBackground(Color.BLACK);

		//Adding Image to the Label
//------------------------------------------------------
			//Ballon 
				icon = new ImageIcon("ballon.png");
				ballon = new JLabel(icon);
				ballon.setBounds(10 , 10 , 40, 35);
				f.add(ballon);
//------------------------------------------------------
			//ArrowUP
				icon = new ImageIcon("arrowup.png");
				arrowUp = new JButton(icon);
				arrowUp.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e){
						ArrowThread at = new ArrowThread();
						at.start();
					}
				});
				arrowUp.setBounds(205 , 390 , 40 , 35);
				arrowUp.setFocusable(false);
				f.add(arrowUp);
//------------------------------------------------------
			//Score
				Score = new JLabel("Score: ");
				Score.setForeground(Color.white);
				Font fontScore = new Font("Arial" , 3 , 15);
				Score.setFont(fontScore);
				Score.setBounds(20 , 350 , 80 , 50);
				f.add(Score);
			//score
				score = new JLabel("0");
				score.setForeground(Color.white);
				score.setBounds(75 , 350 , 30 , 50);
				f.add(score);
//------------------------------------------------------
			//HighScore
				HighScore = new JLabel("High-Score: ");
				HighScore.setForeground(Color.white);
				//Font fontScore = new Font(Color.white);
				HighScore.setFont(fontScore);
				HighScore.setBounds(20 , 390 , 130 , 50);
				f.add(HighScore);
			//highScore
				highScore = new JLabel("0");
				highScore.setForeground(Color.white);
				highScore.setBounds(115 , 390 , 30 , 50);
				f.add(highScore);
//------------------------------------------------------
			//Timer
				Timer = new JLabel("Timer: ");
				Timer.setForeground(Color.white);
				Timer.setFont(fontScore);
				Timer.setBounds(340 , 390 , 80 , 50);
				f.add(Timer);

			//timer
				timer = new JLabel("60");
				timer.setForeground(Color.white);
				timer.setBounds(400 , 390 , 20 , 50);
				f.add(timer);
//--------------------------------------------------------
		//Frame Properties
		ImageIcon icon0 = new ImageIcon("icon.png");
		f.setIconImage(icon0.getImage());
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(500 , 500);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Threads
				BallonThread bt=new BallonThread();
				bt.start();

				TimerThread tt = new TimerThread();
				tt.start();

				//BallonBurst bb = new BallonBurst();
				//bb.start();
				
	}
	
		public static void main(String args[]) throws IOException{

			Game g = new Game();

		}
}