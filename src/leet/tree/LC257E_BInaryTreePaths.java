package leet.tree;

import java.util.ArrayList;
import java.util.List;

public class LC257E_BInaryTreePaths {
	//200pm -- 214pm
    List<String> allPaths = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return new ArrayList<String>();
        } else if(root.left == null && root.right == null) {
            allPaths.add(String.valueOf(root.val));
            return allPaths;
        }
        
        getPaths(root, "");
        return allPaths;
    }
    
    public void getPaths(TreeNode root, String curPath) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            String finalPath = curPath + "->" + root.val;
            if(finalPath.indexOf("->") == 0) {
                allPaths.add(finalPath.substring(2));
            } else {
                allPaths.add(finalPath);    
            }
            return;
        }
        
        curPath = curPath + "->" + root.val;
        getPaths(root.left, curPath);
        getPaths(root.right, curPath);
        
    }
}
