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
    private Date startTime;
    private int score;
    /**
     * Constructor for objects of class road.
     *
     */
    public road()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1);

        score = 0;
        startTime = new Date();

        updateScore();
    }

    public void act()
    {
      updateTime();
      movingCars();
    }

    public void updateTime() {
      Date currentTime = new Date();
      long difference = (currentTime.getTime() - startTime.getTime()) / 1000;
      showText("Time: " + difference, 900, 55);
    }

    public void increaseScore(int increase)
    {
      score += increase;
      updateScore();
    }

    public void updateScore()
    {
      showText("Score: " + score, 900, 475);
    }

    public void movingCars()
    {
        if (Greenfoot.getRandomNumber(100) < 2)
        {
            addObject(new car(), 1000, 103);
        }
        if (Greenfoot.getRandomNumber(100) < 2)
        {
            addObject(new car2(), 0, 168);
        }

    }

    public void gameOver()
    {

    }


}
