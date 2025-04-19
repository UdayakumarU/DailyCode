//https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int longestOnes(int[] nums, int k) {

        int currentlongestOnes = 0;
        int longestOnes = 0;
        int togglesCount = 0;

        for(int start = 0, end = 0; end < nums.length;){
            if(nums[end] == 0 && togglesCount == k){
                if(nums[start] == 0){
                    --togglesCount;
                }
                ++start;
                --currentlongestOnes; 
            }
            else{
                if(nums[end] == 0){
                    ++togglesCount;
                }
                ++currentlongestOnes;
                ++end;
                longestOnes = Math.max(currentlongestOnes, longestOnes);
            }
        }

        return longestOnes;
    }
}
