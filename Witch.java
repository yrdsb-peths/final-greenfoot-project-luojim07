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
    GreenfootImage[] img = new GreenfootImage[4];
    SimpleTimer animationTimer = new SimpleTimer();
    public Witch()
    {
        for (int i = 0; i < img.length; i++)
        {
            img[i] = new GreenfootImage("0"+ i + "_lown" + ".png");
            setImage(img[i]);   
        }
    }
    
     public void act()
    {
        animateWitch();
    }
    int imageIndex = 0;
    public void animateWitch()
    {
        if (animationTimer.millisElapsed() < 300)
        {
            return;
        }


        setImage(img[imageIndex]);
        imageIndex = ((imageIndex + 1) % img.length);
        animationTimer.mark();
    }
}


