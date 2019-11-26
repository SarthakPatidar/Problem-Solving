package dataStructure.trees.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import dataStructure.trees.TreeNode;

/*
 *	1) Create an empty stack S.
 *	2) Initialize current node as root
 *	3) Push the current node to S and set current = current->left until current is NULL
 *	4) If current is NULL and stack is not empty then 
 *    a) Pop the top item from stack.
 *    b) Print the popped item, set current = popped_item->right 
 *    c) Go to step 3.
 *  5) If current is NULL and stack is empty then we are done.
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

public class TraverseInorderIterative {
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
		TreeNode curr = root;

		while (curr != null || st.size() > 0) {
			/*
			 * Push the left nodes until null is encountered.
			 */
			while (curr != null) {
				st.push(curr);
				curr = curr.left;
			}

			curr = st.pop();
			res.add(curr.val);

			curr = curr.right;
		}
		return res;
	}
}
