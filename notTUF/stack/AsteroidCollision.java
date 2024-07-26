/*
  Link: https://leetcode.com/problems/asteroid-collision/description/
*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> collisionStack = new Stack<>();

        for(int asteroid: asteroids){
           boolean isAlive = true;
            while(!collisionStack.isEmpty() && collisionStack.peek() > 0 && asteroid < 0){
                if(collisionStack.peek() < -asteroid){
                    collisionStack.pop();
                    continue;
                }
                else if(collisionStack.peek() == -asteroid){
                    collisionStack.pop();
                }
                isAlive = false;
                break;
            }

            if(isAlive){
                collisionStack.push(asteroid);
            }

        }

        int[] result = new int[collisionStack.size()];
        for(int i=0; i<result.length; ++i){
           result[i] = collisionStack.get(i);
        }
        return result;
    }
}
