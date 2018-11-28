import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class scoreboard here.
 *
 * @author Matt Schroyer, Elizabeth Haase
 * @version 0.1
 */
public class scoreBoard extends Actor
{
    private int score;
    private int currentVal;
    private GreenfootImage background;
    private static final Color transparent = new Color(0,0,0,0);

    public static final float FONT_SIZE = 18.0f;
    public static final int WIDTH = 200;
    public static final int HEIGHT = 50;

    public static final String BUFFER = "Score : ";

    public scoreBoard()
    {
        score = 0;
        updateScore();
    }

    public void inc(int increase)
    {
      score += increase;
      updateScore();
    }

    private void updateScore()
    {
      GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

      image.setColor(new Color(0, 0, 0, 128));
      image.fillRect(0, 0, WIDTH, HEIGHT);
      Font font = image.getFont();
      font = font.deriveFont(FONT_SIZE);
      image.setFont(font);
      image.setColor(Color.WHITE);
      image.drawString(BUFFER + score, 60, 30);
      setImage(image);
    }


}
