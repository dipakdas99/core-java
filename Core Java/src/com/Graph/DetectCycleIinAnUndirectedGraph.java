package com.Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DetectCycleIinAnUndirectedGraph {
	private int V;
	private static LinkedList<Integer> adj[];
	public DetectCycleIinAnUndirectedGraph(int v) {
		this.V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++){
			adj[i] = new LinkedList<>();
		}
	}
	private void addEdge(int i, int w){
		adj[i].add(w);
		adj[w].add(i);
	}
	private boolean isCyclic(int v, LinkedList<Integer>[] adj) {
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++){
			visited[i] = false;
		}
		for (int u = 0; u < V; u++){
			if (!visited[u]){
				if (isCyclicUtil(u, visited, -1))
					return true;
			}
		}
		return false;
	}
	private boolean isCyclicUtil(int u, boolean[] visited, int parent) {
		visited[u] = true;
		int i;
		Iterator<Integer> it = adj[u].iterator();
		while (it.hasNext()){
			i = it.next();
			if (!visited[i]){
				if (isCyclicUtil(i, visited, u))
					return true;
			}
			else if (i != parent)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		DetectCycleIinAnUndirectedGraph graph = new DetectCycleIinAnUndirectedGraph(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		System.out.println(graph.isCyclic(0, adj));
	}
}
