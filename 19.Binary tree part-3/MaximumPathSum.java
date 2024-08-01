/*
  Binary Tree Maximum Path Sum
  Approach: Inorder traversal recursion with global max value maintainer.
  Time complexity: O(n)
  Space complexity: O(1)
*/

class Solution {
    int max = 0;
    public int maxPathSum(TreeNode root) {
        MaxPath mp = new MaxPath();
        mp.findMaxPath(root);
        return mp.max;
    }
}


class MaxPath {
    int max;

    MaxPath(){
        max = Integer.MIN_VALUE;
    }

    public int findMaxPath(TreeNode root){
        if(root == null) return 0;

        int leftSubTreeMaxPath = findMaxPath(root.left);
        int rightSubTreeMaxPath = findMaxPath(root.right);

        int leftCenterRightTotal = root.val + leftSubTreeMaxPath + rightSubTreeMaxPath;
        int leftCenterTotal = root.val + leftSubTreeMaxPath;
        int centerRightTotal = root.val + rightSubTreeMaxPath;

        int extensibleMaxPath = Math.max(root.val, Math.max(leftCenterTotal, centerRightTotal));
        this.max = Math.max(this.max, Math.max(leftCenterRightTotal, extensibleMaxPath));

        return extensibleMaxPath;
    }
}
