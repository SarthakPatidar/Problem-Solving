package dataStructure.trees.binarySearchTree;

import java.util.*;
import dataStructure.trees.TreeNode;

/*
 * 1. Create an empty stack.
 * 2. Make the first value as root. Push it to the stack.
 * 3. Keep on popping while the stack is not empty and the next value is greater than stack’s top value. 
 *    Make this value as the right child of the last popped node. Push the new node to the stack.
 * 4. If the next value is less than the stack’s top value, make this value as the left child of the stack’s top node. 
 *    Push the new node to the stack.
 * 5. Repeat steps 2 and 3 until there are items remaining in pre[].
 */

public class PreOrderToBst {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		Stack<TreeNode> st = new Stack<TreeNode>();

		TreeNode root = new TreeNode(arr[0]);
		st.push(root);

		for (int i = 1; i < n; i++) {
			TreeNode temp = null;

			while (!st.isEmpty() && arr[i] > st.peek().val) {
				temp = st.pop();
			}

			if (temp != null) {
				temp.right = new TreeNode(arr[i]);
				st.push(temp.right);
			} else {
				temp = st.peek();
				temp.left = new TreeNode(arr[i]);
				st.push(temp.left);
			}
		}
		
		printNodes(root);
		sc.close();
	}

	private static void printNodes(TreeNode root) {
		if(root == null)
			return;
		printNodes(root.left);
		System.out.println(root.val);
		printNodes(root.right);
	}
}
