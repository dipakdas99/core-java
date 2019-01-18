package com.Algorithm;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ClimbingTheLeaderboard {
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		// copying all the distinct elements scores[] to array[].
		int[] array = IntStream.of(scores).distinct().toArray();
		int i = array.length-1;
		int start = 0;
		int rank[] = new int[alice.length];
		//Iterating all alice array and checking
		//if scores is greater than length - 1 then decreasing i.
		for(int score: alice) {
			while(i>=0) {
				if(score>=array[i]) 
					i--;
				else {
					// else putting i+2 into result ranke[]
					rank[start] = i+2;
					start++;
					break;
					}
			}
			// If i is less than 0 then simply put as 1.
			if(i<0){ 
				rank[start] = 1;
				start++;
			}
		}
		return rank;
	} 

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int scoresCount = scanner.nextInt();
		//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] scores = new int[scoresCount];



		for (int i = 0; i < scoresCount; i++) {
			int scoresItem = scanner.nextInt();
			scores[i] = scoresItem;
		}

		int aliceCount = scanner.nextInt();
		//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] alice = new int[aliceCount];


		for (int i = 0; i < aliceCount; i++) {
			int aliceItem = scanner.nextInt();
			alice[i] = aliceItem;
		}

		int[] result = climbingLeaderboard(scores, alice);
		for (int i = 0; i < result.length; i++){
			System.out.println(result[i]);
		}

		scanner.close();
	}
}
