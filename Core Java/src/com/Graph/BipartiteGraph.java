package com.Graph;

import java.util.LinkedList;

public class BipartiteGraph {
	private static int V = 3;
	public static void main(String[] args) {
		/*int G[][] = {{0, 1, 0, 1}, 
					{1, 0, 1, 0}, 
					{0, 1, 0, 1}, 
					{1, 0, 1, 0}}; */
		int G[][] = {{0, 1, 0 },
					{0, 0, 1},
					{0, 1, 0}};

		if (isBipartite(G)) 
			System.out.println("Yes"); 
		else
			System.out.println("No");

	}

	private static boolean isBipartite(int[][] g) {
		int color[] = new int[V];
		for (int i = 0; i < V; i++){
			color[i] = -1;
		}
		for (int i = 0; i < V; i++){ 
			if (color[i] == -1) {
				if (isBipartiteUtil(g, i, color) == false) 
					return false; 
			}
		}  
		return true; 
	}

	private static boolean isBipartiteUtil(int G[][], int src,int colorArr[]) {
		colorArr[src] = 1;
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(src);
		while (!q.isEmpty()){
			int u = q.getFirst();
			q.pop();
			if (G[u][u] == 1)
				return false;
			for (int v = 0; v < V; v++){
				if (G[u][v] == 1 && colorArr[v] == -1){
					colorArr[v] = 1 - colorArr[u];
					q.push(v);
				}else if (G[u][v] == 1 && colorArr[u] == colorArr[v]){
					return false;
				}
			}
		}
		return true;
	}

}
