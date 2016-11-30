import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void prepare()
    {
        Botton ayuda = new Ayuda();
        addObject(ayuda,73,425);
        ayuda.setLocation(52,435);
        Botton jugar = new Jugar();
        addObject(jugar,225,480);
        jugar.setLocation(211,473);
        Greenfoot.playSound("Inicio.mp3");
    }
}
