import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author Jim Luo
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    public static int maxFireballs = 10;
    public static int maxHearts = 2;
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

        spawnFire();
        Heart heart = new Heart();
        addObject(heart,50, 50);
        SecondHeart heart2 = new SecondHeart();
        addObject(heart2,125, 50);
    }

    public void act()
    {

    }

    public void spawnFire()
    {
        int x = Greenfoot.getRandomNumber(800);
        Fireball fire = new Fireball();
        addObject(fire, x + 200, 0);

    }

}
