//https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public void moveZeroes(int[] nums) {
        // use 2 pointers L and R 
        //keep them at 0th index
        //when R is pointing to 0 increment just R
        //When R is pointing to non 0 then 
                //swap L and R
                //incremnt L and R

        for(int left=0, right=0; right<nums.length; ++right){
            if(nums[right] == 0){
                continue;
            }
            swap(nums, left, right);
            ++left;
        }
    }

    private static void swap(int[] nums, int source, int destination){
        int temp = nums[source];
        nums[source] = nums[destination];
        nums[destination] = temp;
    }
}
