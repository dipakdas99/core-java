package com.Graph;
import java.util.Iterator;
import java.util.LinkedList;

public class FindMotherVertex {
	private final int V;
	private LinkedList<Integer> adj[];
	
	FindMotherVertex(int v){
		this.V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++){
			adj[i] = new LinkedList();
		}
	}
	private void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	public int findMother(){
		boolean visited[] = new boolean[V];
		//initially all vertex will be false
		for (int i = 0; i < V; i++){
			visited[i] = false;
		}
		//Starting vertex is 0
		int v = 0;
		for (int i = 0; i < V; i++){
			if (visited[i] == false){
				// calling DFS for visit the vertex 
				DFSUtil(i,visited);
				v = i;
			}
		}
		// again making all vertex as false
		for (int i = 0; i < V ; i++){
			visited[i] = false;
		}
		//Calling DFS from last visiting vertex
		DFSUtil(v,visited);
		for (int i = 0; i < V; i++){
			if (visited[i] == false){
				//if all vertex is not false then there is no mother vertex
				return -1;
			}
		}//else
		return v;
	}
	private void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		 Iterator<Integer> i = adj[v].listIterator(); 
	        while (i.hasNext()) 
	        { 
	            int n = i.next(); 
	            if (!visited[n]) 
	            	DFSUtil(n,visited); 
	        } 
		
	}
	public static void main(String[] args) {
		FindMotherVertex g = new FindMotherVertex(7);
		g.addEdge(0, 1); 
	    g.addEdge(0, 2); 
	    g.addEdge(1, 3); 
	    g.addEdge(4, 1); 
	    g.addEdge(6, 4); 
	    g.addEdge(5, 6); 
	    g.addEdge(5, 2); 
	    g.addEdge(6, 0);
	    
	    int motherVertex = g.findMother();
	    System.out.println(motherVertex);
	}

}
