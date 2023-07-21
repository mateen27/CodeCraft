package snakegame;

//importing java swing package
import javax.swing.*;

public class SnakeGame extends JFrame{
    
    SnakeGame(){
        super("Snake Game");
        
        //calling another class i.e Board Class
        add(new Board());   //added to the JFrame   
        //used to refresh the panel so that changes can be visible to the visitor
        pack();
        
        //so that the board comes in the center of the image
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        new SnakeGame();
    }
    
}
