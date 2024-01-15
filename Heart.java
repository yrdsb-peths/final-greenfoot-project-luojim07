import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    /**
     * Act - do whatever the Heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Heart()
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
