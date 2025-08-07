import java.util.Arrays;
import java.util.HashMap;

/**
 * Решение прошло с трудом
 * Общая идея:
 * 1) Преобразуем массив в мапу
 * 2) Идем по массиву, берем очередные два числа и ищем недостающее, если недостающее есть в мапе, проверяем что это не дубликат и выводим
 * 3) Если число все таки дубликат, или его в мапе нет - используем бинарный поиск и ищем ближайшее число. Минимальнуя сумма чисел - ответ.
 */
public class ThreeSumClosest {
    int c1 = 0;
    int c2 = 0;

    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(i -> {
            Integer c = map.get(i);
            if (c == null) {
                map.put(i, 1);
            } else {
                map.replace(i, c + 1);
            }

        });

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                c1 = i;
                c2 = j;
                int res = target - (nums[i] + nums[j]);
                if (map.get(res) != null) {


                    if (nums[i] == nums[j] || nums[j] == res || nums[i] == res) {
                        HashMap<Integer, Integer> mapCopy = new HashMap<>(map);
                        int check = mapCopy.get(nums[i]) - 1;
                        mapCopy.replace(nums[i], check);
                        int check2 = mapCopy.get(nums[j]) - 1;
                        mapCopy.replace(nums[j], check2);
                        int check3 = mapCopy.get(res) - 1;
                        mapCopy.replace(res, check3);
                        if (check < 0 || check2 < 0 || check3 < 0) {

                            int close = binarySearch(nums, res);
                            if (Math.abs(target - (nums[i] + nums[j] + close)) < Math.abs(target - result)) {
                                result = nums[i] + nums[j] + close;
                            }
                            System.out.println(result);
                        } else {
                            return target;
                        }

                    } else {
                        return target;
                    }

                } else {
                    int close = binarySearch(nums, res);
                    if (Math.abs(target - (nums[i] + nums[j] + close)) < Math.abs(target - result)) {
                        result = nums[i] + nums[j] + close;
                    }

                }
            }
        }
        //System.out.println(result);
        return result;
    }

    public int binarySearch(int[] nums, int res) {
        int last = nums.length - 1;
        int first = 0;
        int mid = nums.length / 2;
        int close = 1000000000;

        if (Math.abs(res - nums[first]) < Math.abs(res - nums[last])) {
            if (nums[first] != res && first != c1 && first != c2) {
                close = nums[first];
            } else {
                if (nums[last] != res && last != c1 && last != c2)
                    close = nums[last];
            }
        } else {
            if (nums[last] != res && last != c1 && last != c2)
                close = nums[last];
        }

        while (last - first != 1) {
            if (res >= nums[mid]) {
                first = mid;
                if (Math.abs(res - nums[first]) < Math.abs(res - close)) {
                    if (nums[first] != res && first != c1 && first != c2)
                        close = nums[first];
                }
                mid = (last + 1 - first) / 2 + first;
            } else {
                last = mid;
                if (Math.abs(res - nums[last]) < Math.abs(res - close)) {
                    if (nums[last] != res && last != c1 && last != c2)
                        close = nums[last];
                }
                mid = ((last + 1 - first) / 2 + first);
            }
        }
        return close;
    }
}
