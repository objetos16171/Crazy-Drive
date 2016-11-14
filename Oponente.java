import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * #Esta clase representa a un oponente del jugador
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oponente extends Jugador
{  
    private GifImage myImage;
    private int velocidad=4;
    private int cantGiro=6;
    
    /**
     * 
     */
    public Oponente()
    {
        myImage = new GifImage("Oponente1.gif");  //La imagen representa al jugador principal
    }
    
    public void act(){ 
     CrazyDriveWorld mundo=(CrazyDriveWorld)getWorld();
       if(mundo.iniciaCarrera()<0){
           avanza();
    }    
   }
   
   public void avanza()
   {
     CrazyDriveWorld mundo=(CrazyDriveWorld)getWorld();
     if(puedoMoverme(2)){  
      setRotation(0);
      setLocation(getX(),getY()-velocidad);
     }
     
     if(mundo.getcX()>-90)
     {
         gira(cantGiro);
         setLocation(getX()+velocidad,getY());
     }
   }
   
   public void gira(int sentido)
    {
       setRotation(sentido);
       setLocation(getX()+sentido,getY());
    }
}
