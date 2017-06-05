package heroAnswers;

import java.util.HashSet;

import heroQuestions.SuperPower;

public class SuperHuman extends SuperHero{
	HashSet<SuperPower> powers = new HashSet<SuperPower>();
	
	public SuperHuman(String trueIdentity, String alterEgo, SuperPower[] acquiredPowers) {
		super(trueIdentity, alterEgo);
		for(SuperPower pow : acquiredPowers)
			powers.add(pow);
	}

	@Override
	public boolean hasPower(SuperPower queriedPower) {
		for(SuperPower pow : powers)
			if(pow.equals(pow))
				return true;
		return false;
	}

	@Override
	public int totalPower() {
		int powerCount = 0;
		for(SuperPower pow : powers)
			powerCount += pow.getValue();
		return powerCount;
	}
	
	public void acquirePowers(heroQuestions.SuperPower[] newPowers){
		for(SuperPower e : newPowers)
			powers.add(e);
	}

	public void losePowers(heroQuestions.SuperPower[] oldPowers){
		for(SuperPower e : oldPowers)
			powers.remove(e);
	}
}
