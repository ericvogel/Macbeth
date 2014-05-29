import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoadingScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoadingScreen extends World
{
    int counter = 0;
    boolean fadeIn = true;
    boolean runFade1 = true;
    boolean runFade2 = false;
    boolean runFade3 = false;
    GreenfootSound music = new GreenfootSound("Finally.mp3");
    GreenfootImage engine = new GreenfootImage("LoadingScreen\\5ggix10y.png");
    GreenfootImage presents = new GreenfootImage("Presents", 64, java.awt.Color.WHITE, java.awt.Color.BLACK);
    GreenfootImage title = new GreenfootImage("Macbeth\nThe Video Game", 64, java.awt.Color.WHITE, java.awt.Color.BLACK);
    GreenfootImage temp = new GreenfootImage(1024, 600);
    public LoadingScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1, false);
        temp.setColor(java.awt.Color.BLACK);
        temp.fill();
        setBackground(temp);
        Greenfoot.start();
        music.setVolume(50);
        music.play();
    }
    public void stopped()
    {
        music.stop();
    }
    public void act()
    {
        if (runFade1 == true)
        {
            engine.setTransparency((counter));
            temp.setColor(java.awt.Color.BLACK);
            temp.fill();
            temp.drawImage(engine, 512-150, 300-150);
            if (counter > 254)
            {
                fadeIn = false;
            }
            else if (counter <= 1 && fadeIn == false)
            {
                runFade1 = false;
                runFade2 = true;
                fadeIn = true;
                counter = 1;
            }
            if (fadeIn == true)
            {
                counter++;
            }
            else
            {
                counter--;
            }
        }
        if (runFade2 == true)
        {
            //System.out.println("fade2");
            presents.setTransparency((counter));
            temp.setColor(java.awt.Color.BLACK);
            temp.fill();
            temp.drawImage(presents, 412, 260);
            if (counter > 254)
            {
                fadeIn = false;
            }
            else if (counter <= 1 && fadeIn == false)
            {
                runFade2 = false;
                runFade3 = true;
                fadeIn = true;
                counter = 1;
            }
            if (fadeIn == true)
            {
                counter++;
            }
            else
            {
                counter--;
            }
        }
        if (runFade3 == true)
        {
            //System.out.println("fade3");
            title.setTransparency((counter));
            temp.setColor(java.awt.Color.BLACK);
            temp.fill();
            temp.drawImage(title, 325, 250);
            if (counter > 254)
            {
                fadeIn = false;
            }
            else if (counter <= 1 && fadeIn == false)
            {
                runFade3 = false;
                fadeIn = true;
                counter = 1;
                music.stop();
                Greenfoot.setWorld(new OverWorld());
            }
            if (fadeIn == true)
            {
                counter++;
            }
            else
            {
                counter--;
            }
        }
    }
    private void loadGame()
    {
        
    }
}
