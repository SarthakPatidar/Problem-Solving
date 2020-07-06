# Height of Binary Tree [[Code](https://github.com/SarthakPatidar/Problem-Solving/blob/company-wise/geeksforgeeks/src/com/practice/company/amazon/BinaryTreeHeight)]
Recursively calculate height of left and right subtrees of a node and assign height to the node as max of the heights of two children plus 1. See below pseudo code and program for details.

## Algorithm
1. If tree is empty then return 0
2. Else
    1. Get the max depth of left subtree recursively  i.e., call maxDepth( tree->left-subtree)
    2. Get the max depth of right subtree recursively  i.e., call maxDepth( tree->right-subtree)
    3. Get the max of max depths of left and right subtrees and add 1 to it for the current node.
        ```
        max_depth = max(max dept of left subtree, max depth of right subtree) + 1
        ```
    4. Return max_depth