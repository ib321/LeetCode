package com.ib.twopointer;

public class LP12ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(new Solution12().maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));

	}
}

class Solution12 {
	
	//Two Pointer solution : O(n)
		public int maxArea(int[] height) {
			int maxArea = 0;
			int totalLength = height.length;
			int left = 0;
			int right = totalLength -1;
			
			while(left < right)
			{
				int chosenHeightLeft = height[left];
				int chosenHeightRight = height[right];
				int minHeight = Math.min(chosenHeightLeft, chosenHeightRight);

				int length = right - left;
				int Area = minHeight * length;
				if (Area > maxArea)
					maxArea = Area;
				
				//Pointer Movement Logic: Always choosing max height
				//bw these max length of left n right
				if(chosenHeightLeft<chosenHeightRight)
					left++;
				else
					right--;
			}

			return maxArea;
		}

	//Brute Force : O(n^2)
	public int maxArea2(int[] height) {
		int maxArea = 0;
		int totalLength = height.length;
		for (int i = 0; i < totalLength; i++) {
			for (int j = totalLength - 1; j >= 0; j--) {
				int chosenHeightA = height[i];
				int chosenHeightB = height[j];
				int minheight = chosenHeightA;
				if (chosenHeightB < minheight)
					minheight = chosenHeightB;
				int length = j - i;
				int Area = minheight * length;
				if (Area > maxArea)
					maxArea = Area;
			}
		}
		return maxArea;
	}
}
