package question;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashBag<T> extends Bag<T> {
	private Map<T, Integer> bagContent;
	
	public HashBag(){
		bagContent = new HashMap<T, Integer>();
	}
	
	@Override
	public int quantity(T element) {
		if(bagContent.containsKey(element))
			return bagContent.get(element);
		return 0;
	}

	@Override
	public void add(T newValue, int quantity) throws BagException {
		if(quantity < 0)
			throw new BagException("Cannot add negative amount of items to bag");
		else if(bagContent.containsKey(newValue))
			bagContent.put(newValue, quantity + bagContent.get(newValue));
		else 
			bagContent.put(newValue, quantity);
	}

	@Override
	public void remove(T oldValue, int quantity) throws BagException {
		if(quantity < 0)
			throw new BagException("Cannot remove negative amount of items");
		else if(quantity(oldValue) < quantity)
			throw new BagException("Cannot remove items that don't exist");
		else
			bagContent.put(oldValue, quantity(oldValue)-quantity);
	}

	@Override
	public Set<T> toSet() {
		return bagContent.keySet();
	}

	@Override
	public Iterator<T> iterator() {
		return HashBagIterator<T>(bagContent.entrySet().iterator());
	}

	@Override
	public int size() {
		int size = 0;
		for(T element : toSet())
			size += quantity(element);
		return size;
	}

}
