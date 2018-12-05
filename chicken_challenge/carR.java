import greenfoot.*;

/**
 * Renders a car travelling from right to left
 * across the road
 * @author Matt Schroyer, Elizabeth Haase
 * @version 0.1
 */
public class carR extends Actor
{

    GreenfootImage img1 = new GreenfootImage("Car1Right.png");
    GreenfootImage img2 = new GreenfootImage("Car2Right.png");
    GreenfootImage img3 = new GreenfootImage("Car3Right.png");

    public carR()
    {
        randomCar();
    }

    public void act()
    {
        if(isTouching(carR.class))
        {
            removeTouching(carR.class);           
        }
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
