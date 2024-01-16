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

    String facing = "idle";
    SimpleTimer animationTimer = new SimpleTimer();
    public Witch()
    {
        for (int i = 0; i < down.length; i++)
        {
            down[i] = new GreenfootImage("0"+ i + "_lown" + ".png");
        }
        
        for (int i = 0; i < left.length; i++)
        {
            left[i] = new GreenfootImage("0"+ (i+4) + "_lown" + ".png"); 
        }
        
        for (int i = 0; i < right.length; i++)
        { 
            if(i>=2)
            {
                right[i] = new GreenfootImage((i+8) + "_lown" + ".png"); 
            }
            else
            {
                right[i] = new GreenfootImage("0"+ (i+8) + "_lown" + ".png");
            }
        }
        for (int i = 0; i < up.length; i++)
        {
            up[i] = new GreenfootImage((i+16) + "_lown" + ".png"); 
        }
        for (int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage((i+12) + "_lown" + ".png"); 
        }
        animationTimer.mark();
        setImage(idle[0]);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            facing = "left";
            if(getX() > 200)
            {
                move(-2);
            }
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            facing = "right";
            move(2);
        }
        else if(Greenfoot.isKeyDown("up"))
        {
            facing = "up";
            if(getY() > 250)
            {
                setLocation(getX(), getY()-2);
            }
            
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            facing = "down";
            if(getY() < 350)
            {
                setLocation(getX(), getY()+2);
            }
        }
        else if(Greenfoot.mouseClicked(null))
        {
            facing = "idle";
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
        else if(facing.equals("right"))
        {
            setImage(right[imageIndex]);  
            imageIndex = (imageIndex + 1) % right.length;
        }
        else if(facing.equals("up"))
        {
            setImage(up[imageIndex]);  
            imageIndex = (imageIndex + 1) % up.length;
        }
        else if(facing.equals("down"))
        {
            setImage(down[imageIndex]);  
            imageIndex = (imageIndex + 1) % down.length;
        }
        else
        {
            setImage(idle[imageIndex]);  
            imageIndex = (imageIndex + 1) % idle.length;
        }
    }
}


