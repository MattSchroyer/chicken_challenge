import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

/**
 * A road for chickens to cross.
 *
 * @author Matt Schroyer, Elizabeth Haase
 * @version 0.1
 */
public class road extends World
{
    private scoreBoard Score;
    private Date startTime;
    /**
     * Constructor for objects of class road.
     *
     */
    public road()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        Score = new scoreBoard();
        addObject(Score, 495, 370);

        startTime = new Date();
    }

    public void act()
    {
      updateTime();
    }

    public void updateTime() {
      Date currentTime = new Date();
      long difference = (currentTime.getTime() - startTime.getTime()) / 1000;
      showText("Time: " + difference, 495, 40);
    }

    public void gameOver()
    {

    }
}
