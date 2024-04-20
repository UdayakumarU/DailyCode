/*
17.8 Binary tree top view from left to right
https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
Time complexity O(n)
Space complexity O(n/2) -> max width of the tree
*/

class Solution
{    
    static ArrayList<Integer> topView(Node root)
    {
        Visualizer viz = new Visualizer();
        return viz.getTopView(root);
    }
}

class Visualizer{
    class Pair{
        Node node;
        int column;
        Pair(Node node, int column){
            this.node = node;
            this.column = column;
        }
    }
    TreeMap<Integer, Integer> map;
    LinkedList<Pair> queue;
    
    Visualizer(){
        map = new TreeMap<>();
        queue = new LinkedList<>();
    }
    
    ArrayList<Integer> getTopView(Node root){
        this.traverse(root);
        return convertMapToArrayList(this.map);
    }
    
    private void traverse(Node node){
        if(node == null) return;
        
        queue.add(new Pair(node, 0));
        while(queue.size() >= 1){
            Pair currentPair = queue.remove(); 
             
            if(this.map.get(currentPair.column) == null)
                map.put(currentPair.column, currentPair.node.data);
            if(currentPair.node.left != null) 
                queue.add(new Pair(currentPair.node.left, currentPair.column-1));
            if(currentPair.node.right != null) 
                queue.add(new Pair(currentPair.node.right, currentPair.column+1));
        }
    }
    
    private static ArrayList<Integer> convertMapToArrayList(TreeMap<Integer, Integer> map){
        ArrayList<Integer> list = new ArrayList<>();
        map.forEach((k,v)->{
            list.add(v);
        });
        return list;
    }
    
}    
