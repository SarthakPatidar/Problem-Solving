package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import dataStructure.trees.TreeNode;

public class SameTree {
	
  public boolean isSameTree(TreeNode p, TreeNode q) {

  		if(p == null && q == null)
  			return true;
      
      if(p == null || q == null)
      	return false;
      
      if(p.val != q.val)
      	return false;
      
      return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
      
  }	
	
  public static TreeNode stringToTreeNode(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
        return null;
    }

    String[] parts = input.split(",");
    String item = parts[0];
    TreeNode root = new TreeNode(Integer.parseInt(item));
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);

    int index = 1;
    while(!nodeQueue.isEmpty()) {
        TreeNode node = nodeQueue.remove();

        if (index == parts.length) {
            break;
        }

        item = parts[index++];
        item = item.trim();
        if (!item.equals("null")) {
            int leftNumber = Integer.parseInt(item);
            node.left = new TreeNode(leftNumber);
            nodeQueue.add(node.left);
        }

        if (index == parts.length) {
            break;
        }

        item = parts[index++];
        item = item.trim();
        if (!item.equals("null")) {
            int rightNumber = Integer.parseInt(item);
            node.right = new TreeNode(rightNumber);
            nodeQueue.add(node.right);
        }
    }
    return root;
  }

	public static String booleanToString(boolean input) {
	    return input ? "True" : "False";
	}
	
	public static void main(String[] args) throws IOException {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String line;
	    while ((line = in.readLine()) != null) {
	        TreeNode p = stringToTreeNode(line);
	        line = in.readLine();
	        TreeNode q = stringToTreeNode(line);
	        
	        boolean ret = new SameTree().isSameTree(p, q);
	        
	        String out = booleanToString(ret);
	        
	        System.out.print(out);
	    }
	}
}
