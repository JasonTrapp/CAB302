package heroAnswers;

import heroQuestions.SuperPower;

public abstract class SuperHero implements Hero{
	protected String trueIdentity;
	private String alterEgo;
	protected String current;

	/**
	 * Returns the hero's current identity in a printable format.
	 * @return The hero's current identity
	 */
	public String currentIdentity(){
		return this.current;
	}
	
	/**
	 * Switches the hero's current identity to their alter ego.
	 */
	public void switchIdentity(){
		if(current.equals(trueIdentity))
			current = alterEgo;
		else
			current = trueIdentity;
	}
	
	/**
	 * Tests to see whether or not the superhero currently 
	 * has the queried superpower.
	 * @param The superpower in Question
	 * @return true iff the superhero currently has this power
	 */
	public abstract boolean hasPower(SuperPower queriedPower);
	
	/**
	 * Returns the superhero's current "total power" which is 
	 * the sum of the numerical values associated with all of 
	 * his/her currently-held powers.
	 * @return the numerical sum of the superhero's current powers
	 */
	public abstract int totalPower();
	
	public SuperHero(String trueIdentity, String alterEgo){
		this.trueIdentity = trueIdentity;
		this.alterEgo = alterEgo;
		this.current = trueIdentity;
	}
}
