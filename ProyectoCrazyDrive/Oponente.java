import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Oponente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oponente extends Competidor
{
    private GifImage myImage;
    private int cantGiro=4;
    
    /**
     * 
     */
    public Oponente()
    {
        myImage = new GifImage("Oponente.gif");  //La imagen representa al jugador principal
    }
    
    public void act(){ 
     CrazyDriveWorld mundo=(CrazyDriveWorld)getWorld();
     this.setImage(myImage.getCurrentImage());
       if(mundo.iniciaCarrera()<0){
           mundo.DisparaBalaEnemigo();
           checkIfTouchObstaculo();
    }    
   }
   
   public void gira(int sentido)
    {
       setRotation(sentido);
       setLocation(getX()+sentido,getY());
    }
    
    public void cambiaVelocidad(int cant)
    {
        if(cant==1)
        {
            setLocation(getX()-150,getY()+230);  
        }
        if(cant==-1)
        {
            setLocation(getX()+150,getY()-230);
        }
    }
    
    public int checkIfTouchObstaculo()
    {
        if(this.isTouching(Obstaculo.class))
        {
            setLocation(getX()-20,getY()-50);
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    /**
     * Comprueba si la bala lo ha tocado
     */
    public int checkIfTouchBala()
    {
        if(this.isTouching(BalaPrincipal.class))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
