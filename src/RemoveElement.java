import java.util.Arrays;

/**
 * Сделал через потоки, но пришлось скопировать массив, т.к. при тестировании результат работы метода передавался выше по коду
 * и массив nums в коде был свой, поэтому если переопределять значение через nums= Arrays.stream(nums)... будет меняться только
 * локальная переменная внутри метода
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int[] filtered = Arrays.stream(nums).filter(num -> num != val).toArray();

        System.arraycopy(filtered, 0, nums, 0, filtered.length);
        return filtered.length;
    }
}