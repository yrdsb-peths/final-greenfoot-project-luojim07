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
    
    public Witch()
    {
        GreenfootImage img = new GreenfootImage("pixel_witch_nobg.png");
        img.scale(150, 200);
        setImage(img);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
