import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrazyDriveWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrazyDriveWorld extends World
{
    private static final String bgImageName = "Pista3.png";
    private double scrollSpeed = 0;
    private static final int picHeight = (new GreenfootImage(bgImageName)).getHeight();
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition =0;
    private static final int altura=600;
    private static final int anchura=800;
    private Counter contTiempo=new Counter();
    private int PistaLimiteIzquierdo=235;
    private int PistaLimiteDerecho=545;
    private Competidor principal;
    private SimpleTimer reloj=new SimpleTimer();
    private Ready ready=new Ready();
    private Go go=new Go();
    private Imagen imgGas;
    private Counter contVueltas;
    private Bonificador estrella;
    private Counter contEstrellas;
    private Obstaculo mancha;
    private Obstaculo arbol;
    private Obstaculo bache;
    private SimpleTimer tiempoBalaE=new SimpleTimer(); 
    private Competidor oponente;
    
    /**
    *
    */
    public CrazyDriveWorld()
    {    
        super(anchura, altura, 1,false);
        setBackground(bgImageName);
        bgImage = new GreenfootImage(getBackground());
        bgBase = new GreenfootImage(getWidth(), picHeight);
        bgBase.drawImage(bgImage, 0, 0);
        prepare();
    }

    public void act()
    {
        scrollPosition -= scrollSpeed;
        while(scrollSpeed > 0 && scrollPosition < -picHeight) scrollPosition += picHeight;
        while(scrollSpeed < 0 && scrollPosition > 0) scrollPosition -= picHeight;
        paint(scrollPosition);
        colocaEstrella();
        colocaMancha();
        seQuedoSinGas();
        colocaBache();
        touchCompetidores();
        meDisparo();
        colocaArbol();
    }

    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase,0,position);
        bg.drawImage(bgImage,0,position + picHeight);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void prepare()
    {
        principal= new JugadorPrincipal();      //Se crea y agrega a el competidor principal
        addObject(principal,300,250);
        imgGas=new ImagenGas();
        addObject(imgGas,118,41);
        contTiempo.setValue(3);
        contVueltas= new Counter("Vueltas:");
        addObject(contVueltas,700,41);
        estrella=new Estrella();
        contEstrellas = new Counter("Estrellas:");
        addObject(contEstrellas,600,45);
        mancha=new ManchaDeAceite();
        oponente= new Oponente();
        addObject(oponente,500,250);
        arbol= new ArbolCaido();
        bache= new Bache();
        Greenfoot.playSound("export.mp3");
        Botton menu= new BMenu();
        addObject(menu,700,550); 
        Botton volverJ= new VolveraJugar();
        addObject(volverJ,700,500); 
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
            addObject(ready,450,altura-400);          
        }
        if(contTiempo.getValue()==1){
            removeObject(ready);
            addObject(go,450,altura-400);
        }
        if(contTiempo.getValue()==0){
            removeObject(go);
        }
    
        if(contTiempo.getValue()==-5){
            imgGas.cambiate(0);
        }
                
        return contTiempo.getValue();
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
     * Modifica la cantidad de avance del scroll
     */
    public void setScrollSpeed(double cant){ scrollSpeed=cant;  }
    
    /**
     * Retorna el limite izquierdo de la pista
     */
    public int getPistaLimitIzquierdo(){ return PistaLimiteIzquierdo; }
    
    /**
     * Retorna el limite derecho de la pista
     */
    public int getPistaLimitDerecho(){ return PistaLimiteDerecho; }
    
    /**
     * Retorna la posicion del scroll
     */
    public int getScrollPosition(){ return scrollPosition; }
    
    /**
     * Cuenta el numero de vueltas que ha dado el jugador sobre la pista
     */
    public void cuentaNumVueltas()
    {
        if(scrollPosition<=-3543)
        {
            contVueltas.add(1);
        }
    }
    
    /**
     * Este método coloca a la estrella de una manera aleatoria dentro del juego
     */
    public void colocaEstrella()
    {
            if(scrollPosition>=-400 && scrollSpeed!=0)
            {
                addObject(estrella,400,400);
                estrella.setLocation(estrella.getX(),estrella.getY()-4);
                if(principal.checkIfTouchEstrella()!=0){
                    contEstrellas.add(1);
                    estrella.setLocation(400,0);
                }
            }
            else{
                removeObject(estrella);
            }
    }
    
    /**
     * Checa si el jugador tiene las tres estrellas y las tres vueltas en la pista para ser ganador
     */
    public void ganador()
    {
        if(contEstrellas.getValue()>=3 && contVueltas.getValue()>=3 && principal.getY()>oponente.getY())
        {
            Label etiqueta=new Label("Winner",120);
            addObject(etiqueta,principal.getX()+40,principal.getY()+50);
            Greenfoot.stop();
        }
        else if((contEstrellas.getValue()>=3 && contVueltas.getValue()>=3 && principal.getY()<oponente.getY()) || (contEstrellas.getValue()<=3 && contVueltas.getValue()>=3))
        {
            Label etiqueta= new Label("Game Over",120);
            addObject(etiqueta,principal.getX()+40,principal.getY()+50);
             Greenfoot.stop();
        }
    }
    
    /** 
    * Coloca un obstaculo en el juego
    */
    public void colocaMancha()
    {
        if(scrollPosition<=-800 && scrollSpeed!=0)
            {
                addObject(mancha,Greenfoot.getRandomNumber(600),600);
                mancha.setLocation(mancha.getX(),mancha.getY()-4);
                if(principal.checkIfTouchObstaculo()!=0){
                    oponente.cambiaVelocidad(1);
                    mancha.setLocation(400,0);
                }
            }
            else{
                removeObject(mancha);
            }
        }
    
    /**
     * Checa si el jugador se quedo sin gas
     */
    public void seQuedoSinGas()
    {
        if(imgGas.getTipo()==0)
        {
          Label etiqueta= new Label("Sin Gas",120);
          addObject(etiqueta,principal.getX()+40,principal.getY()+50);
          Greenfoot.stop();
        }
    }
    
    /**
     * Este método crea una bala enemigo cada 6 segundos y se lanza
     */
    public void DisparaBalaEnemigo()
    {  
              if(tiempoBalaE.millisElapsed()> 6000)
              {
                   Arma balaO= new BalaOponente();
                   addObject(balaO,oponente.getX(),oponente.getY());
                   balaO.act();
                   tiempoBalaE.mark();
               }
    }
    
    /**
     * Este metodo permite que la bala salga disparada
     */
    public void disparaBala()
    {
        Arma bala= new BalaPrincipal();
        addObject(bala,principal.getX(),principal.getY());
        bala.act();
    }
    
    /**
     * Cambia las posiciones de los jugadores si se tocan
     */
    public void touchCompetidores()
    {
        
        if(principal.checaSiChoco()==1)
        {
            principal.setLocation(300,250);
            oponente.setLocation(500,oponente.getY());
        }
    }
    
    /**
     * Si la bala te toca te vuelve más lento
     */
    public void meDisparo()
    {
        if(principal.checkIfTouchBala()!=0)
        {
            oponente.setLocation(oponente.getX(),oponente.getY()+50);
        }
        if(oponente.checkIfTouchBala()!=0)
        {
            oponente.cambiaVelocidad(-1);
        }
        if(oponente.getY()>=altura)
        {
            Label etiqueta= new Label("Game Over",120);
            addObject(etiqueta,principal.getX()+40,principal.getY()+50);
            Greenfoot.stop();
        }
    }
    
    /**
    * Coloca un obstaculo en el juego
    */
    public void colocaArbol()
    {
        if(scrollPosition<=-1800 && scrollSpeed!=0)
            {
                addObject(arbol,Greenfoot.getRandomNumber(600),700);
                arbol.setLocation(arbol.getX(),arbol.getY()-4);
                if(principal.checkIfTouchObstaculo()!=0){
                    oponente.cambiaVelocidad(1);
                    arbol.setLocation(400,0);
                }
            }
            else{
                removeObject(arbol);
            }
        }
        
    /**
    * Coloca un obstaculo en el juego
    */
    public void colocaBache()
    {
        if(scrollPosition<=-1000 && scrollSpeed!=0)
            {
                addObject(bache,Greenfoot.getRandomNumber(600),700);
                bache.setLocation(bache.getX(),bache.getY()-4);
                if(principal.checkIfTouchObstaculo()!=0){
                    oponente.cambiaVelocidad(1);
                    bache.setLocation(400,0);
                }
            }
            else{
                removeObject(bache);
            }
        }
}
