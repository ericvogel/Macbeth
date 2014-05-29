import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameAI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameAI extends Actor
{
    /**
     * Act - do whatever the GameAI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage AINorthImage;
    private GreenfootImage AIEastImage;
    private GreenfootImage AISouthImage;
    private GreenfootImage AIWestImage;
    private boolean spokenTo;
    private boolean turns;
    private boolean fades;
    private float fading = 26.0f;
    private int walkCounter;
    private String AIName;
    private TextBox message1;
    private TextBox message2;
    private int relX;
    private int relY;
    private int dirCounter = 0;
    GameAI(int newX, int newY, boolean newTurns, String newAIName, TextBox newMessage1, TextBox newMessage2)
    {
        this.relX = newX;
        this.relY = newY;
        this.turns = newTurns;
        this.fades = false;
        this.AIName = newAIName;
        if (this.turns == true)
        {
            this.AINorthImage = new GreenfootImage(AIName + "\\north.png");
            this.AIEastImage = new GreenfootImage(AIName + "\\east.png");
            this.AISouthImage = new GreenfootImage(AIName + "\\south.png");
            this.AIWestImage = new GreenfootImage(AIName + "\\west.png");
        }
        else
        {
            this.AINorthImage = new GreenfootImage(AIName + "\\self.png");
            this.AIEastImage = new GreenfootImage(AIName + "\\self.png");
            this.AISouthImage = new GreenfootImage(AIName + "\\self.png");
            this.AIWestImage = new GreenfootImage(AIName + "\\self.png");
        }
        this.AINorthImage.scale(48, 57);
        this.AIEastImage.scale(48, 57);
        this.AISouthImage.scale(48, 57);
        this.AIWestImage.scale(48, 57);
        setImage(AISouthImage);
        this.message1 = newMessage1;
        this.message2 = newMessage2;
        getImage().scale(48, 57);
        this.spokenTo = false;
    }
    GameAI(int newX, int newY, boolean newTurns, boolean newFades, String newAIName, TextBox newMessage1, TextBox newMessage2)
    {
        this.relX = newX;
        this.relY = newY;
        this.turns = newTurns;
        this.AIName = newAIName;
        if (this.turns == true)
        {
            this.AINorthImage = new GreenfootImage(AIName + "\\north.png");
            this.AIEastImage = new GreenfootImage(AIName + "\\east.png");
            this.AISouthImage = new GreenfootImage(AIName + "\\south.png");
            this.AIWestImage = new GreenfootImage(AIName + "\\west.png");
        }
        else
        {
            this.AINorthImage = new GreenfootImage(AIName + "\\self.png");
            this.AIEastImage = new GreenfootImage(AIName + "\\self.png");
            this.AISouthImage = new GreenfootImage(AIName + "\\self.png");
            this.AIWestImage = new GreenfootImage(AIName + "\\self.png");
        }
        this.fades = newFades;
        this.AINorthImage.scale(48, 57);
        this.AIEastImage.scale(48, 57);
        this.AISouthImage.scale(48, 57);
        this.AIWestImage.scale(48, 57);
        setImage(AISouthImage);
        this.message1 = newMessage1;
        this.message2 = newMessage2;
        getImage().scale(48, 57);
        this.spokenTo = false;
    }
    public void act() 
    {
        //         if (this.walks == true)
        //         {
        //             //null
        //         }
        //System.out.println(this.spokenTo);
        setLocation(GameWorld.getWorldRelX() + relX, GameWorld.getWorldRelY() + relY);
        if ((dirCounter + Greenfoot.getRandomNumber(5) >= 50) && (OverWorld.isMessageOpen == false) && this.turns == true)
        {
            int tempDir = Greenfoot.getRandomNumber(4);
            if (tempDir == 0)
            {
                setImage(AINorthImage);
                dirCounter = 0;
            }
            else if (tempDir == 1)
            {
                setImage(AIEastImage);
                dirCounter = 0;
            }
            else if (tempDir == 2)
            {
                setImage(AISouthImage);
                dirCounter = 0;
            }
            else if (tempDir == 3)
            {
                setImage(AIWestImage);
                dirCounter = 0;
            }
        }
        dirCounter++;
        if(this.fading <= 25.0)
        {
            getImage().setTransparency((int)fading * 10);
            fading = fading -0.75f;
            if (fading <=0)
            {
                getWorld().removeObject(this);
                return;
            }
        }
        //System.out.println("X" + getX() + " , Y" + getY());
    }
    public void displayMessage(String directionToLook)
    {
        if (OverWorld.isMessageOpen == false && this.turns == true)
        {
            if (this.spokenTo == false)
            {
                OverWorld.addToMessageQue(message1);
                this.spokenTo = true;
            }
            else
            {
                OverWorld.addToMessageQue(message2);
                if (this.fades == true)
                {
                    this.fading = 25.0f;
                    //Greenfoot.playSound("Fade.mp3");
                }
            }
            if (directionToLook == "north")
            {
                setImage(AINorthImage);
            }
            else if (directionToLook == "east")
            {
                setImage(AIEastImage);
            }
            else if (directionToLook == "south")
            {
                setImage(AISouthImage);
            }
            else if (directionToLook == "west")
            {
                setImage(AIWestImage);
            }
        }
    }
}
