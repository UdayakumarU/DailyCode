//16.5 Count and Say
//https://leetcode.com/problems/count-and-say/description/
//Time Complexity: ?
//Space Complexity: O(1)

class Solution {
    public String countAndSay(int n) {
        //1 => 1
        //2 => 1 => 11
        //3 => 11 => 21
        //4 => 21 => 1211
        //5 => 1211 => 111221
        //6 => 111221 => 312211
        String result = "1";
        for(int i=2; i<=n; ++i){
            result = say(result);
        }
        return result;
    }

    private static String say(String number){
        int length = number.length();
        if(length == 0){
            return "";
        }

        int count = 1;
        StringBuilder result = new StringBuilder();
       
        for(int i=1; i<length; ++i){
            if(number.charAt(i-1) == number.charAt(i)){
                ++count;
            }
            else{
                result.append(count).append(number.charAt(i-1));
                count=1;
            }
        }
        return result.append(count).append(number.charAt(length-1)).toString();
    }
}
