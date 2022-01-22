//Find the maximum sliding window

import java.util.*;

public class Program3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array:");
		int size = sc.nextInt();
		int[] nums = new int[size];
		for(int i=0; i<size; i++) {
			System.out.println("Enter element:");
			nums[i] = sc.nextInt();
		}
		System.out.println("Enter the value of k(sliding window size):");
		int k = sc.nextInt();
		System.out.println("Input array:");
		displayArray(nums);
		findMaxSlidingWindow(nums, k);
		sc.close();
	}
	
	static void displayArray(int[] array) { //To display array
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	static void findMaxSlidingWindow(int[] nums, int k) { //To find the maximum sliding window
		if(k>nums.length) { //If the k is greater than the size of array
			System.out.println("Not Possible");
			return;
		}
		ArrayList<Integer> maxResults = new ArrayList<Integer>(); //To hold the maximums of each subarray of size k
		int max = 0; //To hold the max number
		for(int i=0; i<=nums.length-k; i++) { //Traversing the array to find the maximum of each subarray of size k
			max = nums[i];
			for(int j=i; j<i+k; j++) {
				if(nums[j] > max)
					max = nums[j];
			}
			maxResults.add(max);
		}
		max = maxResults.get(0);
		for(int i=1; i<maxResults.size(); i++) { //Finding the max number from all the subarrays of size k
			if(maxResults.get(i) > max)
				max = maxResults.get(i);
		}
		int maxIndex = maxResults.indexOf(max); //To hold the index of max number
		System.out.println("Max Sliding Window:");
		for(int i=maxIndex; i<maxIndex+k; i++) { //Displaying max sliding window
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		System.out.println("Maximum number:" + max); //Displaying maximum number in the max sliding window
	}
}
