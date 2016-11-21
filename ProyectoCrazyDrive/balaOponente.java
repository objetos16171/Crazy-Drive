import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class balaOponente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class balaOponente extends Arma
{
    /**
     * Act - do whatever the balaOponente wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(),getY()-10);
    }    
}
