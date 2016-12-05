import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VolveraJugar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VolveraJugar extends Botton
{
    /**
     * Act - do whatever the VolveraJugar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new CrazyDriveWorld());
        }
    }    
}
