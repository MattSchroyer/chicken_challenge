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
    private int timeRemaining;
    private int lastTime;

    private int lives = 3;  // Used to store lives


    // To adjust how often eggs generate
    private int generateEggs = 1500;


    private Boolean started = false;

    private static int TIME_LIMIT = 31;

    private startScreen startscreen = new startScreen();
    private chicken myChicken = new chicken();
    /**
     * Constructor for objects of class road.
     *
     */
    public road()
    {
        // Create a new world with 1000x500 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1);
        score = 0;
        timeRemaining = TIME_LIMIT;
        lastTime = 0;
        addObject(myChicken, 500, 470);
        addObject(startscreen, 500, 250);
        showText("PRESS SPACE TO START", 500, 45);
    }

    public void act()
    {
      if (Greenfoot.isKeyDown("space")) {
        started = true;
        removeObject(startscreen);
        startTime = new Date();
        updateScore();
      }
      if (started) {
        showText("", 500, 45);
        updateLives();
        updateTime();
        movingCars();
        generateEggs();
      }
    }

    public void updateTime() {
      Date currentTime = new Date();
      int difference = (int) (currentTime.getTime() - startTime.getTime()) / 1000;
      if (lastTime != difference) {
        timeRemaining--;
        showText("Time: " + timeRemaining, 900, 55);
      }
      if (timeRemaining == 0) {
        gameOver();
      }
      lastTime = difference;
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
        if (Greenfoot.getRandomNumber(300) < 1)
        {
            for(int i = 0; i < 1000; i = i+5)
            {
                addObject(new carL(), 1000, 103);
            }
        }

        if (Greenfoot.getRandomNumber(300) < 1)
        {
            for(int i = 0; i < 1000; i = i+5)
            {
                addObject(new carL(), 0, 168);
            }
        }

        if (Greenfoot.getRandomNumber(300) < 1)
        {
            for(int i = 0; i < 1000; i = i+5)
            {
                addObject(new carL(), 1000, 224);
            }
        }

        if (Greenfoot.getRandomNumber(300) < 1)
        {
            for(int i = 0; i < 1000; i = i+5)
            {
                addObject(new carR(), 0, 287);
            }
        }

        if (Greenfoot.getRandomNumber(300) < 1)
        {
            for(int i = 0; i < 1000; i = i+5)
            {
                addObject(new carR(), 1000, 346);
            }
        }

        if (Greenfoot.getRandomNumber(300) < 1)
        {
            for(int i = 0; i < 1000; i = i+5)
            {
                addObject(new carR(), 0, 403);
            }
        }
    }

    public void gameOver()
    {
      // Greenfoot.playSound("game-over-sound.mp3");
      addObject(new endScreen(score), 500, 250);
      Greenfoot.stop();
    }

    public void generateEggs()
    {
        int x = Greenfoot.getRandomNumber(1000);

        if (Greenfoot.getRandomNumber(generateEggs) < 1)
        {
            addObject(new egg(), x, 103);
        }

        if (Greenfoot.getRandomNumber(generateEggs) < 1)
        {
            addObject(new egg(), x, 168);
        }

        if (Greenfoot.getRandomNumber(generateEggs) < 1)
        {
            addObject(new egg(), x, 224);
        }

        if (Greenfoot.getRandomNumber(generateEggs) < 1)
        {
            addObject(new egg(), x, 287);
        }

        if (Greenfoot.getRandomNumber(generateEggs) < 1)
        {
            addObject(new egg(), x, 346);
        }

        if (Greenfoot.getRandomNumber(generateEggs) < 1)
        {
            addObject(new egg(), x, 403);
        }
    }

    public void loseLife()
    {
        lives--;
        if (lives == 0)
        {
            gameOver();
        }
    }

    public void updateLives()
    {
        showText("Lives: " + lives, 100, 475);
    }
}
