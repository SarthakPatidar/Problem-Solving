# Minimum Heap [[Code](https://github.com/SarthakPatidar/Problem-Solving/blob/company-wise/geeksforgeeks/src/com/practice/company/amazon/MinHeap)]
* Complete Binary Tree
* Each internal node <= value in children of that node.

## Representation of Min Heap
* A Min heap is typically represented as array.
* If node is stored at index k
    1. Left child Index = 2*k + 1
    2. Right child Index = 2*k - 1
    3. Parent Index = (k-1)/2

## Operations
1. <b>getMin()</b> : It returns the root element of Min Heap. Time Complexity of this operation is O(1).
2. <b>extractMin()</b> : Removes the minimum element from MinHeap. Time Complexity of this Operation is O(Log n) as this operation needs to maintain the heap property (by calling heapify()) after removing root.
3. <b>insert()</b> : Inserting a new key takes O(Log n) time. We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.