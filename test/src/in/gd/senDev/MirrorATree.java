package in.gd.senDev;

public class MirrorATree {

	private class Node {
		Node left;
		Node right;
	}
	
	Node root;
	
    void mirror()
    {
        root = mirror(root);
    }
 
    Node mirror(Node node)
    {
        if (node == null)
            return node;
 
        /* do the subtrees */
        Node left = mirror(node.left);
        Node right = mirror(node.right);
 
        /* swap the left and right pointers */
        node.left = right;
        node.right = left;
 
        return node;
    }
	
}
