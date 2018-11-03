package com.BST;
import java.util.Scanner;
import com.BST.Node;
public class InorderTraversalAndBST {
	static int isBST(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if(arr[i] <= arr[i - 1]) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int i = 0; i < tests; i++) {
            int n = sc.nextInt();

            int[] arr = new int[n];
            for (int e = 0; e < n; e++) {
                arr[e] = sc.nextInt();
            }

            System.out.println(isBST(arr, n));
        }
    }

}
