package com.practice.company.google;

import java.util.Scanner;

public class SubarrayWithGivenSum {

  public static void main(String[] args) {
    int t, n, curr_sum, sum, start, end;

    Scanner sc = new Scanner(System.in);
    t = sc.nextInt();

    while(t > 0) {
      n = sc.nextInt();
      sum = sc.nextInt();
      start = 0;

      int arr[] = new int[n];
      for(int i=0; i<n; i++)
        arr[i] = sc.nextInt();

      curr_sum = arr[start];

      for(end=1; end<=n; end++) {
        while(curr_sum > sum && start < end-1) {
          curr_sum -= arr[start];
          start++;
        }

        if(curr_sum == sum) {
          System.out.print("Start = " + (start+1) + " ");
          System.out.println("End = " + end);
          break;
        }

        if(end < n)
          curr_sum += arr[end];
      }

      if(end == n+1)
        System.out.println("-1");

      t--;
    }

    sc.close();
  }
}