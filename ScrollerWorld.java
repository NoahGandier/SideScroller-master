import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Omar Nakhleh) 
 * @version (a version number or a date)
 */
public class ScrollerWorld extends World
{
    //Add platformCounter and score variables here

    private int platformCounter = 25;
    private int score = 0;
    private int live = 1;

    /**
     * Constructor for objects of class ScrollerWorld.
     * 
     */
    public ScrollerWorld()
    {    
        super(600, 400, 1);

        prepareWorld();

        displayScore();
        displayLives();
    }

    /**
     * prepareWorld adds objects to world to prepare the game for use
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void prepareWorld()
    {
        for( int i = 0; i <= getWidth()/50; i++ )
        {
            addObject(new Platform(), i*50, getHeight() - 8);
        }

        addObject(new Hero(), 30, getHeight() - 30);

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
            if( platformCounter >= 25 )
            {
                platformCounter = 0;
                addObject(new Platform(), getWidth()-25, getHeight()-8 );
            }

            platformCounter ++; 

        } 

        if(Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Enemy(), 559, getHeight() - 27);
        }

        if(Greenfoot.getRandomNumber(600) < 1)
        {
            addObject(new Mushroom(), 559, getHeight() - 27);
        }

        if(Greenfoot.getRandomNumber(550) < 1)
        {
            addObject(new Block(), 559, getHeight() - 100);
        }

        displayScore();
        displayLives(); 

    }   

    /**
     * gameOver display a message along with the score and stop the prgram from running  
     * @param There is no paramters
     * @return Nothing is returned 
     */    
    public void gameOver()
    {
        showText("You have been defeated! Score:" + score,getWidth()/2, getHeight()/2);
        Greenfoot.stop();

    }

    /**
     * displayScore will display the score at the given x and y coordinate
     * @param There is no paramters
     * @return Nothing is returned 
     */    
    public void displayScore()
    {
        showText("Scroe: " +score, 50, 25);

    }

    /**
     * displayLives will display the players lives at the given x and y coordinate
     * @param There is no paramters
     * @return Nothing is returned 
     */    
    public void displayLives()
    {
        showText("Lives: " +live, 540, 25);

    }

    /**
     * addToScore will increase the players score by a value of one
     * @param There is no paramters
     * @return Nothing is returned 
     */      
    public void addToScore()
    {
        score++;
        displayScore();

    }

    /**
     * addToLives will increase the players lives by a value of one
     * @param There is no paramters
     * @return Nothing is returned 
     */
    public void addToLives()
    {
        live++;
        displayLives();

    }

    /**
     * subtractToLives will decrease the players lives by a value of one
     * @param There is no paramters
     * @return Nothing is returned 
     */
    public void subtractToLives()
    {
        live--;
        displayLives();

    }    
}
