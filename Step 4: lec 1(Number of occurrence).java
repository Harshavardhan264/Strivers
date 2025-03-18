class Solution {
    int countFreq(int[] arr, int target) {
        // Find the first and last occurrences of the target
        int first = findBound(arr, target, true);
        int last = findBound(arr, target, false);
        
        // If target is not present, return 0
        if (first == -1 || last == -1) {
            return 0;
        }
        
        // The number of occurrences is last - first + 1
        return last - first + 1;
    }

    private int findBound(int[] arr, int target, boolean findFirst) {
        int low = 0, high = arr.length - 1;
        int bound = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                bound = mid; // Target found
                if (findFirst) {
                    high = mid - 1; // Search the left half
                } else {
                    low = mid + 1; // Search the right half
                }
            } else if (arr[mid] < target) {
                low = mid + 1; // Move right
            } else {
                high = mid - 1; // Move left
            }
        }
        
        return bound;
    }
}
