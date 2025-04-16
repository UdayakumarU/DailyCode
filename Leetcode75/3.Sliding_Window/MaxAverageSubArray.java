//https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //get the silder total
        // find the average and set it to result,
        //move the window --i and ++j get the current avg and set it to result if it is greater.
        // do above step until J less than nums.length 

        double currentTotal = getTheTotal(nums, 0, k-1);
        double result = currentTotal/k;
        for(int start=0, end=k; end< nums.length; ++start, ++end){
            currentTotal += (nums[end] - nums[start]);
            result = Math.max(result, currentTotal/k);
        }

        return result;
    }

    private static double getTheTotal(int[] nums, int start, int end){
        double total = 0;
        for(int i = start; i <= end; ++i){
            total += nums[i];
        }
        return total;
    }
}
