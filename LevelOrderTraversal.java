/*
  18.1 Level order traversal.
  Appraoch : Use queue
  Time complexity: O(n)
  Space complexity: O(n)
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.isEmpty() == false){
            int currentlevelsize = queue.size();
            List<Integer> level = new LinkedList<>();
            
            for(int i=1; i<=currentlevelsize; ++i){
                TreeNode node = queue.remove();

                level.add(node.val);

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            result.add(level);
        }
        
        return result;
    }
}
