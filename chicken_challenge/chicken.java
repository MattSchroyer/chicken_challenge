import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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

    public void act()
    {
        // Add your action code here.
        keyCheck();
        collisionCheck();
    }

    public void keyCheck()
    {
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

    public void collisionCheck()
    {
      if (isTouching(carL.class)) {
        setImage(splat);
        // myRoad.splatteredChicken
      }
      if (isTouching(carR.class)) {
        setImage(splat);
        // myRoad.splatteredChicken
      }
    }
}
