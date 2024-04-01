/**
  17.6 Right/Left view of binary tree
  Leetcode: https://leetcode.com/problems/binary-tree-right-side-view/
  Time complexity : O(n)
  Space complexity: O(n) auxiliary space when the tree is skewed
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Visualizer view = new Visualizer();
        return view.getRigtSideView(root);
    }
}

class Visualizer{
    HashSet<Integer> set;
    List<Integer> rightSideView;
    
    Visualizer(){
        set = new HashSet<>();
        rightSideView = new LinkedList<>();
    }

    public List<Integer> getRigtSideView(TreeNode root){
        traverseReversePreorder(root, 0);
        return this.rightSideView;
    }

    private void traverseReversePreorder(TreeNode root, int level){
        if(root == null) return;

        if(set.contains(level) == false){
            set.add(level);
            rightSideView.add(root.val);
        }
        traverseReversePreorder(root.right, level+1);
        traverseReversePreorder(root.left, level+1);
    }
}
