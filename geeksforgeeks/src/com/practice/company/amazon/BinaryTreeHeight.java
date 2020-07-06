package com.practice.company.amazon;

public class BinaryTreeHeight {

  public static void main(String args[]) {
    Node newnode = new Node(10);
    newnode.left = new Node(5);
    newnode.right = new Node(6);
    newnode.right.left = new Node(8);
    newnode.right.right = new Node(7);
    newnode.right.right.right = new Node(4);

    int height = calculateHeight(newnode);
    System.out.println("Height of Binary Tree = " + height);
  }

  private static int calculateHeight(Node root) {
    if(root == null)
      return 0;

    int lDepth = calculateHeight(root.left);
    int rDepth = calculateHeight(root.right);

    return 1 + Math.max(lDepth, rDepth);
  }

}

class Node {

  public Node left;
  public Node right;
  public int data;

  public Node(int data) {
    this.data = data;
    this.right = null;
    this.left = null;
  }
}
