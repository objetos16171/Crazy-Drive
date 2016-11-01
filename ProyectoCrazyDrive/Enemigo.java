import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo extends Actor
{  
    public Enemigo(){
    
    }
    
    public void act() 
    {
        // Add your action code here.
        setLocation(getX(),getY()-2);
    }    
}
