/*
1143. Longest Common Subsequence

Approach: DP tabulation (bottom up)
          Build a grid mxn for given 2 string
          at any given cell if its row and col character matches simply add 1 + one cell before it diagonally (since it is a match so add 1 current state)
          else find the max from one cell above or once cell left (chop last character from one text and keep the other as is and vice versa)
          the very last cell will hold the expected result

Time complexity; O(nxm)
Space complexity: O(nxm)
*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int text1Length = text1.length();
        int text2Length = text2.length();

        int cache[][] = new int[text1Length+1][text2Length+1];

        for(int i=0; i<text1Length; ++i){
            for(int j=0; j<text2Length; ++j){
                if(text1.charAt(i) == text2.charAt(j)){
                    cache[i+1][j+1] = 1 + cache[i][j];
                }
                else{
                    cache[i+1][j+1] = Math.max(cache[i+1][j],  cache[i][j+1]);
                }
            }
        }

        return cache[text1Length][text2Length];
    }
}
