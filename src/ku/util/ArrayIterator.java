package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provide an iterator in the collection without knowing the structure of the collection.
 * @author Phanuwatch Luangpradit
 *
 * @param <T> the type of thing in the ArrayIterator.
 */
public class ArrayIterator<T> implements Iterator<T> {
	/** attribute for the array we want to iterate over */
	private T[] array;
	/** Initially the cursor points to the first element */
	private int point;
	/** check that the method can call or not */
	private boolean call;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array
	 *            is the array to iterate over
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		this.call = false;
	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	@Override
	public T next() {
		if(hasNext()){
			T next = array[point];
			this.point += 1;
			this.call = true;
			return array[point];
		}
		else
			throw new NoSuchElementException();
	}

	/**
	 * return true if next() can return another non-null array element.
	 * return false if no more elements.
	 */
	@Override
	public boolean hasNext() {
		for(int i = this.point; i < array.length; i++){
			if(array[i] != null){
				point = i;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Remove most recent element returned by next() from the array by setting it to null.
	 */
	@Override
	public void remove(){
		if(this.call != false){
			array[point - 1] = null;
			this.call = false;
		}
		else{
			throw new IllegalStateException();
		}
	}
}
