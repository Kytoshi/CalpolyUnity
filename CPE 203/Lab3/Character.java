import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends PhysicsActor
{
    protected Vec2D velocity;
    private int JUMP_POWER = 7;
    private boolean activeMovement;
    
    public Character()
    {
        super();
    }
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
        move();
    }
    public void move()
    {
        if(Greenfoot.isKeyDown("a"))
        {   
            activeMovement = true;
            //flippedOrientation();
            velocity.x = -3;
        }
        if(Greenfoot.isKeyDown("d"))
        {
            activeMovement = true;
            //defaultOrientation();
            velocity.x = 3;
        }
        if(Greenfoot.isKeyDown("space") && isGrounded)
        {
            activeMovement = true;
            setLocation(getX(), getY() - 3);
            isGrounded = false;
            velocity.y = -JUMP_POWER;
        }
     
        //setLocation(x,y);
    }
    private void Jump() 
    {
        if(Greenfoot.isKeyDown("space") && isGrounded)
        {
            setLocation(getX(), getY() - 3);
            isGrounded = false;
        }
    }
}
