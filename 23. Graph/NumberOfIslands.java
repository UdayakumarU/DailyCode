/*
200. Number of Islands
Approach:
   iterate every cell and make it a count when ever the current cell is 1
   traverse the land -> turns the land in to water
       before doing it recursively ensure the the neighbours cell is not water '0' and grid surrounding

Time complexity: O(n*m)
Space complexity: O(1)
*/

class Solution {
    public int numIslands(char[][] grid) {
        int isLandCount = 0;

        for(int row=0; row < grid.length; ++row){
            for(int column=0; column < grid[0].length; ++column){
                if(grid[row][column] == '1'){
                    turnLandToWater(grid, row, column);
                    ++isLandCount;
                }
            }
        }        

        return isLandCount;
    }

    private static void turnLandToWater(char[][] grid, int row, int column){
        //ensure I am not accessing beside the given boundary or water
        if(row >= grid.length || row < 0 || column >= grid[0].length || column < 0 || grid[row][column] == '0' )
            return;

        grid[row][column]  = '0';

        turnLandToWater(grid, row, column-1); //go left
        turnLandToWater(grid, row, column+1); // go right
        turnLandToWater(grid, row-1, column); // go up
        turnLandToWater(grid, row+1, column); // go down
    } 

}
