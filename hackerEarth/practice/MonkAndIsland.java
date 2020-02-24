package hackerEarth.practice;

import java.util.*;

public class MonkAndIsland {
	
  private int numVertices;
  private LinkedList<Integer> adjList[];

  public MonkAndIsland(int vertices) {
      numVertices = vertices;
      adjList = new LinkedList[numVertices+1];
      
      for(int i=1; i<=numVertices; i++)
          adjList[i] = new LinkedList<>();
  }
      
  public void addEdge(int src, int dest){
      adjList[src].add(dest);
      adjList[dest].add(src);
  }
  
  public int bfs(int start){
      int count = 0;
      
      if(numVertices == 1)
          return 0;
      
      boolean[] visited = new boolean[numVertices+1];
      
      LinkedList<Integer> queue = new LinkedList<>();
      LinkedList<Integer> hopsRequired = new LinkedList<>();
      
      queue.add(start);
      hopsRequired.add(start);
      
      while(queue.size() != 0) {
          start = queue.poll();
          int hops = hopsRequired.remove();
          
          Iterator<Integer> li = adjList[start].listIterator();
          while(li.hasNext())
          {
              int n = li.next();
              if(n == numVertices)
                  return hops;
                  
              queue.add(n);
              hopsRequired.add(hops+1);
          }
          
      }
    
      return -1;  
      
  }
  
  public static void main(String args[] ) throws Exception {
      
      int t, vertices, numEdges;
      //Scanner
      Scanner sc = new Scanner(System.in);
      t = sc.nextInt();
      
      while(t > 0){
          vertices = sc.nextInt();
          numEdges = sc.nextInt();
          
          MonkAndIsland graph = new MonkAndIsland(vertices);
          
          for(int i=0; i < numEdges; i++)
              graph.addEdge(sc.nextInt(),sc.nextInt());
              
          int ans = graph.bfs(1);    
          System.out.println(ans);   
              
          t--;
      }

  }
}
