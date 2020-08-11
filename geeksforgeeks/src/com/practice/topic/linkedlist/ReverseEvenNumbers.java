package com.practice.topic.linkedlist;

import java.util.Scanner;
import java.util.Stack;

class Node {
  Object data;
  Node next;
  
  Node(Object data) {
    this.data = data;
  }
}

public class ReverseEvenNumbers {
  
  private static Node head = null;
  
  public static void insertNode(Object data) {
    if(head == null) {
      head = new Node(data);
      return;
    }
        
    Node temp = head;
    while(temp.next != null)
      temp = temp.next;
    
    temp.next = new Node(data);
    return;
  }

  
  public static void main(String[] args) {
    
    int n;
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    
    for(int i=0; i<n; i++) {
       insertNode(sc.nextInt());
    }
    
    Stack<Integer> st = new Stack<>();
    while(head != null) {
      if((int)head.data % 2 == 0)
        st.push((int) head.data);
      else {
        while(!st.isEmpty()) {
          System.out.println(st.pop());
        }
        System.out.println(head.data);    
      }
      
      head = head.next;
    }
    
    while(!st.isEmpty())
      System.out.println(st.pop());
    
    sc.close();
  }
}
