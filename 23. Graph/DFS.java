/*
Graph traversal: Depth first search

Approach: Stack for keeping the next node, HashSet for tracking visited nodes.
          Note. Here, I traversed the nodes from left to right, so I reversed adjacent node insertion to the stack. 
                The recursive approach will do this by default
                Ref: https://stackoverflow.com/a/9201268

Time complexity: O(E+V)
Space complexity: O(V)
*/
class Solution {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
 
        Set<Integer> visitedNodes = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> dfs = new ArrayList<>();
        
        stack.push(0);
        
        while(!stack.isEmpty()){
            
            int node = stack.pop();
            
            if(visitedNodes.contains(node))
                continue;
            
            dfs.add(node);
            visitedNodes.add(node);
            
            for(int i=adj.get(node).size()-1; i>=0; --i){
               int adjacentNode = adj.get(node).get(i);
               if(!visitedNodes.contains(adjacentNode)){
                    stack.push(adjacentNode);
                }
            }
            
        }
        
        return dfs;
    }
}
