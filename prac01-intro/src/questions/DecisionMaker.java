package questions;

/**
 * Determines if a team should accept a project depending on length and difficulty
 * of project
 * @author Jason Trapp
 * @version 1.1
 */


public class DecisionMaker {

	/* Put your "decision" method here, assuming the parameters are
	 * the number of months required to complete the job and the
	 * perceived level of difficulty, on a 1 to 10 scale
	 */
	public static String decision(int months, int scale){
		//Short and Hard
		if(months <= 3 && scale >= 7)
			return "decline";
		//Short and easy and long and hard
		else if((months <= 3 && scale < 7) || (months > 3 && scale >= 7))
			return "discuss";
		else
			return "accept";
	}
	
	/* Main program that tests the "decision" function */
	public static void main(String[] args) {
		/* Project 1: Easy with plenty of time */
		System.out.println("You should " + decision(12, 1) + " Project 1");
		/* Project 2: Hard with very little time */
		System.out.println("You should " + decision(1, 9) + " Project 2");
		/* Project 3: Easy but with little time */
		System.out.println("You should " + decision(2, 5) + " Project 3");
		/* Project 4: Hard but with lots of time */
		System.out.println("You should " + decision(12, 8) + " Project 4");
	}

}
