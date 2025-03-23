//https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int[] productExceptSelf(int[] nums) {

        if(nums.length <= 1) return nums;
        
        int length = nums.length; 

        //populate post fix
        int[] postfix = new int[length];
        postfix[length-1] = nums[length-1];
        for(int i=length-2; i>=0; --i){
            postfix[i] = nums[i] * postfix[i+1];
        }
        
        //populateProductExcept self by creating the profix on the go
        int prefix = 1;
        for(int i=0; i<length-1; ++i){
            postfix[i] = postfix[i+1] * prefix;
            prefix *= nums[i];
        }
        postfix[length-1] = prefix;

        return postfix;
    }
