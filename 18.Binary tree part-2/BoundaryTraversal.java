/*
Boundary Traversal of Binary Tree
Approach:
  leftTraversal -> straight and ignore leaf,
  Leaftraversal -> Inorder Leaf
  rightTraversal -> Reverse and ignore leaf

Time complexity: O(3n)
Space complexity; O(1)
*/

class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> boundaryTraversalResult = new ArrayList<>();
	    if(node == null) 
	        return boundaryTraversalResult;
	    
	    boundaryTraversalResult.add(node.data);
	    
	    traverseLeftBoundary(node.left, boundaryTraversalResult);
	    
	    if(node.left != null || node.right != null) // avoid double count in case of one node
	      traverseLeaf(node, boundaryTraversalResult);
	    
	    traverseRightBoundary(node.right, boundaryTraversalResult);
	    
	    return boundaryTraversalResult;
	}
	
	private static void traverseLeftBoundary(Node node, ArrayList<Integer> result){
	    if(node == null || (node.left == null && node.right == null)) 
        return;
	    
	    result.add(node.data);
	    
	    if(node.left != null)
	        traverseLeftBoundary(node.left, result);
	    else
	        traverseLeftBoundary(node.right, result);
	}
	
	private static void traverseRightBoundary(Node node, ArrayList<Integer> result){
	    if(node == null || (node.left == null && node.right == null)) 
        return;
	    
	    if(node.right != null)
	        traverseRightBoundary(node.right, result);
	    else
	        traverseRightBoundary(node.left, result);
	        
	    result.add(node.data);
	}
	
	private static void traverseLeaf(Node node, ArrayList<Integer> result){
	    if(node == null) 
        return;
	    
	    if(node.left == null && node.right == null){
	        result.add(node.data);
	        return;
	    }
	        
	    traverseLeaf(node.left, result);
	    traverseLeaf(node.right, result);
	}
	
}
