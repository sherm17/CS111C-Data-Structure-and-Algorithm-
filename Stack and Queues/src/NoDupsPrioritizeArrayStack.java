
//Authors: Yu Liao Peng, John Holman

public class NoDupsPrioritizeArrayStack<T> extends ArrayStack<T>
	implements NoDupsPrioritizeStackInterface<T> {
	
	public NoDupsPrioritizeArrayStack() {
		super();
	} 
	public NoDupsPrioritizeArrayStack(int initialCapacity) {
		super(initialCapacity);
	} 

	
	@Override
	public void push(T newEntry) {
		boolean add = true;
		// YOUR CODE HRE
		if(inStackIndex(newEntry) > -1) {
			add = false;
		}
		if(add) {
			super.push(newEntry);
		}
	}

	public void moveToTop(T entry) {
		// YOUR CODE HERE
		int index = inStackIndex(entry);
		if(index == -1) {
			push(entry);
		}//not in stack and add
		else {
			T temp = stack[index];
			for(int i = index; i <topIndex; i++) {
				stack[i] = stack[i+1];
			}
			stack[topIndex] = temp;
		}
	}
	
	// helper method to iterate through stack
	private int inStackIndex(T entry) {
		for(int i = 0; i <= topIndex; i++) {
			if(stack[i].equals(entry)) {
				return i;
			}
		}
		return -1;
	}

	public void display() {
		System.out.print("BOTTOM ");
		if(!isEmpty()) {
			for(int i = 0; i <= topIndex; i++) {
				System.out.print(stack[i] + " ");
			}
		}
		System.out.print("TOP\n");
	}
	


} 