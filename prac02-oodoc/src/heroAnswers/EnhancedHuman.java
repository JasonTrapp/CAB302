package heroAnswers;

import heroQuestions.SuperPower;

/**
 * An "enhanced" human is born as a mere mortal (e.g., Billy Batson) but later gains the
 *  ability to turn into a superhero (e.g., Captain Marvel) through some magical or science 
 *  fiction plot device (e.g., by saying the name of the wizard "Shazam"). Therefore, when 
 *  an enhanced human switches into their secret (super) identity they also acquire a whole 
 *  collection of superpowers, and lose them again when changing back to their real (non-super) 
 *  identity.
 * @author Jason Trapp
 * 
 */
public class EnhancedHuman extends SuperHero{
	
	private SuperPower[] power;
	
	/**
	 * A superhero of the "enhanced human" variety begins life with no superpowers and a 
	 * mortal identity, but also has an "enhanced" (super) identity, in which he/she acquires 
	 * several superpowers.
	 * @param trueIdentity the superhero's initial, mortal identity
	 * @param alterEgo the superhero's "enhanced" identity, when transformed
	 * @param acquiredPowers the superpowers the hero acquires when in his/her "enhanced" identity
	 */
	public EnhancedHuman(String trueIdentity, String alterEgo, SuperPower[] acquiredPowers) {
		super(trueIdentity, alterEgo);
		power = acquiredPowers;
	}

	/**
	 * Returns the superhero's current "total power" which is the sum of the 
	 * numerical values associated with all of his/her currently-held powers.
	 * @return The numerical sum of the superhero's current powers.
	 */
	public int totalPower() {
		int powerCount = 0;
		if(!super.current.equals(super.trueIdentity)){
			for(SuperPower mypower : power)
				powerCount += mypower.getValue();
			return powerCount;
		}
		return 0;
	}
	
	/**
	 * Switches the hero's current identity to their alter ego. When a hero changes to 
	 * their "super" identity they gain all of their powers. When they switch back to their 
	 * normal identity they lose them again.
	 */
	public void switchIdentity(){
		super.switchIdentity();
	}
	
	/**
	 * Tests to see whether or not the superhero currently has the queried superpower.
	 * @param queriedPower the superpower in question
	 * @return true iff the superhero currently has this power
	 */
	public boolean hasPower(SuperPower queriedPower){
		if(!super.current.equals(super.trueIdentity))
			for(int i = 0; i < power.length; i++){
				if(power[i].equals(queriedPower))
					return true;
			}
		return false;
	}
	
}
