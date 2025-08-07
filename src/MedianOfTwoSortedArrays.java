import java.util.Arrays;

/**
 * Общая идея:
 * Объединяем два массива в один, сортируем и в отсортированном массиве ищем медиану
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] resultArray = new int[nums1.length + nums2.length];

        System.arraycopy(nums1, 0, resultArray, 0, nums1.length);
        System.arraycopy(nums2, 0, resultArray, nums1.length, nums2.length);

        Arrays.sort(resultArray);
        return findMedian(resultArray);
    }

    private double findMedian(int[] result) {
        if (result.length % 2 == 1) {
            return result[result.length / 2];
        } else {
            return (double) (result[result.length / 2] + result[result.length / 2 - 1]) / 2;
        }
    }
}