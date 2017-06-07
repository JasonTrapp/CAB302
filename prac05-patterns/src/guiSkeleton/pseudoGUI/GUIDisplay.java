package guiSkeleton.pseudoGUI;

import guiSkeleton.guiEvents.GUIEvent;
import guiSkeleton.guiEvents.GUIEventListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class which displays the actionPerformed to console
 * @author Jason Trapp
 *
 */
public class GUIDisplay implements GUIEventListener {
	public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	private String regionName;
	
	/**
	 * Constructor which sets the region name
	 * @param rn The region name being added
	 */
	public GUIDisplay(String rn) {
		this.regionName=rn;
	}

	/**
	 * Prints the action to the console
	 * @param ge Gets the type of action performed
	 */
	@Override
	public void guiActionPerformed(GUIEvent ge) {
		String str = this.regionName+ ":" + ge.toString() + ":" + ge.getSource().toString()+ 
		":" + this.now();
		System.out.println(str);
	}

	/**
	 * Returns the current date and time in a readable format
	 * @return A printable String of the date and time
	 */
	private String now() {
	  Calendar cal = Calendar.getInstance();
	  SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	  return sdf.format(cal.getTime());
    }
	

}
