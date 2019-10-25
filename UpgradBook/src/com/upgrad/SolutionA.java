package com.upgrad;

import java.util.Scanner;

public class SolutionA {
		
	public static void main(String args[]) {
		SolutionA pa = new SolutionA();
		Scanner input = new Scanner(System.in);
			int n = input.nextInt();
			int[] array = new int[n+1];
			for(int i=1; i<=n; i++) // Initializing the index from index-1.
			{
				array[i] = input.nextInt();
			}
			input.close();
			pa.searchMethod(array);
	}
	
	public void searchMethod(int[] array) 
	{
		int start = 1;        // starting index from 1 instead of 0.
		int end = array.length;
		boolean isFound = false;
		while (start <= end) {
			int mid = (start + end)/2;
			if (array[mid] == mid) {
				System.out.println(mid); 
				isFound = true;
				break;
			} if(array[mid] > mid) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		} if (!isFound) {
			System.out.println("NOT_FOUND");
		}
	}
}
