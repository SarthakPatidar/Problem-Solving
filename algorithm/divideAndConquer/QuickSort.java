package algorithm.divideAndConquer;

import java.util.*;

public class QuickSort {
	
	/**
	 * Recursive Code for partition and sorting array. 
	 */
	public static void quickSort(int[] arr, int low, int high) {
		if(low < high) {
			int pi = partition(arr, low, high);
			
			quickSort(arr,low,pi-1);
			quickSort(arr,pi+1,high);	
		}
	}
	
	/**
	 * @param arr - Input Array
	 * @param low - Lower Index
	 * @param high - Upper Index
	 * @return - Index of element that is placed at its correct index in sorted array.
	 * 
	 */
	private static int partition(int[] arr, int low, int high) {
		
		// i = Index of element smaller than pivot
		int pivot = arr[high], i = low-1;
		
		for(int j = low; j <= high-1; j++) {
			if(arr[j] <= pivot) {
				i++;
				
				// swap(arr[i], arr[j])
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
	  // swap(arr[i+1], arr[high])
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;		
		
		return i+1;
	}

	/**
	 * Utility for printing array
	 */
	private static void printArray(int[] arr) {
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}	

	/**
	 * Entry point for QuickSort Algorithm
	 */
	public static void main(String args[]) {
		int n;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		quickSort(arr,0,arr.length-1);
		printArray(arr);
		sc.close();
	}
}
