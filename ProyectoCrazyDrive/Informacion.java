import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Informacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Informacion extends World
{

    private Botton back;
    
    /**
     * Constructor for objects of class Informacion.
     * 
     */
    public Informacion()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        Botton back=new Back();
        addObject(back,700,550);
    }
}
