import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaPrincipal extends Arma
{
    /**
     * Act - do whatever the Bala wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
           setLocation(getX(),getY()-15); //Hace que la bala se mueva hacia arriba
           checkIfTouchArma();
           checkIfTouchMancha();
     }
     
     public void checkIfTouchArma()
    {
       CrazyDriveWorld mundo=(CrazyDriveWorld)getWorld();
        if(this.isTouching(ArbolCaido.class)){
            mundo.eliminaArbol();
            
        }
    }
    
    public void checkIfTouchMancha()
    {
       CrazyDriveWorld mundo=(CrazyDriveWorld)getWorld();
        if(this.isTouching(ManchadeAceite.class)){
            mundo.eliminaMancha();
        }
    }
    }    

