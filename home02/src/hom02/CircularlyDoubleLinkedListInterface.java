package hom02;
/**
 * @author Jaden Young
 * @param <E> Data type for the linked list
 */

public interface CircularlyDoubleLinkedListInterface <E> {
	
	/** Returns the number of nodes in the list */
	public int size();
	
	/** Returns true if the list is empty, false if not */
	public boolean isEmpty();
	
	/**
	 * Returns, without removing, the first element in the list.
	 * This is the element immediately following the tail reference.
	 */
	public E first();
	
	/**
	 * Returns, without removing, the last element in the list.
	 * This is the tail reference.
	 */
	public E last();

	/** Adds a new element to the front of the list */
	public void addFirst(E newElement);
	
	/** Adds a new element to the end of the list */
	public void addLast(E newElement);
	
	/** Removes and returns the first element of the list */
	public E removeFirst();
	
	/** Removes and returns the last element of the list */
	public E removeLast();
}
