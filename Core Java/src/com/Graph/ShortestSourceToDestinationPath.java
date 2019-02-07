package com.Graph;

public class ShortestSourceToDestinationPath {

	public static void main(String[] args) {
		int matrix[][] = {{1,0,0,0},
				{1,1,0,1},
				{0,1,1,1}};
		/*int[] src = {0,0};
		int[] dest ={2,3};*/
		int row = 3;
		int col = 4;
		boolean visited[][] = new boolean[row][col];
		int tempMatrix[][] = new int[matrix.length][];
		for (int k = 0; k < matrix.length; k++){
			tempMatrix[k] = matrix[k].clone();
		}
		findMinimumSteps(0, 0,tempMatrix,visited);
	}
	private static boolean isSafe(int i, int j, int matrix[][]){
		if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length)
			return true;
		return false;
	}
	private static void findMinimumSteps(int i, int j,int[][] tempMatrix, boolean[][] visited) {
		if (isSafe(i,j,tempMatrix) && tempMatrix[i][j] != 0 && visited[i][j] == false){
			visited[i][j] = true;
			
			findMinimumSteps(i-1, j, tempMatrix,visited);
			findMinimumSteps(i+1, j, tempMatrix,visited);
			findMinimumSteps(i, j-1, tempMatrix,visited);
			findMinimumSteps(i, j+1, tempMatrix,visited);
		}

	}

}
