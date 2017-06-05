package footyAnswers;

/**
 * An Australian Rules football score consists of a number of points, 
 * accumulated by kicking goals and behinds.
 * @author Jason Trapp
 * @version 1.0
 */
public class FootyScore {
		private int score, behind, goals;
		
		/**
		 * Function that returns the score of the current team.
		 * @return score of the team
		 */
		public int getPoints(){
			return this.score;
		}
		
		/**
		 * Method that updates the score and amount of goals kicked by a team.
		 */
		public void kickGoal(){
			this.score += 6;
			this.goals++;
		}
		
		/**
		 * Method that updates the score and amount of behinds kicked by the team.
		 */
		public void kickBehind(){
			this.score +=1;
			this.behind++;
		}
		
		/**
		 * Function that gets the amount of goals, behinds and score of a team into one string
		 * @return String of goal, behinds and score
		 */
		public String sayScore(){
			return this.goals + " " + this.behind + " " + this.score;
		}
		
		/**
		 * Function that gets boolean value by comparing teams points
		 * @param e The opposing team
		 * @return True ifamount of goals by current team are greater than amount from other team.
		 */
		public boolean inFrontOf(FootyScore e){
			if(e.getPoints() < this.getPoints())
				return true;
			else
				return false;
		}
		
		/**
		 * Constructor that resets the amount of goals, behinds and score of team.
		 */
		public FootyScore(){
			this.score = 0;
			this.behind = 0;
			this.goals = 0;
		}
}
