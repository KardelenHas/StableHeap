package stableHeap;

public class StableHeap<Type extends Comparable<? super Type>> implements Heap<Type>{
	private static final int DEFAULT_CAPACITY = 17;
	private Object[] array;
	private int size;
	
	public StableHeap() { 
		array = new Object[DEFAULT_CAPACITY];
		size = 0;
	}
	
	public StableHeap(int capacity) {  //Space opens up for capacity.
		array = new Object[capacity];
		size = 0;
	}
	
	@Override
	public void insert(Type data) {  //The added value is added last. It increases to you because it is addition.
		array[size] = data;
		size++;
	}

	@Override
	public Type findMin() { // Smallest item is at the root
		if(isEmpty())
			return null;
		return (Type) array[0]; 
	}

	@Override
	public Type deleteMin() { // Remove the smallest item from the heap.
		if(isEmpty())
			return null;
		
		Type minItem = findMin(); // Returns array[1]
		
		for(int i=0; i < array.length - 1; i++)
		{
			array[i] = array[i+1];
		}
		array[array.length - 1] = null;
		size--; //# of items is decremented
		
		return minItem;
	}
	
	@Override
	public boolean isEmpty() { //If the heap is equal to 0, it is empty.
		return size == 0; 
	}

	@Override
	public void makeEmpty() {  //Makes it completely empty.
		array = new Object[DEFAULT_CAPACITY];
		size = 0;
	}
}
