package com.mathemetics;

public class GradingStudents {
	private static int[] gradingStudents(int[] grades) {
		int gradedArray[] = new int[grades.length];
		for (int i = 0; i < grades.length; i++){
			if (grades[i] >= 38 && (grades[i]+2)%5 == 0){
				gradedArray[i] = grades[i]+2;
			}else if(grades[i] >= 38 && (grades[i]+1)%5 == 0){
				gradedArray[i] = grades[i]+1;
			}else
				gradedArray[i] = grades[i];
		}
		return gradedArray;
	}
	public static void main(String[] args) {
		int n = 4;
		int arr[] = {73, 67, 38, 33, 84, 29};
		int result[] = gradingStudents(arr);
		for (int i = 0; i < result.length; i++){
			System.out.println(result[i]);
		}
	}

}
