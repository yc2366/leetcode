package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T145_BinaryTreePostOrderTraversal {
	
	//Definition for a binary tree node.
	public class TreeNode {
	   int val;
       TreeNode left;
	   TreeNode right;
	   TreeNode(int x) { val = x; }
	}
	

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }
    public void postorder(TreeNode root, List<Integer> res){
        if(root ==  null) return;        
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }
}