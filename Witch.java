import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Our protagonist, the Witch!
 * 
 * @author Jim
 * @version 12/12/23
 */
public class Witch extends Actor
{
    /**
     * Act - do whatever the Witch wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] idle = new GreenfootImage[4];
    GreenfootImage[] left = new GreenfootImage[4];
    GreenfootImage[] right = new GreenfootImage[4];
    GreenfootImage[] up = new GreenfootImage[4];
    GreenfootImage[] down = new GreenfootImage[4];

    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    public Witch()
    {
        for (int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("0"+ i + "_lown" + ".png");
            
        }
        
        for (int i = 0; i < left.length; i++)
        {
            left[i] = new GreenfootImage("0"+ (i+4) + "_lown" + ".png"); 
        }
        
        animationTimer.mark();
        setImage(idle[0]);
    }
    
     public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            facing = "left";
            move(-2);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            facing = "right";
        }
        
        animateWitch();
    }
    int imageIndex = 0;
    public void animateWitch()
    {
        if (animationTimer.millisElapsed() < 200)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("left"))
        {
            setImage(left[imageIndex]);  
            imageIndex = (imageIndex + 1) % left.length;
        }
        else
        {
            setImage(idle[imageIndex]);  
            imageIndex = (imageIndex + 1) % idle.length;
        }

    }
}


