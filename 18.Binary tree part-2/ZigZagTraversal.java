/*
Zig Zag Traversal Of Binary Tree
Approach: Use queue, with insertion direction flad and counter at each level
Time complexity: O(n)
Space complexity:O(n)
*/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigZagResult = new ArrayList<>(); 
        if(root == null) 
            return zigZagResult;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root); 
        boolean leftToRight = true;

        while(!queue.isEmpty()){
            List<Integer> row = new LinkedList<>();
            int count = queue.size();

            for(int i=count; i>0; --i){
                TreeNode node = queue.poll();

                if(leftToRight)
                    row.addLast(node.val);
                else
                    row.addFirst(node.val);
                    
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }

            zigZagResult.add(row);
            leftToRight = !leftToRight;
        }

        return zigZagResult;
    }
}
