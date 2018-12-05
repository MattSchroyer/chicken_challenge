import greenfoot.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

/**
 * Renders a chicken that can be controlled by the player.
 * Chicken becomes "splattered" when it comes into contact with a car.
 * Splattering chicken removes control from player
 * and sends the chicken to the start line after a period of time.
 * @author Matt Schroyer, Elizabeth Haase
 * @version 0.1
 */
public class chicken extends Actor
{

   GreenfootImage splat = new GreenfootImage("Splat.png");
   GreenfootImage chickenImg = new GreenfootImage("ChickGray.png");

   private Boolean isSplattered = false;
   private Date splatterTime;

    public void act()
    {
        keyCheck();
        collisionCheck();
        splatterCheck();
        finishLineCheck();
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
        if (!isSplattered) {
          splatter();
        }
      }
      if (isTouching(egg.class)) {
        touchEgg();
      }
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

    public void finishLineCheck()
    {
      if (getY() < 10) {
        road myRoad = (road)getWorld();
        myRoad.increaseScore(50);
        myRoad.loseLife();
        regenerate();
      }
    }

    public void splatter()
    {
      splatterTime = new Date();
      isSplattered = true;
      setImage(splat);
      road myRoad = (road)getWorld();
      myRoad.loseLife();
    }

    public void touchEgg()
    {
      Actor myEgg = getOneIntersectingObject(egg.class);
      road myRoad = (road)getWorld();
      myRoad.increaseScore(500);
      myRoad.removeObject(myEgg);
    }

    public void regenerate()
    {
      setImage(chickenImg);
      setLocation(500, 470);
      isSplattered = false;
    }
}
