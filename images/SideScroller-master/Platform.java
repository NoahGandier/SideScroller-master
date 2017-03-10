import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{

    public Platform()
    {
        getImage().scale(100, 16);
    }
    
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add code to move platforms if right key is pressed
        if( Greenfoot.isKeyDown("right") )
       { 
           move(-1); 
       } 
        
        // Add code to remove platforms if it's x coordinate is < 0
      
       if(getX() < 0)
       {
          getWorld().removeObject(this);
       }    
    }
}
