import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Our protagonist, the Witch!
 * Arrow keys to move left right up down
 * Click to gain a heart when witch loses a heart
 * Max of three heart gains
 * Movement of speed may increase of decrease based on score
 * Movement of witch is restricted to x = 350-950 and y = 250-350
 * 
 * @author Jim
 * @version v1
 */
public class Witch extends Actor
{
    GreenfootSound witchHurt = new GreenfootSound("a.mp3");
    GreenfootSound healing = new GreenfootSound("healing.mp3");
    
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
            if(getX() > 350)
            {
                move(-GameWorld.plSpd);
            }
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            facing = "right";
            if(getX() < 950)
            {
                move(GameWorld.plSpd);
            }
        }
        else if(Greenfoot.isKeyDown("up"))
        {
            facing = "up";
            if(getY() > 250)
            {
                setLocation(getX(), getY()-GameWorld.plSpd);
            }

        }
        else if(Greenfoot.isKeyDown("down"))
        {
            facing = "down";
            if(getY() < 350)
            {
                setLocation(getX(), getY()+GameWorld.plSpd);
            }
        }
        else if(Greenfoot.mouseClicked(null))
        {
            facing = "idle";
            if(GameWorld.maxHearts > 0 && GameWorld.lastHeart < 2)
            {
                GameWorld.lastHeart++;
                if(GameWorld.lastHeart != 0 && GameWorld.healCount != 0)
                {
                    getWorld().addObject(new SecondHeart(), 125, 50);
                    healing.play();
                    GameWorld.healCount--;
                }
            }
        }
        
        animateWitch();
        damaged();
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

    public void damaged()
    {
        
        if(isTouching(Fireball.class))
        {
            removeTouching(Fireball.class);
            GameWorld world = (GameWorld) getWorld();
            world.spawnFire();
            getWorld().removeObjects(getWorld().getObjects(SecondHeart.class));
            GameWorld.maxHearts--;
            witchHurt.play();
            GameWorld.lastHeart--;
            
        }
        
    }

}

