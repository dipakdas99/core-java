package com.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountLuck {
	static String countLuck(String[] matrix, int k) {
	 int[] startPoint = null, endPoint = null;
	    for (int r = 0; r < matrix.length; r++) {
	        for (int c = 0; c < matrix[r].length(); c++) {
	            if (matrix[r].charAt(c) == 'M') {
	                startPoint = new int[] { r, c };
	                if (endPoint != null) {
	                    break;
	                }
	            } else if (matrix[r].charAt(c) == '*') {
	                endPoint = new int[] { r, c };
	                if (startPoint != null) {
	                    break;
	                }
	            }
	        }
	    }

	    boolean[][] visited = new boolean[matrix.length][matrix[0].length()];
	    int count = 0;
	    count = countWaves(matrix, startPoint, endPoint, visited);
	    return count == k ? "Impressed" : "Oops!";
	}

	static int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int NO_WAY = -1;

	static int countWaves(String[] matrix, int[] startPoint, int[] endPoint, boolean[][] visited) {
	    if (startPoint[0] == endPoint[0] && startPoint[1] == endPoint[1]) {
	        return 0;
	    }
	    visited[startPoint[0]][startPoint[1]] = true;

	    List<int[]> nextPoints = new ArrayList<>();
	    for (int[] direction : directions) {
	        int r = startPoint[0] + direction[0],
	            c = startPoint[1] + direction[1];
	        if (0 <= r && r < matrix.length && 0 <= c && c < matrix[r].length() && matrix[r].charAt(c) != 'X' && !visited[r][c]) {
	            nextPoints.add(new int[]{ r, c });
	        }
	    }

	    if (nextPoints.size() == 0) {
	        return NO_WAY;
	    } else if (nextPoints.size() == 1) {
	        int[] nextPoint = nextPoints.get(0);
	        int count = countWaves(matrix, nextPoint, endPoint, visited);
	        return count != NO_WAY ? count : NO_WAY;
	    } else {
	        for (int[] nextPoint : nextPoints) {
	            int count = countWaves(matrix, nextPoint, endPoint, visited);
	            if (count != NO_WAY) {
	                return count + 1;
	            }
	        }
	        return NO_WAY;
	    }
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scanner.nextInt();

		for (int tItr = 0; tItr < t; tItr++) {

			int n = scanner.nextInt();

			int m = scanner.nextInt();

			String[] matrix = new String[n];

			for (int i = 0; i < n; i++) {
				matrix[i] = scanner.next();
			}

			int k = scanner.nextInt();
			System.out.println();
			String result = countLuck(matrix, k);
			System.out.println(result);
		}
		System.out.println();
		scanner.close();
	}
}
