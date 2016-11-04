import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oponente extends Actor
{  
    public Oponente(){
    
    }
    
    public void act() 
    {
        setLocation(getX(),getY()-2);
    }    
}
