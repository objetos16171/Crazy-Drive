import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrazyDriveWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrazyDriveWorld extends World
{
    /*Atributos para la pantalla*/
    private static final int WIDTH = 560;
    private static final int HEIGHT = 850;
    private int limiteIzquierdoPista=130;
    private int limiteDerechoPista=322;
    
    /*Atributos del juego*/
    private JugadorPrincipal jugador;
    private Estrella estrella;
    private Counter contEstrellas;
    private Counter contTiempo;
    private SimpleTimer reloj=new SimpleTimer();
    private Gas gas;
    private Nitrox nitrox;
    private Agujero agujero;
    private int i=0;
    

    /**
     * Constructor for objects of class CrazyDriveWorld.
     * 
     */
    public CrazyDriveWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super( WIDTH, HEIGHT, 1); 
        prepare();
        contTiempo.setValue(3);

     
    }
    
    public void act()
    { 
        if(reloj.millisElapsed() > 1000){
        contTiempo.add(-1);
        reloj.mark();
        
        if(contTiempo.getValue()==0)
        {  
         
        }
       
       }
    
    }
    
        /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void prepare()
    {
        jugador = new JugadorPrincipal();
        addObject(jugador,206,805);
        jugador.setLocation(198,805);
        estrella = new Estrella();
        addObject(estrella,257,258);
        estrella.setLocation(253,255);
        contEstrellas = new Counter("Estrellas: ");
        addObject(contEstrellas,416,162);
        contTiempo = new Counter("Tiempo: ");
        addObject(contTiempo,416,200);
        gas = new Gas();
        addObject(gas,145,397);   
        gas.setLocation(150,400);
        nitrox = new Nitrox();
        addObject(nitrox,300,600);
        nitrox.setLocation(310,610);
        agujero = new  Agujero();
        addObject(agujero,120,600);
        agujero.setLocation(130,610);
    }
    
    public void eliminaEstrella()
    {
        removeObject(estrella);
        incrementaContEstrellas();
    }
    
    public void eliminaGas()
    {  
        removeObject(gas);
    }
    
    public void eliminaNitrox()
    {  
        removeObject(nitrox);
    }
    
     public void eliminaAgujero()
    {  
        removeObject(agujero);
    }
    
    public void incrementaContEstrellas()
    {
        contEstrellas.setValue(+1);
    }
    
    public int getLimitIzqPi(){ return limiteIzquierdoPista; }
      
    public int getLimitDerPi(){ return limiteDerechoPista; }
}
