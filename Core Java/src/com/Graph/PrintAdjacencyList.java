package com.Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
public class PrintAdjacencyList {
	private int V;
	private LinkedList<Integer> adj[];
	public PrintAdjacencyList(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++){
			adj[i] = new LinkedList();
		}
	}
	void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}
	void printGraph(){
		for (int k = 0; k < V; k++){
			System.out.print(k);
			for (Integer list : adj[k]){
				System.out.print("-> "+list);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int noOfInput = Integer.parseInt(bf.readLine().trim());
		for (int i = 0; i < noOfInput; i++){
			String vertces = bf.readLine().trim();
			int noOfVertex = Integer.parseInt(vertces.split(" ")[0]);
			int noOfElements = Integer.parseInt(vertces.split(" ")[0]);
			/*int noOfVertex = Integer.parseInt(bf.readLine().trim());*/
			PrintAdjacencyList graph = new PrintAdjacencyList(noOfVertex);
			/*int noOfElements = Integer.parseInt(bf.readLine().trim());*/
			for (int j = 0; j < noOfElements; j++){
				String edge = bf.readLine().trim();
				/*int w = Integer.parseInt(bf.readLine().trim());*/
				int v = Integer.parseInt(edge.split(" ")[0]);
				int w = Integer.parseInt(edge.split(" ")[0]);
			    graph.addEdge(v,w);
			}
			
		}
		/*PrintAdjacencyList graph = new PrintAdjacencyList(5);
		graph.addEdge(0, 1); 
		graph.addEdge(0, 4); 
		graph.addEdge(1, 2); 
		graph.addEdge(1, 3); 
		graph.addEdge(1, 4); 
		graph.addEdge(2, 3); 
		graph.addEdge(3, 4);
		graph.printGraph();*/
	}

}
