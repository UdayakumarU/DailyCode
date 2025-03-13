//https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for(int i=0; i<flowerbed.length; ++i){
            if(isPlantableSpot(i, flowerbed)){
                flowerbed[i] = 1;
                --n;
            }
        }

        return n <= 0;
    }


    private static boolean isPlantableSpot(int spot, int[] flowerbed){
        return 
        (flowerbed[spot] == 0 && 
           ((spot+1 < flowerbed.length && flowerbed[spot+1] == 0) || spot+1 == flowerbed.length) &&
           ((spot-1 >= 0 && flowerbed[spot-1] == 0 )|| spot-1 == -1)  
        );
    }
}
