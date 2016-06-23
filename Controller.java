import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
* Controller Klasse als Aktoer zwischen Model und View
*/
public class Controller{
    private View _view;
    private Model _model;
    private boolean valid;
    
    /**
     * erstellt ein Model und ein View
     * und fuegt die ActionListener Hinzu
     */
    public Controller(){
       this._model = new Model();
       this._view = new View();
       addListener();
    }
    
	
	/**
     * Sichtbarkeit des Frames wird auf true gesetzt
     */
    public void showView(){
        this._view.setVisible(true);
    }
	
    /**
     * Fuegt die 3 ActionListener der 3 Knoepfe hinzu
     */
    private void addListener(){
        this._view.setStartListener(new StartListener());
        this._view.setStepListener(new StepListener());
        this._view.setClearListener(new ClearListener());
        this._view.setDrawListener(new DrawListener());
       
    }
	
    /**
     * Prueft bei jedem Knopfdruck
     * ob die Eintraege alle Korrekt sind
     */
    public void isValidController(){
        this.valid = _model.isValid(_view.getAX(), _view.getAY(), 
            _view.getBX(), _view.getBY(),
            _view.getCX(), _view.getCY(), 
            _view.getPunktX(), _view.getPunktY(),
            _view.getStep());
            
            _view.farbe(valid); 
    }
    
	/**
     * Erzeugt einen neuen Punkt in Richtung einer Pyramide,
	 * der sich bis zur Hälfte dieser Bewegt
	 * @param x,y Koordinaten der Pyramide
     */
    public void moveToPoint(int x, int y){
    	//aktueller Punkt:
    	int x1 = _view.myPanel.points.get(_view.myPanel.points.size()-1).getX(); 
    	int y1 = _view.myPanel.points.get(_view.myPanel.points.size()-1).getY();
    	
    	int dx = (x - x1)/2;
    	int dy = (y - y1)/2;
    	
    	Punkt p = new Punkt(x1+dx,y1+dy);
    	_view.myPanel.points.add(p);
    	
    	
    	_view.myPanel.repaint();
    }
    
	/**
     * Waehlt zufaellig eine Pyramide aus, zu der sich bewegt werden soll
	 * Und macht das Verfahren step-Mal
	 * @param steps	Schritte die im Stepfeld eingegeben werden
     */
    public void move(int steps){
    	Random r = new Random();
        for(int i = 0; i < steps; i++){
            switch(r.nextInt(3)){
            	case 0: 
            		//Move to A:
            		if(_view.getStandard()){
            			moveToPoint(400,400);
            		}else{
            			moveToPoint(Integer.parseInt(_view.getAX()), Integer.parseInt(_view.getAY()));
            		}
            		
            		break;
            	case 1: 
            		//Move to B:
            		if(_view.getStandard()){
            			moveToPoint(100,400);
            		}else{
            			moveToPoint(Integer.parseInt(_view.getBX()), Integer.parseInt(_view.getBY()));
            		}
            		
            		break;
            	case 2: 
            		//Move to C:
            		if(_view.getStandard()){
            			moveToPoint(250,140);
            		}else{
            			moveToPoint(Integer.parseInt(_view.getCX()), Integer.parseInt(_view.getCY()));
            		}
            		
            		break;
            }
        }
    }
    
	/**
     * Zeichne eine Pyramide, je nachdem welcher Radiobutton aktiv ist.
     */
    public void drawPyramid(){
    	_view.myPanel.points.clear();
    	
    	if(_view.getStandard()){
    		_view.myPanel.setKoordinaten(400, 400, 100, 400, 250, 140);
    		_view.myPanel.points.add(new Punkt(250, 313));
    	}else if(_view.getEingeben()){
    		isValidController();
    		if(valid){
    			_view.myPanel.points.add(new Punkt(Integer.parseInt(_view.getPunktX()), Integer.parseInt(_view.getPunktY())));
            	_view.myPanel.setKoordinaten(Integer.parseInt(_view.getAX()), 
        									 Integer.parseInt(_view.getAY()), 
        									 Integer.parseInt(_view.getBX()), 
        									 Integer.parseInt(_view.getBY()), 
        									 Integer.parseInt(_view.getCX()), 
        									 Integer.parseInt(_view.getCY()));
    		}
    		
    	}else{
    		Random r = new Random();
    		int[] posX = new int[4];
    		for(int i = 0; i < 4; i++){
    			posX[i] = r.nextInt(540);
    		}
    		int[] posY = new int[4];
    		for(int i = 0; i < 4; i++){
    			posY[i] = r.nextInt(470);
    		}
    		
    		while(!_model.punktImDreieck(posX[0],posY[0],posX[1],posY[1],posX[2], posY[2],posX[3],posY[3])){
    			posX[3] = r.nextInt(540);
    			posY[3] = r.nextInt(470);
    			
    		}
    		
    		_view.myPanel.points.add(new Punkt(posX[3], posY[3]));
        	_view.myPanel.setKoordinaten(posX[0], posY[0], posX[1], posY[1], posX[2], posY[2]);
        	
        	_view.txtAX.setText(String.valueOf(posX[0]));
        	_view.txtAY.setText(String.valueOf(posY[0]));
        	_view.txtBX.setText(String.valueOf(posX[1]));
        	_view.txtBY.setText(String.valueOf(posY[1]));
        	_view.txtCX.setText(String.valueOf(posX[2]));
        	_view.txtCY.setText(String.valueOf(posY[2]));
        	
        	_view.txtPunktX.setText(String.valueOf(posX[3]));
        	_view.txtPunktY.setText(String.valueOf(posY[3]));
    	}
    	
    	_view.myPanel.repaint();
    }
    
    
    
    //Aktionen:
	
	/**
     * Aktion fuer den Startbutton
     */
    class StartListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            isValidController();
            if(valid){
            	move(Integer.parseInt(_view.getStep()));
            }
            
        }
    }
    
	/**
     * Aktion fuer den Stepbutton
     */
    class StepListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            isValidController();
            if(valid){
            	move(1);
            }
            
        }
    }
    
	/**
     * Aktion fuer den Claerbutton
     */
    class ClearListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	_view.myPanel.points.clear();
        	_view.myPanel.points.add(new Punkt(Integer.parseInt(_view.getPunktX()), Integer.parseInt(_view.getPunktY())));
        	_view.myPanel.repaint();
        }
    }
    
	/**
     * Aktion fuer den Drawbutton
     */
    class DrawListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	drawPyramid();
        }
    }
}

