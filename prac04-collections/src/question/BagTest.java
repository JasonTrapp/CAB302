package question;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * This class contains a few simple tests for the bag type.
 * It is NOT necessarily a comprehensive test suite.  In
 * particular, it does not exercise every possible "boundary"
 * case or example of "misusing" the bag type because some
 * of the responses to such situations depend on your API
 * design for bags.  Having implemented your bag type you
 * should add extra tests to cover design decisions you have
 * made.
 * 
 * Note: If your bag methods may throw exceptions then you
 * will need to add "throws" declarations to some of these
 * tests.
 */
public class BagTest {

	Bag<String> stringBag; // a bag of one type
	Bag<Integer> intBag; // a bag of another type

	@Before @Test /* Create two new bags */
	public void setUp() {
		stringBag = new YourBag<String>(); // <-- insert *your* bag type's name
		intBag = new YourBag<Integer>(); // <-- insert *your* bag type's name
	}

	@Test /* One bag, one kind of element */
	public void singleElementType() {
		stringBag.add("c", 3);
		stringBag.add("c", 6);
		assertEquals(9, stringBag.quantity("c"));
	}

	@Test /* One bag, multiple kinds of element */
	public void multipleElementTypes() {
		stringBag.add("a", 5);
		stringBag.add("b", 3);
		stringBag.add("a", 6);
		stringBag.add("b", 2);
		assertEquals(5, stringBag.quantity("b"));
		assertEquals(11, stringBag.quantity("a"));
	}

	@Test /* Adding and then removing elements */
	public void removingElements() {
		stringBag.add("x", 17);
		stringBag.add("y", 3);
		stringBag.remove("x", 1);
		stringBag.add("x", 6);
		stringBag.remove("x", 2);
		assertEquals(20, stringBag.quantity("x"));
	}

	@Test /* Multiple bags */
	public void multipleBags() {
		intBag.add(86, 5);
		stringBag.add("m", 12);
		stringBag.remove("m", 3);
		intBag.add(86, 8);
		intBag.add(99, 5);
		intBag.add(99, 5);
		assertEquals(9, stringBag.quantity("m"));
		assertEquals(13, intBag.quantity(86));
		assertEquals(10, intBag.quantity(99));
	}

	@Test /* Total size of a bag */
	public void totalSizeEqualsSumOfQuantities() {
		stringBag.add("j", 33);
		stringBag.add("k", 1);
		stringBag.remove("j", 10);
		stringBag.add("i", 6);
		stringBag.remove("i", 2);
		stringBag.add("k", 6);
		assertEquals(stringBag.quantity("i") + stringBag.quantity("j") + 
		             stringBag.quantity("k"), stringBag.size());
	}

	@Test /* Removing all elements */
	public void removeAll() {
		stringBag.add("u", 6);
		stringBag.add("v", 4);
		stringBag.add("u", 2);
		stringBag.remove("u", 8);
		assertEquals(0, stringBag.quantity("u"));
	}

	@Test /* Nonexistent elements */
	public void nonexistent() {
		stringBag.add("f", 3);
		stringBag.add("g", 2);
		assertEquals(0, stringBag.quantity("h"));
	}

	@Test /* Adding nothing */
	public void addNothing() {
		stringBag.add("p", 5);
		stringBag.add("p", 0);
		assertEquals(5, stringBag.quantity("p"));
	}
	
	@Test /* Removing nothing */
	public void removeNothing() {
		stringBag.add("p", 5);
		stringBag.remove("p", 0);
		assertEquals(5, stringBag.quantity("p"));
	}
	
	@Test /* Distinct elements in a bag */
	public void distinctElements() {
		stringBag.add("t", 33);
		stringBag.add("s", 4);
		stringBag.add("t", 6);
		assertEquals(2, stringBag.toSet().size());
		assertTrue(stringBag.toSet().contains("s"));
		assertTrue(stringBag.toSet().contains("t"));
	}
	
	@Test /* Iterating over the elements in a bag */
	public void elementIteration() {
		ArrayList<String> valuesProduced = new ArrayList<String>();
		Object[] sortedValues;
		stringBag.add("r", 1);
		stringBag.add("q", 3);
		stringBag.add("r", 2);
		stringBag.add("q", 1);
		stringBag.add("p", 1);
		for (String element : stringBag)
			valuesProduced.add(element);
		sortedValues = valuesProduced.toArray();
		Arrays.sort(sortedValues);
		assertArrayEquals(new String[] {"p", "q", "q", "q", "q", "r", "r", "r"}, 
		                  sortedValues);
	}

}
