import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        HashMap<Integer, Integer> numbers = new HashMap<>();
        Set<List<Integer>> result = new HashSet<>();
        Arrays.stream(nums).forEach(i -> {
            Integer c = numbers.get(i);
            if (c == null) {
                numbers.put(i, 1);
            } else {
                numbers.replace(i, c + 1);
            }

        });

//        nums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int res = target - (nums[i] + nums[j]);
                for (int k = nums.length - 1; k > j; k--) {
                    HashMap<Integer, Integer> map = new HashMap<>(numbers);
                    int last = res - nums[k];
                    if (nums[i] + nums[j] + nums[k] + last != target) {
                        continue;
                    }

                    if (map.get(last) == null) {
                        continue;
                    }
                    //System.out.println(nums[i] + " " + nums[j] + " " + nums[k] + " " + (res - nums[k]));
                    Integer check = map.get(nums[i]) - 1;
                    map.replace(nums[i], check);
                    Integer check2 = map.get(nums[j]) - 1;
                    map.replace(nums[j], check2);
                    Integer check3 = map.get(nums[k]) - 1;
                    map.replace(nums[k], check3);
                    Integer check4 = map.get(last) - 1;
                    map.replace(nums[k], check4);
                    if (check < 0 || check2 < 0 || check3 < 0 || check4 < 0) {
                        continue;
                    }

                    Integer[] con = new Integer[]{nums[i], nums[j], nums[k], last};
                    Arrays.sort(con);
                    result.add(List.of(con));
                }
            }
        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(numbers);
//        System.out.println(result);
        return new ArrayList<>(result);
    }
}
