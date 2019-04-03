package com.Algorithm;

public class FindStates {
	public static void main(String[] args) {
		int cells[] = {1, 0, 1, 1, 0, 1, 0};
		int k = 3;
		int n = cells.length;
		findTheStates(cells, n, k);
	}

	private static void findTheStates(int[] cells, int n, int k) {
		int temp[] = new int[n];
		for (int i = 0; i < n; i++){
			temp[i] = cells[i];
		}
		for (int i = 0; i < k; i ++){
			temp[0] = 0 ^ cells[1];
			temp[n-1] = 0 ^ cells[n-2];
			for (int j = 1; j < n-1; j++){
				if (cells[j-1] == cells[j+1])
					temp[j] = 0;
				else{
					temp[j] = 1;
				}
			}
			for (int j = 0; j < n; j++){
				cells[j] = temp[j];
			}
		}
		for (int i = 0; i < n; i++){
			System.out.print(cells[i]+" ");
		}
	}
}
