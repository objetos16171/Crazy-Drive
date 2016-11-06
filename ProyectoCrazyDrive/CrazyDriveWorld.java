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
    /**
     * Constructor for objects of class CrazyDriveWorld.
     * 
     */
    public CrazyDriveWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super( WIDTH, HEIGHT, 1); 
        prepare();
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
    }
    
    public void eliminaEstrella()
    {
        this.removeObject(estrella);
        incrementaContEstrellas();
    }
    
    public void incrementaContEstrellas()
    {
        contEstrellas.setValue(+1);
    }
    
    public int getLimitIzqPi(){ return limiteIzquierdoPista; }
    
    public int getLimitDerPi(){ return limiteDerechoPista; }
}
