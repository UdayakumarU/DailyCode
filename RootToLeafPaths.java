/*
 17.11 Root to Node Path in Binary Tree
 Approach : DFS; use recursive call stack and populate the path on the fly
 time: O(n)
 space: O(1)
*/

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> allPaths = new ArrayList<>();
        depthFirstTraversal(root, "", allPaths);
        return allPaths;
    }

    private static void depthFirstTraversal(TreeNode node, String path, List<String> allPaths){
        if(node == null) 
            return;

        if(node.left == null && node.right == null){
            allPaths.add(path + node.val);
            return;
        }
        
        depthFirstTraversal(node.left,  path + node.val + "->", allPaths);
        depthFirstTraversal(node.right,  path + node.val + "->", allPaths);
    }
}
