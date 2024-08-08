/*
Topology sort
Approach: Stack and DFS
          Note: this can be done using BFS and queue but it requires an additional indegree data structure 
          (refer: https://github.com/UdayakumarU/DailyCode/blob/main/23.%20Graph/DetectCycleInAGraphBFS.java) 

Time complexity: O(v + E)
Space complexity: O(v)

*/
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        
        for(int node=0; node<V; ++node){
            if(!visited[node]){
                dfs(node, visited, stack, adj);
            }
        }
        
        return convertToArray(stack);
    }
    
    private static void dfs(
        int node, 
        boolean[] visited, 
        Stack<Integer> stack, 
        ArrayList<ArrayList<Integer>> adj){
            
            visited[node] = true;
            
            for(int adjNode: adj.get(node)){
                if(!visited[adjNode]){
                    dfs(adjNode, visited, stack, adj);
                }
            }
            
            stack.push(node);
    }
    
    
    private static int[] convertToArray(Stack<Integer> stack){
        int[] result = new int[stack.size()];
        
        int i = stack.size();
        
        for(int item: stack){
            result[--i] = item;
        }
        
        return result;
    }
}
