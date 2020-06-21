package com.practice.company.google;

import java.util.Scanner;

public class MaximumIndex {
  public static void main(String[] args) {
    int t,n;

    Scanner sc = new Scanner(System.in);
    t = sc.nextInt();

    while(t > 0) {

      n = sc.nextInt();
      int[] arr = new int[n];

      for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

      int[] Lmin = new int[n];
      int[] Rmax = new int[n];

      Lmin[0] = arr[0];
      for(int i=1; i<n; i++)
        Lmin[i] = Math.min(arr[i], Lmin[i-1]);

      Rmax[n-1] = arr[n-1];
      for(int i=n-2; i>=0; i--)
        Rmax[i] = Math.max(arr[i], Rmax[i+1]);

      int i = 0, j=0, maxDiff = -1;
      while(i < n && j < n) {

        if(Lmin[i] <= Rmax[j]) {
          j++;
          maxDiff = Math.max(maxDiff, j-i);
        }
        else
          i++;
      }

      System.out.println(maxDiff);
      t--;
    }

    sc.close();
  }
}
