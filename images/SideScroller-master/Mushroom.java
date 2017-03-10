import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mushroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mushroom extends Actor
{
    private int imageCounter = 3;
    private GreenfootImage mushroom = new GreenfootImage("Mushroom.png");
    
    // Add Enemy constructor here to scale the image for the Enemy
    
    public Mushroom()
    {
        mushroom.scale(25, 25);
        setImage(mushroom);
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add code to have enemy move left here
            move(-2); 
       
        
        /**
         * Check if imageCounter is >= 3. If so, mirror the image horizontally and
         * set imageCounter to 0. Otherwise, increase the imageCounter by 1.
         */
         
       if(imageCounter >= 1)
       {
           mushroom.mirrorHorizontally();
           imageCounter = 0;
       }
       else
       {
           imageCounter ++;  
       }
        

       if(getX() <= 0)
       {
          getWorld().removeObject(this);
       }    
    }    
}
