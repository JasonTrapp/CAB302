/**
 * 
 */
package guiExplorer;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * @author Jason Trapp
 *
 */
public class Wiring extends JFrame implements ActionListener, Runnable {

	private static final long serialVersionUID = -7031008862559936404L;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	
	private JPanel pnlDisplay;
	private JPanel pnlTwo;
	private JPanel pnlBtn;
	private JPanel pnlFour;
	private JPanel pnlFive;
	
	private JButton btnLoad;
	private JButton btnUnload;
	private JButton btnFind;
	private JButton btnSwitch;
	
	private JTextArea areDisplay; 
		
	/**
	 * Constructor that calls the JFrame superclass
	 */
	public Wiring(String arg0)  throws HeadlessException{
		super(arg0);
	}
	
	/**
	 * Creates the panels and necessary layout.
	 */
	private void createGUI(){
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new BorderLayout());
	    
	    pnlDisplay = createPanel(Color.WHITE);
	    pnlTwo = createPanel(Color.LIGHT_GRAY);
	    pnlBtn = createPanel(Color.LIGHT_GRAY);
	    pnlFour = createPanel(Color.LIGHT_GRAY);
	    pnlFive = createPanel(Color.LIGHT_GRAY);
	    
	    btnLoad = createButton("Load");
	    btnUnload = createButton("Unload");
	    btnFind = createButton("Find");
	    btnSwitch = createButton("Switch");
	    
	    areDisplay = createTextArea();
	    
	    pnlDisplay.setLayout(new BorderLayout());
	    pnlDisplay.add(areDisplay, BorderLayout.CENTER);
	 
	    layoutButtonPanel(); 
	    
	    this.getContentPane().add(pnlDisplay,BorderLayout.CENTER);
	    this.getContentPane().add(pnlTwo,BorderLayout.NORTH);
	    this.getContentPane().add(pnlBtn,BorderLayout.SOUTH);
	    this.getContentPane().add(pnlFour,BorderLayout.EAST);
	    this.getContentPane().add(pnlFive,BorderLayout.WEST);
	    repaint(); 
	    this.setVisible(true);

	}
	
	/**
	 * Create a new JPanel with a certain colour
	 * @param c The colour applied to the JPanel
	 * @return A coloured JPanel
	 */
	private JPanel createPanel(Color c){
		JPanel myPanel = new JPanel();
		myPanel.setBackground(c);
		return myPanel;
	}
	
	private JButton createButton(String str){
		JButton myButton = new JButton(str);
		myButton.addActionListener(this);
		return myButton;
	}
	
	private JTextArea createTextArea(){
		JTextArea text = new JTextArea();
		text.setEditable(false);
		text.setLineWrap(true);
		text.setFont(new Font("Arial", Font.BOLD, 24));
		text.setBorder(BorderFactory.createEtchedBorder());
		return text;
	}
	
	private void layoutButtonPanel(){
		GridBagLayout layout = new GridBagLayout();
		pnlBtn.setLayout(layout);
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 100;
		constraints.weighty = 100;
		
		addToPanel(pnlBtn, btnLoad,constraints,0,0,2,1); 
	    addToPanel(pnlBtn, btnUnload,constraints,3,0,2,1); 
	    addToPanel(pnlBtn, btnFind,constraints,0,2,2,1); 
	    addToPanel(pnlBtn, btnSwitch,constraints,3,2,2,1); 	
	}
	
	/**
	*
	* A convenience method to add a component to given grid bag
	* layout locations. Code due to Cay Horstmann
	*
	* @param c the component to add
	* @param constraints the grid bag constraints to use
	* @param x the x grid position
	* @param y the y grid position
	* @param w the grid width of the component
	* @param h the grid height of the component
	*/
	private void addToPanel(JPanel jp,Component c, GridBagConstraints
				constraints,int x, int y, int w, int h) {
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		jp.add(c, constraints);
	}
	
	/* 
	 * Implements the Runnable method run() to create the GUI.
	 */
	@Override
	public void run() {
		createGUI();
	}

	/* 
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object src = arg0.getSource();
		
		if(src == btnLoad){
			JButton btn = ((JButton) src);
			areDisplay.setText(btn.getText().trim());
		}
		else if(src == btnUnload){
			JButton btn = ((JButton) src);
		    areDisplay.setText(btn.getText().trim());
		}
		else if(src == btnSwitch){
			JOptionPane.showMessageDialog(this, "A warning Message", "Wiring Class: Warning", JOptionPane.WARNING_MESSAGE);
		}
		else if(src == btnFind){
			JOptionPane.showMessageDialog(this,"An Error Message","Wiring Class: Error",JOptionPane.ERROR_MESSAGE);
		}
			
	}

	/**
	 * main method to run the program
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new Wiring("BorderLayout"));
	}

}
