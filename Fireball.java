import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Actor
{
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] fire = new GreenfootImage[8];
    SimpleTimer animationTimer = new SimpleTimer();
    public Fireball()
    {
        for (int i = 0; i < fire.length; i++)
        {
            fire[i] = new GreenfootImage("tile00" + i +".png");
        }
        animationTimer.mark();

    }

    public void act()
    {
        // Add your action code here.
        int spd = 3;
        GameWorld world = (GameWorld) getWorld();
        setLocation(getX(), getY()+spd);
        animateFireball();
        
        if(GameWorld.score >= 5 && GameWorld.score < 10)
        {
            spd = 4;
            GameWorld.plSpd = 3;
        }
        if(GameWorld.score >= 10 && GameWorld.score < 15)
        {
            spd = 5;
            GameWorld.plSpd = 4;
        }
        if(GameWorld.score >= 15 && GameWorld.score < 20)
        {
            spd = 6;
        }
        if(GameWorld.score >= 30 && GameWorld.score < 40)
        {
            spd = 7;
            GameWorld.plSpd = 5;
        }
        if(GameWorld.score >= 40 && GameWorld.score < 50)
        {
            spd = 8;
            GameWorld.plSpd = 5;
        }
        if(GameWorld.score >= 50 && GameWorld.score < 75)
        {
            spd = 9;
            GameWorld.plSpd = 6;
        }
        if(GameWorld.score >= 75)
        {
            spd = 10;
        }
        if(getY() == 252 && getWorld().numberOfObjects() < GameWorld.maxFireballs)
        {
            ((GameWorld) getWorld()).spawnFire();
            ((GameWorld) getWorld()).increaseScore();
        }
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    int imageIndex = 0;
    public void animateFireball()
    {
        if (animationTimer.millisElapsed() < 80)
        {
            return;
        }
        animationTimer.mark();
        setImage(fire[imageIndex]);  
        imageIndex = (imageIndex + 1) % fire.length;

    }
}
