//https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public int compress(char[] chars) {

        char recentlyAccessedChar = chars[0];
        StringBuilder compressedStr = new StringBuilder("");
        int count = 0;

        for(int i=0; i<chars.length;){
            if(i == 0 || chars[i] == recentlyAccessedChar){
                ++count;
                ++i;
            }
            else{
                compressedStr.append(compressedString(recentlyAccessedChar, count));
                count = 0;
                recentlyAccessedChar = chars[i];
            }
        }
        
        compressedStr = compressedStr.append(compressedString(recentlyAccessedChar, count));

        populateCompressedArray(compressedStr, chars);
        return compressedStr.length();
    }

    private static void populateCompressedArray(StringBuilder compressedStr, char[] inputedChars){
        for(int i=0; i<compressedStr.length(); ++i){
            inputedChars[i] = compressedStr.charAt(i);
        }
    }

    private static String compressedString(char recentlyAccessedChar, int count){
        if(count == 1)
            return recentlyAccessedChar + "";
        else
            return recentlyAccessedChar + "" + count;
    }

}
