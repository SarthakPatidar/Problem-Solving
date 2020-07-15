package com.practice.topic.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearchIterative {

  public Map<Integer, List<Integer>> getGraph() {

    GraphUtil graphUtil = new GraphUtil();

    graphUtil.addNode(0);
    graphUtil.addNode(1);
    graphUtil.addNode(2);
    graphUtil.addNode(3);
    graphUtil.addNode(4);

    graphUtil.addEdge(1, 0);
    graphUtil.addEdge(0, 2);
    graphUtil.addEdge(2, 1);
    graphUtil.addEdge(0, 3);
    graphUtil.addEdge(1, 4);

    return graphUtil.getAdjList();
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    Map<Integer, List<Integer>> adjList = new DepthFirstSearchIterative().getGraph();

    int src = sc.nextInt();
    Stack<Integer> st = new Stack<>();
    Set<Integer> visited = new HashSet<>();

    st.push(src);

    while(!st.isEmpty()) {
      System.out.println(st.peek());
      visited.add(st.peek());

      src = st.pop();
      List<Integer> neighbors = adjList.get(src);

      neighbors.forEach((neighbor) -> {
        if(!visited.contains(neighbor))
          st.push(neighbor);
        visited.add(neighbor);
      });
    }

    sc.close();

  }
}
