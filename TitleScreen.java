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
        Label label = new Label("Anesthesia", 110);
        addObject(label,300,160);
        
        Label label2 = new Label("Click to start!", 50);
        addObject(label2,300,260);
        
        Label label3 = new Label("Use arrow keys for movement", 28);
        addObject(label3,180,345);
        
        Label label4 = new Label("Click to heal, only twice", 28);
        addObject(label4,170,375);
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
