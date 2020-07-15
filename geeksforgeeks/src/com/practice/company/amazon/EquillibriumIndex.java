package com.practice.company.amazon;

import java.util.Scanner;

public class EquillibriumIndex {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n];
    for(int i=0; i<n; i++)
      arr[i] = sc.nextInt();

    sc.close();
    int leftSum = 0, rightSum, total = 0;

    for(int i=0; i<n; i++)
      total += arr[i];

    for(int i=0; i<n; i++) {
      rightSum = total - (leftSum + arr[i]);

      if(leftSum == rightSum) {
        System.out.println("Equilibrium Index = "+i);
        return;
      }

      leftSum += arr[i] ;
    }

    System.out.println("Equilibrium Index = -1");

  }
}
