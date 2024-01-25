import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
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

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int res = -1 * (nums[i] + nums[j]);
                Integer c = numbers.get(res);
                if (c != null) {
                    HashMap<Integer, Integer> map = new HashMap<>(numbers);

                    Integer check = map.get(nums[i]);
                    check--;
                    map.replace(nums[i], check);
                    if (check < 0) {
                        continue;
                    }

                    Integer check2 = map.get(nums[j]);
                    check2--;
                    map.replace(nums[j], check2);
                    if (check2 < 0) {
                        continue;
                    }

                    Integer check3 = map.get(res);
                    check3--;
                    map.replace(res, check3);
                    if (check3 < 0) {
                        continue;
                    }

                    Integer[] con = new Integer[]{nums[i], nums[j], res};
                    Arrays.sort(con);
                    result.add(List.of(con));
                }
            }
        }
        /*System.out.println(Arrays.toString(nums));
        System.out.println(numbers);
        System.out.println(result);*/
        return new ArrayList<>(result);
    }
}
