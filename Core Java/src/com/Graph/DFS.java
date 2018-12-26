package com.Graph;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
public class DFS {
	private int V;
	private static LinkedList<Integer> adj[];
	DFS(int v){
		this.V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < v; i++){
			adj[i] = new LinkedList();
		}
	}
	void addGraph(int i, int w){
		adj[i].add(w);
	}
	void findDFS(int v, LinkedList<Integer> adjj[]){
		boolean visited[] = new boolean[V];
		visited[v] = true; 
        System.out.print(v+" "); 
  
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
            	findDFS(n,adjj); 
        } 
		
	}
	private void DFSUtil(int v, boolean[] visited) {
		visited[v] = true; 
        System.out.print(v+" "); 
  
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
		
	}
	public static void main(String[] args) {
		DFS graph = new DFS(4);
		graph.addGraph(0,1);
		graph.addGraph(0,2);
		graph.addGraph(1,2);
		graph.addGraph(2,0);
		graph.addGraph(2,3);
		graph.addGraph(3,3);
		
		graph.findDFS(2, adj);
	}

}
