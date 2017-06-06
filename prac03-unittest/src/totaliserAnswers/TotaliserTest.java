package totaliserAnswers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import totaliserQuestion.Totaliser;

/**
 * 
 * @author Jason Trapp
 *
 */
public class TotaliserTest {
	Totaliser to;
	
	@Before
	public void intialise(){
		to = new Totaliser();
	}
	
	@Test
	public void test(){
		assertEquals(0, to.getSum());
	}
	
	@Test
	public void test2(){
		to.enterValue(5);
		assertEquals(5, to.getSum());
	}
	
	@Test
	public void test3(){
		to.enterValue(5);
		to.reset();
		assertEquals(0,to.getSum());
	}
	
	@Test
	public void test4(){
		to.enterValue(5);
		to.enterValue(10);
		assertEquals(15, to.getSum());
	}
}
