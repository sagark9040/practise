package leet.tree;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class LC538E_ConvertBSTToAGreaterTree {

    //Create a TreeMap with node.val, node.newVal ... order will be low to high
    //Iterate the tree again and get the values in the map which is cumulated
    
   Map<Integer, Integer> nodeValues = new TreeMap<Integer, Integer>(Collections.reverseOrder());   

	    public TreeNode convertBST(TreeNode root) {
	        if(root == null || (root.left == null && root.right == null))
	            return root;
	        
	        populateMap(root);
	        cumulateValues();
	        changeValues(root);
			return root;
	    }
	    
	    public void changeValues(TreeNode root) {
	        if(root == null)
	            return;
	        else
	            root.val = nodeValues.get(root.val);
	        changeValues(root.left);
	        changeValues(root.right); 
	    }
	    
	    public void populateMap(TreeNode root) {
	    	if(root == null)
	            return;
	        else
	            nodeValues.put(root.val, root.val);
	        populateMap(root.left);
	        populateMap(root.right); 
	    }
	    
	    public void cumulateValues() {
	        int valSoFar = 0;
	        
	        for(Integer key: nodeValues.keySet()) {       // Iterating Maps has been a problem
	            valSoFar += nodeValues.get(key);
	            nodeValues.put(key, valSoFar);
	        }
	    }
	    
	    public static void main (String args[]) {
	    	LC538E_ConvertBSTToAGreaterTree con = new LC538E_ConvertBSTToAGreaterTree();
	    	TreeNode root = new TreeNode(5);
	    	root.left = new TreeNode(2);
	    	root.right = new TreeNode(13);
	    	con.convertBST(root);
	    }
}
