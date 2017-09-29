package src.in.gd;

public class IsTreeMirrorImage {

    /* Given two trees, return true if they are
    mirror of each other */
 boolean areMirror(Node a, Node b) 
 {
     /* Base case : Both empty */
     if (a == null && b == null)
         return true;

     // If only one is empty
     if (a == null || b == null) 
         return false;

     /* Both non-empty, compare them recursively
        Note that in recursive calls, we pass left
        of one tree and right of other tree */
     return a.data == b.data
             && areMirror(a.left, b.right)
             && areMirror(a.right, b.left);
 }
 private class Node{
	 int data;
	 Node left, right;
 }
}
