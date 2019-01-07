package com.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
	private int V;
	private LinkedList<Integer> adj[];
	TopologicalSort(int v){
		this.V = v;
		adj = new LinkedList[V];
		for (int  i = 0; i < V; i++){
			adj[i] = new LinkedList();
		}
	}
	private void addEdge(int src, int dest){
		adj[src].add(dest);
	}
	private void topologicalSort(){
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++){
			if (!visited[i]){
				topologicalUtil(i, visited, stack);
			}
		}
		while (!stack.isEmpty())
			System.out.print(stack.pop()+" ");
	}
	private void topologicalUtil(int i, boolean[] visited, Stack<Integer> stack) {
		visited[i] = true;
		int n;
		Iterator<Integer> itr = adj[i].listIterator();
		while (itr.hasNext()){
			n = itr.next();
			if (!visited[n])
				topologicalUtil(n, visited, stack);
		}
		stack.push(new Integer(i));
	}
	public static void main(String[] args) {
		TopologicalSort graph = new TopologicalSort(6);
		graph.addEdge(5, 0);
		graph.addEdge(5, 2);
		graph.addEdge(2, 3);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(1, 3);
		
		graph.topologicalSort();
	}

}
