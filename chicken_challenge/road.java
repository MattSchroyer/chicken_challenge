import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A road for chickens to cross.
 *
 * @author Matt Schroyer, Elizabeth Haase
 * @version 0.1
 */
public class road extends World
{
    private scoreBoard Score;
    private timer myTimer;
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

        myTimer = new timer();
        addObject(myTimer, 495, 40);
    }
}
