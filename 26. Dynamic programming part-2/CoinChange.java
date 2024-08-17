/*
322. Coin Change
Approach: Top down -> recursive
          Subtract the given total with given N coins which in turns form N new sub problems
          Solve those sub problems recursively until it becom 0 or < 1
          Cache the result of every subproblem and use the cache value if same sub problem occurs next time (dynamic programming)

Time complexity: O(n x amount)
Space complexity: O(amount)

*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount+1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        
        int min = findMinimalCoins(amount, cache, coins);
        return min == Integer.MAX_VALUE? -1 : min; 
    }   
    
    private static int findMinimalCoins(int amount, int[] cache, int[] coins){

        if(amount == 0) 
            return 0;

        if(amount < 0) 
            return Integer.MAX_VALUE;

        if(cache[amount] != -1){
            return cache[amount];
        }

        int min = Integer.MAX_VALUE;

        for(int coin: coins){
            int target = amount-coin;
            int currentMin = findMinimalCoins(target, cache, coins);

            if(currentMin != Integer.MAX_VALUE){ //prevent overflow ie Integer.MAX_VALUE + 1
                min = Math.min(min, currentMin+1);
            }
        }

        return cache[amount] = min;
    }
}


/*
Approach: Bottom up -> tabulation

Time complexity: O(n x amount)
Space complexity: O(amount)

*/

class Solution {
    public int coinChange(int[] coins, int amount) {
     
        int[] subProblems = new int[amount+1];
        Arrays.fill(subProblems, amount+1);
        subProblems[0] = 0;

        for(int currentTarget = 1; currentTarget<=amount; ++currentTarget){
            for(int coin: coins){
                int subTarget = currentTarget - coin;
                if(subTarget >= 0)
                    subProblems[currentTarget] = Math.min(subProblems[currentTarget], 1 + subProblems[subTarget]);
            }
        }

        return subProblems[amount] == amount+1? -1: subProblems[amount];

    }
}

