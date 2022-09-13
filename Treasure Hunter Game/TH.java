import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TH here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TH extends GridActor
{
    Timer actTimer = new Timer(25);
    private GreenfootImage right = new GreenfootImage("THRight0.png");
    private GreenfootImage left = new GreenfootImage("THLeft0.png");
    private GreenfootImage rightHurt = new GreenfootImage("THRight1.png");
    private GreenfootImage leftHurt = new GreenfootImage("THLeft1.png");
    int health = 3;
    private int time=30;
    
    public TH(Grid parent) {
        super(parent);
        getImage().scale(30, 30);
    }
    
    public void act() 
    {
        movement();
    }    
    
    public void movement() {        
        if (Greenfoot.isKeyDown("left") && getObjectsAtOffset(-1,0,Boulder.class).isEmpty()){
            setImage(left);
            move(-10);
        }
        if (Greenfoot.isKeyDown("right") && getObjectsAtOffset(1,0,Boulder.class).isEmpty()){
            setImage(right);
            move(10);       
        }
        getImage().scale(30, 30);
    }
}
