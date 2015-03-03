package hom02;

import java.util.Random;

/**
 *
 * @author Jaden Young
 */
public class LinkedListTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Random rand = new Random();
		CircularDoubleLinkedList<Integer> list = new CircularDoubleLinkedList();
		for(int i = 0; i < 10; i++) {
			list.addFirst(rand.nextInt(41) + 10);
		}
		
		System.out.println("Current size of the list: " + list.size());
		System.out.println("------- Rotating forwards -------");
		for(int i = 0; i < 10; i++) {
			System.out.println(i + ": " + list.first());
			list.rotate();
		}
		
		
		System.out.println("------- Rotating backwards -------");
		for(int i = 9; i >= 0; i--) {
			list.rotateBackward();
			System.out.println(i + ": " + list.first());
			
		}
		
		list.removeFirst();
		System.out.println("Size after removing the first element: " 
				+ list.size());
		System.out.println("------- Rotating forwards -------");
		for(int i = 0; i < 9; i++) {
			System.out.println(i + ": " + list.first());
			list.rotate();
		}
		
		list.removeLast();
		System.out.println("Size after removing the last element: "
				+ list.size());
		System.out.println("------- Rotating backwards -------");
		for(int i = 7; i >= 0; i--) {
			System.out.println(i + ": " + list.first());
			list.rotateBackward();
		}
		CircularDoubleLinkedList other = new CircularDoubleLinkedList();
		other = list.clone();
		System.out.println(list.equals(other));
		System.out.println("Current size of the other list: " + other.size());
		System.out.println("------- Rotating forwards -------");
		for(int i = 0; i < 8; i++) {
			System.out.println(i + ": " + other.first());
			other.rotate();
		}
	}
}	
