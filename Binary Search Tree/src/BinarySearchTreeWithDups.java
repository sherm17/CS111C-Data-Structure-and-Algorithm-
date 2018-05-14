import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
		implements SearchTreeInterface<T>, java.io.Serializable {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	@Override
	public T add(T newEntry) {
		T result = null;
		if (isEmpty())
			setRootNode(new BinaryNode<T>(newEntry));
		else
			result = addEntryHelperIterative(newEntry);
		return result;
	}

	// ??? IMPLEMENT THIS METHOD
	private T addEntryHelperIterative(T newEntry) {
		// IMPORTANT: METHOD MUST BE ITERATIVE!!
		
		// will return null 
		BinaryNodeInterface<T> currentNode = getRootNode();
		assert currentNode != null;
		T result = null;
		boolean found = false;
		
		while(!found) {
			T currentEntry = currentNode.getData();
			int comparison = newEntry.compareTo(currentEntry);
			
			if(comparison == 0) {
				if(currentNode.hasRightChild())
					currentNode = currentNode.getRightChild();
				else {
					found = true;
					currentNode.setRightChild(new BinaryNode<T>(newEntry));
				}
			}
			else if (comparison < 0) {
				if (currentNode.hasLeftChild())
					currentNode = currentNode.getLeftChild();
				else {
					found = true;
					currentNode.setLeftChild(new BinaryNode<T>(newEntry));
				} // end if
			} 
			else {
				assert comparison > 0;

				if (currentNode.hasRightChild())
					currentNode = currentNode.getRightChild();
				else {
					found = true;
					currentNode.setRightChild(new BinaryNode<T>(newEntry));
				}
			}
		}	
		return result;
	}
	
	public ArrayList<T> getAllEntriesIterative(T searchVal) {
		BinaryNodeInterface<T> currentNode = getRootNode();
		ArrayList<T> entryList = new ArrayList<T>();

		StackInterface<BinaryNodeInterface<T>> nodeStack = new LinkedStack<BinaryNodeInterface<T>>();
		
		while(!nodeStack.isEmpty() || (currentNode != null)) {
			while(currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			
			if(!nodeStack.isEmpty()) {
				BinaryNodeInterface<T> nextNode = nodeStack.pop();
				if(nextNode.getData().equals(searchVal)) {
					entryList.add(nextNode.getData());
				}
				assert nextNode != null;
				currentNode = nextNode.getRightChild();
			}
		}
		
		
		return entryList;
	}

	public ArrayList<T> getAllEntriesRecursive(T searchVal) {
		BinaryNodeInterface<T> rootNode = getRootNode();
		
		// getAllEntriesHelper(searchVal, rootNode, entryList);
		
		ArrayList<T> entryList = new ArrayList();
		inorderTraverse(rootNode, searchVal, entryList);
		return entryList;
	}
	
	private void inorderTraverse(BinaryNodeInterface<T> node, T val, ArrayList arr) {

		if(node != null) {
			inorderTraverse(node.getLeftChild(), val, arr);
			if(val.equals(node.getData())) {
				arr.add(node.getData());
			}
			inorderTraverse(node.getRightChild(), val, arr);
		}
	}

	// ??? IMPLEMENT THIS METHOD
	public ArrayList<T> getAllEntriesLessThanIterative(T searchVal) {

		BinaryNodeInterface<T> currentNode = getRootNode();
		ArrayList<T> entryList = new ArrayList<T>();

		StackInterface<BinaryNodeInterface<T>> nodeStack = new LinkedStack<BinaryNodeInterface<T>>();
		
		while(!nodeStack.isEmpty() || (currentNode != null)) {
			while(currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			
			if(!nodeStack.isEmpty()) {
				BinaryNodeInterface<T> nextNode = nodeStack.pop();
				if(nextNode.getData().compareTo(searchVal) < 0) {
					entryList.add(nextNode.getData());
				}
				assert nextNode != null;
				currentNode = nextNode.getRightChild();
			}
		}
		
		
		return entryList;
	}

	public ArrayList<T> getAllEntriesLessThanRecursive(T searchVal) {
		// this initial code is meant as a suggestion to get your started- feel
		// free to use it or delete it!
		BinaryNodeInterface<T> rootNode = getRootNode();
		ArrayList<T> entryList = new ArrayList<T>();
		getAllEntriesLessThanHelper(searchVal, rootNode, entryList);
		Collections.sort(entryList);
		return entryList;
	}
	
	private void getAllEntriesLessThanHelper(T searchVal, BinaryNodeInterface<T> rootNode, ArrayList<T> entryList) {
		//preorder traverse
		if(rootNode!=null) {
			if(rootNode.getData().compareTo(searchVal) < 0){
				entryList.add(rootNode.getData());
			}
			getAllEntriesLessThanHelper(searchVal,rootNode.getLeftChild(), entryList);
			getAllEntriesLessThanHelper(searchVal,rootNode.getRightChild(), entryList);
		}
	}
}