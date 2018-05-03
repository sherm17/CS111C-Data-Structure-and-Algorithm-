//Authors: Yu Liao Peng, John Holman
import java.util.Arrays;

public class NoDupsDePrioritizeArrayQueue<T> extends ArrayQueue<T> 
	implements NoDupsDePrioritizeQueueInterface<T> {


	public NoDupsDePrioritizeArrayQueue() {
		super();
	} 
	public NoDupsDePrioritizeArrayQueue(int initialCapacity) {
		super(initialCapacity);
	} 

	@Override
	public void enqueue(T newEntry) {
		// YOUR CODE HERE
		if(findIndex(newEntry) == -1) {
			super.enqueue(newEntry);
		}
	} 
	
	private int findIndex(T entry) {
		int curr = frontIndex;
		while(queue[curr] != null) {
			if(queue[curr].equals(entry)) {
				return curr;
			}
			curr = (curr + 1) % queue.length;
		}
		return -1;
	}
	
	public void moveToBack(T entry) {
		// YOUR CODE HERE
		if(findIndex(entry) == -1) {
			enqueue(entry);
		}//entry not in queue
		else { //entry found and need to shift
			int curr = findIndex(entry); 
			T temp = queue[curr];
			while(queue[(curr + 1) % queue.length] != null) {
				queue[curr] = queue[curr+1];
				curr = (curr + 1) % queue.length;
			}
			queue[backIndex] = temp;
		}	
	}

	public void display() {
		// YOUR CODE HERE
		System.out.print("FRONT ");
		int currIndex = frontIndex;
		while(queue[currIndex] != null) {
			System.out.print(queue[currIndex] + " ");
			currIndex = (currIndex + 1) % queue.length;
		}
		System.out.print("BACK\n");
	} 

}