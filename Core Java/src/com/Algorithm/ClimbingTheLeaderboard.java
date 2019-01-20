package com.Algorithm;

import java.util.HashMap;
import java.util.Scanner;

public class ClimbingTheLeaderboard {
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		HashMap<Integer, Integer> hmap = new HashMap<Integer,Integer>();
		int start = 1;
		for (int i = 0; i < scores.length; i++){
			if (!hmap.containsValue(scores[i])){
				hmap.put(start++, scores[i]);
			}
		}
		return alice;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int scoresCount = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);
        for (int i = 0; i < result.length; i++){
        	System.out.println(result[i]);
        }
        scanner.close();
    }
}
