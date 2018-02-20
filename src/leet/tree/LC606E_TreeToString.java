package leet.tree;

public class LC606E_TreeToString {
	//332pm - 400 pm didn't solve all the TCs. f=ed up.. rewriting now
	//Need to break it down to smaller problems with every step what choices to I have!!
	
    public String tree2str2(TreeNode t) {
        if(t == null) return "";
        String s = t.val + "";
        if(t.left == null && t.right == null) return s;
        else if(t.left == null)  s = s + "()" + "(" + tree2strWrongOrSubOptimal(t.right) + ")";
        else if(t.right == null) s = s + "(" + tree2strWrongOrSubOptimal(t.left) + ")";
        else s = s + "(" + tree2strWrongOrSubOptimal(t.left) + ")" + "(" + tree2strWrongOrSubOptimal(t.right) + ")";
        return s;
    }
	
	
	public String tree2strWrongOrSubOptimal(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        
        String s = tree2str(t, sb).toString();
        return replaceEmpty(s);
    }
    
    private String replaceEmpty(String string) {
    	for(int i=0; i<string.length()-1; i++) {
    		if(string.charAt(i) == '(' && string.charAt(i+1) == ')'){
    			string = string.substring(0,i) + string.substring(i+2);
    		}
    	}
    	
    	for(int i=0; i<string.length()-2; i++) {
    		if(Character.isDigit(string.charAt(i)) && string.charAt(i+1) == '(' && string.charAt(i+2) == ')'){
    			string = string.substring(0,i+1) + string.substring(i+3);
    		}
    	}
		return string;
	}

    public StringBuilder tree2str(TreeNode t, StringBuilder sb) {
        if(t == null) {
            return sb;
        }
        
        sb.append(t.val);
//        sb.append("(");
//        tree2str(t.left, sb);
//        sb.append(")");

        if(t.left != null || t.right != null) {
        	sb.append("(");
            tree2str(t.left, sb);
            sb.append(")");
        }
        
        if(t.right!=null) {        	
            sb.append("(");
            tree2str(t.right, sb);
            sb.append(")");
        }
        return sb;
    }
    
    public static void main(String args[]) {
    	LC606E_TreeToString t2 = new LC606E_TreeToString();
    	TreeNode t = new TreeNode(1);
    	t.left = new TreeNode(2);
    	t.left.right = new TreeNode(4);
    	t.right = new TreeNode(3);
    	System.out.println(t2.tree2strWrongOrSubOptimal(t));
    	
    }
}
