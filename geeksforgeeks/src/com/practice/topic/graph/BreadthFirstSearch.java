package com.practice.topic.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BreadthFirstSearch {

  public Map<Integer, List<Integer>> getGraph() {

    GraphUtil graphUtil = new GraphUtil();

    graphUtil.addNode(0);
    graphUtil.addNode(1);
    graphUtil.addNode(2);
    graphUtil.addNode(3);

    graphUtil.addEdge(0, 1);
    graphUtil.addEdge(0, 2);
    graphUtil.addEdge(1, 2);
    graphUtil.addEdge(2, 0);
    graphUtil.addEdge(2, 3);
    graphUtil.addEdge(3, 3);

    return graphUtil.getAdjList();
  }

  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);
    int src = sc.nextInt();

    Map<Integer, List<Integer>> adjList = new BreadthFirstSearch().getGraph();
    Set<Integer> visited = new HashSet<Integer>();

    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(src);

    while(!queue.isEmpty()) {
      int source = queue.poll();

      System.out.println(source);

      visited.add(source);
      List<Integer> neighbors = adjList.get(source);

      neighbors.forEach((dest) -> {
        if(!visited.contains(dest)) {
          queue.add(dest);
          visited.add(source);
        }
      });
    }

    sc.close();
  }
}
