package com.Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class FindAMotherVertexInAGraph {
	private int V; // No. of vertices

	// Array of lists for Adjacency List Representation
	// an array of linked list
	// in this implementation the graph vertex values will be same array index 
	private LinkedList<Integer> adj[];

	FindAMotherVertexInAGraph(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	}
	//Function to add an edge into the graph
	void addEdge(int v, int w)
	{
		adj[v].add(w); // Add w to v's list.
	}
	void DFSUtil(int v,boolean visited[])
	{
		// Mark the current node as visited and print it
		visited[v] = true;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext())
		{
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}
	// The function to do DFS traversal. It uses recursive DFSUtil()
	void DFS()
	{
		// Mark all the vertices as not visited(set as false by default in java)
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++)
		{
			visited[i] = false;
		}    

		// The vertex that finishes last should be the mother node
		int v = -1;
		for (int i = 0; i < V; i++)
		{
			if (visited[i] == false)
			{
				DFSUtil(i, visited);
				v = i;
			}
		}
		// the node that finishes last in DFS can be the mother vertex
		for (int i = 0; i < V; i++)
		{
			visited[i] = false;
		}
		System.out.println(" Mother Vertex Detected At:"  + v);
		// we found the last finishing node
		// need to validate that
		// consider a individual node in the graph. It may not be the last vertex to finish.
		// to we need to confirm that
		DFSUtil(v, visited);
		for(int i = 0; i < V; i++)
		{
			if(visited[i] == false)
			{
				System.out.println("Not a mother vertex.Node that wasn't connected :" + i);        
				return;
			}
		}
		System.out.println(" Mother Vertex: "  + v);
	}
	public static void main(String[] args) {
		FindAMotherVertexInAGraph g = new FindAMotherVertexInAGraph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(4, 1);
		g.addEdge(6, 4);
		g.addEdge(6, 0);
		g.addEdge(5, 2);
		g.addEdge(5, 6);
		// g.addEdge(7, 7);

		// g.printGraph();
		g.DFS();

	}
	void printGraph() 
	{
		for (int j= 0; j < V; ++j)
		{
			System.out.print("j:" + j + " :  ");
			Iterator<Integer> i = adj[j].listIterator();
			while (i.hasNext())
			{
				int n = i.next();
				System.out.print( " " + n + " ");
			}
			System.out.println(" ");
		}    
	}
}
