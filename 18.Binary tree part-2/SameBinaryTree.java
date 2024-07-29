/*
  Check if two trees are identical or not
  Time complexity: O(n)
  Space complexity: O(1)
*/


class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) 
          return true;

        if(q ==null || p==null || p.val != q.val ) 
          return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
