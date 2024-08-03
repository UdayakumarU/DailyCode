/*
 Mirror tree
 Approach: Recursion, switch the left and right using tempnode
 Time complexity: O(n)
 Space complexity: O(1)
*/

class Solution {
    void mirror(Node node) {
        node = helper(node);
    }
    
    static Node helper(Node node){
        
        if(node == null) 
          return null;
        
        Node tempNode = node.right;
        node.right = helper(node.left);
        node.left = helper(tempNode);
        
        return node;
    
    }
}
