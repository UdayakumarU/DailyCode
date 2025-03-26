//https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int firstNumber = Integer.MAX_VALUE, secondNumber = Integer.MAX_VALUE; 
        for(int number: nums){
            if(number <= firstNumber){
                firstNumber = number;
            }
            else if(number <= secondNumber){
                secondNumber = number;
            }
            else{
                return true;
            }
        }
        return false;     
    }
}
