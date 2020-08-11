package com.practice.topic.stack;

import java.util.Scanner;
import java.util.Stack;

public class GameOfNumbers {
  
  public static void main(String[] args) {
    int n, arr[], nextGreater[], nextSmaller[];
    
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    arr = new int[n];
    nextGreater = new int[n];
    nextSmaller = new int[n];
    
    for(int i=0; i<n; i++)
      arr[i] = sc.nextInt();
    
    Stack<Integer> st = new Stack<>();
    
    for(int i=0; i<n; i++) {      
      while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
        nextGreater[st.pop()] = i;
      }  
      st.push(i);
    }
    
    while(!st.isEmpty())
      nextGreater[st.pop()] = -1;
    

    for(int i=0; i<n; i++) {
      
      while(!st.isEmpty() && arr[i] < arr[st.peek()])
        nextSmaller[st.pop()] = i; 
      
      st.push(i);
    }
    
    while(!st.isEmpty())
      nextSmaller[st.pop()] = -1;
    
    for(int i=0; i<n; i++) {
      if(nextGreater[i] == -1)
        System.out.println("-1");
      else
        System.out.println(arr[nextSmaller[nextGreater[i]]]);
    }    
    
    sc.close();
  }
}
