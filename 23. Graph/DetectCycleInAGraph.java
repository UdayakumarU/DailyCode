/*
207. Course Schedule A.K.A. Detect cycle in a graph
Approach: DFS using recursion

Time complexity: O(V+E)
Space complexity: O(V);

*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> preRequisiteCourseMap = generateAdjacencyList(numCourses, prerequisites); 
        boolean[] visitedCourse = new boolean[numCourses];
        boolean[] completedCourse = new boolean[numCourses];

        for(int course=0; course<numCourses; ++course){ // need to repeat for all vertices since it is a disjoint graph
            if(isCycleExist(course, completedCourse, visitedCourse, preRequisiteCourseMap)){
                return false;
            }
            completedCourse[course] = true;
        }

        return true;
    }

    private static boolean isCycleExist(
        int course, 
        boolean[] completedCourse, 
        boolean[] visitedCourse,
        List<List<Integer>>preRequisiteCourseMap){

            if(preRequisiteCourseMap.get(course).size() == 0 || completedCourse[course]){ //no cycle exist
                return false;
            }

            if(visitedCourse[course] == true){ // cycle exist
                return true;
            }

            visitedCourse[course] = true;

            for(int preRequisiteCourse: preRequisiteCourseMap.get(course)){
                if(isCycleExist(preRequisiteCourse, completedCourse, visitedCourse, preRequisiteCourseMap)){
                    return true; // cycle exist
                }
            }

            completedCourse[course] = true;// if any internal course is completed, set it here

            return false;
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
