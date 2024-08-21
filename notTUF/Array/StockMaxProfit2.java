/*
122. Best Time to Buy and Sell Stock II

Approach:  Look for dip then assign buy 
           sell any value as soon as you find it is greater than current buy and add it to total
              -> reset buy to current price
            
Time complexity: O(n)
Space complexity: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;

        for(int price: prices){
            if(price < buy){
                buy = price;
            }
            else if(price > buy){
                maxProfit += (price - buy);
                buy = price;
            }
        }
        return maxProfit;
    }
}
