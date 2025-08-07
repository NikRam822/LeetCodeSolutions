import java.util.*;

/**
 * Переводим все эдементы в сет (используем LinkedHashSet чтобы гарантировать порядок элементов, как в оригинальном массиве), чтобы оставить только уникальны, затем в основном массиве заменяем первые эелементы на уникальные.
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        Set<Integer> uniqNumbers = new LinkedHashSet<>();


        Arrays.stream(nums).forEach(uniqNumbers::add);

        ArrayList<Integer> uniqs = new ArrayList<>(uniqNumbers);

        for (int i = 0; i < uniqNumbers.size(); i++) {
            nums[i] = uniqs.get(i);
        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(uniqNumbers.size());
        return uniqNumbers.size();
    }
}
