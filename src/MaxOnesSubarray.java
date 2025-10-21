import java.util.List;

public class MaxOnesSubarray {

    /**
     * Дан массив из нулей и единиц.
     * Необходимо определить, какой максимальный по длине подмассив только из единиц можно получить,
     * удалив ровно один элемент массива.
     *
     * @param array массив из нулей и единиц (состоит как минимум из одного элемента)
     * @return максимальная длина подмассива из единиц после удаления одного элемента
     */

    public int findMaxSubArray(List<Integer> array) {
        int result = 0;
        int countOnes = 0;
        int zeros = 0;

        for (int e : array) {
            if (e == 0 && countOnes == 0) continue;

            if (e == 1) {
                countOnes++;
            } else {
                if (zeros == 0) {
                    zeros++;
                } else {
                    if (result < countOnes) {
                        result = countOnes;
                    }
                    countOnes = 0;
                }
            }

        }

        if (result < countOnes) result = countOnes;
        System.out.println(result);
        return result;
    }
}
