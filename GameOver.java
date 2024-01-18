import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gameover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class Gameover.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        
    }
    
    private void prepare()
    {
        int sc = GameWorld.score;
        Label label = new Label("Game over", 110);
        addObject(label,300,150);
        Label label2 = new Label("Score: " + sc, 80);
        addObject(label2,300,250);
        GameWorld.maxFireballs = 10;
        GameWorld.maxHearts = 5;
        GameWorld.lastHeart = 2;
        GameWorld.score = 0;
        GameWorld.plSpd = 2;
        GameWorld.healCount = 3;
    }
}
