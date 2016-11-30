import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Helph here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Helph extends World
{
    private Botton volver;
    
    /**
     * Constructor for objects of class Helph.
     * 
     */
    public Helph()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1);
        volver=new Back();
        addObject(volver,550,450);
    }
}
