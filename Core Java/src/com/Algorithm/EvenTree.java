package com.Algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class EvenTree {
	static int V;
	static int c;
	int arr[];
	static LinkedList<Integer> adj[];
	EvenTree(int v){
		this.V = v;
		c = 0;
		adj = new LinkedList[V];
		arr = new int[V];
		for (int  i = 0; i < V; i++){
			adj[i] = new LinkedList<>();
		}
	}

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        EvenTree tree = new EvenTree(n);
    	for(int y=0;y<m;y++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            tree.adj[a-1].add(b);
            tree.adj[b-1].add(a);
        }
        for(int x = n; x >= 1; x--)
        {
            if(tree.adj[x-1].size() == 1)
            {
            	tree.arr[x-1]=1;
            }
            else
            {
                int count = 1;
                Iterator<Integer> i = tree.adj[x-1].listIterator();
                while (i.hasNext())
                {
                    int w = i.next();
                    if (w < x)
                    {
                        continue;
                    }
                    count += tree.arr[w-1];
                }
                if (count % 2 == 0)
                {
                	tree.c++;
                }
                tree.arr[x-1]=count;
            }
        }
        System.out.println(tree.c-1);
    }
}
