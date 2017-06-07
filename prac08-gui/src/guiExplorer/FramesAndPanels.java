/**
 * 
 */
package guiExplorer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.*;
/**
 * @author Jason Trapp
 *
 */
public class FramesAndPanels extends JFrame implements ActionListener, Runnable {

	private static final long serialVerionUID = -7031008862559936404L;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	
	private JPanel pnlOne;
	private JPanel pnlTwo;
	private JPanel pnlThree;
	private JPanel pnlFour;
	private JPanel pnlFive;
	
	/**
	 * Constructor that calls the JFrame superclass
	 */
	public FramesAndPanels(String arg0) {
		super(arg0);
	}

	/* 
	 * Implements the Runnable method run() to create the GUI.
	 */
	@Override
	public void run() {
		createGUI();
	}

	/* 
	 * Deals with any action performed, since no actions are considered this is blank
	 * Only added for because of how inheritance.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

	}
	
	/**
	 * Creates the panels and necessary layout.
	 */
	private void createGUI(){
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		pnlOne = createPanel(Color.WHITE);
		pnlTwo = createPanel(Color.BLACK);
		pnlThree = createPanel(Color.RED);
		pnlFour = createPanel(Color.GREEN);
		pnlFive = createPanel(Color.BLUE);
		
		this.getContentPane().add(pnlOne, BorderLayout.CENTER);
		this.getContentPane().add(pnlTwo, BorderLayout.CENTER);
		this.getContentPane().add(pnlThree, BorderLayout.CENTER);
		this.getContentPane().add(pnlFour, BorderLayout.CENTER);
		this.getContentPane().add(pnlFive, BorderLayout.CENTER);
		
		repaint();
		this.setVisible(true);

	}
	
	/**
	 * Create a new JPnel with a certain colour
	 * @param c The colour applied to the JPanel
	 * @return A coloured JPanel
	 */
	private JPanel createPanel(Color c){
		JPanel myPanel = new JPanel();
		myPanel.setBackground(c);
		return myPanel;
	}

	/**
	 * main method to run the program
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new FramesAndPanels("BorderLayout"));
	}

}
