package leet.tree;

public class INCOMPLETE_LC297H_SerializeDeSerializeABinaryTree {

    //One pass do the pre-order
    //Second pass add nulls to the pre-order
    
    TreeNode head = null;
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        
        System.out.println(getPreOrder(root, new StringBuilder()).toString());
        
        return "";
    }
    
    public StringBuilder getPreOrder(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return sb;
        } 
        
        sb.append(root.val);
        
        sb = root.left != null ? sb.append("L") : sb;
        sb = getPreOrder(root.left, sb);
        
        sb = root.right != null ? sb.append("R") : sb;
        sb = getPreOrder(root.right, sb);        
        
        sb = sb.append("U");
        
        return sb;
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data == null || data.length() == 0)
    		return null;
    	System.out.println("012345678901234567890123456789");
    	TreeNode root = new TreeNode(Character.getNumericValue(data.charAt(0))), curNode = root, prev = root;
    	int i = 1;
    	
    	deserializeUtil(data.substring(1), root, root);
    	
//    	while(i < data.length()) {
//    		char cur = data.charAt(i);
//    		if (cur == 'L') {
//    			curNode.left = new TreeNode(Character.getNumericValue(data.charAt(i+1)));
//    			prev = curNode;
//    			curNode = curNode.left;
//    			i++;
//    		} else if (cur == 'R') {
//    			curNode.right = new TreeNode(Character.getNumericValue(data.charAt(i+1)));
//    			prev = curNode;
//    			curNode = curNode.right;
//    			i++;
//    		} else if (cur == 'U'){
//    			curNode = prev;
//    		}
//    		
//    		i++;
//    	}
        
        return root;
    }
    
    public void deserializeUtil(String data, TreeNode curNode, TreeNode prev){
    	char cur = data.charAt(0);
    	if (cur == 'L') {
			curNode.left = new TreeNode(Character.getNumericValue(data.charAt(0)));
			prev = curNode;
			curNode = curNode.left;
		} else if (cur == 'R') {
			curNode.right = new TreeNode(Character.getNumericValue(data.charAt(0)));
			prev = curNode;
			curNode = curNode.right;
		} else if (cur == 'U'){
			curNode = prev;
		}
    	if(data.length()>1)
    		deserializeUtil(data.substring(1), curNode, prev);
    }

    public static void main(String args[]) {
    
    	TreeNode root = new TreeNode (1);
    	root.left = new TreeNode(2);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	
    	root.right = new TreeNode(3);
    	root.right.right = new TreeNode(6);
    	
    	INCOMPLETE_LC297H_SerializeDeSerializeABinaryTree s = new INCOMPLETE_LC297H_SerializeDeSerializeABinaryTree();
    	s.serialize(root);
    	TreeNode root2 = s.deserialize("1L2L4UR5UUR3R6UUU");
    	printBinaryTree(root2, 0);
    	
    }	
    
    public static void printBinaryTree(TreeNode root, int level){		
	    if(root==null)
	         return;
	    printBinaryTree(root.right, level+1);
	    if(level!=0){
	        for(int i=0;i<level-1;i++)
	            System.out.print("|\t");
	            System.out.println("|-------"+root.val);
	    }
	    else
	        System.out.println(root.val);
	    printBinaryTree(root.left, level+1);
	} 
}













