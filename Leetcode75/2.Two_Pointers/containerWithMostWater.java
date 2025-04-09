//https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int maxArea(int[] height) {
        //initialize left = 0 and right = height.length()
        //calculate area and udpate the max area if new area is greater
        //if(right point shorter) decrement right
        //else incerment left

        int left = 0, right = height.length-1;
        int maxArea = 0;
        while(left < right){
           maxArea = Math.max(maxArea, calculateArea(height, left, right));
           if( height[left] > height[right]){
                --right;
           }
           else{
                ++left;
           }
        }

        return maxArea;
    }

    private static int calculateArea(int[] height, int left, int right){
        int breadth = right - left;
        int length = Math.min(height[right], height[left]);

        return breadth * length;
    }

}
