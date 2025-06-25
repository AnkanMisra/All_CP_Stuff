// Tc = O(nlogm)   => dependent on count function

class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = (long) -1e10, high = (long) 1e10;

        while (low <= high) {
            long dotProduct = (low + high) / 2;
            if (countNoOfElements(nums1, nums2, dotProduct) < k)
                low = dotProduct + 1;
            else
                high = dotProduct - 1;
        }
        return high;
    }

    private long countNoOfElements(int[] nums1, int[] nums2, long dotProduct) { // this function will return the no. of
                                                                                // elements(after product) which are
                                                                                // less than dotProduct
        long count = 0;
        for (int element : nums1) {
            if (element >= 0) { // if positve
                int low = 0, high = nums2.length; // binary search on nums2
                while (low < high) {
                    int mid = (low + high) / 2;
                    if ((long) element * nums2[mid] < dotProduct)
                        low = mid + 1;
                    else
                        high = mid;
                }
                count += low; // no. of elemets after product with element smaller than dotproduct
            } else { // if negative => binary search in some reverse order
                int low = 0, high = nums2.length;
                while (low < high) {
                    int mid = (low + high) / 2;
                    if ((long) element * nums2[mid] >= dotProduct)
                        low = mid + 1;
                    else
                        high = mid;
                }

                count += nums2.length - low; // in negative element case smaller element will be on right side
            }

        }
        return count;
    }
}
