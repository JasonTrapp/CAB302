package heroAnswers;

import heroQuestions.SuperPower;

public class EnhancedHuman extends SuperHero{
	
	private SuperPower[] power;
	
	public EnhancedHuman(String trueIdentity, String alterEgo, SuperPower[] acquiredPowers) {
		super(trueIdentity, alterEgo);
		power = acquiredPowers;
	}

	@Override
	public int totalPower() {
		int powerCount = 0;
		if(!super.current.equals(super.trueIdentity)){
			for(SuperPower mypower : power)
				powerCount += mypower.getValue();
			return powerCount;
		}
		return 0;
	}
	
	public void switchIdentity(){
		super.switchIdentity();
	}
	
	public boolean hasPower(SuperPower queriedPower){
		if(!super.current.equals(super.trueIdentity))
			for(int i = 0; i < power.length; i++){
				if(power[i].equals(queriedPower))
					return true;
			}
		return false;
	}
	
}
