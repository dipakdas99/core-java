package com.HackerRank.DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class ComponentsInAGraph {
	static HashMap<Integer, ArrayList<Integer>> nodes;
	ComponentsInAGraph(int v){
		nodes = new HashMap<>();
        for (int i = 1; i <= 2*v; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(i);
            nodes.put(i, list);
        }
	}
	private void addEdge(int src, int dist) {
		 ArrayList<Integer> list1 = nodes.get(src);
         ArrayList<Integer> list2 = nodes.get(dist);
         if (list1 != list2) {
             list1.addAll(list2);
             list2.forEach(i -> nodes.put(i, list1));
         }
	}
	static void findComponentsInGraph(int s) {
		ArrayList<Integer> vertices = new ArrayList<Integer>();
        
        for (ArrayList<Integer> list : nodes.values()) {
            if (list.size() > 1)
                vertices.add(list.size());
            list.clear();
        }
        System.out.print(Collections.min(vertices) + " ");
        System.out.println(Collections.max(vertices));
    }

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = Integer.parseInt(scanner.nextLine().trim());
        ComponentsInAGraph graph = new ComponentsInAGraph(n);

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
        	int src = scanner.nextInt();
        	int dist = scanner.nextInt();
            graph.addEdge(src, dist);
        }
        findComponentsInGraph(1);
    }
}
