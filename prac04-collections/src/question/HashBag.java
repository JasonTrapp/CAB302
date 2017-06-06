package question;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Implementation of the bag data structure. Implements the removal, addition
 * size, quantity and converts to a Set.
 * @author Jason Trapp
 *
 * @param <T>
 */
public class HashBag<T> extends Bag<T> {
	//Field that stores the values in the bag
	private Map<T, Integer> bagContent;
	
	/**
	 * Contructor that instantiates the bag.
	 */
	public HashBag(){
		bagContent = new HashMap<T, Integer>();
	}
	
	/**
	 * 
	 * @return 
	 */
	@Override
	public int quantity(T element) {
		if(bagContent.containsKey(element))
			return bagContent.get(element);
		return 0;
	}
	
	/**
	 * Adds a new element to the  bag.
	 * @throws BagException Throws exception when the quantity added is negative.
	 * @param newValue The object being added
	 * @param quantity The amount of new objects added
	 */
	@Override
	public void add(T newValue, int quantity) throws BagException {
		if(quantity < 0)
			throw new BagException("Cannot add negative amount of items to bag");
		else if(bagContent.containsKey(newValue))
			bagContent.put(newValue, quantity + bagContent.get(newValue));
		else 
			bagContent.put(newValue, quantity);
	}

	/**
	 * 
	 * @throws BagEXception Throws exception when quantity removed is negative.
	 * @param oldValue The object being removed
	 * @param quantity The amount of objects being removed.
	 */
	@Override
	public void remove(T oldValue, int quantity) throws BagException {
		if(quantity < 0)
			throw new BagException("Cannot remove negative amount of items");
		else if(quantity(oldValue) < quantity)
			throw new BagException("Cannot remove items that don't exist");
		else
			bagContent.put(oldValue, quantity(oldValue)-quantity);
	}
	
	/**
	 * Converts hashmap to a set
	 * @return A set of the hashmap
	 */
	@Override
	public Set<T> toSet() {
		return bagContent.keySet();
	}
	
	/**
	 * Function which allows iteration over data structure
	 * @return Iterator object to iterate over data structure
	 */
	@Override
	public Iterator<T> iterator() {
		return HashBagIterator<T>(bagContent.entrySet().iterator());
	}

	/**
	 * Gets the size of the bag with respect to amount of elements in it
	 * @return Size of the bag
	 */
	@Override
	public int size() {
		int size = 0;
		for(T element : toSet())
			size += quantity(element);
		return size;
	}

}
