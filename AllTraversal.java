/*
  17.9 Preorder Inorder Postorder Traversals in One Traversal
  Approach: Use a stack and counter where 1 is preOrder, 2 is inOrder and 3 is postOrder
  Space: O(n)
  Time: O(3n)
*/

class TreeNodeCounter {
	TreeNode node;
	int count;
	
	TreeNodeCounter(TreeNode node, int count){
		this.node = node;
		this.count = count;
    }
}

public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        if(root == null)
         return null;
        List<List<Integer>> result = new ArrayList<>();	
        Stack<TreeNodeCounter> stack = new Stack<>();
        stack.push(new TreeNodeCounter(root, 1));

        //initialize preorder => +ab
        result.add(new ArrayList<Integer>());
        //initialize inorder => a+b
        result.add(new ArrayList<Integer>());
        //initialize postorder => ab+
        result.add(new ArrayList<Integer>());
            
        while(stack.size() != 0){
            TreeNodeCounter currentNode = stack.pop();
            if(currentNode.count == 1){ //preorder
                result.get(0).add(currentNode.node.data);
                currentNode.count += 1;
                stack.push(currentNode);
                if(currentNode.node.left != null){
                    stack.push(new TreeNodeCounter(currentNode.node.left, 1));
                }
            }
            else if(currentNode.count == 2){ //inorder
                result.get(1).add(currentNode.node.data);
                currentNode.count += 1;
                stack.push(currentNode);
                if(currentNode.node.right != null){
                    stack.push(new TreeNodeCounter(currentNode.node.right, 1));
                }
            }
            else{ // postorder
                result.get(2).add(currentNode.node.data);
            }		
        }

        return result;
    }
}
