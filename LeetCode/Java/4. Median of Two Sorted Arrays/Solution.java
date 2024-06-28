import java.util.ArrayList;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // This array will store the result of merging two arrays
        ArrayList<Integer> mergedArray = new ArrayList<>();
        int i = 0, j = 0;

        // Starting the merging of arrays
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                mergedArray.add(nums1[i]);
                i++;
            } else {
                mergedArray.add(nums2[j]);
                j++;
            }
        }

        // After the first stage of merging, the elements of one of the arrays were not added to the
        // final array. To do this, call the updateArray function to add the remaining elements to the
        // end
        updateArray(nums1, mergedArray, i);
        updateArray(nums2, mergedArray, j);

        if (mergedArray.isEmpty())
            return 0;

        // Calculate the median index
        int medIdx = (int) Math.ceil((double) mergedArray.size() / 2) - 1;

        // Returning the median value
        if (mergedArray.size() % 2 == 0)
            return (double) (mergedArray.get(medIdx) + mergedArray.get(medIdx + 1)) / 2;

        return mergedArray.get(medIdx);
    }


    // This function allows you to add missing elements of one of the arrays to the array
    private void updateArray(int[] nums, ArrayList<Integer> mergedArray, int pointer) {
        while (pointer < nums.length) {
            mergedArray.add(nums[pointer]);
            pointer++;
        }
    }
}