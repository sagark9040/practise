package leet.tree;import com.sun.xml.internal.ws.util.StringUtils;

public class LongestAbsolutePath {
	
	// WEAKNESS ----> String parsing and converting to something like a tree or a heap.
	
	//515pm
	//Feels similar to creating the binary tree from a string.
	//Creating an n-ary tree O(s) - len of string ....... o(n) space
	//Traversing the tree O(n) - num of nodes.
	//Trying to think if I even need to actually create a tree, maybe solve it directly.
	
//	public int lengthLongestPath(String input) {
//		int v = getRoot(input);
//		Node root = new Node(input.substring(0, v));
//		int start = v;
//		String sub = "";
//        for(int i=v; i<input.length(); i++) {
//        	if(input.charAt(i) == '\'' || input.charAt(i) == '/') {
//        		sub = input.substring(start, i);
//        		start = i+1;
//        	}
//        }
//    }
	
	//dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext
	
	public static void main(String args[]) {
		String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		LongestAbsolutePath l = new LongestAbsolutePath();
		l.lengthLongestPath(s);
	}
	
	public int lengthLongestPath(String input) {
		//input.replaceAll("\t", "");
		
		String[] items = input.split(":?\\\\");
		
		for(String token:items) {
			int lev = token.lastIndexOf("\\\\");
			System.out.println(token + " " + lev);
		}
		return 0;
	}	
	private int getRoot(String input) {
		int i=0;
		while(i < input.length()) {
			if(input.charAt(i) == '\'' || input.charAt(i) == '/')
				break;			
		}
		
		return i;
	}

	class Node {
		String val;
		Node[] children;
		Node(String v) {
			val = v;
		}
		Node(String v, Node[] c) {
			val = v;
			children = c;
		}		
	}
}
