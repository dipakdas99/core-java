package com.Graph;

import java.util.Scanner;

public class RottenOranges {

	public static void main(String[] args) {
		/*int r = 3, c = 5;*/
		/*boolean visited[][] = new boolean[r][c];*/
		
		/*int mat[][] = {{2, 1, 0, 2, 1},
					   {1, 0, 1, 2, 1},
					   {1, 0, 0, 2, 1}};*/
		/*int mat[][] = {{2,1,0,2,1},
					   {0,0,1,2,1},
				       {1,0,0,2,1}};*/
		Scanner sc = new Scanner(System.in);
		int noOfInput = sc.nextInt();
		for (int a = 0; a < noOfInput; a++){
			int row = sc.nextInt();
			int col = sc.nextInt();
			int mat[][] = new int[row][col];
			boolean visited[][] = new boolean[row][col];
			for (int b = 0; b < row; b++){
				for (int c = 0; c < col; c++){
					mat[b][c] = sc.nextInt();
				}
			}
			int tempMat[][] = new int[mat.length][];
			for (int k = 0; k < mat.length; k++){
				tempMat[k] = mat[k].clone();
			}
			int count = 0;
			for (int i = 0; i < row; i++){
				for (int j = 0; j < col; j++){
					if (mat[i][j] == 2 && visited[i][j] == false){
						count++;
						rotOranges(i, j, tempMat,visited);
					}
				}
			}
			int flag = 0;
			for (int l = 0; l < row; l++){
				for (int m = 0; m < col; m++){
					if (tempMat[l][m] != 1){
						flag = 1;
					}else{
						flag = 0;
						System.out.println("-1");
						System.exit(0);
					}
				}
			}
			if (flag == 1)
				System.out.println(count);
		}
		/*int tempMat[][] = new int[mat.length][];
		for (int k = 0; k < mat.length; k++){
			tempMat[k] = mat[k].clone();
		}
		int count = 0;
		for (int i = 0; i < r; i++){
			for (int j = 0; j < c; j++){
				if (mat[i][j] == 2 && visited[i][j] == false){
					count++;
					rotOranges(i, j, tempMat,visited);
				}
			}
		}
		int flag = 0;
		for (int l = 0; l < r; l++){
			for (int m = 0; m < c; m++){
				if (tempMat[l][m] != 1){
					flag = 1;
				}else{
					flag = 0;
					System.out.println("-1");
					break;
				}
			}
		}
		if (flag == 1)
			System.out.println(count);*/
	}
	private static boolean isSafe(int i, int j, int matrix[][]){
		if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length)
			return true;
		return false;
	}

	private static void rotOranges(int i, int j, int[][] mat, boolean[][] visited) {
		
		if (isSafe(i,j,mat) && mat[i][j] != 0 && visited[i][j] == false){
			visited[i][j] = true;
			
			if (mat[i][j] == 1)
				mat[i][j] = 2;
			
			rotOranges(i-1, j, mat,visited);
			rotOranges(i+1, j, mat,visited);
			rotOranges(i, j-1, mat,visited);
			rotOranges(i, j+1, mat,visited);
		}
	}
}
