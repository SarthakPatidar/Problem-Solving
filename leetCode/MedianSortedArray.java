package leetCode;

import java.util.*;

public class MedianSortedArray {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int a
	}
}

class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      
      double med = 0;
      int pos = (nums1.length + nums2.length)/2;
      int count = 0, head1 = 0, head2 = 0;
      
      if(nums1.length <= 0) {
          med = nums2[pos] + nums2[pos-1];
          return med;     
      }

      if(nums2.length <= 0) {
          med = nums1[pos] + nums1[pos-1];
          return med;     
      }  
      
      while(count < pos) {
          if(nums1[head1] <= nums2[head2]){
              med = nums1[head1];
              nums1[head1] = 0;
              head1 = (head1 < nums1.length) ? head1+1 : head1;
          }
          else{
              med = nums2[head2];
              nums2[head2] = 0;
              head2 = (head2 < nums2.length) ? head2+1 : head2;
          }
          
          count++;
     }
  
     int next = Math.min(nums1[head1], nums2[head2]);
     med = (count % 2 != 0) ? next : (med+next)/2;
     
     return med; 
      
  }
}