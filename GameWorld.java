import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{

    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1); 
        GreenfootImage img = new GreenfootImage("forest_bg.png");
        img.scale(1000, 400);
        setBackground(img);
        
        Witch witch = new Witch();
        addObject(witch,750,310);
        
        Heart heart1 = new Heart();
        addObject(heart1,50, 50);
        Heart heart2 = new Heart();
        addObject(heart2,125, 50);
        Heart heart3 = new Heart();
        addObject(heart3,200, 50);
    }
    
    public void act()
    {
        
    }
    
}
