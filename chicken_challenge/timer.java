import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
/**
 * Write a description of class timer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class timer extends Actor
{
    private Date startTime;
    public static final float FONT_SIZE = 18.0f;
    public static final int WIDTH = 200;
    public static final int HEIGHT = 50;
    public static final String BUFFER = "Time : ";

    public timer()
    {
      startTime = new Date();
      //DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
      //time = sdf.format(startTime);
      updateTime();
    }

    public void act()
    {
        // Add your action code here.
        updateTime();
    }

    public void updateTime()
    {
      Date currentTime = new Date();
      long difference = (currentTime.getTime() - startTime.getTime()) / 1000;

      GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
      image.setColor(new Color(0, 0, 0, 128));
      image.fillRect(0, 0, WIDTH, HEIGHT);
      Font font = image.getFont();
      font = font.deriveFont(FONT_SIZE);
      image.setFont(font);
      image.setColor(Color.WHITE);
      image.drawString(BUFFER + difference, 20, 30);
      setImage(image);
    }

}
