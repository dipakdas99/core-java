package com.Algorithm;

public class InterleavedStrings {
	
	public static void main(String[] args) {
		String a = "XY";
		String b = "X";
		String c = "XXY";
		System.out.println(isInterleave(a.toCharArray(), b.toCharArray(), c.toCharArray()));
	}

	private static boolean isInterleave(char[] a, char[] b, char[] c) {
		int m = a.length, n = b.length;
		boolean table[][] = new boolean[m+1][n+1];
		
		if ((m+n) != c.length)
			return false;
		for (int i = 0; i <= m; ++i){
			for (int j = 0; j <= n; ++j){
				if (i == 0 && j == 0)
					table[i][j] = true;
				
				else if (j-1 >= 0 && i == 0 && b[j-1] == c[j-1])
					table[i][j] = table[i][j-1];
				
				else if (i-1 >= 0 && j==0 && a[i-1] == c[i-1])
					table[i][j] = table[i-1][j];
				
				else if (j-1 >= 0 && i-1 >= 0 && a[i-1] == c[i+j-1] && b[j-1] != c[i+j-1])
					table[i][j] = table[i-1][j];
				
				else if (j-1 >= 0 && a[i-1] != c[i+j-1] && b[j-1] == c[i+j-1])
					table[i][j] = table[i][j-1];
				
				else if (j-1 >= 0 && i-1 >= 0 && a[i-1] == c[i+j-1] && b[j-1]== c[i+j-1])
					table[i][j] = (table[i-1][j] || table[i][j-1]);
			}
		}
		return table[m][n];
	}
}
