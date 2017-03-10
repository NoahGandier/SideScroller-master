import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{

    /**
     * Platform will scale the image and display a picture for the class
     * @param There is no paramters
     * @return a platform is returned 
     */
    public Platform()
    {
        getImage().scale(100, 16);

    }

    /**
     * act handles the actions must be taken everytime the program is run 
     * @param There is no paramters
     * @return Nothing is returned 
     */
    public void act() 
    {
        if( Greenfoot.isKeyDown("right") )
        { 
            move(-1); 
        } 

        if(getX() < 0)
        {
            getWorld().removeObject(this);
        }

    }
}
