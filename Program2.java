/*
 * Given two sorted arrays nums1 and nums2 of 
 * size m and n respectively, return the median 
 * of two sorted arrays.
 */

import java.util.*;

public class Program2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of first array:");
		int m = sc.nextInt();
		System.out.println("Enter the size of second array:");
		int n = sc.nextInt();
		int[] nums1 = new int[m];
		int[] nums2 = new int[n];
		System.out.println("Enter elements in first array");
		for(int i=0; i<m; i++) {
			System.out.println("Enter element:");
			nums1[i] = sc.nextInt();
		}
		System.out.println("Enter elements in second array");
		for(int i=0; i<n; i++) {
			System.out.println("Enter element:");
			nums2[i] = sc.nextInt();
		}
		displayArray(nums1);
		displayArray(nums2);
		int ans = findMedian(nums1, nums2, m, n);
		System.out.println("Median:" + ans);
		sc.close();
	}
	
	static void displayArray(int[] array) { //To display array
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	static int findMedian(int[] nums1, int[] nums2, int m , int n) { //To find median of two arrays
		/*
		 * For odd elements, median index = (number of elements)/2
		 * For even elements, median index = ((number of elements)/2-1) + ((number of elements)/2) 
		 */
		
		int[] mergedArray = new int[m+n]; //To hold the elements of both the arrays
		for(int i=0; i<m; i++) { //Inserting first array elements to merged array
			mergedArray[i] = nums1[i];
		}
		int currentIndex = m; //To hold the current index of the last filled element in merged array
		for(int i=0; i<n; i++) { //Inserting second array elements to merged array
			mergedArray[currentIndex] = nums2[i];
			currentIndex++;
		}
		Arrays.sort(mergedArray); //Sorting merged array
		displayArray(mergedArray);
		
		int mergedArrayLength = m+n; //To hold the total size of merged array
		int median = 0; //To hold the median
		if(mergedArrayLength % 2 !=0) { //For odd number of elements
			int medianIndex = mergedArrayLength/2;
			median = mergedArray[medianIndex];
		}
		else { //For even number of elements
			int firstElement = mergedArray[mergedArrayLength/2];
			int secondElement = mergedArray[mergedArrayLength/2 - 1];
			median = (firstElement+secondElement)/2;
		}
		
		return median;
	}
}
