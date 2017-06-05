package heroAnswers;

/**
 * A secret agent has both a name and an alias, usually a number. 
 * In addition, secret agents have a favourite gadget.
 * @author Jason Trapp
 *
 */
public class SecretAgent implements Hero{
	private String gadget, codeName, trueName, current;
	
	/**
	 * A secret agent has a civilian identity and a codename used when on a mission, as well as a number of gadgets.
	 * @param trueName the secret agents's real name
	 * @param codeName the secret agent's identity within his or her organisation
	 * @param gadget the secret agent's favourite gadget
	 */
	public SecretAgent(String trueName, String codeName, String gadget){
		this.gadget = gadget;
		this.trueName = trueName;
		this.codeName = codeName;
		this.current = trueName;
	}
	
	/**
	 * Returns the hero's current identity in a printable format.
	 * @return the hero's current identity
	 */
	@Override
	public String currentIdentity() {
		return this.current;
	}

	/**
	 * Switches the hero's current identity to their alter ego.
	 */
	@Override
	public void switchIdentity() {
		if(current.equals(trueName))
			this.current = this.codeName;
		else
			this.current = this.trueName;
	}

	/**
	 * Identifies the secret agent's favourite gadget.
	 * @return a description of the gadget
	 */
	public String getGadget(){
		return this.gadget;
	}
}
