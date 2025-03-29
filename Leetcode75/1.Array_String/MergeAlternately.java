//https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while(i<word1.length() && i<word2.length()){
            result.append(word1.charAt(i)+""+word2.charAt(i));
            ++i;
        }

        if(word1.length() == i)
            result.append(word2.substring(i));
        else
            result.append(word1.substring(i));

        return result.toString();
    }
}
