import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Intro screen to the game
 * 
 * @author Jim
 * @version 12/12/23
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Witch witch = new Witch();
        addObject(witch,370,280);

        Label label = new Label("Anesthesia", 110);
        addObject(label,270,105);
        
        
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(null))
        {
            GameWorld world = new GameWorld();
            Greenfoot.setWorld(world);
        }
    }
}
