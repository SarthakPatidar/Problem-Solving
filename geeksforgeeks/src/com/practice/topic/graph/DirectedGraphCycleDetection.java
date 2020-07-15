package com.practice.topic.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DirectedGraphCycleDetection {

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

  private static boolean isCycle(Integer srcNode, Set<Integer> visited, Set<Integer> recursiveStack) {
    if(recursiveStack.contains(srcNode))
      return true;

    if(visited.contains(srcNode))
      return false;

    recursiveStack.add(srcNode);
    visited.add(srcNode);

    List<Integer> neighbors = adjList.get(srcNode);

    for(int i=0; i<neighbors.size(); i++) {
      if(isCycle(neighbors.get(i), visited, recursiveStack))
        return true;
    };


    recursiveStack.remove(srcNode);
    return false;
  }

  public static void main(String args[]) {

    adjList = new DirectedGraphCycleDetection().getGraph();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> recursiveStack = new HashSet<>();

    Iterator<Integer> itr = adjList.keySet().iterator();

    while(itr.hasNext()) {
      if(isCycle(itr.next(), visited, recursiveStack)) {
        System.out.println("The graph is cyclic");
        return;
      }
    }

    System.out.println("The graph does not have cycle");
  }


}
