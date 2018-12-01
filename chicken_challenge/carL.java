import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class carL extends Actor
{
    /**
     * Act - do whatever the car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img1 = new GreenfootImage("Car1.png");
    GreenfootImage img2 = new GreenfootImage("Car2.png");
    GreenfootImage img3 = new GreenfootImage("Car3.png");
       
    public carL()
    {
        randomCar();
    }
    
    
    public void act() 
    {               
        driveLeft();
    }    
    
    
    public void driveLeft()
    {
        move(-2);          
        if (isAtEdge()) 
        {
            getWorld().removeObject(this);
        }        
    }
    
    public void randomCar()
    {
        int x = Greenfoot.getRandomNumber(3) + 1;         
        if (x == 1)
        {
            setImage(img1);
        }
        
        if (x == 2)
        {
            setImage(img2);
        }
        
        if (x == 3)
        {
            setImage(img3);
        }       
    }
}