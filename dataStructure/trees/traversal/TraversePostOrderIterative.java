package dataStructure.trees.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import dataStructure.trees.TreeNode;

/*
 * 1. Push root to first stack.
 * 2. Loop while first stack is not empty
 *  2.1 Pop a node from first stack and push it to second stack
 *  2.2 Push left and right children of the popped node to first stack
 * 3. Print contents of second stack
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

public class TraversePostOrderIterative {
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> st1 = new Stack<TreeNode>();
		Stack<TreeNode> st2 = new Stack<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();

		if (root == null)
			return res;

		TreeNode curr = root;
		st1.push(curr);

		while (!st1.isEmpty()) {
			curr = st1.pop();

			if (curr.left != null)
				st1.push(curr.left);

			if (curr.right != null)
				st1.push(curr.right);

			st2.push(curr);
		}

		for (int i = st2.size() - 1; i >= 0; i--) {
			res.add(st2.get(i).val);
		}
		return res;
	}
}
