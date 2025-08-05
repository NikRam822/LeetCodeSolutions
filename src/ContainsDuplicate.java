import java.util.Arrays;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        System.out.println(nums.length != Arrays.stream(nums).distinct().count());
        return nums.length !=  Arrays.stream(nums).distinct().count();

    }
}