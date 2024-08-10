/*
785. Is Graph Bipartite?

Bipartite: If all nodes are colored with just 2 colors and no adjacent nodes have the same color
Approach: DFS -> color every next node with an alternate color recursively

Time complexity: O(V+E)
Space complexity: O(V)
*/

class Solution {
    public boolean isBipartite(int[][] graph) {
        //If all node are colored with just 2 colors and no adjacent nodes have the same color
        int[] nodeColor = new int[graph.length];

        //Loop through all the nodes since graph can be disconnected
        for(int graphStart=0; graphStart<graph.length; ++graphStart){
            if(nodeColor[graphStart] != 0)
                continue;

            if(!canColor(graphStart, 1, nodeColor, graph))
                return false;
        }

        return true;
    }

    private static boolean canColor(int node, int color, int[] nodeColor, int[][] graph){
        if(nodeColor[node] == color*-1)
            return false;
        
        if(nodeColor[node] == 0){
           nodeColor[node] = color;
           for(int adjacentNode: graph[node]){
                boolean canColor = canColor(adjacentNode, color*-1, nodeColor, graph);
                if(!canColor) 
                    return canColor;
            }
        }

        return true;
    }
}
