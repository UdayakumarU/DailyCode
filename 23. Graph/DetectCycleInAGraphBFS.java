/*
207. Course Schedule A.K.A. Detect cycle in a graph
Approach: BFS using queue -> Topology sort

Time complexity: O(V+E)
Space complexity: O(V);

*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> preRequisiteCourseMap = generateAdjacencyList(numCourses, prerequisites);
        List<Integer> topo = new LinkedList<>(); // this is required since it is a disjoint graph
        int[] indegree = generateIndegree(numCourses, prerequisites);
        Queue<Integer> queue = new LinkedList<>();

        for(int course=0; course<indegree.length; ++course){
            if(indegree[course] == 0){
                queue.add(course);
            }
        }

        if(queue.isEmpty())
            return false;
        
        while(!queue.isEmpty()){
            int currentCourse = queue.poll();
            topo.add(currentCourse);

            for(int preRequisiteCourse: preRequisiteCourseMap.get(currentCourse)){
                --indegree[preRequisiteCourse];

                if(indegree[preRequisiteCourse] < 0) 
                    return false;

                if(indegree[preRequisiteCourse] == 0)
                    queue.add(preRequisiteCourse);
            }
        }

        return (topo.size() == numCourses);
    }

    private static int[] generateIndegree(int numCourses, int[][] prerequisites){
        int[] indegree = new int[numCourses];
        
        for(int i=0; i<prerequisites.length; ++i){
            ++indegree[prerequisites[i][1]];
        }   
        return indegree;
    }


    private static List<List<Integer>> generateAdjacencyList(int vertices, int[][] edges){
        
        List<List<Integer>> adjacenyList = new ArrayList<>();
        for(int i=0; i<vertices; ++i){
           adjacenyList.add(new ArrayList<Integer>());
        }

        for(int i=0; i<edges.length; ++i){
            adjacenyList.get(edges[i][0]).add(edges[i][1]);
        }

        return adjacenyList;
    }

}
