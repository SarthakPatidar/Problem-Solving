package dataStructure.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 1) Create an empty stack nodeStack and push root node to stack.
 * 2) Do following while nodeStack is not empty.
 *   a) Pop an item from stack and print it.
 *   b) Push right child of popped item to stack
 *   c) Push left child of popped item to stack
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class TraversePreOrderIterative {
	public List<Integer> preorderTraversal(TreeNode root) {
    Stack<TreeNode> st = new Stack<TreeNode>();
    List<Integer> res = new ArrayList<Integer>();
    
    if(root == null)
        return res;
    
    TreeNode curr = root;
    st.push(curr);

    while(!st.isEmpty())
    {
        curr = st.pop();
        res.add(curr.val);
        
        if(curr.right != null)
            st.push(curr.right);
        
        if(curr.left != null)
            st.push(curr.left);   
    }
    
    return res;
	}
}