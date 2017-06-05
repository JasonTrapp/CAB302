package heroAnswers;

import heroQuestions.SuperPower;

public class EnhancedHuman extends SuperHero{
	
	public EnhancedHuman(String trueIdentity, String alterEgo) {
		super(trueIdentity, alterEgo);
	}

	@Override
	public boolean hasPower(SuperPower queriedPower) {
		return false;
	}

	@Override
	public int totalPower() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getIdentity() {
		return null;
	}
	
	public void switchIdentity(){
		
	}
	
	public boolean hasPower(){
		
		return true;
	}
	
}
