package question;

import java.util.AbstractCollection;
import java.util.Set;

public abstract class Bag<T> extends AbstractCollection<T> {
	public abstract int quantity(T element);
	
	public abstract void add(T newValue, int quantity) throws BagException;
	
	public abstract void remove(T oldValue, int quantity) throws BagException;
	
	public abstract Set<T> toSet();
}
