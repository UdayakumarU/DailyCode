/*
  300. Longest increasing subsequence

  Approach: Build the memoization from last element 
            compare if current element is smaller against all memoized items so far and get its LIS -> this ensures the next increasing subsequence
            Do it until reaching 0;

  Time complexity: O(n^2)
  Space complexity: O(n)
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        
        int maxLength = 1;
        int[] lisCache = new int[nums.length];
        lisCache[nums.length-1] = 1;
        
        for(int i=nums.length-2; i>=0; --i){
            lisCache[i] = 1;
            for(int j=i+1; j<nums.length; ++j){
                if(nums[i] < nums[j]){
                    lisCache[i] = Math.max(lisCache[i], 1+lisCache[j]);
                }
            }
            maxLength = Math.max(maxLength, lisCache[i]);
        }

        return maxLength;
    }
}
