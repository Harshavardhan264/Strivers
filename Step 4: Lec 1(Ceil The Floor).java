import java.util.* ;
import java.io.*; 

public class Solution {
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
       int floor = -1, ceil = -1;
        int low = 0, high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (a[mid] <= x) {
                floor = a[mid];
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }

        low = 0;
        high = a.length - 1;

        // Find ceiling
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (a[mid] >= x) {
                ceil = a[mid];
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }

        return new int[]{floor, ceil};
    }
    
}
