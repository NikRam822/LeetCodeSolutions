import java.util.*;

/**
 * Решение еле-еле прошло Time Limit
 * Общая идея:
 *
 * 1) Создал Хэшмэп из массива чисел, где ключ - это число из массива, а значение - кол-во раз, которое число встречается в массиве.
 * 2) Иду по массиву и беру все возможные пары чисел
 * 3) Для каждой пары ищу число, которое в сумме с двумя даст 0 и беру его из мапы.
 * 4) Если в мапе оно есть - проверяю что все три числа можно взять из массива (нет дубликатов числа) и добаляю такой маасив в сет массив.
 * Предварительно сортирую массив чисел, чтобы исключить дублирование при использовании сета (result)
 */
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
                    if (nums[i] == nums[j] || nums[j] == res || nums[i] == res) {
                        HashMap<Integer, Integer> map = new HashMap<>(numbers);
                        int check = map.get(nums[i])-1;
                        map.replace(nums[i], check);
                        int check2 = map.get(nums[j])-1;
                        map.replace(nums[j], check2);
                        int check3 = map.get(res)-1;
                        map.replace(res, check3);
                        if (check < 0 || check2< 0 || check3 < 0) {
                            continue;
                        }
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
