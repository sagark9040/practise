package leet.dfsBfs;

import java.util.HashSet;
import java.util.Set;

public class MOCK_TreeAmzn {
	Set<Integer> mySet = new HashSet<Integer>();
	public int largestIndependentSet(Node root) {
	    getIndependentSet(root);
	    return mySet.size();
	}

	public void getIndependentSet(Node node) {
	    if(node == null) {
	        return;
	    } else if (node.lChild == null && node.rChild == null) {
	        mySet.add(node.data);
	        return;
	    }

	    getIndependentSet(node.lChild);    
	    getIndependentSet(node.rChild);
	    if((node.lChild != null && !mySet.contains(node.lChild.data)) && 
	       (node.rChild != null && !mySet.contains(node.rChild.data))) {  //a2 .. possible null 
	        mySet.add(node.data);
	    }
	}
	
	
	
	public static void main(String args[]) {
		Node root = new Node(1);
		//root.left = new Node();
		
		
	}
}

class Node {
    int data;
    Node lChild, rChild;
    Node(int d) {
  	  data = d;
    }
}
