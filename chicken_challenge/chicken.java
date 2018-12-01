import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

/**
 * Write a description of class chicken here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class chicken extends Actor
{
    /**
     * Act - do whatever the chicken wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

   GreenfootImage splat = new GreenfootImage("Splat.png");
   GreenfootImage chickenImg = new GreenfootImage("ChickGray.png");

   private Boolean isSplattered = false;
   private Date splatterTime;

    public void act()
    {
        // Add your action code here.
        keyCheck();
        collisionCheck();
        splatterCheck();
    }

    public void keyCheck()
    {
      if (!isSplattered) {
        if (Greenfoot.isKeyDown("up")) {
          road myRoad = (road)getWorld();
          setLocation(getX(), getY() - 4);
          myRoad.increaseScore(10);
        }
        if (Greenfoot.isKeyDown("down"))
        {
          setLocation(getX(), getY() + 4);
        }
        if (Greenfoot.isKeyDown("right"))
        {
          setLocation(getX()+4, getY());
        }
        if (Greenfoot.isKeyDown("left"))
        {
          setLocation(getX()-4, getY());
        }
      }
    }

    public void collisionCheck()
    {
      if (isTouching(carL.class) || isTouching(carR.class)) {
        splatter();
      }
      // add egg collision detection to increase score
    }

    public void splatterCheck()
    {
      if (isSplattered) {
        Date currentTime = new Date();
        int difference = (int) (currentTime.getTime() - splatterTime.getTime()) / 1000;
        if (difference > 1) {
          regenerate();
        }
      }
    }

    public void splatter()
    {
      splatterTime = new Date();
      isSplattered = true;
      setImage(splat);
      // myRoad.splatteredChicken();
    }

    public void regenerate()
    {
      setImage(chickenImg);
      setLocation(500, 470);
      isSplattered = false;
    }
}
