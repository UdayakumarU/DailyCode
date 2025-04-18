//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public int maxVowels(String s, int k) {
        int maxCount = getVowelsCount(s, 0, k-1);
        int currentCount = maxCount;

        for(int oldStart=0, newEnd=k; newEnd<s.length(); ++newEnd, ++oldStart){
            if(isVowel(s.charAt(oldStart))){
                --currentCount;
            }
            if(isVowel(s.charAt(newEnd))){
                ++currentCount;
            }

            maxCount = Math.max(currentCount, maxCount);
        }

        return maxCount;
    }

    private static int getVowelsCount(String s, int start, int end){
        int count = 0;

        for(int i=start; i<=end; ++i){
            if(isVowel(s.charAt(i))){
                ++count;
            }
        }

        return count;
    }

    private static boolean isVowel(char letter){
        if(letter =='a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u')
            return true;
        return false;
    }
}
