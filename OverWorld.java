import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Write a description of class OverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OverWorld extends World
{
    public static boolean isMessageOpen = false;
    private GreenfootImage worldOne = new GreenfootImage("worldOne.png");
    private static ArrayList<TextBox> messageQue = new ArrayList<TextBox>(0);
    /**
     * 
     * Constructor for objects of class OverWorld.
     * 
     */
    GreenfootSound music = new GreenfootSound("Finally.mp3");
    public OverWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1, false);
        Setup();
        music.setVolume(50);
        music.playLoop();
    }
    public void stopped()
    {
        music.pause();
    }
    public void started()
    {
        music.playLoop();
    }
    public void Setup()
    {
        addObject(new GameWorld(worldOne), 0, 0);
        
        Actor witch1AI = new GameAI(-4950, -75, true, true, "Witch_1", new TextBox("All hail, Macbeth!", "Hail to thee,", "thane of Glamis!", "", "", true), new TextBox("Hail!", "", "", "", "", true));
        addObject(witch1AI, 0, 0);
        Actor witch2AI = new GameAI(-4950, 0, true, true, "Witch_2", new TextBox("All hail, Macbeth!", "Hail to thee,", "thane of Cawdor!", "", "", true), new TextBox("Hail!", "", "", "", "", true));
        addObject(witch2AI, 0, 0);
        Actor witch3AI = new GameAI(-4950, 75, true, true, "Witch_3", new TextBox("All hail, Macbeth,", "that shalt be king hereafter!", "", "", "", true), new TextBox("Go on, Follow the path!", "", "", "", "", true));
        addObject(witch3AI, 0, 0);
        Actor duncan = new GameAI(-3425, -115, true, "Duncan", new TextBox("And, for an earnest of a greater honor,", "Duncan, from him, call thee thane of Cawdor:", "In which addition, hail, most worthy thane,", "For it is thine.", "", true), new TextBox("You've done good so far,", "just keep following the path.", "", "", "", true));
        addObject(duncan, 0, 0);
        Actor ladyMacbeth = new GameAI(-515, -275, true, "LadyMacbeth", new TextBox("Their drenchèd natures lie as in a death,", "What cannot you and I perform upon", "The unguarded Duncan? What not put upon", "His spongy officers, who shall bear the guilt", "Of our great quell?", true), new TextBox("Go on now,", "Duncan awaits.", "", "", "", true));
        addObject(ladyMacbeth, 0, 0);
        Actor duncanDead = new GameAI(4275, -125, false, "Duncan", new TextBox("And, for an earnest of a greater honor,", "Duncan, from him, call thee thane of Cawdor:", "In which addition, hail, most worthy thane,", "For it is thine.", "", true), new TextBox("You've done good so far,", "just keep following the path.", "", "", "", true));
        addObject(duncanDead, 0, 0);
        
        //addObject(new GameAI(100, 0, false, "Steve", new TextBox("Hi. My name is Steve! You can call me Stevie.", "I am a member of Steve Squad,", "our goal is to take over the world of", "<INSERT_GAME_NAME_HERE>", "", true),
                        //new TextBox("...", "", "", "", "", true)), 0, 0);
        //loadWorld(worldOne, 2400, 500, true);
        String userInput = JOptionPane.showInputDialog("Please enter your name.");
        addObject(new Macbeth(userInput), 0, 0);
        Macbeth.setNewPos(-4950, -200);
        //Macbeth.setNewPos(3150, -200);
        act();
        
        addToMessageQue(new TextBox("Welcome " + Macbeth.getName() + ", Here you play as Macbeth", "Our story starts in Scotland, home of the great king Duncan!","You are on your way home from a great war",
                        "as you stumble across 3 witches.","Walk up to them to see what they have to say!", true));
        //addToMessageQue(new TextBox("Can you find the elusive Stevie?", "Only time will tell.", "Have fun exploring the map!", "", "",true));
        Greenfoot.start();
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("i") && isMessageOpen == false)
        {
            addToMessageQue(new TextBox("This is a test of a really long String object in a text box. I need to keep typing in", "order for this to new line.","","","", true));
        }
        if (messageQue.isEmpty() == false && isMessageOpen == false)
        {
            Greenfoot.getKey();
            addObject(getNextMessage(), 512, 550);
            isMessageOpen = true;
        }
        //System.out.println(isMessageOpen);
    }
    public static void addToMessageQue(TextBox newTextBox)
    {
        messageQue.add(newTextBox);
    }
    public static TextBox getNextMessage()
    {
        TextBox temp = messageQue.get(0);
        messageQue.remove(0);
        return temp;
    }
}
