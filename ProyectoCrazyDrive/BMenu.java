import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BMenu extends Botton
{
    /**
     * Act - do whatever the BMenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
          if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Menu());
        }
    }    
}
