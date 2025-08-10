import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Общая идея:
 * Идем по массиву чисел, ищем число n - число, которое дает в сумме с текущим, искомое число
 * добавляем n в вспомогательный массив и каждый раз проверям, содержится ли в массиве очередное число, если содержится - возращяем индексы
 */
class TwoSun {
   /* public int[] twoSum(int[] nums, int target) {
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
    }*/

    /**
     * Решение лучше по памяти.Сделал с помощью двойных указателей.
     * Делаем 2 указателя слева и справа массива.
     * Слкадываем левое и правое число, если сумма совпадает с искомым числом - решено.
     * Если нет,тогда:
     *  1) Если искомое число больше найденной суммы, тогда увеличиваем сумму, за счет смещения наименьшего элемента
     *  (чтобы к наибольшему прибавлять больший элемент, чем в прошлый раз)
     *  2) Если искомое число меньше найденной суммы, тогда уменьшаем сумма за счет сдвига наиольшего элеемнта
     *  P.S. Работает только для отсортированного массива.
     */
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length-1;

        while (left <= right) {
            int checkSum = numbers[left] + numbers[right];

            if (checkSum == target) return new int[]{left, right};

            if (target > checkSum) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};
    }
}
