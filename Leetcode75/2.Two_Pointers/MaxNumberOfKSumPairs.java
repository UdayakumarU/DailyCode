//https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int maxOperations(int[] nums, int k) {
        //sort the given array
        //keep 2 pointer left and right
        //check if left + right is k 
        //  then increment operationCount, increament left and decrement right
        //if left + right < k
        // then increment left
        // else increment right
        //return the operationCount

        Arrays.sort(nums);
        
        int left = 0, right = nums.length-1;
        int counter = 0;

        while(left < right){
            int currentSum = nums[left] + nums[right];
            if(currentSum == k){
                ++counter;
                ++left;
                --right;
            }
            else if(currentSum < k){
                ++left;
            }
            else{
                --right;
            }
        }

        return counter;
    }
}
