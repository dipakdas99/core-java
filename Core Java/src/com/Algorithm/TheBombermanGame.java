package com.Algorithm;

import java.util.Scanner;

public class TheBombermanGame {
	static String[] bomberMan(int n, String[] grid) {
		for(int i=0;i<grid.length;i++){
			char[] tmp1 = grid[i].toCharArray();
			for(int j=0;j<grid[0].length();j++){
				if(tmp1[j] == 'O'){
					tmp1[j] = '1';
				}
				else if(tmp1[j] == '.'){
					tmp1[j] = 'O';
				}
			}
			String ala = new String(tmp1);
			grid[i]=ala;
			
		}
		System.out.println("*******************************");
		for (int k = 0; k < grid.length; k++){
			System.out.println(grid[k]);
		}
		System.out.println("*******************************");
		for (int i = 0; i < grid.length; i++){
			for (int j = 0 ; j < grid[0].length(); j++){
				if (grid[i].charAt(j) == '1'){
					if (i-1 >= 0){
						char[] tmp2 = grid[i-1].toCharArray();
						tmp2[j] = '.';
						String ala1 = new String(tmp2);
						grid[i-1] = ala1;
					}
					if (i+1 < grid.length){
						char[] tmp2 = grid[i+1].toCharArray();
						/*if (tmp2[j] != '1')*/
							tmp2[j] = '.';
						String ala1 = new String(tmp2);
						grid[i+1] = ala1;
					}
					if (j-1 >= 0){
						char[] tmp2 = grid[i].toCharArray();
						/*if (tmp2[j-1] != '1')*/
							tmp2[j-1] = '.';
						String ala1 = new String(tmp2);
						grid[i] = ala1;
					}
					if (j+1 < grid[0].length()){
						char[] tmp2 = grid[i].toCharArray();
						/*if (tmp2[j+1] != '1')*/
							tmp2[j+1] = '.';
						tmp2[j] = '.';
						String ala1 = new String(tmp2);
						grid[i] = ala1;
					}
				}
			}
		}
		return grid;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String[] rcn = scanner.nextLine().split(" ");

		int r = Integer.parseInt(rcn[0]);

		int c = Integer.parseInt(rcn[1]);

		int n = Integer.parseInt(rcn[2]);

		String[] grid = new String[r];

		for (int i = 0; i < r; i++) {
			String gridItem = scanner.nextLine();
			grid[i] = gridItem;
		}

		String[] result = bomberMan(n, grid);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}


		scanner.close();
	}
}
