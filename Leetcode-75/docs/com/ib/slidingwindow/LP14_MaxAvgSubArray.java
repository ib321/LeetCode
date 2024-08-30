package com.ib.slidingwindow;


public class LP14_MaxAvgSubArray {

	public static void main(String[] args) {
		System.out.println(new Solution14().findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4));
	}
}

class Solution14 {
    public double findMaxAverage(int[] nums, int k) {
    	int currSum = 0;
		for (int i = 0; i < k; i++) {
			currSum += nums[i];
		}
		int maxSum = currSum;
    	for (int i = k; i < nums.length ; i++) {
    		currSum = currSum + nums[i] - nums[i-k];
    		if(currSum>maxSum)
    			maxSum = currSum;
		}
    	return (double)maxSum/k;
    }
}
