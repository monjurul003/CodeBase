package newstart.programming.slidingwindow;
/*
Maximize number of 0s by flipping a subarray
Given a binary array, find the maximum number of zeros in an array with one flip of a subarray allowed. A flip operation switches all 0s to 1s and 1s to 0s.
Examples:

Input :  arr[] = {0, 1, 0, 0, 1, 1, 0}
Output : 6
We can get 6 zeros by flipping the subarray {1, 1}

Input :  arr[] = {0, 0, 0, 1, 0, 1}
Output : 5
* */
public class BitFlapping {
    // A Kadane's algorithm based solution to find maximum
    // number of 0s by flipping a subarray.
    public static int findMaxZeroCount(int arr[], int n)
    {
        // Initialize count of zeros and maximum difference
        // between count of 1s and 0s in a subarray
        int orig_zero_count = 0;

        // Initiale overall max diff for any subarray
        int max_diff = 0;

        // Initialize current diff
        int curr_max = 0;

        for (int i = 0; i < n; i ++)
        {
            // Value to be considered for finding maximum sum if arr[i] == 1 then +1 else -1
            int val = 1;
            // Count of zeros in original array (Not related to Kadane's algorithm) but val -1 related to kadane
            if (arr[i] == 0) {
                orig_zero_count++;
                val = -1;
            }

            // Update current max and max_diff
            curr_max = Math.max(val, curr_max + val);
            max_diff = Math.max(max_diff, curr_max);
        }
        max_diff = Math.max(0, max_diff);

        return orig_zero_count + max_diff;
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        int arr[] = {0, 1, 0, 0, 1, 0, 0};

        System.out.println(findMaxZeroCount(arr, arr.length));
    }
}

