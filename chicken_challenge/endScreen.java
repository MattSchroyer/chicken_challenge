import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class endScreen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class endScreen extends Actor
{
    /**
     * Act - do whatever the endScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static final float FONT_SIZE = 28.0f;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 250;

    public endScreen(int score)
    {
      GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
      image.setColor(new Color(0, 0, 0, 128));
      image.fillRect(0, 0, WIDTH, HEIGHT);
      Font font = image.getFont();
      font = font.deriveFont(FONT_SIZE);
      image.setFont(font);
      image.setColor(Color.WHITE);
      image.drawString("Game Over!", 150, 50);
      image.drawString("YOUR SCORE:", 140, 100);
      image.drawString(Integer.toString(score), 235, 150);
      image.drawString("Thanks for playing", 100, 200);
      setImage(image);
    }
}
