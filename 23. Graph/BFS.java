/*
  Graph traversal : Breath first search
  Approach: Queue to store the next nodes and HashSet to store the visited node

  Time complexity: O( E + V )
  Space complexity: O(V)
*/

class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
      
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        ArrayList<Integer> bfs = new ArrayList<>();
        
        queue.add(0);
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            
            if(set.contains(node))
                continue;
                
            bfs.add(node);
            set.add(node);
            
            for(int adjacentNode : adj.get(node)){
                 if(!set.contains(adjacentNode)){
                     queue.add(adjacentNode);
                 }
            }
        }
        
        return bfs;
    }
}
