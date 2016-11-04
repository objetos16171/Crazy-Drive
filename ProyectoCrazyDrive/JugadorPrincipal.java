import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Corredor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JugadorPrincipal extends Actor
{
    private int velocidad=3;
    private int giro;
    
    public JugadorPrincipal(){
    }
    
    public void act() 
    {
        avanza();   
        checkIfTouchStar();
    }    
    
    public void checkIfTouchStar()
    {
        CrazyDriveWorld mundo=(CrazyDriveWorld)getWorld();
        if(this.isTouching(Estrella.class)){
            mundo.eliminaEstrella();
        }
    }
    
    public void avanza()
    {
        if(Greenfoot.isKeyDown("Left"))
      {
        move(-velocidad);
      }
       if(Greenfoot.isKeyDown("Right"))
      {
        move(velocidad);
      }
         setLocation(getX(),getY()-velocidad);     
      if(Greenfoot.isKeyDown("Down"))
      {
        setLocation(getX(),getY()+3);       
      } 
    }
}
