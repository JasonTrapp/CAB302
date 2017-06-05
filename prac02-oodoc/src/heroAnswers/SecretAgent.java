package heroAnswers;

public class SecretAgent implements Hero{
	private String gadget, codeName, trueName, current;
	
	public SecretAgent(String trueName, String codeName, String gadget){
		this.gadget = gadget;
		this.trueName = trueName;
		this.codeName = codeName;
		current = trueName;
	}
	
	@Override
	public String currentIdentity() {
		return current;
	}

	@Override
	public void switchIdentity() {
		if(current.equals(trueName))
			current = codeName;
		else
			current = trueName;
	}

	public String getGadget(){
		
		return gadget;
	}
}
