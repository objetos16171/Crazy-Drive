import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oponente extends Jugador
{  
    private GifImage myImage;
    
    /**
     * 
     */
    public Oponente()
    {
        myImage = new GifImage("Oponente1.gif");  //La imagen representa al jugador principal
    }
    
    public void act() 
    {
        setLocation(getX(),getY()-2);
    }    
}
