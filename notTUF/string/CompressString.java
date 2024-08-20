/*
443. String Compression

Time complexity: O(n)
Space complexity: O(log10Counter+1)
*/
class Solution {
    public int compress(char[] chars) {
        int compressedLength =  0;
        int counter = 0;
        char currentChar = ' ';

        for(int i=0; i<chars.length; ++i){
            if(currentChar == ' '){
                currentChar = chars[i];
                counter = 1;
            }
            else if(currentChar == chars[i]){
                ++counter;
            }
            else{
                compressedLength += compressAndGetLength(currentChar, counter, compressedLength, chars);;
                currentChar = chars[i];
                counter = 1;
            }
        }

        compressedLength += compressAndGetLength(currentChar, counter, compressedLength, chars);
        return compressedLength;
    }

    private int compressAndGetLength(char currentChar, int counter, int currentStringIndex, char[] chars){

        // include the currentchar
        int total = 1; 
        chars[currentStringIndex++] = currentChar;

        //including the count
        if(counter == 1){
            return total;
        }

        if(counter < 10){
            chars[currentStringIndex] = (char) (counter + '0');
            return total + 1;
        }

        String counterString = counter+"";
        for(int i = 0;  i < counterString.length(); ++i){
            chars[currentStringIndex++] = counterString.charAt(i);
        }
        return total + counterString.length();
    }
}
