import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Общая идея:
 * Идем по массиву чисел, ищем число n - число, которое дает в сумме с текущим, искомое число
 * добавляем n в вспомогательный массив и каждый раз проверям, содержится ли в массиве очередное число, если содержится - возращяем индексы
 */
class TwoSun {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < nums.length; i++) {
            int secondNumber = target - nums[i];
            if (list.contains(secondNumber) && i != list.indexOf(secondNumber)) {
                return new int[]{i, list.indexOf(secondNumber)};
            }

        }
        return null;
    }
}
