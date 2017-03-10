import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    private GreenfootImage block = new GreenfootImage("block.png");

    public Block()
    {
        block.scale(25, 25);
        setImage(block);
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

        if(getX() <= 0)
        {
            getWorld().removeObject(this);
        }    
    }     
}
