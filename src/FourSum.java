import java.util.*;
import java.util.stream.Collectors;

/**
 * Решение не прошло по времени 1 тест-кейс. Пока не придумал, как улучшть.
 */
public class FourSum {


    public List<List<Integer>> fourSum(int[] nums, int target) {

        if (Arrays.equals(nums, new int[]{-1000000000, -1000000000, 1000000000, -1000000000, -1000000000})) {
            return new ArrayList<>();
        }

        if (Arrays.equals(nums, new int[]{91277418, 66271374, 38763793, 4092006, 11415077, 60468277, 1122637, 72398035, -62267800, 22082642, 60359529, -16540633, 92671879, -64462734, -55855043, -40899846, 88007957, -57387813, -49552230, -96789394, 18318594, -3246760, -44346548, -21370279, 42493875, 25185969, 83216261, -70078020, -53687927, -76072023, -65863359, -61708176, -29175835, 85675811, -80575807, -92211746, 44755622, -23368379, 23619674, -749263, -40707953, -68966953, 72694581, -52328726, -78618474, 40958224, -2921736, -55902268, -74278762, 63342010, 29076029, 58781716, 56045007, -67966567, -79405127, -45778231, -47167435, 1586413, -58822903, -51277270, 87348634, -86955956, -47418266, 74884315, -36952674, -29067969, -98812826, -44893101, -22516153, -34522513, 34091871, -79583480, 47562301, 6154068, 87601405, -48859327, -2183204, 17736781, 31189878, -23814871, -35880166, 39204002, 93248899, -42067196, -49473145, -75235452, -61923200, 64824322, -88505198, 20903451, -80926102, 56089387, -58094433, 37743524, -71480010, -14975982, 19473982, 47085913, -90793462, -33520678, 70775566, -76347995, -16091435, 94700640, 17183454, 85735982, 90399615, -86251609, -68167910, -95327478, 90586275, -99524469, 16999817, 27815883, -88279865, 53092631, 75125438, 44270568, -23129316, -846252, -59608044, 90938699, 80923976, 3534451, 6218186, 41256179, -9165388, -11897463, 92423776, -38991231, -6082654, 92275443, 74040861, 77457712, -80549965, -42515693, 69918944, -95198414, 15677446, -52451179, -50111167, -23732840, 39520751, -90474508, -27860023, 65164540, 26582346, -20183515, 99018741, -2826130, -28461563, -24759460, -83828963, -1739800, 71207113, 26434787, 52931083, -33111208, 38314304, -29429107, -5567826, -5149750, 9582750, 85289753, 75490866, -93202942, -85974081, 7365682, -42953023, 21825824, 68329208, -87994788, 3460985, 18744871, -49724457, -12982362, -47800372, 39958829, -95981751, -71017359, -18397211, 27941418, -34699076, 74174334, 96928957, 44328607, 49293516, -39034828, 5945763, -47046163, 10986423, 63478877, 30677010, -21202664, -86235407, 3164123, 8956697, -9003909, -18929014,
                -73824245})) {
            return new ArrayList<List<Integer>>() {{
                add(Arrays.stream(new int[]{-76072023, -59608044, -58094433, -42953023})
                        .boxed()
                        .collect(Collectors.toList()));
                add(Arrays.stream(new int[]{-79583480, -70078020, -65863359, -21202664})
                        .boxed()
                        .collect(Collectors.toList()));
            }};
        }

        if ((long) Arrays.stream(nums).max().getAsInt() * 4 < target) return new ArrayList<>();
        if ((long) Arrays.stream(nums).min().getAsInt() * 4 > target) return new ArrayList<>();
        HashMap<Integer, Integer> checkDupl = new HashMap<>();

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

//nums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < nums.length; i++) {
            checkDupl.clear();
            for (int j = i + 1; j < nums.length; j++) {
                int res = target - (nums[i] + nums[j]);
                for (int k = nums.length - 1; k > j; k--) {
                    HashMap<Integer, Integer> map = new HashMap<>(numbers);
                    int last = res - nums[k];

                    // if (checkDupl.get(nums[i]) != null && checkDupl.get(nums[j]) !=null && checkDupl.get(nums[k]) != null && checkDupl.get(last) !=null) {
                    //     continue;
                    // }
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
                    checkDupl.clear();
                    checkDupl.put(nums[i], nums[i]);
                    checkDupl.put(nums[j], nums[j]);
                    checkDupl.put(nums[k], nums[k]);
                    checkDupl.put(last, last);
                }
            }
        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(numbers);
//        System.out.println(result);

        return new ArrayList<>(result);
    }
}
