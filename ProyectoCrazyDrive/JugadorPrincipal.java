import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JugadorPrincipal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JugadorPrincipal extends Competidor
{
    private int velocidad=3;
    private int cantGiro=2;
    private GifImage myImage;
    
    /**
     * Este es el constructor del Jugador Principal
     */
    public JugadorPrincipal()
    {
      myImage = new GifImage("JugaPrincipal.gif");  //La imagen representa al jugador principal
    }
    
    /**
     * Act - do whatever the JugadorPrincipal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        CrazyDriveWorld mundo=(CrazyDriveWorld)getWorld();
        this.setImage(myImage.getCurrentImage());
        if(mundo.iniciaCarrera()<0){
         this.avanza();
        }
    }    
    
    /**
     * Este método permite que el jugador principal avance
     */
    public void avanza()
    {
        CrazyDriveWorld mundo =(CrazyDriveWorld)getWorld();
        mundo.setScrollSpeed(velocidad);
        if(Greenfoot.isKeyDown("Right")&& this.getX()<mundo.getPistaLimitDerecho()){
            gira(cantGiro);
            setLocation(getX()+velocidad,getY());
        }
        if(Greenfoot.isKeyDown("Left")&& this.getX()>mundo.getPistaLimitIzquierdo()){
            gira(-cantGiro);
            setLocation(getX()-velocidad,getY());
        }
        if(Greenfoot.isKeyDown("space")){
            mundo.disparaBala();  
          }
        
        mundo.cuentaNumVueltas();
        mundo.ganador();
    }
    
    /**
     * Permite girar en sentido izquiero o derecho
     */
    public void gira(int sentido)
    {
       setRotation(sentido);
       setLocation(getX()+sentido,getY());
    }
    
    /**
     * Checa si el jugador principal toco una estrella
     */
    public int checkIfTouchEstrella()
    {
        
        if(this.isTouching(Estrella.class))
        {
          return 1; 
        }
        else
        {
          return 0;
        }
        
    }
    
    /**
     * Checa si el jugador toca algun obstaculo
     */
    public int checkIfTouchObstaculo()
    {
        if(this.isTouching(Obstaculo.class))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    /**
     * Regresa 1 si el jugador principal choca con el oponente
     */
    public int checaSiChoco()
    {
        if(this.isTouching(Oponente.class))
        {
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
        if(this.isTouching(BalaOponente.class))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
}
