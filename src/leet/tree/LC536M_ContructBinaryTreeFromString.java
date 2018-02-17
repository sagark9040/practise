package leet.tree;

public class LC536M_ContructBinaryTreeFromString {

    public TreeNode str2tree(String s) {
    	TreeNode root = null;
        if(s == null || s.length() == 0) {
            return root;
        } else if(s.indexOf('(') == -1) {
            return new TreeNode(Integer.parseInt(s));
        }
        char[] c = s.toCharArray();
        int i=0, pos=0;
        while(pos<c.length && (Character.isDigit(s.charAt(pos)) || s.charAt(pos) == '-')) {
        	pos++;
        }
        root = new TreeNode(extractVal(c, i, pos));
        
        if(pos < c.length) {
	        i = pos;
	        int count = 1;
	        while(pos+1 < c.length && count != 0) {
	        	pos++;
	        	if(c[pos] == '(') count++;
	        	if(c[pos] == ')') count--;
	        }
	        
	        root.left = str2tree(s.substring(i+1, pos));
        }
        pos++;
        if(pos < s.length()) {
        	root.right = str2tree(s.substring(pos+1, s.length()-1));
        }
        
        
        return root;
    }
   
    
    int extractVal(char[] c, int start, int end) {
        return Integer.parseInt(String.valueOf(c).substring(start, end));
    }
    
    public static void main(String args[]) {
    	
    	String s = "4(2(3)(1))(6(5))";
    	LC536M_ContructBinaryTreeFromString c = new LC536M_ContructBinaryTreeFromString();
    	
    	TreeNode n = c.str2tree(s);
    	System.out.println(n.val);
    }
}
