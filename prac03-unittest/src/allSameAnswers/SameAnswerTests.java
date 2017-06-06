package allSameAnswers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import allSameQuestion.*;

public class SameAnswerTests {
	AllSameA a;
	AllSameB b;
	AllSameC c;
	
	@Before
	public void instantiate(){
		a = new AllSameA();
		b = new AllSameB();
		c = new AllSameC();
	}
	
	@Test(expected = Exception.class)
	public void emptyArr() throws Exception{
		int[] arr = {};
		assertTrue(a.same(arr));
	}
	
	@Test
	public void arr1Elem() throws Exception{
		int[] arr = {1};
		assertTrue(a.same(arr));
	}
	
	@Test(expected = Exception.class)
	public void negativeNum() throws Exception{
		int[] arr = {-1};
		assertTrue(a.same(arr));
	}
	
	@Test(expected = Exception.class)
	public void sameBEmpty() throws Exception{
		int[] arr = {};
		assertFalse(b.same(arr));
	}
	
	@Test
	public void sameBSame() throws Exception{
		int[] arr = {5,5,5};
		assertTrue(b.same(arr));
	}
	
	@Test
	public void sameBDiff() throws Exception{
		int[] arr = {1,2,3};
		assertFalse(b.same(arr));
	}
	
	@Test(expected = Exception.class)
	public void sameCEmpty() throws Exception{
		int[] arr = {};
		assertTrue(c.same(arr));
	}
	
	@Test
	public void sameCSame() throws Exception{
		int[] arr = {5,5,5};
		assertTrue(c.same(arr));
	}
	
	@Test
	public void sameCDiff() throws Exception{
		int[] arr = {2,3,4};
		assertFalse(c.same(arr));
	}
	
	@Test(expected = Exception.class)
	public void sameCNeg() throws Exception{
		int[] arr = {-1};
		assertTrue(c.same(arr));
	}
	
}
