package heroAnswers;


/**
 * A feature common to all the heroes of interest in this exercise
 *  is that they have (at least) two identities, a "super" or "secret" 
 *  one used when performing heroic feats and a "plain" one that allows 
 *  them to move through society without attracting attention.
 * @author Jason Trapp
 * @version 1.0
 */
public interface Hero {
	/**
	 * Returns the hero's current identity in a printable format.
	 * @return the hero's current identity
	 */
	public String currentIdentity();
	
	/**
	 * Switches between the hero's identities.
	 */
	public void switchIdentity();
}
