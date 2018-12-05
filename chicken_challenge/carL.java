import greenfoot.*;

/**
 * Renders a car travelling from left to right
 * across the road
 * @author Matt Schroyer, Elizabeth Haase
 * @version 0.1
 */
public class carL extends Actor
{

    GreenfootImage img1 = new GreenfootImage("Car1.png");
    GreenfootImage img2 = new GreenfootImage("Car2.png");
    GreenfootImage img3 = new GreenfootImage("Car3.png");

    public carL()
    {
        randomCar();
    }

    public void act()
    {
        if(isTouching(carL.class))
        {
            removeTouching(carL.class);           
        }
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
