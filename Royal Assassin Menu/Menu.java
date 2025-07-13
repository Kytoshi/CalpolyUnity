import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    /**
     * Act - do whatever the Menu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Menu(){
        super(1000,500,1);
        setBackground("StartScreen.png");
        GreenfootImage myImage = getBackground();
        int NewHeight = (int)myImage.getHeight();
        int NewWidth = (int)myImage.getWidth();
        myImage.scale(NewWidth, NewHeight);
    }
    public void act()
    {
        // Add your action code here.

    }
}
