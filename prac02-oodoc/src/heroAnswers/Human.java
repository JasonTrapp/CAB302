package heroAnswers;

import heroQuestions.SuperPower;


/**
 * Some mere mortals are nonetheless "super" heroes thanks to their fearlessness 
 * and training. (Batman is an obvious example.) These superheroes never have 
 * any superpowers.
 * @author Jason Trapp
 * @version 1.0
 */
public class Human extends SuperHero{

	/**
	 * When born a human superhero has a "plain" identity (e.g., "Bruce Wayne"), 
	 * but later in life adopts a secret identity for use when fighting 
	 * crime (e.g., "Batman").
	 * @param the superhero's birth identity
	 * @param the superhero's assumed identity
	 */
	public Human(String realName, String secretIdentity) {
		super(realName, secretIdentity);
	}

	/**
	 * Returns the sum of a human's superpowers (which is always zero).
	 * @return zero
	 */
	@Override
	public boolean hasPower(SuperPower queriedPower) {
		return false;
	}

	/**
	 * Returns the answer to whether or not a human has a particular superpower 
	 * (which is always no).Returns the answer to whether or not a human 
	 * has a particular superpower (which is always no).
	 * @param The superpower in question
	 * @return false
	 */
	@Override
	public int totalPower() {
		return 0;
	}
}
