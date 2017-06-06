package journeyPlannerAnswers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import journeyPlannerQuestion.*;

public class JourneyPlannerTests {
	JourneyPlannerA planner;
	
	@Before
	public void newPlanner() throws Exception {
		planner = new JourneyPlannerA(3);
	}

	@Test
	public void normalCase() {
		planner.setOrigin(0, 1);
		planner.setDestination(3, 4);
		assertEquals(planner.journeyTime(), 18);
	}

	@Test
	public void alongTheBorder() {
		planner.setOrigin(0, 0);
		planner.setDestination(10, 0);
		assertEquals(planner.journeyTime(), 30);
	}

	@Test
	public void changeDestination() {
		planner.setOrigin(5, 1);
		planner.setDestination(2, 3);
		planner.setDestination(1, 2);
		assertEquals(planner.journeyTime(), 15);
	}

	@Test
	public void goingNowhere() {
		planner.setOrigin(8, 9);
		planner.setDestination(8, 9);
		assertEquals(planner.journeyTime(), 0);
	}

	@Test
	public void longestJourney() {
		planner.setOrigin(0, 0);
		planner.setDestination(10, 10);
		assertEquals(planner.journeyTime(), 60);
	}

	@Test
	public void towardsZeroZero() {
		planner.setOrigin(6, 5);
		planner.setDestination(1, 2);
		assertEquals(planner.journeyTime(), 24);
	}
	
	@Test
	public void startingAtTen() {
		planner.setOrigin(10, 2);
		planner.setDestination(8, 5);
		assertEquals(planner.journeyTime(), 15);
	}
}
