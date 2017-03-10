import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    //Add GreenfootImage variables for original image and jumping image here
    private GreenfootImage original = new GreenfootImage( "Hero.png" );
    private GreenfootImage jumping = new GreenfootImage( "Hero_Jumping.png" );
    private GreenfootImage bigMario =  new GreenfootImage( "Hero.png" );
    private GreenfootImage bigjump = new GreenfootImage( "Hero_Jumping.png" );
    private int marioSz = 1;
    
    //Add the following variables here: y, ySpeed, smallUp, up, cannotJump, and lookingRight
    private int y = 0;
    private int ySpeed = 1;
    private int smallUp = -9;
    private int up = -15;
    private boolean cannotJump = false;
    private boolean lookingRight = true;
    
    /**
     * Create constructor to scale the original and jumping images, mirror the 
     * original image horizontally, and set the image of the hero to the original
     * variable
     */
    
    public Hero()
    {
       original.scale(30, 30);
       jumping.scale(32, 32);
       original.mirrorHorizontally();
       setImage(original);
       bigMario.scale(40,40);
       jumping.scale(42, 42);
    }
    

    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add method call to movement method here
        movement();
        
        //Add method call to checkCollision here
        checkCollision();
    }
    
    /**
     * Add movement method here that will handle the movement right, left, and up
     * for the Hero
     */
    private void movement()
    {
        if( Greenfoot.isKeyDown("right") )
        { 
            if (lookingRight == false)
            {
                original.mirrorHorizontally();
                jumping.mirrorHorizontally();
            }
            lookingRight = true; 
            setLocation( getX()+3, getY() );           
        }
        if( Greenfoot.isKeyDown("left") )
        { 
            if (lookingRight == true)
            {
                original.mirrorHorizontally(); 
                jumping.mirrorHorizontally();
            }
            lookingRight = false; 
            setLocation( getX()-3, getY() );           
        }
        if( Greenfoot.isKeyDown("up") )
        { 
            if (cannotJump == false)
            {
             if(marioSz == 1)
             {
                 setImage(jumping);
             }
             else
             {
                 setImage(bigjump);
             }
             y = up;
             fall();
            }
        }
        if( getY() >= 360 )
        { 
            setLocation( getX(), 370 );
            y = 0; 
        }        
    }
    
    // Add fall method here to handle the Hero's jumping and falling movement
    private void fall()
    {
        cannotJump = true;
        setLocation( getX(), getY()+y ); 
        y = y + ySpeed;
    }
    
    /**
     * Add checkCollision method here that will check if we've landed on the top
     * of an Enemy, which will increase the score; touched an Enemy otherwise, which
     * will have us lose the game; touched a platform which will allow us to jump again;
     * or fall
     */
    private void checkCollision()
    {
        ScrollerWorld myWorld = (ScrollerWorld)getWorld();

        if(getOneObjectAtOffset(0, getImage().getHeight()-15, Enemy.class) != null)
        {
             getWorld().removeObject(getOneObjectAtOffset(0, getImage().getHeight()-15, Enemy.class));
             myWorld.addToScore(); 
             y = smallUp;
             fall();
        }
        else if(isTouching(Enemy.class))
        {
             myWorld.gameOver();
        }
        else if(isTouching(Mushroom.class))
        {
             setImage(bigMario);
             marioSz = 2;
        }
        else if(getOneObjectAtOffset(0, getImage().getHeight()-15, Platform.class) != null)
        {
             if(marioSz == 2)
             {
                 setImage(bigMario);
             }
             else
             {
                 setImage(original);
             }
             cannotJump = false;
             y = 0;
        }
        else
        {
            fall();
        }
       }
       
}
//if(marioSize == 2)
        //{
           // if( isTouching(Enemy.class) )
           // {
            //    marioSize = 1;
            //    setImage(original);
           // }
        //}
      //  else if(marioSize == 1)
       // {
        //   if( isTouching(Enemy.class))
        //   {
        //       myWorld.ga
        //   }}
      // }
       // else if(marioSize == 1)
       // {
         //   if( isTouching(Mushroom.class))
          //  marioSize = 2;
           // setImage(bigMario)