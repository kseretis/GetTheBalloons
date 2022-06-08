import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class created for the trophies with numbers as images
 * 
 * @author Seretis Kleanthis 
 * @version 2
 * @date 24/04/2022
 */
public class Trophy extends SmoothMover implements MovingObject{
    private static final String SUFFIX = ".png";
    private static final int SPEED = 1;
    private int movingCounter = 0;
    private MathModel problem;
    private int number;
    private GreenfootImage image;
    // Act
    public void act(){
        if(Level.getLevel() > Level.HEIGHT)
            randomMove(SPEED);
    }
    // Constructor
    public Trophy(MathModel problem, int number){
        this.problem = problem;
        this.number = number;
        image = new GreenfootImage(this.number + SUFFIX);
        setImage(image);
        getImage().scale(60, 60);
    }
    // Random move
    public void randomMove(int speed){
        if(movingCounter < 100)
            setLocation(getX() + speed, getY());
        else if(movingCounter < 200)
            setLocation(getX() - speed, getY());
        else
            movingCounter = 0;
        movingCounter++;
    }
    
    public boolean isTouchingSand(){
        return isTouching(Sand.class) ? true : false;
    }
    // Returns the image's number of the tropgy
    public int getNumber(){
        return number;
    }
    // Returns if hero is touching the correct trophy    
    public boolean isTheCorrectAnswer(int answer){
        return this.problem.getSolution() == answer ? true : false;
    }
    
    public void switchImage(){
    }
}
