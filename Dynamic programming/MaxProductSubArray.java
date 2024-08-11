/*
152. Maximum Product Subarray

Approach: Keep a current min and current max at every stage (DP way), update the actual max when current max is greater
Time complexity: O(n)
Space complexity: O(1)

Note. This one test case fails though : [0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0]
*/

class Solution {
    public int maxProduct(int[] nums) {

        if(nums.length == 0) 
          return 0;

        int soFarMax = nums[0];
        int currentMin = nums[0];
        int currentMax = nums[0];

        for(int i=1; i< nums.length; ++i){
            int tempMax = currentMax;
            currentMax =  Math.max(Math.max((currentMin * nums[i]), nums[i]), currentMax * nums[i]);
            currentMin = Math.min(Math.min((currentMin * nums[i]), nums[i]), tempMax*nums[i]);
            soFarMax = Math.max(currentMax, soFarMax);
        }

        return soFarMax;
    }
}
