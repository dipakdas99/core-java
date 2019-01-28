package com.Algorithm;

import java.util.Scanner;

public class ConnectedCellsInAGrid {
	static int max = 0;
	static int result =0;
	static int connectedCell(int[][] matrix) {
		int new_c = 2;
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				if (matrix[i][j] == 1){
					int prev_c = matrix[i][j];
					countFill(matrix, i, j, prev_c, new_c);
					//replacing max value
					if (max > result){
						result = max;
					}
					max = 0;
				}
			}
		}
		return result;

    }

    private static void countFill(int[][] matrix, int x, int y, int prev_c, int new_c) {
    	// checking boundaries
    	if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) 
            return; 
    	//if not equals to prev_c then return
        if (matrix[x][y] != prev_c) 
            return; 
      
        // Replace the value at (x, y) with new value(2)
        matrix[x][y] = new_c;
        //counting no of times replacing the values
        max++;
        // Recur for up, down,right,left, up right corner, down left corner, up left corner and down right corner 
        countFill(matrix, x+1, y, prev_c, new_c); 
        countFill(matrix, x-1, y, prev_c, new_c); 
        countFill(matrix, x, y+1, prev_c, new_c); 
        countFill(matrix, x, y-1, prev_c, new_c);
        countFill(matrix, x-1, y+1, prev_c, new_c);
        countFill(matrix, x+1, y-1, prev_c, new_c);
        countFill(matrix, x+1, y+1, prev_c, new_c);
        countFill(matrix, x-1, y-1, prev_c, new_c);
		return;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();

        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int result = connectedCell(matrix);
        System.out.println(result);
        scanner.close();
    }

}
