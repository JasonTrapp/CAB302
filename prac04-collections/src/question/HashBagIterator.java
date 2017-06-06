package question;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public class HashBagIterator<T> implements Iterator<T>{

	private Iterator<Entry<T, Integer>> collectionIterator;
	
	private Entry<T, Integer> current;
	
	private int counter;
	
	public HashBagIterator(Iterator<Entry<T, Integer>> iterator){
		collectionIterator = iterator;
		advanceEntry();
	}
	
	@Override
	public boolean hasNext() {
		return current != null;
	}

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
	
	@Override
	public void remove(){
		throw new UnsupportedOperationException();
	}
	
	private void advanceEntry(){
		do{
			current = collectionIterator.hasNext() ? collectionIterator.next(): null;
		} while(current != null && current.getValue() <= 0);
		
		counter = 1;
	}

}
