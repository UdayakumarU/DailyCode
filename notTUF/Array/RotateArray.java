/*
189. Rotate Array

Approach 1: Using temp array, though it runs in O(n), it takes O(k) extra space, hence not much optimal

Approach 2: reverse the 2 halves and then entire array
Time complexity: O(n)
Space complexity: O(1)
*/

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) 
            return;
        //rotateWithExtraSpace(nums, k);
        rotateUsingReverse(nums, k);
    }

    private void rotateWithExtraSpace(int[] nums, int k){
        //create new array of size k
        int[] tempArr = new int[k];
    
        // copy last k elements to new array
        for(int j=k, i=nums.length; j>0 ;){
            tempArr[--j] = nums[--i];
        }

        //shift n-k to 0 elements to n-1 to k in existing array
        for(int j=nums.length, i=nums.length-k; i>0;){
            nums[--j] = nums[--i];
        }
      
        //fill 0 to k of exsisting from new array
        for(int i=0; i<k; ++i){
            nums[i] = tempArr[i];
        }
    }

    private void rotateUsingReverse(int[] nums, int k){

        int length = nums.length;
        reverse(nums, 0, length-k-1);
        reverse(nums, length-k, length-1);
        reverse(nums, 0, length-1);
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp; 
        }
    }
}
