/*
  17.7 Bottom View of Binary tree
  GFG: https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
  Time complexity: O(n)
  Space complexity: O(n)
*/

class Solution
{
    public ArrayList <Integer> bottomView(Node root)
    {
        Visualizer viz = new Visualizer();
        return viz.getBottomView(root);
    }
}


class Visualizer{
    private class NodeWithPosition{
        Node node;
        Integer column;
        
        NodeWithPosition(Node node, Integer column){
            this.node = node;
            this.column = column;
        }
    }

    ArrayList<Integer> bottomView;
    TreeMap<Integer, Integer> tracker;

    Visualizer(){
        bottomView = new ArrayList<>();
        tracker = new TreeMap<>();
    }
    
    ArrayList<Integer> getBottomView(Node root){
        this.traverseLevelorder(root);
        ArrayList<Integer> sortedColumn = new ArrayList<>(this.tracker.keySet());
        
        this.tracker.forEach((Integer column, Integer value) -> {
            this.bottomView.add(value);
        });
        
        return this.bottomView;
    }

    private void traverseLevelorder(Node root){
        if (root == null) return;
        
        Queue<NodeWithPosition> queue = new LinkedList<>();
        NodeWithPosition nodeWithPosition = new NodeWithPosition(root, 0);
        
        queue.offer(nodeWithPosition);
        
        while(!queue.isEmpty()){
            NodeWithPosition currentNodePair = queue.poll();
            tracker.put(currentNodePair.column, currentNodePair.node.data);
            
            if(currentNodePair.node.left != null){
                nodeWithPosition = new NodeWithPosition(currentNodePair.node.left, currentNodePair.column-1);
                queue.offer(nodeWithPosition);
            }
            
            if(currentNodePair.node.right != null){
                nodeWithPosition = new NodeWithPosition(currentNodePair.node.right, currentNodePair.column+1);
                queue.offer(nodeWithPosition);
            }
        }
    }
}
