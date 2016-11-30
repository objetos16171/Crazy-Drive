import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ImagenGas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImagenGas extends Imagen
{
    int tipo=2;
    
    /**
     * Constructor de la clase ImagenGas
     */
    public ImagenGas()
    {
       this.setImage("contGas3.png");
    }
    
    /**
     * Este método permite cambiar el tipo de imagen
     */
    public void cambiate(int cant)
    {
        tipo+=cant;
        
        if(tipo==2)
        {
            setImage("contGas2.png");
        }
         if(tipo==1)
        {
            setImage("contGas1.png");
        }
         if(tipo==3)
        {
            setImage("contGas3.png");
        }
        
        if(tipo<=0)
        {
            setImage("contGas0.png");
            tipo=0;
        }
    }
    
    /**
     * Retorna el tipo de imagen colocada en el juego
     */
    public int getTipo(){ return tipo; }
}
