package com.Algorithm;

import java.util.Scanner;

public class AbsolutePermutation {
	static int[] absolutePermutation(int n, int k) {
		int arr[]=new int[n];
		try
		{
			for (int x = 1;x <= n; x++)
			{
				if (x - k > 0 && arr[x-k-1] == 0)
				{
					arr[x - k - 1] = x;
				}
				else
				{
					arr[x + k - 1] = x;
				}
			}
		}
		catch(Exception e)
		{
			int q[]={-1};
			return q;
		}
		return arr;
	}
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			//            String[] nk = scanner.nextLine().split(" ");

			int n = scanner.nextInt();
			int k = scanner.nextInt();

			int[] result = absolutePermutation(n, k);

			for (int i = 0; i < result.length; i++){
				System.out.print(result[i]+" ");
			}
		}
		scanner.close();
	}
}
