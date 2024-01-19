import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This heart can be regained through witch's healing
 * 
 * @author Jim
 * @version v1
 */
public class SecondHeart extends Actor
{
    /**
     * Act - do whatever the SecondHeart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SecondHeart()
    {
        GreenfootImage hrt = new GreenfootImage("pixel_heart.png");
        hrt.scale(75, 75);
        setImage(hrt);
    }

    public void act()
    {
        // Add your action code here.
    }
}
