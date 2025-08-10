import java.util.Arrays;

public class BinarySearch {
    /**
     * Встроенная реалезация
     *
     * @param nums   - отсортированный массив
     * @param target - искомое число
     * @return число, если есть, отрицательный индекс - если числа нет.
     */
    /*public int search(int[] nums, int target) {
        int res = Arrays.binarySearch(nums, target);
        return res < 0 ? -1 : res;
    }*/
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) return middle;

            if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
