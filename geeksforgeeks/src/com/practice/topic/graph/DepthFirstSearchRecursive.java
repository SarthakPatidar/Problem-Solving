package com.practice.topic.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DepthFirstSearchRecursive {

  private static Map<Integer, List<Integer>> adjList;

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

  private static void DfsUtil(int src, Set<Integer> visited) {

    if(!visited.contains(src)) {
      System.out.println(src);
      visited.add(src);
    }

    List<Integer> neighbors = adjList.get(src);
    neighbors.forEach((neighbor) -> {
      if(!visited.contains(neighbor))
        DfsUtil(neighbor, visited);
    });

  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int src = sc.nextInt();

    adjList = new DepthFirstSearchRecursive().getGraph();
    Set<Integer> visited = new HashSet<>();

    DfsUtil(src, visited);

    sc.close();
  }



}
