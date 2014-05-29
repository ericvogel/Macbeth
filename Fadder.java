import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color; //colors
/**
 * Write a description of class Fadder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fadder extends Actor
{
    /**
     * Act - do whatever the Fadder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean fadeIn = true;
    private GreenfootImage fade = new GreenfootImage(1024, 600);
    private int counter = 0;
    public Fadder()
    {
        fade.setColor(Color.BLACK);
        fade.fill();
        setImage(fade);
        getImage().setTransparency(0);
    }
    public void act() 
    {
        getWorld().setPaintOrder(TextBox.class, Fadder.class);
        if (fadeIn == true && OverWorld.isMessageOpen == false)
        {
            getImage().setTransparency((int)counter * 10);
            counter++;
            if (counter >= 25)
            {
                fadeIn = false;
                OverWorld.addToMessageQue(new TextBox("Is this a dagger which I see before me,", "The handle toward my hand?", "", "", "", true));
            }
        }
        if (fadeIn == false && OverWorld.isMessageOpen == false)
        {
            getImage().setTransparency((int)counter * 10);
            counter--;
            if(counter <= 0)
            {
                getWorld().removeObject(this);
                return;
            }
        }
        
    }    
}
