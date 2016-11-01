import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Corredor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Corredor extends Actor
{
    public Corredor(){
    }
    
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("Left"))
      {
        move(-3);
      }
       if(Greenfoot.isKeyDown("Right"))
      {
        move(3);
      }
       if(Greenfoot.isKeyDown("Up"))
      {
         setLocation(getX(),getY()-3);
      }     
      if(Greenfoot.isKeyDown("Down"))
      {
        setLocation(getX(),getY()+3);       
      }    
    }    
}
