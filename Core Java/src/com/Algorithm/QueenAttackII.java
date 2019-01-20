package com.Algorithm;

import java.util.Scanner;

public class QueenAttackII {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] chessBoard = new int[n][n];
        int rQueen = in.nextInt()-1;
        int cQueen = in.nextInt()-1;
        int sum = 0;
        chessBoard[rQueen][cQueen] = 1;
        for(int a0 = 0; a0 < k; a0++){
            int rObstacle = in.nextInt()-1;
            int cObstacle = in.nextInt()-1;
            // your code goes here
            chessBoard[rObstacle][cObstacle]=-1;
        }
        //check all 8 ways
        // and down
        for(int i =rQueen+1;i<n;i++){
            if(chessBoard[i][cQueen] ==0){
                sum+=1;
            }else{
                break;
            }
        }
         for(int i =rQueen-1;i>=0;i--){
              if(chessBoard[i][cQueen] ==0){
                sum+=1;
            }else{
                break;
            }
        }
        //left and right
         for(int i =cQueen+1;i<n;i++){
              if(chessBoard[rQueen][i] ==0){
                sum+=1;
            }else{
                break;
            }
        }
         for(int i =cQueen-1;i>=0;i--){
              if(chessBoard[rQueen][i] ==0){
                sum+=1;
            }else{
                break;
            }
        }
        //diagonal right
        for(int row =rQueen-1,col=cQueen+1;row>=0 && col<n;row--,col++){
              if(chessBoard[row][col] ==0){
                sum+=1;
            }else{
                break;
            }
        }
         for(int row =rQueen+1,col=cQueen-1;row<n && col>=0;row++,col--){
              if(chessBoard[row][col] ==0){
                sum+=1;
            }else{
                break;
            }
        }
        
         //diagonal left
        for(int row =rQueen-1,col=cQueen-1;row>=0 && col>=0;row--,col--){
              if(chessBoard[row][col] ==0){
                sum+=1;
            }else{
                break;
            }
         }
         for(int row =rQueen+1,col=cQueen+1;row<n && col<n;row++,col++){
              if(chessBoard[row][col] ==0){
                sum+=1;
            }else{
                break;
            }
        }
        
        System.out.println(sum);
    }

}
