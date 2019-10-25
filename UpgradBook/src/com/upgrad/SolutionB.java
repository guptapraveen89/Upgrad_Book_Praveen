package com.upgrad;

import java.util.Scanner;

public class SolutionB {

	public static void main(String args[]) {
		SolutionB pb = new SolutionB();
		Scanner input = new Scanner(System.in);
			int n = input.nextInt();
			int key = input.nextInt();
			int[] array = new int[n+1];
			for(int i=1; i<=n; i++) // Initializing the index from index-1.
			{ 
				array[i] = input.nextInt();
			}
			input.close();
			
			pb.findIndex(array, key);
	}
	
	// this will check the array bound condition for any infinite array
	// here we are initially taking lower bound as index 1 and upper bound index 2, which is increasing by multiplication of 2.
	void findIndex(int[] array, int key) {
		int start = 1;
		int end = 2;
		int flag1 = 0;
		int flag2 = 0;
		
		for(int i = 2; flag1 == 0;) {
			try {
				if(array[end] > key) {
					flag1 = 1;
					
				} else if(array[end] == key){
				
					System.out.println(end);
				
				} else if(start == end) {
				
					flag1 = 1;
					flag2 = 1;
				
				} else {
				
					i *=2;       // increasing the index value by multiply of 2.
					start = end; // end index becomes start index.
					end = i;     // end index will set to new position.
				}
			}
			
			catch (ArrayIndexOutOfBoundsException e) {
				
				end = start + (end - start)/2;
			}
		}
		
		if(flag2 == 0) {
			
			searchMethod(array, start, end, key);
			
		} else{
			
			System.out.println("NOT_FOUND");
			
		}
	}
	
	// once the start index and end index found where the searching key is present, below binary method will run for 
	//the search of key.
	void searchMethod(int[] array, int start, int end, int key){
			int index = -1;
			
			while(start <= end) {
			int mid = (start+(end-1))/2;
			if (array[mid] == key){
				index = mid;
				break;
			} else if (array[mid] > key) {
				
				end = mid - 1;
				
			} else {
				
				start = mid + 1;
			}
		} 
			if(index == -1){
				System.out.println("NOT_FOUND");
			} else {
				System.out.println(index);
			}
	}
		
}
