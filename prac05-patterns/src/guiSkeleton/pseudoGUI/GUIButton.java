/**
 * 
 */
package guiSkeleton.pseudoGUI;

import guiSkeleton.guiEvents.GUIEvent;
import guiSkeleton.guiEvents.GUIEventListener;
import guiSkeleton.guiEvents.GUIEventSource;

import java.util.ListIterator;
import java.util.Vector;


/**
 * The Concrete Subject class for the Observer Pattern example 
 * @author hogan
 *
 */
public class GUIButton implements GUIEventSource {
	private String name; 
	private boolean clicked;
	private Vector<GUIEventListener> guiEventListerners;
	
	public GUIButton(String nm) {
		this.name=nm;
		this.clicked=false; 
		this.guiEventListerners = XXXXXX;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void doClick() {
		XXXXXX;
		XXXXXX;
		XXXXXX;
	}

	@Override
	public void fireGUIEvent() {
		ListIterator<GUIEventListener> iter = this.guiEventListerners.listIterator();
		while (iter.hasNext()) {
			iter.next().guiActionPerformed(new GUIEvent(this));
		}
	}

	@Override
	public void addGUIEventListener(GUIEventListener gel) {
		XXXXXX;
	}

	@Override
	public void removeGUIEventListener(GUIEventListener gel) {
		XXXXXX;
	}
	
	@Override
	public String toString() { 
		return "guiButton:" + this.name; 
	}
}
