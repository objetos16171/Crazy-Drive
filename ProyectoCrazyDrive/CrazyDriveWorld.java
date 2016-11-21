import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.awt.Scrollbar;
import greenfoot.Actor;
import greenfoot.GreenfootImage;
import java.util.Calendar;
import java.awt.Color;
import java.lang.Class;
import java.util.LinkedList;

/**
 * Esta es la clase mundo de nuestro juego (proyecto de la materia de programación orientada a objetos)
 * 
 * Todos los atributos son privados y todos los metodos publicos
 * 
 * 
 * @author Nava Torres Claudio Isauro, Bustos Hernandez Maricruz
 * @version 10/11/2016- Fue la fecha en que comenzamos a comentar nuestro codigo xD
 */
public class CrazyDriveWorld extends World
{
    private int cx=-170;
    private int cy=-3300;
    private GreenfootImage pista =(new GreenfootImage("Pista1.png"));  //La imagen es un atributo de la clase
    private static final int altura=500;
    private static final int anchura=600;
    private ScrollActor principal;
    private Oponente oponente1;
    private Salida puntoSalida;
    private Ready ready=new Ready();
    private Go go=new Go();
    private Meta puntoMeta;
    private SimpleTimer reloj=new SimpleTimer();
    private Counter contTiempo=new Counter();
    private Counter contArma=new Counter();
    private Arma arma=new Arma();
    private Obstaculo arbol=new ArbolCaido();
    private Obstaculo mancha=new ManchadeAceite();
    private Bonificador gas;
    private Imagen imgGas;
    private Arma Bala=new Bala();
    private LinkedList <GreenfootImage> botones;
     private Boton Jugar,Ayuda,Salir;
    
     
     public void act()
     { 
         seleccionar();
      }
      
    /**
     * Este es el constructor de nuestra clase mundo 
     * 
     */
    public CrazyDriveWorld()
    {    
        // Se crea el mundo con sus valores en ancho y alto, con celdas de un pixel
        super(anchura, altura, 1,false);
        
        botones= new LinkedList();
        botones.add(new GreenfootImage("crazyDrive.png"));
        botones.add(new GreenfootImage("Ayuda.png"));
        botones.add(new GreenfootImage("Jugar.png"));
        botones.add(new GreenfootImage("Salir.png"));
        botones.add(new GreenfootImage("Pista1.png"));
        
        Jugar= new Boton(getBotones(2));
        Ayuda= new Boton(getBotones(1));
        Salir= new Boton(getBotones(3));
        
        menu();
      
    }
    
    public void menu()
    {

        setBackground(getBotones(0));
        addObject(Jugar, 220, 470);
        //addObject(Salir, 400, 100);
        addObject(Ayuda, 70, 430);  
        Greenfoot.setSpeed(47);
    }
    
    public GreenfootImage getBotones(int n)
    {
        return botones.get(n);
    }

    /**
     * Metodo para el arranque del jugador
     * @return contTiempo 
     */
    public int iniciaCarrera(){        

        if(reloj.millisElapsed()>1000){
            contTiempo.add(-1);
            reloj.mark();
        }   
        if(contTiempo.getValue()==2){
            addObject(ready,250,altura-400);          
        }
        if(contTiempo.getValue()==1){
            removeObject(ready);
            addObject(go,250,altura-400);

        }
        if(contTiempo.getValue()==0){
            removeObject(go);
        }
        if(contTiempo.getValue()==-5){
            imgGas.cambiate(0);
        }
        
        return contTiempo.getValue();
    }

    public void eliminaArma(){ 
        removeObject(arma);
        contArma.setValue(+1);
    }

    public void eliminaArbol(){ 
        removeObject(arbol);
    }
    
    public void eliminaMancha(){ 
        removeObject(mancha);
    }

    /**
     * Asigna una orientacion en la imagen de fondo del mundo 
     */
    public void setOrientacion(int oX, int oY)
    {
        cx=cx+oX;
        cy=cy+oY;
        getBackground().drawImage(pista,cx,cy);   //redibuja el fondo en las nuevas coordenadas recibidas por parametro
    }

    /**
     * @return X
     */
    public int getcX(){ return cx; }

    /**
     * @return Y
     */
    public int getcY(){ return cy; }

    /**
     * @param cx Recibe un nuevo valor de cx
     */
    public void setcX(int x){ cx=x; } 

    /**
     * @param cy Recibe un nuevo valor de cy
     */
    public void setcY(int y){ cy=y; }

    /**
     * Método para agregar el objeto gas en una posición en X aleatoriamente
     */
    public void agregaGas()
    {
        gas=new Gas();
        addObject(gas,Greenfoot.getRandomNumber(400),-1700);   
    }

