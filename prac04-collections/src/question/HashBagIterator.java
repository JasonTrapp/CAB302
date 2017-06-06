package question;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public class HashBagIterator<T> implements Iterator<T>{

	private Iterator<Entry<T, Integer>> collectionIterator;
	
	private Entry<T, Integer> current;
	
	private int counter;
	
	/**
	 * Instantiates the Iterator object
	 */
	public HashBagIterator(Iterator<Entry<T, Integer>> iterator){
		collectionIterator = iterator;
		advanceEntry();
	}
	
	/**
	 * Checks if the iterator has another value.
	 * @return return true if there is another value, false otherwise
	 */
	@Override
	public boolean hasNext() {
		return current != null;
	}

	/**
	 * Method which gets the next items in iterator object
	 * @return returns a generic type which is the next item
	 */
	@Override
	public T next() {
		if(current == null)
			throw new NoSuchElementException();
		
		T nextItem = current.getKey();
		
		if(counter == current.getValue())
			advanceEntry();
		else
			counter++;
		
		return nextItem;
	}
	
	/**
	 * Removes next item but throws exception.
	 */
	@Override
	public void remove(){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Advance the current entry to the next available entry
	 * containing a positive number of items (as it is not meaningful to repeat
	 * zero or fewer times). If we have reached the end of the underlying
	 * collection, current entry will be null. The current counter is set to 1
	 */
	private void advanceEntry(){
		do{
			current = collectionIterator.hasNext() ? collectionIterator.next(): null;
		} while(current != null && current.getValue() <= 0);
		
		counter = 1;
	}

}
