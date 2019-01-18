package com.Algorithm;

import java.util.Scanner;

public class TheHurdleRace {
	static int hurdleRace(int k, int[] height) {
		int max = height[0];
		for (int i = 1; i < height.length; i++){
			if (max < height[i])
				max = height[i];
		}
		int result = 0;
		if (max > k){
			result = max - k;
			return result;
		}
		return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] height = new int[n];

        String[] heightItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int heightItem = Integer.parseInt(heightItems[i]);
            height[i] = heightItem;
        }

        int result = hurdleRace(k, height);
        System.out.println(result);

        scanner.close();
    }

}
