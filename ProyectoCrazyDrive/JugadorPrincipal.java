import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JugadorPrincipal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JugadorPrincipal extends Jugador
{
    private int velocidad=7;
    private int cantGiro=4;
    private GifImage myImage;
    
    /**
     * Este es el constructor de la clase JugadorPrincipal
     */
    public JugadorPrincipal()
    {
        myImage = new GifImage("carJugPrin.gif");  //La imagen representa al jugador principal
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
        checkIfTouchArma();
    }    
    
    /**
     * 
     */
    public void avanza()
    {
        if(puedoMoverme(2)){
            setRotation(0);
            setLocation(getX(),getY()-velocidad);
        }
         if(Greenfoot.isKeyDown("Down")&&puedoMoverme(3)){
            setLocation(getX(),getY()+velocidad);
        }
        if(Greenfoot.isKeyDown("Right")&&puedoMoverme(0)){
            gira(cantGiro);
            setLocation(getX()+velocidad,getY());
        }
        if(Greenfoot.isKeyDown("Left")&&puedoMoverme(1)){
            gira(-cantGiro);
            setLocation(getX()-velocidad,getY());
        }
    }
    
     public void checkIfTouchArma()
    {
       CrazyDriveWorld mundo=(CrazyDriveWorld)getWorld();
        if(this.isTouching(Armas.class)){
            mundo.eliminaArma();
        }
    }
    
    /**
     * 
     */
    public void gira(int sentido)
    {
       setRotation(sentido);
       setLocation(getX()+sentido,getY());
    }
}






/*import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Corredor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
/*public class JugadorPrincipal extends Jugador
{
    private int velocidad=5;
    private int cantGiro=4;
    
    /*
    public JugadorPrincipal(){
      }
    
    public void act() 
    {
        avanza();   
        checkIfTouchStar();
        checkIfTouchGas();
        checkInagujero();
        
    }    
    
    public void checkIfTouchStar()
    {
       CrazyDriveWorld mundo=(CrazyDriveWorld)getWorld();
        if(this.isTouching(Estrella.class)){
            mundo.eliminaEstrella();
        }
    }
    
     public void checkIfTouchGas()
    {
              CrazyDriveWorld mundo=(CrazyDriveWorld)getWorld();
        if(this.isTouching(Gas.class)){
          mundo.eliminaGas();
        }
    }
    
      public void checkInitrox()
    {
              CrazyDriveWorld mundo=(CrazyDriveWorld)getWorld();
        if(this.isTouching(Nitrox.class)){
          mundo.eliminaNitrox();
          velocidad+=5;
        }
       
    }
    
       public void checkInagujero()
    {
         CrazyDriveWorld mundo=(CrazyDriveWorld)getWorld();
        if(this.isTouching(Agujero.class)){
          mundo.eliminaAgujero();
          setLocation(getX(),0);
        }
       
    }
    
    public void avanza()
    {        
        setRotation(0);
        checkInitrox();        
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
    }*/

