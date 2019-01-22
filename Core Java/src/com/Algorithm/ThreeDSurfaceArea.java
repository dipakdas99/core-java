package com.Algorithm;

import java.util.Scanner;

public class ThreeDSurfaceArea {
	
	static int surfaceArea(int[][] A) {
	        int area = 0;

	        for (int i = 0; i < A.length; i++) {
	            int areaOfOneRow = A[i][0];
	            for (int j = 0; j < A[i].length - 1; j++) {
	                if (A[i][j + 1] > A[i][j]) {
	                    areaOfOneRow += A[i][j + 1] - A[i][j];
	                }
	            }
	            area += areaOfOneRow * 2;
	        }

	        for (int i = 0; i < A[0].length; i++) {
	            int areaOfOneColumn = A[0][i];
	            for (int j = 0; j < A.length - 1; j++) {
	                if (A[j + 1][i] > A[j][i]) {
	                    areaOfOneColumn += A[j + 1][i] - A[j][i];
	                }
	            }
	            area += areaOfOneColumn * 2;
	        }

	        area += A.length * A[0].length * 2;

	        return area;
	    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);
        System.out.println(result);
        scanner.close();
    }

}
