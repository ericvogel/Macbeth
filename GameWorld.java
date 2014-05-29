import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color; //(java Color)
/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends Actor
{
    public static int worldRelX = 0;
    public static int worldRelY = 0;
    private static int worldWidth;
    private static int worldHeight;
    GameWorld(GreenfootImage worldToGen)
    {
        setWorldRelLocation(0, 0);
        setLocation(worldRelX, worldRelY);
        
        
        worldWidth = worldToGen.getWidth() * 50;
        worldHeight = worldToGen.getHeight()* 50;
        //System.out.println(worldWidth + "," + worldHeight);
        //System.out.println(worldToGen.getWidth() + "," + worldToGen.getHeight());
        //Tile Images//
        GreenfootImage worldMap = new GreenfootImage(worldWidth, worldHeight);
        GreenfootImage waterTile = new GreenfootImage("Water1.png");
        waterTile.scale(50, 50);
        GreenfootImage grassTile = new GreenfootImage("GrassTile.png");
        grassTile.scale(50, 50);
        GreenfootImage sandTile = new GreenfootImage("sand2.png");
        sandTile.scale(50, 50);
        GreenfootImage pathTile = new GreenfootImage("dirt.png");
        pathTile.scale(50, 50);
        
        //Shore Images//
        GreenfootImage sandwater_hor = new GreenfootImage("sandwater_hor.png");
        sandwater_hor.scale( 10 , 50);
        GreenfootImage watersand_hor = new GreenfootImage("watersand_hor.png");
        watersand_hor.scale( 10 , 50);
        GreenfootImage sandwater_vert = new GreenfootImage("sandwater_vert.png");
        sandwater_vert.scale( 50 , 10);
        GreenfootImage watersand_vert = new GreenfootImage("watersand_vert.png");
        watersand_vert.scale( 50 , 10);
        
        for (int i = 0; i < worldWidth/50; i++)
        {
            for (int j = 0; j < worldHeight/50; j++)
            {
                if (worldToGen.getColorAt(i, j).equals(Color.BLUE))
                {
                    worldMap.drawImage(waterTile, i * 50, j* 50);
                    //System.out.println("found BLUE,================================== ");
                }
                if (worldToGen.getColorAt(i, j).equals(Color.RED))
                {
                    worldMap.drawImage(sandTile, i * 50, j* 50);
                    //System.out.println("found RED,================================== ");
                }
                if (worldToGen.getColorAt(i, j).equals(Color.GREEN))
                {
                    worldMap.drawImage(grassTile, i * 50, j* 50);
                    //System.out.println("found GREEN,================================== ");
                }
                if (worldToGen.getColorAt(i, j).equals(Color.MAGENTA))
                {
                    worldMap.drawImage(pathTile, i * 50, j* 50);
                    //System.out.println("found MAGENTA,================================== ");
                }
                //System.out.println("found " + worldToGen.getColorAt(i, j));
                //System.out.println(i*50 + ", " + j*50);
                //System.out.println(worldMap.getWidth() + ", " + worldMap.getHeight());
            }
        }
        
        //System.out.println("||=====================||");
        //System.out.println("|| checking Vertically ||");
        //System.out.println("||=====================||");
        for (int i = 0; i < worldWidth/50; i++)
        {
            boolean waterFirstVert = false;
            boolean sandFirstVert = false;
            //System.out.println(i);
            for (int j = 0; j < worldHeight/50; j++)
            {
                //System.out.print(j+ ", ");
                if (worldToGen.getColorAt(i, j).equals(Color.BLUE) || worldToGen.getColorAt(i, j).equals(Color.RED))
                {
                    if (worldToGen.getColorAt(i, j).equals(Color.BLUE) && sandFirstVert == true)
                    {
                        sandFirstVert = false;
                        waterFirstVert = true;
                        worldMap.setColor(Color.CYAN);
                        //worldMap.fillRect(i*50,j*50-5,50,10);
                        worldMap.drawImage(sandwater_vert, i*50, j*50-5);
                        //shore = sand on top water on bottom
                        //System.out.print(" | ");                    
                    }
                    else if (worldToGen.getColorAt(i, j).equals(Color.BLUE) && sandFirstVert == false)
                    {
                        waterFirstVert = true;
                        //System.out.print(" B ");
                    }
                    if (worldToGen.getColorAt(i, j).equals(Color.RED) && waterFirstVert == true)
                    {
                        waterFirstVert = false;
                        sandFirstVert = true;
                        worldMap.setColor(Color.CYAN);
                        //worldMap.fillRect(i*50,j*50-5,50,10);
                        worldMap.drawImage(watersand_vert, i*50, j*50-5);
                        //shore = water on top sand on bottom
                        //System.out.print(" | ");
                    }
                    else if (worldToGen.getColorAt(i, j).equals(Color.RED) && waterFirstVert == false)
                    {
                        sandFirstVert = true;
                        //System.out.print(" R ");
                    }
                }
                else
                {
                    sandFirstVert = false;
                    waterFirstVert = false;
                }
            }
        }
            //System.out.println("");
    
        
        //System.out.println("||=====================||");
        //System.out.println("||checking horizontally||");
        //System.out.println("||=====================||");
        for (int j = 0; j < worldHeight/50; j++)
        {
            boolean waterFirstHor = false;
            boolean sandFirstHor = false;
            for (int i = 0; i < worldWidth/50; i++)
            {
                if (worldToGen.getColorAt(i, j).equals(Color.BLUE) || worldToGen.getColorAt(i, j).equals(Color.RED))
                {
                    if (worldToGen.getColorAt(i, j).equals(Color.BLUE) && sandFirstHor == true)
                    {
                        sandFirstHor = false;
                        waterFirstHor = true;
                        worldMap.setColor(Color.CYAN);
                        //worldMap.fillRect(i*50-5,j*50,10,50);
                        worldMap.drawImage(sandwater_hor, i*50-5, j*50);
                        //shore = sand on left water on right
                        //System.out.print(" | ");                    
                    }
                    else if (worldToGen.getColorAt(i, j).equals(Color.BLUE) && sandFirstHor == false)
                    {
                        waterFirstHor = true;
                        //System.out.print(" B ");
                    }
                    if (worldToGen.getColorAt(i, j).equals(Color.RED) && waterFirstHor == true)
                    {
                        waterFirstHor = false;
                        sandFirstHor = true;
                        worldMap.setColor(Color.CYAN);
                        //worldMap.fillRect(i*50-5,j*50,10,50);
                        worldMap.drawImage(watersand_hor, i*50-5, j*50);
                        //shore = water on left sand on right
                        //System.out.print(" | ");
                    }
                    else if (worldToGen.getColorAt(i, j).equals(Color.RED) && waterFirstHor == false)
                    {
                        sandFirstHor = true;
                        //System.out.print(" R ");
                    }
                }
                else
                {
                    sandFirstHor = false;
                    waterFirstHor = false;
                }
                //System.out.println("");
            }
        }
        //worldMap.fillRect(worldMap.getWidth()/2-100, worldMap.getHeight()/2-100, worldMap.getWidth()/2+100, worldMap.getHeight()/2+100);
        
        setImage(worldMap);
        //System.out.println(worldMap.toString());
        //System.out.println(worldMap.getWidth());
    }
    
    /**
     * Act - do whatever the TempWorld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        setLocation(worldRelX, worldRelY);
    }    
    public static void setWorldRelLocation(int newRelX, int newRelY)
    {
        worldRelX = newRelX;
        worldRelY = newRelY;
    }
    public static int getWorldRelX()
    {
        return worldRelX;
    }
    public static int getWorldRelY()
    {
        return worldRelY;
    }
    public static int getWorldWidth()
    {
        return worldWidth;
    }
    public static int getWorldHeight()
    {
        return worldHeight;
    }
}
