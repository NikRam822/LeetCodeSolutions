package dt.tasks;

import java.util.Arrays;

/*Дано a - упорядоченный по не убыванию массив, index - индекс элемента, k - кол-во элементов которое надо вернуть

Требуется вернуть k ближайших элементов к числу расположенному на index индексе в массиве

a=[1, 2, 5, 6, 100] index=3, k=3: ответ [5, 6, 2]
a=[1, 2, 4, 5, 6] index=2, k=0: ответ []*/
public class NeighborsSearch {

    public int[] neighborsSearch(int[] a, int index, int k) {
        if (a.length < index || k == 0) return new int[0];
        if (index == 0) return Arrays.copyOfRange(a, 0, k);
        if(k==1) return new int[]{a[index]};
        int[] result = new int[k];

        result[0] = a[index - 1];
        int count = 1;

        int left = index - 1;
        int right = index - 1;


        for (int i = 1; i < k; i++) {
            if (count == k) {
                System.out.println(Arrays.toString(result));
                return result;
            }

            if ( left != 0) {
                left--;
                result[count] = a[left];
                count++;
            }

            if (right + 1 != a.length) {
                right++;
                result[count] = a[right];
                count++;
            }
        }

        return result;
    }
}
