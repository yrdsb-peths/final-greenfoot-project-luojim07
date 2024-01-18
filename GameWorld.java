import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author Jim Luo
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    GreenfootSound bgMusic = new GreenfootSound("21 Savage - nee nah (instrumental) ft. Travis Scott.mp3");
    public static int maxFireballs = 10;
    public static int maxHearts = 5;
    public static int lastHeart = 2;
    public static int score = 0;
    public static int plSpd = 2;

    Label scoreLabel;
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
        
        scoreLabel = new Label(0, 100);
        addObject(scoreLabel, 930, 50);

        spawnFire();
        Heart heart = new Heart();
        addObject(heart,50, 50);
        SecondHeart heart2 = new SecondHeart();
        addObject(heart2,125, 50);
    }

    public void act()
    {
        bgMusic.play();
        if(maxHearts == 0 || lastHeart == 0)
        {
            GameOver world = new GameOver();
            Greenfoot.setWorld(world);
            bgMusic.stop();
        }
    }

    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    public void spawnFire()
    {
        int x = Greenfoot.getRandomNumber(600);
        Fireball fire = new Fireball();
        addObject(fire, x + 350, 0);
        
        if(score >= 15 && Greenfoot.getRandomNumber(3) == 1)
        {
            Fireball fire2 = new Fireball();
            addObject(fire2, Greenfoot.getRandomNumber(600) + 350, 0);
        }
        if(score >= 30 && Greenfoot.getRandomNumber(2) == 1)
        {
            Fireball fire3 = new Fireball();
            addObject(fire3, Greenfoot.getRandomNumber(600) + 350, 0);
        }
        if(score >= 50 && Greenfoot.getRandomNumber(2) == 1)
        {
            Fireball fire4 = new Fireball();
            addObject(fire4, Greenfoot.getRandomNumber(600) + 350, 0);
        }
    }

}
