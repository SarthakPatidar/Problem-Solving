package com.practice.miscellaneous;

import java.util.Scanner;
import java.util.Stack;

public class MsOffice {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    String res[] = new String[n];
    char alpha[] = new char[26];
    
    for(int i=0; i<26; i++) {
      alpha[i] = (char)(65+i);
    }
    
    for(int i=0; i<n; i++) {
      res[i] = getColNum(sc.nextInt(), alpha);
    }  
    
    for(int i=0; i<n; i++) {
      System.out.println(res[i]);
    }     
    
    sc.close();
  }

  private static String getColNum(int nextInt, char[] alpha) {
     
      String res = "";
      Stack<String> st = new Stack<>();
    
      while(nextInt != 0) {
        int index = (nextInt-1) % 26;
        st.push(String.valueOf(alpha[index]));
        nextInt = (nextInt-1) / 26;
      }
      
      while(!st.isEmpty()) {
        res += st.pop();
      }
      
      return res;
  }

}
