package com.HackerRank.DataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CastleOnTheGrid {
	static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
	static int NO_WAY = -1;
	static int minimumMoves(String[] matrix, int[] startPoint, int[] endPoint, boolean[][] visited) {
	    if (startPoint[0] == endPoint[0] && startPoint[1] == endPoint[1]) {
	        return 1;
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
	    int prevX = 0;
	    int prevY = 0;
	    if (nextPoints.size() == 0) {
	        return NO_WAY;
	    } else if (nextPoints.size() == 1) {
	        int[] nextPoint = nextPoints.get(0);
	       
	        int count = minimumMoves(matrix, nextPoint, endPoint, visited);
	        if (prevX == nextPoint[0] && prevY == nextPoint[0]){
	        	return count+1;
	        }
	        prevX = nextPoint[0];
	        prevY = nextPoint[1];
	        return count != NO_WAY ? count : NO_WAY;
	    } else {
	        for (int[] nextPoint : nextPoints) {
	            int count = minimumMoves(matrix, nextPoint, endPoint, visited);
	            if (count != NO_WAY) {
	                return count + 1;
	            }
	        }
	        return NO_WAY;
	    }
	}
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
        	String str = scanner.next();
            grid[i] = str.trim();
        }

        int startX = scanner.nextInt();

        int startY = scanner.nextInt();
        
        int startPoint[] = {startX, startY};
        
        int goalX = scanner.nextInt();
        int goalY = scanner.nextInt();
        int endPoint[] = {goalX, goalY};
        
        boolean[][] visited = new boolean[grid.length][grid[0].length()];
        
        int result = minimumMoves(grid, startPoint,endPoint,visited);
        System.out.println(result);
        scanner.close();
    }

}
