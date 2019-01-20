package com.Algorithm;

import java.util.Scanner;

public class OrganizingContainersOfBalls {
	static String organizingContainers(int[][] container) {
		/*int count[] = new int[container.length];
		for (int  i = 0; i < container.length; i++){
			for (int j = 0; j < container.length; j++){
				count[j] += container[i][j]; 
			}
		}
		for (int i = 1; i < count.length; i++){
			if (count[i-1] != count[i])
				return "Impossible";
		}
		return "Possible";*/
		int[] a = new int[container.length];
		int[] b = new int[container.length];
		for (int  i = 0; i < container.length; i++){
			for (int j = 0; j < container.length; j++){
				 a[i] += container[i][j];
			     b[j] += container[i][j];
			}
		}
		String pts = "Possible";
		for(int i=0;i<container.length;i++)
		{
		    int j=0;
		    for(j=i;j<container.length;j++)
		    {
		        if(a[i] == b[j])
		        {
		            int temp = b[j];
		            b[j] = b[i];
		            b[i] = temp;
		            break;
		        }
		    }
		    if(j==container.length)
		    {
		        pts = "Impossible";
		        break;
		    }
		}
		return pts;
		
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int q = scanner.nextInt();
		//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			int n = scanner.nextInt();
			//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[][] container = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int containerItem = scanner.nextInt();
					container[i][j] = containerItem;
				}
			}

			String result = organizingContainers(container);
			System.out.println(result);

		}


		scanner.close();
	}
}
