/*
  17.10 Vertical order traversal
  Approach: Using recursively find row and column and store them on Treemap<Integer, Treemap<Integer, PriorityQueue>>>
  Time: O(n)
  Space: O(n)
*/

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = 
			new TreeMap<>();

		generateVerticalOrderMap(root, map, 0 , 0);
		return getVerticalOrderList(map);
    }

    private static void generateVerticalOrderMap(TreeNode node, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, int row, int column){
	
		//base condition
		if(node == null) return;

        TreeMap<Integer, PriorityQueue<Integer>> currentRow;
        if(map.containsKey(row) == false){
            currentRow = new TreeMap<>();
            map.put(row, currentRow);
        }
        else{
            currentRow = map.get(row);
        }

        if(currentRow.containsKey(column) == false){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(node.val);	
            currentRow.put(column, pq);
        }
        else{
            PriorityQueue<Integer> pq = currentRow.get(column);
            pq.add(node.val);
        }

        generateVerticalOrderMap(node.left, map, row-1, column+1);
        generateVerticalOrderMap(node.right, map, row+1, column+1);
    }

    private static List<List<Integer>> getVerticalOrderList(TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map){
	    List<List<Integer>> verticalOrder = new ArrayList<>();
	
        map.forEach((key, row) ->{
            ArrayList<Integer> section = new ArrayList<>();
           
            for(Map.Entry<Integer, PriorityQueue<Integer>> cell: row.entrySet()){
                while(cell.getValue().size() != 0){
                    section.add(cell.getValue().poll());
                }
            }
            
            verticalOrder.add(section);
        });

	    return verticalOrder;
    }

}
