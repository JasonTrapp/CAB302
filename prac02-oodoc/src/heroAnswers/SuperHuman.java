package heroAnswers;

import java.util.HashSet;

import heroQuestions.SuperPower;

/**
 * A superhuman is born with "powers and abilities far beyond those of mortal men" 
 * (e.g., the Amazonian Wonder Woman) but usually adopts a mild-mannered secret identity 
 * (e.g., "Diana Prince"). However, under certain circumstances a superhuman may lose 
 * some of their powers (e.g., when Superman is exposed to gold kryptonite), may later regain 
 * lost ones, or may acquire entirely new powers.
 * @author Jason Trapp
 *
 */
public class SuperHuman extends SuperHero{
	HashSet<SuperPower> powers = new HashSet<SuperPower>();
	
	/**
	 * When born a superhuman has a real (super) name and later adopts a secret (non-super) 
	 * identity. A superhuman also has a collection of innate superpowers at birth. If the 
	 * given collection of superpowers contains duplicates the unnecessary ones are ignored.
	 * @param trueIdentity the superhuman's true identity
	 * @param alterEgo the superhuman's adopted identity
	 * @param acquiredPowers the superhuman's original superpowers
	 */
	public SuperHuman(String trueIdentity, String alterEgo, SuperPower[] acquiredPowers) {
		super(trueIdentity, alterEgo);
		for(SuperPower pow : acquiredPowers)
			powers.add(pow);
	}

	/**
	 * Tests to see whether or not the superhero currently has the queried superpower.
	 * @param the superpower in question
	 * @return true iff the superhero currently has this power
	 */
	public boolean hasPower(SuperPower queriedPower) {
		for(SuperPower pow : powers)
			if(pow.equals(pow))
				return true;
		return false;
	}

	/**
	 * Returns the superhero's current "total power" which is the sum of the numerical
	 * values associated with all of his/her currently-held powers.
	 * @return the numerical sum of the superhero's current powers
	 */
	public int totalPower() {
		int powerCount = 0;
		for(SuperPower pow : powers)
			powerCount += pow.getValue();
		return powerCount;
	}
	
	/**
	 * Adds the given collection of new superpowers to those already possessed. No 
	 * action is taken for powers already owned by the superhero, i.e., a superhero 
	 * can't have the same superpower twice.
	 * @param newPowers the new powers to be added, if not already owned
	 */
	public void acquirePowers(heroQuestions.SuperPower[] newPowers){
		for(SuperPower e : newPowers)
			powers.add(e);
	}

	/**
	 * Removes the given collection of superpowers from those possessed by the superhero. 
	 * No action is taken for powers not currently owned by the superhero, 
	 * i.e., you can't take away a power that the hero doesn't have.
	 * @param oldPowers the existing powers to be retracted, if currently possessed
	 */
	public void losePowers(heroQuestions.SuperPower[] oldPowers){
		for(SuperPower e : oldPowers)
			powers.remove(e);
	}
}
