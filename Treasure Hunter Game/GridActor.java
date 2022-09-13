import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GridActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridActor extends Actor
{
    Grid parentGrid;
    int x;
    int y;
    
    public GridActor(Grid parent) {
        parentGrid=parent;
    }
    
    public void setLocation(int x, int y)
    {
        int xOffset = parentGrid.getX() - parentGrid.getImage().getWidth()/2;
        int yOffset = parentGrid.getY() - parentGrid.getImage().getHeight()/2;
        
        super.setLocation(x + xOffset, y + yOffset);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
