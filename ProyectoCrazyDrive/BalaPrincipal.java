import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BalaPrincipal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaPrincipal extends Arma
{
    private int cantDisparo=6;
    
    /**
     * Act - do whatever the BalaPrincipal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        disparate();
    }    
    
    public void disparate()
    {
       setLocation(getX(),getY()+cantDisparo);   
    }
}
