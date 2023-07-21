package snakegame;

//importing java Swing package
import javax.swing.*;
//importing java AWT package
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener{  //panel is basically like a div which holds some area inside of the JFrame
    
    //initializing all the dots
    private final int ALL_DOTS = 2500;
    //giving the dot size
    private final int DOT_SIZE = 10;
    
    private final int RANDOM_POSITION = 29;
    
    //apple's variables (used for its coordinates)
    private int apple_x;
    private int apple_y;
    
    private Timer timer;
    
    //creating the array for the dots [how much dots can come on a frame]
    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];
    
    //direction variable's
    private boolean leftDirection = false;
    private boolean rightDirection = true;  //because it will move in the right direction
    private boolean upDirection = false;
    private boolean downDirection = false;
    
    //present in game or not
    private boolean inGame = true;
    
    //game variable's
    private int dots;
    
    //globally declaring Image Variables
    Image seb , sar , jism;
    
    Board(){
        addKeyListener(new TAdapter());
        
        //setting the Panel or board bgColor using the rgb value
        setBackground(new Color(28 , 33 , 48));
        //enabling the focus on the JPanel
        setFocusable(true);
        
        //setting the size of the FRAME
        setPreferredSize(new Dimension(500 , 500));
        
        //loading the images before initializing the game
        loadImages();
        //initializing the game by calling its function
        initGame();
    }
    
    //image loading function
    public void loadImages(){
        
        //apple image
        ImageIcon apple = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/apple.png"));
        seb = apple.getImage();
        
        //head of snake image
        ImageIcon snakeHead = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/dooot.png"));
        sar = snakeHead.getImage();
        
        //snake body image
        ImageIcon snakeBody = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/dot.png"));
        jism = snakeBody.getImage();
    }
    
    //game's function
    public void initGame(){
        dots = 3;   //length of the snake (first stage) head and rest of the body
        
        for(int i = 0 ; i < dots ; i++){
            y[i] = 50;  //position from y axis from top on the board of the snake
            
            x[i] = 50 - (i * DOT_SIZE);//position from x axis from left on the board of the snake
        }
        
        locateApple();
        
        timer = new Timer(140 , this);
        timer.start();
    }
    
    //function for giving random position to the APPLE
    public void locateApple(){
        int r = (int)(Math.random() * RANDOM_POSITION);
        apple_x = r * DOT_SIZE;
        
        r = (int)(Math.random() * RANDOM_POSITION);
        apple_y = r * DOT_SIZE;
    }
    
    //graphics class method to display the image on the board
    public void paintComponent(Graphics g){
        //calls parent paint component
        super.paintComponent(g);
        
        draw(g);    //will draw the image on the board
    }
    
    //function for drawing apple image
    public void draw(Graphics g){
        if(inGame){
            g.drawImage(seb , apple_x , apple_y , this);

            for(int i = 0 ; i < dots ; i++){
                //will hold the snake's head in the 0 position
                if(i == 0){
                    g.drawImage(sar, x[i], y[i], this);
                }
                else {
                    g.drawImage(jism, x[i], y[i], this);
                }
            }

    //        initializing with the default toolkit
            Toolkit.getDefaultToolkit().sync(); //so that it gets initialized
        }
        else{
            gameOver(g);
        }
    }
    
    //function for drawing gameOver 
    public void gameOver(Graphics g){
        String msg = "Game Over";
        //Giving the Font as the metrices is inside the FONT METRICE
        Font font = new Font("SAN_SERIF" , Font.BOLD , 14);
        FontMetrics metrices = getFontMetrics(font);
        
        //font Color of the GAME OVER
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(msg, (500 - metrices.stringWidth(msg)) / 2, 500/2);
    }
    
    public void move(){
        //moving the body of the snake to the position of the snake's head pos
        for(int i = dots ; i > 0 ; i--){
            x[i] = x[i - 1];
            y[i] = y[i-1];
        }
        
        //on the left direction 
        if(leftDirection){
            x[0] = x[0] - DOT_SIZE;
        }
        //on the right direction 
        if(rightDirection){
            x[0] = x[0] + DOT_SIZE;
        }
        //on the up direction 
        if(upDirection){
            y[0] = y[0] - DOT_SIZE;
        }
        //on the down direction 
        if(downDirection){
            y[0] = y[0] + DOT_SIZE;
        }
    }
    
    //functon checking if the apple and snake coordination meets at the same place
    public void checkApple(){
        if((x[0] == apple_x) && (y[0] == apple_y)){
            //body will be increased
            dots++;
            //want a new apple at new location  (to generate the new location of apple we have a method named locateApple)
            locateApple();
        }
    }
    
    //method which will check for the collision of the snake
    public void checkCollision(){
        //checking if the snake collides by itself
        for(int k = dots ; k > 0 ; k--){
            if((k > 4) && (x[0] == x[k]) && (y[0] == y[k])){
                inGame = false;
            }
        }
        
        //checking if the snake collides by the edge of the frame
        if(y[0] >= 500){
            inGame = false;
        }
        if(y[0] < 0){
            inGame = false;
        }
        if(x[0] >= 500){
            inGame = false;
        }
        if(x[0] <  0){
            inGame = false;
        }
        
        //since snake is moving because of timer need to stop the timer
        if (!inGame){
            timer.stop();
        }
    }
    
    //ActionListener method
    public void actionPerformed(ActionEvent e){
        if(inGame){
            //method for checking if the apple and snake is on the same coordinates
            checkApple();

            //method which will check for the collision
            checkCollision();

            //method to move the snake
            move();
        }
        repaint();//method to refresh the screen same as the pack method
    }
    
    public class TAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            
            if(key == KeyEvent.VK_LEFT && (!rightDirection)){
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }
            
            if(key == KeyEvent.VK_RIGHT && (!leftDirection)){
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }
            
            if(key == KeyEvent.VK_UP && (!downDirection)){
                upDirection = true;
                leftDirection = false;
                rightDirection = false;
            }
            
            if(key == KeyEvent.VK_DOWN && (!upDirection)){
                downDirection = true;
                leftDirection = false;
                rightDirection = false;
            }
        }
    }
}
