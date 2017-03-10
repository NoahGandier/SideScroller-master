import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private int imageCounter = 3; 

    /**
     * Enemy will cunstuct an Enemy to scale 
     * @param There is no paramters
     * @return Enemey(goomba) is returned 
     */
    public Enemy()
    {
        getImage().scale(25, 25);

    }

    /**
     * act handles the actions must be taken everytime the program is run 
     * @param There is no paramters
     * @return Nothing is returned 
     */
    public void act() 
    {
        move(-2); //Will move 2 pixels at a time left

        GreenfootImage enemy = new GreenfootImage("Goomba.png"); 
        if(imageCounter >= 3)
        {
            enemy.mirrorHorizontally();
            imageCounter = 0;
        }
        else
        {
            imageCounter ++;  
        }

        //Will remove the Enemy once it reaches the end of the map on the left
        if(getX() <= 0)
        {
            getWorld().removeObject(this);
        }

    }    
}
