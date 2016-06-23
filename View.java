import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * View Klasse fuer den Graphischen Kontent
 */
public class View extends JFrame implements ItemListener{
    
    //Panels:
    private JPanel pnlLinks = new JPanel();
    private JPanel pnlA     = new JPanel();
    private JPanel pnlB     = new JPanel();
    private JPanel pnlC     = new JPanel();
    private JPanel pnlPunkt = new JPanel();
    private JPanel pnlStart = new JPanel();
    private JPanel pnlStep  = new JPanel();
    private JPanel pnlDraw  = new JPanel();
    private JPanel pnlMitte = new JPanel();
    
    public MyPanel myPanel;
    
    //Labels:
    private JLabel lblA     = new JLabel("A:");
    private JLabel lblB     = new JLabel("B:");
    private JLabel lblC     = new JLabel("C:");
    private JLabel lblPunkt = new JLabel("Punkt:");
    
    //Textfelder:
    public JTextField txtAX     = new JTextField("400",3);
    public JTextField txtAY     = new JTextField("400",3);
    public JTextField txtBX     = new JTextField("100",3);
    public JTextField txtBY     = new JTextField("400",3);
    public JTextField txtCX     = new JTextField("250",3);
    public JTextField txtCY     = new JTextField("140",3);
    public JTextField txtPunktX     = new JTextField("250",3);
    public JTextField txtPunktY     = new JTextField("313",3);
    public JTextField txtStep       = new JTextField("50",3);
    
    //Buttons:
    private JButton cmdStart    = new JButton("Start");
    private JButton cmdStep     = new JButton("Step");
    private JButton cmdClear    = new JButton("Clear");
    private JButton cmdDraw     = new JButton("Draw");
    
    private JRadioButton rdbStandard = new JRadioButton("Gleichseitig, Mitte",true);
    private JRadioButton rdbEingeben = new JRadioButton("Eingeben, Eingeben");
    private JRadioButton rdbZufall = new JRadioButton("Zufall, Zufall");
    private ButtonGroup gruppe = new ButtonGroup();

    /**
     * Setzt den Titelnamen und baut die GUI
     */
    public View(){
        super("Fluch Des Pharao");
        initForm();
    }

    /**
     * Ordnet GUI-Elemente an
     */
    public void initForm(){
        myPanel = new MyPanel();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(750,500);
       
       pnlLinks.setLayout(new BoxLayout(pnlLinks,BoxLayout.Y_AXIS));
       this.add(pnlLinks,BorderLayout.WEST);
       this.add(pnlMitte,BorderLayout.CENTER);
       
       pnlLinks.add(rdbStandard);
       pnlLinks.add(rdbEingeben);
       pnlLinks.add(rdbZufall);
       
       pnlLinks.add(pnlA);
       pnlLinks.add(pnlB);
       pnlLinks.add(pnlC);
       
       pnlLinks.add(pnlPunkt);
       pnlLinks.add(pnlStart);
       pnlLinks.add(pnlStep);
       pnlLinks.add(pnlDraw);
       add(myPanel, BorderLayout.CENTER);
       
       pnlA.add(lblA);
       pnlA.add(txtAX);
       pnlA.add(txtAY);
       pnlB.add(lblB);
       pnlB.add(txtBX);
       pnlB.add(txtBY);
       pnlC.add(lblC);
       pnlC.add(txtCX);
       pnlC.add(txtCY);
       pnlPunkt.add(lblPunkt);
       pnlPunkt.add(txtPunktX);
       pnlPunkt.add(txtPunktY);
       pnlStart.add(cmdStart);
       pnlStart.add(txtStep);
       pnlStep.add(cmdStep);
       pnlStep.add(cmdClear);
       pnlDraw.add(cmdDraw);
       gruppe.add(rdbStandard);
       gruppe.add(rdbZufall);
       gruppe.add(rdbEingeben);
       
       rdbStandard.addItemListener(this);
       rdbEingeben.addItemListener(this);
       rdbZufall.addItemListener(this);
       
       sichtbarkeit(false);
              
       this.pnlLinks.setVisible(true);
    }
    /**
     * Prueft ob man die Radionbuttons drückt
     * 
     * @param ev Das drückevent
     */
    public void itemStateChanged(ItemEvent ev){
        if(rdbStandard.isSelected()){
            sichtbarkeit(false);
        }
        if(rdbZufall.isSelected()){
            sichtbarkeit(false);
        }
        if(rdbEingeben.isSelected()){
            sichtbarkeit(true);
        }
    
    }
    /**
     * Blendet nicht bönigte Bedienelemente aus oder ein
     * 
     * @param x Ein oder ausblenden
     */
    public void sichtbarkeit(boolean x){
        lblA.setVisible(x);
        lblA.setVisible(x);
        lblB.setVisible(x);
        lblB.setVisible(x);
        lblC.setVisible(x);
        lblC.setVisible(x);
        lblPunkt.setVisible(x);
        lblPunkt.setVisible(x);
        txtAX.setVisible(x);
        txtAY.setVisible(x);
        txtBX.setVisible(x);
        txtBY.setVisible(x);
        txtCX.setVisible(x);
        txtCY.setVisible(x);
        txtPunktX.setVisible(x);
        txtPunktY.setVisible(x);
    }
    
