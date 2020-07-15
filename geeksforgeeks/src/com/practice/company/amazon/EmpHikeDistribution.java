package com.practice.company.amazon;

import java.util.Scanner;

public class EmpHikeDistribution {
  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();

    int[] salary = new int[size+2];
    salary[0] = Integer.MAX_VALUE;
    salary[size+1] = Integer.MAX_VALUE;

    for(int i=1; i<=size; i++)
      salary[i] = sc.nextInt();

    int[] hike = new int[size+2];

    for(int i=0; i<size+2; i++)
      hike[i] = 0;


    int[] distributedHike = getHikeDistribution(salary, hike, size);

    for(int i=1; i<=size; i++) {
      System.out.println(distributedHike[i] + " ");
    }

    sc.close();

  }

  private static int[] getHikeDistribution(int[] salary, int[] hike, int size) {

    for(int i=1; i<=size; i++) {
      if(salary[i] <= salary[i-1] && salary[i] <= salary[i+1]) {
        hike[i] = 1;
      }
    }

    for(int i=1; i<=size; i++) {
      if(salary[i] > salary[i-1] && salary[i] <= salary[i+1]) {
        hike[i] = hike[i-1] + 1;
      }
    }

    for(int i=1; i<=size; i++) {
      if(salary[i] <= salary[i-1] && salary[i] > salary[i+1]) {
        hike[i] = hike[i+1] + 1;
      }
    }

    for(int i=1; i<=size; i++) {
      if(salary[i] > salary[i-1] && salary[i] > salary[i+1]) {
        hike[i] = Math.max(hike[i-1], hike[i+1]) + 1;
      }
    }

    return hike;

  }
}
