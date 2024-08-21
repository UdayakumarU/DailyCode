/*
  1865. Finding Pairs With a Certain Sum
  Approach: Use hash map to store the num2 numbers occurance.
            This will reduce the time complexity of Count operation from O(n^2) to O(n)
  Time complexity: 
    Add: O(1)
    Count: O(num1)
  Space complexity: O(num2)
*/
class FindSumPairs {
    int[] nums1;
    int[] nums2;
    HashMap<Integer, Integer> numberOccurance;
    
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        
        numberOccurance = new HashMap<>();
        for(int num: nums2 ){
            numberOccurance.put(num, numberOccurance.getOrDefault(num, 0)+1);
        }
    }

    public void add(int index, int val) {
        numberOccurance.put(nums2[index], numberOccurance.getOrDefault(nums2[index], 0)-1);
        nums2[index] += val;
        numberOccurance.put(nums2[index], numberOccurance.getOrDefault(nums2[index], 0)+1);
    }
    
    public int count(int tot) {
        int totalPair = 0;
        for(int number : nums1){
            totalPair += numberOccurance.getOrDefault(tot-number, 0);
        }
        return totalPair;
    }
}
