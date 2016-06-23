import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * Panel Klasse, die fuer die Zeichnungen zustaendig ist
 */
public class MyPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private int x1, y1, x2, y2, x3, y3;
	public List<Punkt> points = new ArrayList<Punkt>();
	
	/**
     * Konstruktor
     */
	
	public MyPanel(){
		x1 = y1 = x2 = y2 = x3 = y3 = 0;
		points.add(new Punkt(0,0));
	}
	
	/**
     * Zeichenfunktion die ueberschrieben wird,
     * Zeichne 3 Linien, die die Pyramiden verbinden
     * und alle Punkte an denen gegraben wurde
	 * @param g, Graphics Objekt
     */
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	Graphics2D g2 = (Graphics2D)g;
    	
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHints(rh);
        
        
        //zeichenzeug
        g2.setColor(Color.black);
        g2.drawLine(x1, y1, x2, y2);
        g2.drawLine(x2, y2, x3, y3);
        g2.drawLine(x3, y3, x1, y1);
        
        g2.setColor(Color.red);
        for(Punkt p : points){
        	g2.drawOval(p.getX(), p.getY(), 1, 1);
        }
        
        
        g2.dispose();
    }
    
    /**
     * Setze die Koordinaten der Pyramiden
	 * @param x1 y1 x2 y2 x3 y3,	Koordinaten der Punkte A, B und C
     */
    public void setKoordinaten(int x1, int y1, int x2, int y2, int x3, int y3){
    	this.x1 = x1;
    	this.y1 = y1;
    	
    	this.x2 = x2;
    	this.y2 = y2;
    	
    	this.x3 = x3;
    	this.y3 = y3;
    }
}
