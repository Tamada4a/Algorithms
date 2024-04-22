import java.util.HashMap;

class Solution {
    // We are looking for two numbers that add up to the target number
    public int[] twoSum(int[] nums, int target) {
        // Creating a HashMap in which the key is the value of the element, and the value
        // is the index of the element
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            // If there is a number in the HashMap that, combined with the current element, gives target,
            // then we return a pair of indexes
            if (numsMap.containsKey(target - nums[i]))
                return new int[]{numsMap.get(target - nums[i]), i};
            // Otherwise, we add the number to the HashMap
            else
                numsMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}