    /**
     * Este método elimina el objeto gas creado anteriormente
     */
    public void eliminaGas()
    {  
        removeObject(gas);
    }

    /**
     * Este metodo disminuye la cantidad de gas disponible cada 3 segundos
     *Y si la cantidad de gas es cero, el juego se termina
     */
    public void cambiaImagenGas(int i)
    {
        imgGas.cambiate(i);
    }

    /**
     * Este método crea una bala y hace que la bala avance
     */
    public void DisparaBala()
    {
        Bala.setLocation(principal.getX(),principal.getY()-100);
        addObject(Bala,principal.getX(),principal.getY()-100);
    }
    
    public void ganador()
    {
            Label etiqueta=new Label("Winner",120);
            addObject(etiqueta,principal.getX()+40,principal.getY()+50);
    }
    public void seleccionar()
    {
        
        if(Greenfoot.mouseClicked(Salir)) {
            removeObjects(getObjects(null));
            menu();
        }
        
        if(Greenfoot.mouseClicked(Jugar)) {
            removeObjects(getObjects(null));            
             Nivel1();
             
        }
        
         if(Greenfoot.mouseClicked(Ayuda)) {
            removeObjects(getObjects(null));
   
        }
    }
    
    public void Nivel1()
    {
        setBackground(getBotones(4));
        principal=new JugadorPrincipal();   //se crea un jugador de tipo principal    
        addObject(principal,270,400);       //se agrega el jugador principal en el mundo
        oponente1=new Oponente();
        addObject(oponente1,150,400);
        Escenario();
       
    }
    
    private void Escenario()
    {
        addObject(arma,200,100);
        puntoSalida=new Salida();
        addObject(puntoSalida,220,620);
        puntoMeta=new Meta();
        addObject(puntoMeta,220,-3100);
        contTiempo.setValue(3);
        addObject(arbol,271,19);
        addObject(mancha,271,-1000);
        agregaGas();
        imgGas=new ImagenGas();
        addObject(imgGas,118,41);
    }
}
    
   /* /**
    }}
  
    /*
    /**
     * Metodo para el arranque del jugador
     * @return contTiempo 
     */
 /*       public int iniciaCarrera(){        
      
       if(reloj.millisElapsed()>1000){
        contTiempo.add(-1);
        reloj.mark();
       }   
       if(contTiempo.getValue()==2){
         addObject(ready,250,altura-500);          
       }
        if(contTiempo.getValue()==1){
          removeObject(ready);
          addObject(go,250,altura-500);
       }
       if(contTiempo.getValue()<0){
         removeObject(go);
       }
        return contTiempo.getValue();
    }
    
     public void eliminaArma(){ 
         removeObject(arma);
         contArma.setValue(+1);
        }
    
    /**
     * Asigna una orientacion en la imagen de fondo del mundo 
     */
 /*   public void setOrientacion(int oX, int oY)
    {
        cx=cx+oX;
        cy=cy+oY;
        getBackground().drawImage(pista,cx,cy);   //redibuja el fondo en las nuevas coordenadas recibidas por parametro
    }
    
    /**
     * @return X
     */
 /*   public int getcX(){ return cx; }
    
    /**
     * @return Y
     */
 /*   public int getcY(){ return cy; }
    
    /**
     * @param cx Recibe un nuevo valor de cx
     */
  /*  public void setcX(int x){ cx=x; }
    
    /**
     * @param cy Recibe un nuevo valor de cy
     */
  /*  public void setcY(int y){ cy=y; }
    
    /**
     * Este metodo nos permite eliminar el objeto gas colocado en la pantalla
     */
  /*  public void eliminaGas()
    {  
        removeObject(gas);
    }
 }

/*public class CrazyDriveWorld extends World
{
   
    /*Atributos para la pantalla*/
   /* private static final int WIDTH = 560;
    private static final int HEIGHT = 850;
    private int limiteIzquierdoPista=130;
    private int limiteDerechoPista=322;
    
    /*Atributos del juego*/
    /*private JugadorPrincipal jugador;
    private Estrella estrella;
    private Counter contEstrellas;
    private Counter contTiempo;
    private SimpleTimer reloj=new SimpleTimer();
    private Gas gas;
    private Nitrox nitrox;
    private Agujero agujero;
    private int i=0; //este atributo no debe pertenecer a la clase Ojo mari
    

    /**
     * Constructor for objects of class CrazyDriveWorld.
     * 
     */
    /*public CrazyDriveWorld()
    {    
        super( WIDTH, HEIGHT, 1); 
        prepare();
        //contTiempo.setValue(3);

     
    }
    
    
   /*     /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    /*public void prepare()
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
    
    //public int getLimitIzqPi(){ return limiteIzquierdoPista; }
      
    //public int getLimitDerPi(){ return limiteDerechoPista; }
    */
