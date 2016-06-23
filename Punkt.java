/**
 * Punktklasse, die x und y Werte eines Punktes speichert
 */
public class Punkt {
	
	private int x;
	private int y;
	
	/**
     * Konstruktor
     */
	public Punkt(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
     * Get Methode fuer X
     */
	public int getX(){
		return x;
	}
	
	/**
     * Get Methode fuer Y
     */
	public int getY(){
		return y;
	}
	
	/**
     * Set Methode fuer X
     */
	public void setX(int x){
		this.x = x;
	}
	
	/**
     * Set Methode fuer Y
     */
	public void setY(int y){
		this.y = y;
	}
}
