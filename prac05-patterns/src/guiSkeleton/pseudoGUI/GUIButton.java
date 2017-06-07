/**
 * 
 */
package guiSkeleton.pseudoGUI;

import guiSkeleton.guiEvents.GUIEvent;
import guiSkeleton.guiEvents.GUIEventListener;
import guiSkeleton.guiEvents.GUIEventSource;

import java.util.ArrayList;
import java.util.ListIterator;


/**
 * The Concrete Subject class for the Observer Pattern example 
 * @author Jason Trapp
 *
 */
public class GUIButton implements GUIEventSource {
	private String name; 
	private boolean clicked;
	private ArrayList<GUIEventListener> guiEventListerners;
	
	/**
	 * Constructor of the GUIButton class, set the name of the button
	 * initialize the click status to false and initialize a new ArrayList
	 * @param nm Name of the new button
	 */
	public GUIButton(String nm) {
		this.name=nm;
		this.clicked=false; 
		this.guiEventListerners = new ArrayList<GUIEventListener>();
	}
	
	/**
	 * Function which gets the name of the button
	 * @return The name of the button
	 */
	public String getName() {
		return name;
	}

	/**
	 * Change the name of the button.
	 * @param name The new name of the button
	 * @return The new name of the button
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Implementation of the doClick, when clicked triggers the GUI event
	 */
	@Override
	public void doClick() {
		clicked = true;
		fireGUIEvent();
		clicked = false;
	}

	/**
	 * Implementation of the GUI execution event
	 */
	@Override
	public void fireGUIEvent() {
		ListIterator<GUIEventListener> iter = this.guiEventListerners.listIterator();
		while (iter.hasNext()) {
			iter.next().guiActionPerformed(new GUIEvent(this));
		}
	}

	/**
	 * Adds a listener to the eventListener
	 */
	@Override
	public void addGUIEventListener(GUIEventListener gel) {
		this.guiEventListerners.add(gel);
	}

	/**
	 * Removes a listener from the eventListner
	 */
	@Override
	public void removeGUIEventListener(GUIEventListener gel) {
		this.guiEventListerners.remove(gel);
	}
	
	/**
	 * Gets the name of the button into a string
	 * @return the name of the button with prepended name
	 */
	@Override
	public String toString() { 
		return "guiButton:" + this.name; 
	}
}
