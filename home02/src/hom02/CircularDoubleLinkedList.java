package hom02;

/**
 *
 * @author Jaden Young
 * @param <E> Datatype for the linked list
 */
public class CircularDoubleLinkedList <E> implements 
		CircularlyDoubleLinkedListInterface<E>, Cloneable {
	
	//------------ nested Node class ------------
	private static class Node<E> {
		private E element;
		private Node<E> previous;
		private Node<E> next;
		
		public Node(E newElement, Node<E> newPrevious, Node<E> newNext) {
			element = newElement;
			previous = newPrevious;
			next = newNext;
		}
		
		/** Returns the element stored in the node */
		public E getElement() {
			return element;
		}
		/** Returns a reference to the previous node in the list */
		public Node<E> getPrevious() {
			return previous;
		}
		/** Returns a reference to the next node in the list */
		public Node<E> getNext() {
			return next;
		}
		
		/** Sets the previous node in the list to a specified node */
		public void setPrevious(Node<E> newPrevious) {
			previous = newPrevious;
		}
		/** Sets the next node in the list to a specified node */
		public void setNext(Node<E> newNext) {
			next = newNext;
		}
	}//------------------ end Node class ------------------
	
	private int count = 0;
	private Node<E> tail = null;
	
	public CircularDoubleLinkedList() {
		//constructs an empty list
	}
	
	//------------------------ Accessor Methods ------------------------------
	
	/** Returns the number of elements in the list */
	@Override
	public int size() {
		return count;
	}
	
	/** Returns true if the the list is empty, false if not */
	@Override
	public boolean isEmpty() {
		return count == 0;
	}
	
	/**
	 * Returns, without removing, the first element in the list.
	 * This is the element immediately following the tail reference.
	 * If the list is empty, null is returned.
	 * @return 
	 */
	@Override
	public E first() {
		if(isEmpty())
			return null;
		return tail.getNext().getElement();
	}
	/**
	 * Returns, without removing, the last element in the list.
	 * This is the tail reference.
	 * If the list is empty, null is returned.
	 */
	@Override
	public E last() {
		if(isEmpty())
			return null;
		return tail.getElement();
	}
	
	//------------------------ Mutator Methods ------------------------------
	
	/** 
	 * Adds an element to the front of the list.
	 * When adding the first element, the references for the next and previous
	 * nodes will be set to the first node
	 */
	@Override
	public void addFirst(E newElement) {
		//when adding the first item, the references for next and previous
		//are set to itself
		if(count == 0) {
			tail = new Node<>(newElement, tail, tail);
		} else {
			Node<E> temp = new Node<>(newElement, tail, tail.getNext());
			tail.setNext(temp);
			temp.getNext().setPrevious(temp);
			if(count == 1)
				tail.setPrevious(temp);
		}
		count++;
	}
	
	/**
	 * Adds an element to the end of the list.
	 * When adding the first element, the references for the next and previous
	 * nodes will be set to the first node
	 */
	@Override
	public void addLast(E newElement) {
		addFirst(newElement);
		tail = tail.getNext();
	}
	
	/**
	 * Removes and returns the first element of the list.
	 * If the list is empty, null is returned.
	 * @return Element stored in the node that was removed
	 */
	@Override
	public E removeFirst() {
		if(isEmpty())
			return null;
		Node<E> temp = tail.getNext();
		if(temp == tail) {
			tail = null;
		} else { 
			tail.setNext(tail.getNext().getNext());
		}
		return temp.getElement();
	}
	
	/**
	 * Removes and returns the last element of the list.
	 * If the list is empty, null is returned
	 * @return Element stored in the node that was removed
	 */
	@Override
	public E removeLast() {
		if(isEmpty())
			return null;
		Node<E> temp = tail;
		tail.getPrevious().setNext(tail.getNext());
		tail.getNext().setPrevious(tail.getPrevious());
		tail = tail.getPrevious();
		return temp.getElement();
	}
	
	/**
	 * Rotates the list forwards, assigning the tail reference to the next
	 * node in the list
	 */
	public void rotate() {
		if(tail != null)
			tail = tail.getNext();
	}
	
	/**
	 * Rotates the list backwards, assigning the tail reference to the previous
	 * node in the list
	 */
	public void rotateBackward() {
		if(tail != null)
			tail = tail.getPrevious();
	}
	
	/** Returns a clone of the entire linked list
	 * @throws java.lang.CloneNotSupportedException 
	 * @return Reference to a deep copy of the entire linked list
	 */
	@Override
	public CircularDoubleLinkedList clone() throws CloneNotSupportedException {
		CircularDoubleLinkedList other = 
				(CircularDoubleLinkedList) super.clone();
		if(count > 0) {
			other.tail = new Node<>(tail.getElement(), other.tail, other.tail);
			Node<E> temp = tail.getNext();
			while(temp != tail) {
				other.addFirst(temp.getElement());
				temp = temp.getNext();
			}
		}
		return other;
	}
	
	/**
	 * Compares two lists for equality
	 * @param Obj Object to be compared against
	 * @return true if lists contain identical nodes, false if not
	 */
	@Override
	public boolean equals(Object Obj) {
		if(!(Obj instanceof CircularDoubleLinkedList))
			return false;
		CircularDoubleLinkedList other = (CircularDoubleLinkedList)Obj;
		if(count != other.size())
			return false;
		Node<E> thisTemp = tail.getNext();
		Node<E> otherTemp = other.tail.getNext();
		while(thisTemp != tail) {
			if(thisTemp.getElement() != otherTemp.getElement())
				return false;
		}
		return true;
	}
}
