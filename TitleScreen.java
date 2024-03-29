import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Intro screen to the game
 * 
 * @author Jim
 * @version 12/12/23
 */
public class TitleScreen extends World
{
    GreenfootSound introMus = new GreenfootSound("frank.mp3");
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        prepare();
        GameWorld.score = 0;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     * Added title and user keys/instructions
     */
    private void prepare()
    {
        Label label = new Label("Anesthesia", 110);
        addObject(label,300,160);
        
        Label label2 = new Label("Click to start!", 50);
        addObject(label2,300,260);
        
        Label label3 = new Label("Use arrow keys for movement", 28);
        addObject(label3,180,345);
        
        Label label4 = new Label("Click to heal, max 3 heals", 28);
        addObject(label4,170,375);
        introMus.play();
    }
    
    public void act()
    {
        //Click to start game
        if(Greenfoot.mouseClicked(null))
        {
            GameWorld world = new GameWorld();
            Greenfoot.setWorld(world);
            introMus.stop();
        }
        
    }
    
    
}
