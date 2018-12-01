import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class car2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class carR extends Actor
{
    /**
     * Act - do whatever the carRight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img1 = new GreenfootImage("Car1Right.png");
    GreenfootImage img2 = new GreenfootImage("Car2Right.png");
    GreenfootImage img3 = new GreenfootImage("Car3Right.png");
    
    public carR()
    {
        randomCar();
    }
    
    public void act() 
    {
        driveRight();
    }    
    
    public void driveRight()
    {
        move(2);       
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
