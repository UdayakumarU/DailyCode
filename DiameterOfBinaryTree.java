/*18.3 Diameter of binary tree
 Approach: 
   At every recursion return check the sum the length of left and right and return the side to next level.
   Also at every level check the max of left+right 
 Time complexity: O(n)
 Space complexity: O(1)
*/

class Solution {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        TreeTraverser traverser = new TreeTraverser();
        traverser.findMaxLength(root);
        return traverser.diameter;
    }
}


class TreeTraverser{
    int diameter;

    TreeTraverser(){
        this.diameter = 0;
    }

    public int findMaxLength(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = findMaxLength(node.left);
        int right = findMaxLength(node.right);

        this.diameter = Math.max(this.diameter, left+right);
      
        return Math.max(left, right)+1;
    }
}
