/*
785. Is Graph Bipartite?

Bipartite: If all node are colored with just 2 colors and no adjacent nodes have the same color
Approach: BFS:
         It is a bruteforce technique just color the start as 1 and color its adjacent nodes -1 

Time complexity: O(V+E)
Space complexity: O(V)
*/

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] nodeColor = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        //Loop through all the nodes since graph can be disconnected
        for(int graphStart=0; graphStart<graph.length; ++graphStart){
            if(nodeColor[graphStart] != 0)
                continue;

            queue.add(graphStart);
            nodeColor[graphStart] = 1;
            while(!queue.isEmpty()){
                int node = queue.poll();

                for(int adjacentNode: graph[node]){
                    if(nodeColor[adjacentNode] == nodeColor[node]) 
                        return false;

                    if(nodeColor[adjacentNode] == 0){
                        nodeColor[adjacentNode] = nodeColor[node] * -1;
                        queue.add(adjacentNode);
                    }
                }
            }
        }

        return true;
    }
}
