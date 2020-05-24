package dataStructure.minHeap;

public class MinHeapImpl {
	private static int[] Heap;
	private static int size;
	private int maxSize;

	public MinHeapImpl(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		Heap = new int[this.maxSize];
	}

	private boolean isLeaf(int pos) {
		if(pos >= (size-1)/2 && pos <= size-1)
			return true;

		return false;
	}

	private boolean hasParent(int pos) {
		return parent(pos) >= 0;
	}

	private boolean hasLeftChild(int pos) {
		return leftChild(pos) < size;
	}

	private boolean hasRightChild(int pos) {
		return rightChild(pos) < size;
	}

	private void minHeapify(int pos) {
		if(!isLeaf(pos)) {
			if(Heap[pos] > Heap[leftChild(pos)] ||
					Heap[pos] > Heap[rightChild(pos)]) {

				if(Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				}
				else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}

	private void minHeap() {
    for (int pos = (size-1)/2; pos >= 0; pos--) {
      minHeapify(pos);
    }
	}

	private int parent(int pos) {
			return (pos-1)/2;
	}

	private int leftChild(int pos) {
		return 2*pos + 1;
	}

	private int rightChild(int pos) {
		return 2*pos + 2;
	}

	private void swap(int l, int r) {
		int temp = Heap[l];
		Heap[l] = Heap[r];
		Heap[r] = temp;
	}


	private void insert(int i) {
		if(size >= maxSize)
			return;

		Heap[size] = i;
		size++;

		int current = size-1;

		while(hasParent(current) && Heap[current] < Heap[parent(current)]) {
				swap(current, parent(current));
				current = parent(current);
		}
	}

	private int remove() {
		int popped = Heap[0];
		Heap[0] = Heap[size-1];
		size--;
		minHeapify(0);
		return popped;
	}

	public void print()
	{
		for (int i = 0; i < (size-1)/ 2; i++) {
			System.out.print(" PARENT : " + Heap[i]
							+ " LEFT CHILD : " + Heap[2 * i + 1]
							+ " RIGHT CHILD :" + Heap[2 * i + 2]);
			System.out.println();
		}
	}


	public static void main(String args[]) {
		MinHeapImpl minHeap = new MinHeapImpl(15);
    minHeap.insert(5);
    minHeap.insert(3);
    minHeap.insert(17);
    minHeap.insert(10);
    minHeap.insert(84);
    minHeap.insert(19);
    minHeap.insert(6);
    minHeap.insert(22);
    minHeap.insert(9);
    minHeap.print();

    System.out.println("Removed Element = "+minHeap.remove());
	}


}
