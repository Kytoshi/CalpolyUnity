import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PhysicsActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhysicsActor extends Actor
{
    public static final float GRAVITY = -0.25f;
    protected Vec2D velocity;
    protected boolean isGrounded;
     public PhysicsActor()
    {
        super();
        velocity = new Vec2D(0,0);
        isGrounded = false;
    }
    
    /**
     * Act - do whatever the PhysicsActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        int newXPos, newYPos, oldXPos, oldYPos;
        // Save your old position now
        
        //Move velocity by acceleration every frame
        velocity.y += -GRAVITY;
        //Move position by velocity every frame
        newXPos = (int)(getX() + velocity.x + 0.5f);
        newYPos = (int)(getY() + velocity.y + 0.5f);
        setLocation(newXPos, newYPos);
    }
}
