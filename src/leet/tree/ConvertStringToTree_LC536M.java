package leet.tree;

public class ConvertStringToTree_LC536M {

	TreeNode2 root = null;
	
	public TreeNode2 str2tree(String s) {
		//Thought of tokenizing based off brackets. Didn't see much benefit to it.
		//Simply gonna parse the string. Open bracket indicates children, close bracket indicates go back to root. 
		//Children would be left by default unless the node has left child already
		

		
		
		if(s==null || s.length() == 0) return null;
		if(s.length() == 1) return new TreeNode2(Integer.valueOf(s.charAt(0)));
		
		TreeNode2 root = new TreeNode2(Integer.valueOf(s.charAt(0)));
		String stringLeft = new String(s.substring(1));
		TreeNode2 cur = root;
		while(stringLeft.length() > 0) {
			if(s.charAt(0) == '(') {
				stringLeft = stringLeft.substring(1);
			}
			else if (Character.getNumericValue(s.charAt(0)) >= 0 && Character.getNumericValue(s.charAt(0)) <= 9) {
				if(cur.hasLeftChild) {
					cur.right = new TreeNode2(Character.getNumericValue(s.charAt(0)));					
				}
				else
					cur.left = new TreeNode2(Character.getNumericValue(s.charAt(0)));						
			}
			else if (s.charAt(0) == ')') {
				
			}					
		}
		
		root = new TreeNode2(Character.getNumericValue(s.charAt(0)));
		buildTree(root, s.substring(1));
		return root;
    }
	
	private TreeNode2 buildTree(TreeNode2 root, String s) {
		if(s == null || s.length() == 0)
			return root;
		
		if(s.charAt(0) == '(') {
			if(root.hasLeftChild) 
				root.right = buildTree(root, s.substring(1));
			else
				root.left = buildTree(root, s.substring(1));			
		} else if (Character.getNumericValue(s.charAt(0)) >= 0 && Character.getNumericValue(s.charAt(0)) <= 9) {
			root = new TreeNode2(Character.getNumericValue(s.charAt(0)));
		}
		
		return root;
	}

	class TreeNode2 {
      int val;
      boolean hasLeftChild = false;
      TreeNode2 left;
      TreeNode2 right;
      TreeNode2(int valueOf) {
    	  val = valueOf;
      }
      
    }
	
	public static void main(String args[]) {
		ConvertStringToTree_LC536M con = new ConvertStringToTree_LC536M();
		con.str2tree("4(2(3)(1))(6(5))");
	}
}

/*
Input: "4(2(3)(1))(6(5))"
Output: return the tree root node representing the following tree:

       4
     /   \
    2     6
   / \   / 
  3   1 5   
*/