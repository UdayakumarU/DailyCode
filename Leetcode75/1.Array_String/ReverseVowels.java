//https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String reverseVowels(String s) {
        int startIndex = 0;
        int endIndex = s.length()-1;
        char temp = ' ';

        StringBuilder string = new StringBuilder(s);

        while(startIndex <= endIndex){
         
            while(startIndex < endIndex){
                if(isVowel(string.charAt(startIndex)))
                    break;
                ++startIndex;
            }
            
            while(endIndex > startIndex){
                if(isVowel(string.charAt(endIndex)))
                    break;
                --endIndex;
            }

            temp = string.charAt(startIndex);
            string.setCharAt(startIndex, string.charAt(endIndex));
            string.setCharAt(endIndex, temp); 

            ++startIndex;
            --endIndex;
            
        }

        return string.toString();
    }

    private static boolean isVowel(char letter){
        return (letter == 'a' || letter == 'A' ||
           letter == 'e' || letter == 'E' ||
           letter == 'i' || letter == 'I' ||
           letter == 'o' || letter == 'O' ||
           letter == 'u' || letter == 'U');
    }
}
