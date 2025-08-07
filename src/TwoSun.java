import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Общая идея:
 * Идем по массиву чисел, ищем число n - число, которое дает в сумме с текущим, искомое число
 * добавляем n в вспомогательный массив и каждый раз проверям, содержится ли в массиве очередное число, если содержится - возращяем индексы
 */
class TwoSun {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer result = map.get(target - nums[i]);
            if (result != null && result != i) {
                return new int[]{i, result};
            }
        }
        return null;
    }
}
