package com.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DetectCycleInADirectedGraph {
	private int V;
	private static List<List<Integer>> adj; 
	  
    public DetectCycleInADirectedGraph(int V)  
    { 
        this.V = V; 
        adj = new ArrayList<>(V); 
          
        for (int i = 0; i < V; i++) 
            adj.add(new LinkedList<>()); 
    } 
	private void addEdge(int i, int w){
		adj.get(i).add(w); 
	}
	private static boolean isCyclicUtil(int i, boolean[] visited, boolean[] explored){
		
		/*LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		explored[start] = true;
		queue.add(start);
		
		while (!queue.isEmpty()){
			start = queue.poll();
			System.out.print(start+" ");
			Iterator<Integer> itr = adj[start].listIterator();
			while (itr.hasNext()){
				int n = itr.next();
				if (!visited[n] && !explored[n]){
					explored[start] = true;
					visited[n] = true;
					queue.add(n);
				}else{
					return 1;
				}
			}
		}
		return 0;*/
		if (explored[i]) 
			return true; 

		if (visited[i]) 
			return false; 

		visited[i] = true; 

		explored[i] = true; 
		List<Integer> children = adj.get(i); 

		for (Integer c: children) 
			if (isCyclicUtil(c, visited, explored)) 
				return true; 

		explored[i] = false; 

		return false; 
	}
	 private boolean isCyclic()  
	    { 
	          
	        // Mark all the vertices as not visited and 
	        // not part of recursion stack 
	        boolean[] visited = new boolean[V]; 
	        boolean[] recStack = new boolean[V]; 
	          
	          
	        // Call the recursive helper function to 
	        // detect cycle in different DFS trees 
	        for (int i = 0; i < V; i++) 
	            if (isCyclicUtil(i, visited, recStack)) 
	                return true; 
	  
	        return false; 
	    } 
	public static void main(String[] args) {
		DetectCycleInADirectedGraph graph = new DetectCycleInADirectedGraph(4);
        /*graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3);*/ 
        
		graph.addEdge(0, 1);
		graph.addEdge(1, 0);
		if (graph.isCyclic()){
			System.out.println("Cycle Detected");
		}else{
			System.out.println("Graph with out cycle");
		}
	}

}