    //Die Ganzen Getter
	
	/**
	 * Get Methode fuer A x
	 */
    public String getAX(){
        return this.txtAX.getText();
    }
	
	/**
	 * Get Methode fuer A y
	 */
    public String getAY(){
        return this.txtAY.getText();
    }
	
	/**
	 * Get Methode fuer B x
	 */
    public String getBX(){
        return this.txtBX.getText();
    }
	
	/**
	 * Get Methode fuer B y
	 */
    public String getBY(){
        return this.txtBY.getText();
    }
	
	/**
	 * Get Methode fuer C x
	 */
    public String getCX(){
        return this.txtCX.getText();
    }
	
	/**
	 * Get Methode fuer C y
	 */
    public String getCY(){
        return this.txtCY.getText();
    }
	
	/**
	 * Get Methode fuer Startpunkt x
	 */
    public String getPunktX(){
        return this.txtPunktX.getText();
    }
	
	/**
	 * Get Methode fuer STartpunkt y
	 */
    public String getPunktY(){
        return this.txtPunktY.getText();
    }
	
	/**
	 * Get Methode fuer den Step Wert
	 */
    public String getStep(){
        return this.txtStep.getText();
    }
    
    //Actionlistener Buttons:
	
	/**
	 * Fuegt ActionListener zum Start Button hinzu
	 */
    public void setStartListener(ActionListener l){
        this.cmdStart.addActionListener(l);
    }
	
	/**
	 * Fuegt ActionListener zum Step Button hinzu
	 */
    public void setStepListener(ActionListener l){
        this.cmdStep.addActionListener(l);
    }
	
	/**
	 * Fuegt ActionListener zum Clear (Loeschen der Punkte) Button hinzu
	 */
    public void setClearListener(ActionListener l){
        this.cmdClear.addActionListener(l);
    }
	
	/**
	 * Fuegt ActionListener zum Draw Button hinzu
	 */
    public void setDrawListener(ActionListener l){
        this.cmdDraw.addActionListener(l);
    }
    
    
    //Radiobuttons:
	
	/**
	 * Fragt ab, ob der Standard Radio Buttoin gedrueckt ist
	 * @return boolean
	 */
    public boolean getStandard(){
        return rdbStandard.isSelected();
    }
	
	/**
	 * Fragt ab, ob der Zufall Radio Buttoin gedrueckt ist
	 * @return boolean
	 */
    public boolean getZufall(){
        return rdbZufall.isSelected();
    }
	
	/**
	 * Fragt ab, ob der Eingabe Radio Buttoin gedrueckt ist
	 * @return boolean
	 */
    public boolean getEingeben(){
        return rdbEingeben.isSelected();
    }
    
    
    /**
     * Faerbt die Startknoepfe Gruen oder Rot je nach dem ob die
     * Eingaben korrekt sind oder nicht
     * 
     * @param valid Ob die einstellungen erlaubt sind oder nicht
     */
    public void farbe(boolean valid){
        if(valid){
            cmdStart.setBackground(Color.GREEN);
            cmdStep.setBackground(Color.GREEN);
        }else{
            cmdStart.setBackground(Color.RED);
            cmdStep.setBackground(Color.RED);
        }
         
    }
}

