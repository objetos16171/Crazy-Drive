import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Esta es la clase padre de los jugadores del juego
 * 
 * @author Nava Torres Claudio Isauro, Bustos Hernandez Maricruz 
 * @version 10/11/2016
 */
public class Jugador extends Actor
{
    private final int RIGHT=0;
    private final int LEFT=1;
    private final int UP=2;
    private final int DOWN=3;
   
    /**
     * Sobrescritura del metodo setLocation para nuestro juego
     */
    @Override public void setLocation(int x, int y)
    {
        int x2=getX()-x;
        int y2=getY()-y;    //obtenemos las posiciones donde el jugador esta intentado moverse
        List <Other> todos= getWorld().getObjects(Other.class);
        for(int i=0;i<todos.size();i++)
        {
            Actor uno= todos.get(i);
            uno.setLocation(uno.getX()+x2,uno.getY()+y2);   //Le damos la posicion de los otros
        }
        
        ((CrazyDriveWorld) getWorld()).setOrientacion(x2,y2);    //para retroceder el mundo
    }
    
    /**
     * Sobrescritura del metodo move
     */
    @Override public void move(int num)
    {
        List <Other> todos =getWorld().getObjects(Other.class);
        if(todos.size()>0)
        {
            Actor uno = todos.get(0);
            int x=uno.getX();
            int y=uno.getY();
            int primero=uno.getRotation();
            uno.setRotation(getRotation()-90);
            uno.move(-num);
            uno.setRotation(primero);
            ((CrazyDriveWorld)getWorld()).setOrientacion(uno.getX()-x,uno.getY()-y);
        }
        for(int i=0;i<todos.size();i++)
        {
            Actor uno=todos.get(i);
            int primero=uno.getRotation();
            uno.move(-num);
            uno.setRotation(primero);
        }
    }
    
    /**
     * Este metodo nos indica si nos podemos mover o no
     */
    public boolean puedoMoverme(int direction)
    {
         int x = ((CrazyDriveWorld)getWorld()).getcX();
        int y = ((CrazyDriveWorld)getWorld()).getcY();
        if(direction == LEFT)
        {
            if(x < 0)
                return true;
            else
                return false;
        }
        else if(direction == RIGHT)
        {
            if(x > -240)
                return true;
            else
                return false;
        }
        else if(direction == UP)
        {
            if(y < 0)
                return true;
            else
                return false;
        }
        else if(direction == DOWN)
        {
            if(y > -3300)
                return true;
            else
                return false;
        }
        else
            return false;
    }
    
    /**
     * 
     */
    public boolean golpeoElBorde()
    {
       int x=((CrazyDriveWorld)getWorld()).getcX();
       int y=((CrazyDriveWorld)getWorld()).getcY();
       int y_limite = -200;
       int x_limite = -100;
       if(x > 0 || y>0 || x < x_limite || y < y_limite)
            return true;
        else
            return false;
    }
    
    /**
     * Act - do whatever the Jugador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //
    }    
}

