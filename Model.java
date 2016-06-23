import java.util.*;

/**
 * Model Klasse fuer Berechnungen
 */
public class Model 
{   
    private int rechts = 540;
    private int links = 000;
    private int oben = 0;
    private int unten = 470;
    
    /**
     * Prueft ob das Dreieck und der Startpunkt in der 
     * Zeichenflaeche liegen.
     * 
     * @param AX Punkt A die X-Koordinate
     * @param AY Punkt A die Y-Koordinate
     * @param BX Punkt B die X-Koordinate
     * @param BY Punkt B die Y-Koordinate
     * @param CX Punkt C die X-Koordinate
     * @param CY Punkt C die Y-Koordinate
     * @param PX Die X-Koordinate des Startpunktes
     * @param PY Die Y-Koordinate des Startpunktes
     */
    public boolean punkteInZeichenebene(int AX, int AY, int BX, int BY, int CX, int CY, int PX, int PY){
        if(AX >= links && AX <= rechts &&
        BX >= links && BX <= rechts &&
        CX >= links && CX <= rechts &&
        PX >= links && PX <= rechts &&
        AY >= oben && AY <= unten &&
        BY >= oben && BY <= unten &&
        CY >= oben && CY <= unten &&
        PY >= oben && PY <= unten){
            return true;
        }else{
            return false;
        }
        
    }
    /**
     * Berechnet ob der Punkt im Dreieck liegt,
     * mit Hilfe der Gausschen Flaechenformel
     * 
     * @param AX Punkt A die X-Koordinate
     * @param AY Punkt A die Y-Koordinate
     * @param BX Punkt B die X-Koordinate
     * @param BY Punkt B die Y-Koordinate
     * @param CX Punkt C die X-Koordinate
     * @param CY Punkt C die Y-Koordinate
     * @param PX Die X-Koordinate des Startpunktes
     * @param PY Die Y-Koordinate des Startpunktes
     */
    public boolean punktImDreieck(int AX, int AY, int BX, int BY, int CX, int CY, int PX, int PY){
        int ABC, ABCP, ABPC, APBC;
        
        ABC = AX * (BY-CY) + BX * (CY-AY) + CX * (AY-BY);
        ABCP = AX * (BY-PY) + BX * (CY-AY) + CX * (PY-BY) + PX * (AY-CY);
        ABPC = AX * (BY-CY) + BX * (PY-AY) + PX * (CY-BY) + CX * (AY-PY);
        APBC = AX * (PY-CY) + PX * (BY-AY) + BX * (CY-PY) + CX * (AY-BY);
        if(ABC < 0){ABC *= -1;}
        if(ABCP < 0){ABCP *= -1;}
        if(ABPC < 0){ABPC *= -1;}
        if(APBC < 0){APBC *= -1;}
        
        if( (ABCP-ABC) > 0 || (ABPC-ABC) > 0 || (APBC-ABC) > 0){
            return false;
        }
        
        return true;
    }
    /**
     * Prueft ob:
     * 1) Die Eintraege nicht leer sind
     * 2) Die Eintraege integer sind
     * 3) Keine Dreieckseckpunkte doppelt auftreten
     * 4) Der Eintrag des Stepfeldes > 0 ist
     * 5) Ob der Punkt im Dreieck liegt
     * 6) Ob alles in der Zeichenflaeche liegt
     *
     * @param AX Punkt A die X-Koordinate
     * @param AY Punkt A die Y-Koordinate
     * @param BX Punkt B die X-Koordinate
     * @param BY Punkt B die Y-Koordinate
     * @param CX Punkt C die X-Koordinate
     * @param CY Punkt C die Y-Koordinate
     * @param PunktX Die X-Koordinate des Startpunktes
     * @param PunktY Die Y-Koordinate des Startpunktes
     * @param Step Der Eintrag des Step-Feldes
     */
    
    public boolean isValid(String AX, String AY, String BX, String BY, String CX, String CY, String PunktX, String PunktY, String Step){
        boolean temp = true;
        try{
        try{
        Integer.parseInt(AX);
        Integer.parseInt(AY);
        Integer.parseInt(BX);
        Integer.parseInt(BY);
        Integer.parseInt(CX);
        Integer.parseInt(CY);
        Integer.parseInt(PunktX);
        Integer.parseInt(PunktY);
        Integer.parseInt(Step);
       
        if(Integer.parseInt(AX) == Integer.parseInt(BX) && 
        Integer.parseInt(AY) == Integer.parseInt(BY) ||
        Integer.parseInt(AX) == Integer.parseInt(CX) &&
        Integer.parseInt(AY) == Integer.parseInt(CY) ||
        Integer.parseInt(BX) == Integer.parseInt(CX) &&
        Integer.parseInt(BY) == Integer.parseInt(CY) ){
            temp = false;
           
        }else{
          
            if(Integer.parseInt(Step) <= 0 ){
                temp = false;
               
            }else{
                temp = punktImDreieck(Integer.parseInt(AX),Integer.parseInt(AY), 
                Integer.parseInt(BX),  Integer.parseInt(BY),
                Integer.parseInt(CX),  Integer.parseInt(CY),
                Integer.parseInt(PunktX),  Integer.parseInt(PunktY));
                if(temp){
                    temp = punkteInZeichenebene(Integer.parseInt(AX),Integer.parseInt(AY), 
                    Integer.parseInt(BX),  Integer.parseInt(BY),
                    Integer.parseInt(CX),  Integer.parseInt(CY),
                    Integer.parseInt(PunktX),  Integer.parseInt(PunktY));
                }
            }
        }
        
        
        }catch(NumberFormatException e){
            temp = false;
        }
        }catch(NullPointerException p){
            temp = false;
        }
    
        return temp;
    }
}

