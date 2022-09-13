import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Grid grid;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 442, 1);
        prepare();
    }
    
    public void prepare() {
        grid = new Grid();
        addObject(grid, 300, 221);
        
        addObject(new TH(grid), 20, 20);
    }
}
