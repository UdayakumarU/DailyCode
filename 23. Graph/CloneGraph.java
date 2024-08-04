/*
133. Clone Graph

Approach: Using Hashmap to track new nodes and queue (BFS) for give node
Time complexity: O(E+V)
Space complexity; O(n)
*/

class Solution {
    public Node cloneGraph(Node node) {
        GraphCloner gc = new GraphCloner(node);
        return gc.clone();
    }
}


class GraphCloner{
    Map<Integer, Node> newNodeMap;
    Queue<Node> oldNodeQueue;
    Node cloneNode;

    GraphCloner(Node node){
        newNodeMap = new HashMap<>();
        oldNodeQueue = new LinkedList<>();
        oldNodeQueue.add(node);
        cloneNode = null;
    }

    public Node clone(){
        boolean isFirstNode = true;

        while(!oldNodeQueue.isEmpty()){
            Node node = oldNodeQueue.poll();
            if(node != null){
                Node newNode = generateNode(node);
                if(isFirstNode){
                    cloneNode = newNode;
                    isFirstNode = false;
                }
            }
        }

        return cloneNode;
    }

    private Node generateNode(Node node){
        Node newNode;

        if(!newNodeMap.containsKey(node.val)){
            newNode = new Node(node.val, new ArrayList<>());
            newNodeMap.put(node.val, newNode);
        }
        else{
            newNode = newNodeMap.get(node.val);
        }


        for(Node oldNeighborNode: node.neighbors){
            Node neighborNode;
            if(!newNodeMap.containsKey(oldNeighborNode.val)){
                neighborNode = new Node(oldNeighborNode.val, new ArrayList<>());

                newNodeMap.put(neighborNode.val, neighborNode);
                oldNodeQueue.add(oldNeighborNode);
            }
            else{
                neighborNode = newNodeMap.get(oldNeighborNode.val);
            }

            newNode.neighbors.add(neighborNode);
        }

        return newNode;
    }


}
