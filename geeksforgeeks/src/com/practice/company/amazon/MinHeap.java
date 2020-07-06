package com.practice.company.amazon;

public class MinHeap {

  private int maxSize;
  private int size;
  private int[] Heap;
  private int FRONT = 1;

  public MinHeap(int maxSize) {
    this.maxSize = maxSize;
    this.size = 0;
    Heap = new int[this.maxSize + 1];
    Heap[0] = Integer.MIN_VALUE;
  }

  public boolean isLeaf(int pos) {
    if(pos >= (size/2) && pos <= size) {
      return  true;
    }
    return false;
  }

  public int getParent(int pos) {
    return pos/2;
  }

  public int getLeftChild(int pos) {
    return 2*pos;
  }

  public int getRightChild(int pos) {
    return 2*pos + 1;
  }

  public void swap(int current, int parent) {
    int temp = Heap[current];
    Heap[current] = Heap[parent];
    Heap[parent] = temp;
  }

  public int pop() {
    int popped = Heap[FRONT];
    Heap[FRONT] = Heap[size--];
    minHeapify(FRONT);
    return popped;
  }

  public void minHeap() {
    for(int pos=(size/2); pos >= 1; pos--) {
      minHeapify(pos);
    }
  }

  public void print() {
    for(int pos=1; pos<=(size/2); pos++) {
      System.out.println("Element = " + Heap[pos]);
      System.out.println("Left Child = " + Heap[2*pos]);
      System.out.println("Reft Child = " + Heap[2*pos+1]);
    }
  }


  public void minHeapify(int pos) {
    if(!isLeaf(pos)) {
      if(Heap[pos] > Heap[getLeftChild(pos)]
          || Heap[pos] > Heap[getRightChild(pos)]) {


        if(Heap[getRightChild(pos)] < Heap[getLeftChild(pos)]) {
          swap(pos, getRightChild(pos));
          minHeapify(getRightChild(pos));
        }

        else {
          swap(pos, getLeftChild(pos));
          minHeapify(getLeftChild(pos));
        }
      }
    }

  }

  public void insert(int element) {

    if (size >= maxSize) {
      return;
    }

    Heap[++size] = element;
    int current = size;

    while(Heap[current] < Heap[getParent(current)]) {
      swap(current, getParent(current));
      current = getParent(current);
    }
  }

  public static void main(String[] args) {
    MinHeap minHeap = new MinHeap(15);
    minHeap.insert(5);
    minHeap.insert(3);
    minHeap.insert(17);
    minHeap.insert(10);
    minHeap.insert(84);
    minHeap.insert(19);
    minHeap.insert(6);
    minHeap.insert(22);
    minHeap.insert(9);
    minHeap.minHeap();

    minHeap.print();
    System.out.println("The Min val is " + minHeap.pop());
    System.out.println("The Min val is " + minHeap.pop());
  }

}
