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

   private Boolean isSplattered = false;

    public void act()
    {
        // Add your action code here.
        keyCheck();
        collisionCheck();
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

    public void splatter()
    {
      isSplattered = true;
      setImage(splat);
      setLocation(500, 470);
      // myRoad.splatteredChicken();
    }
}
