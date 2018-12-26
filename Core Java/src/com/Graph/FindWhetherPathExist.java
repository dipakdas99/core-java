package com.Graph;

public class FindWhetherPathExist {
	
	private static void findPath(int[][] mat, int x){
		int i,j;
		int istart,jstart;
		for (i = 0; i < x; i++){
			for (j = 0; j < x; j++){
				if (mat[i][j] == 1){
					istart = i;
					jstart = j;
					boolean flag = isPathExist(mat, i, j);
					System.out.println(flag);
				}
			}
		}
		
	}

	private static boolean isPathExist(int[][] mat, int i, int j) {
		if (mat[i][j] == 2)
			return true;
		if (i >= 0 && j >= 0 && i < mat.length && j < mat.length && mat[i][j] != 0){
			 j = j + 1;
			 i = i - 1;
			isPathExist(mat, i, j);
		}
		if (i >= 0 && j >= 0 && i < mat.length && j < mat.length && mat[i--][j--] != 0){
			i = i - 1;
			j = j - 1;
			isPathExist(mat, i, j);
		}
			
		if (i >= 0 && j >= 0 && i < mat.length && j < mat.length && mat[i++][j++] != 0){
			i = i + 1;
			j = j + 1;
			isPathExist(mat, i, j);
		}
		if (i >= 0 && j >= 0 && i < mat.length && j < mat.length && mat[i++][j--] != 0){
			i = i + 1;
			j = j - 1;
			isPathExist(mat, i++, j--);
		}
		return false;
		
	}

	public static void main(String[] args) {
		int [][] mat = {{ 0 , 3 , 2 },
		                { 3 , 3 , 0 },
		                { 1 , 3 , 0 }};
		int x = 3;
		
		findPath(mat,x);
	}

}
