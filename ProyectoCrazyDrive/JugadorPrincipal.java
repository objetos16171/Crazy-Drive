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
    private int cantGiro=4;
    
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
        setRotation(0);
        setLocation(getX(),getY()-velocidad);
        if(Greenfoot.isKeyDown("Left"))
      {
          gira(-cantGiro);
          checaLimites();
      }
      
       if(Greenfoot.isKeyDown("Right"))
      {
          gira(cantGiro);
          checaLimites();
      }     
    }
    
    public void gira(int sentido)
    { 
       setRotation(sentido);
       setLocation(getX()+sentido,getY());
    }
    
    public void checaLimites(){
        CrazyDriveWorld mundo=(CrazyDriveWorld)getWorld();
        
        if(this.getX()<=mundo.getLimitIzqPi()){
            gira(cantGiro);
        }
        
        if(this.getX()>=mundo.getLimitDerPi()){
            gira(-cantGiro);
        }
    }
}
