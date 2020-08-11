package com.practice.topic.stack;

import java.util.Scanner;
import java.util.Stack;

public class NextSmallerElement {
  
  public static void main(String[] args) {
    int n, arr[], result[];
    
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    arr = new int[n];
    result = new int[n];
    
    for(int i=0; i<n; i++)
      arr[i] = sc.nextInt();
    
    Stack<Integer> st = new Stack<>();
    
    for(int i=0; i<n; i++) {
      
      while(!st.isEmpty() && arr[i] < arr[st.peek()])
        result[st.pop()] = arr[i]; 
      
      st.push(i);
    }
    
    while(!st.isEmpty())
      result[st.pop()] = -1;
    
    
    for(int i=0; i<n; i++) {
      System.out.println(result[i]);
    }    
    
    sc.close();
    
  }
}
