package com.practice.topic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphUtil {
  private Map<Integer, List<Integer>> adjList;

  public Map<Integer, List<Integer>> getAdjList() {
    return adjList;
  }

  public GraphUtil() {
    adjList = new HashMap<Integer, List<Integer>>();
  }

  public void addNode(int val) {
    adjList.put(val, new ArrayList<Integer>());
  }

  public void addEdge(int src, int dest) {
    adjList.get(src).add(dest);
  }

}
