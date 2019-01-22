package com.Algorithm;

import java.util.Collections;
import java.util.Scanner;

public class TheGridSearch {
	static String gridSearch(String[] G, String[] P) {
		/*int count = 0;
		String res = "NO";
		int start = 0;
		String prev = "";
		for (int i = 0; i < G.length; i++){
			if (prev.equals(P[start]))
				count = count-1;
			boolean flag = isPatternMatched(G[i], P[start]);
			prev = P[start];
			if (flag){
				count++;
				start++;
			}else{
				count = 0;
				start = 0;
			}
			if (count == P.length){
				res = "YES";
				return res;
			}
		}
		return res;*/
		int n = G[0].length() - P[0].length() + 1;
	    String delimiter = " ";
	    String pad = String.format(".{%s}", n);
	    String grid = String.format("%s%s", String.join(delimiter, G), String.join("", Collections.nCopies(n, delimiter)));
	    String regex = String.format(".*%s%s.*", String.join(pad, P), pad);
	    return grid.matches(regex)? "YES" : "NO";
    }

    private static boolean isPatternMatched(String g, String p) {
    	int start = 0;
		for (int i = 0; i < g.length(); i++){
			if (g.charAt(i) == p.charAt(start)){
				start++;
			}else if (start > 0 && g.charAt(i) != p.charAt(start)){
				i = i -start;
				start = 0;
			}
			else
				start = 0;
			
			if (start == p.length())
				return true;
		}
		return false;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {
            //String[] RC = scanner.nextLine().split(" ");

            /*int R = Integer.parseInt(RC[0]);
            int C = Integer.parseInt(RC[1]);*/
        	int R = scanner.nextInt();
            int C = scanner.nextInt();

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.next();
                G[i] = GItem.trim();
            }
            //String[] rc = scanner.next().split(" ");

            int r = scanner.nextInt();

            int c = scanner.nextInt();

            String[] P = new String[r];

            for (int j = 0; j < r; j++) {
                String PItem = scanner.next();
            	P[j] = PItem.trim();
            }

            String result = gridSearch(G, P);
            System.out.println(result);
        }
        scanner.close();
    }

}
