import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Основная идея:
 * Идем по массиву, если текущий элемент == последний элеемнт +1 - значит это послеовательность и тогда делаем следующее:
 * Если длинна текущей строки равна длинне последнего символа - значит в строке один символ (это первый член псоледовательности) тогда мы дорисовываем ->.
 * Если длинна текущей строки равна последнему символу +2 - значит сейчас в строке первый член последовательности и "->" тогда добавляем текущий элемент,
 * но если в строке уже есть есть что-то после стрелочки - заменяем это на текущий.
 *
 *
 * Возвращаемся к первому условию, если у нас не последовталеьность - проверяем текущую строку, если она не пуста - добавляем в итоговый массив и очищаем ее.
 * Далее просто добавляем текущий элемент в строку
 *
 * Вне зависимоти от условий меняем последний элеемнт на текущий
 *
 * после выхода из массива добавляем в массив строку, если она не пустая и возвращаем результат
 *
 * P.S. Кода многовато, но решение хорошее по времени.
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<String>();
        List<String> result = new ArrayList<>();

        long last = Long.MIN_VALUE;
        StringBuilder currentStr = new StringBuilder();
        for (int n : nums) {

            if (last + 1 == n) {
                if (currentStr.length() == String.valueOf(last).length()) currentStr.append("->");
                if (currentStr.length() == String.valueOf(last).length()+2) {
                    currentStr.append(n);
                } else {
                    currentStr.replace(String.valueOf(last).length()+2, currentStr.length(), String.valueOf(n));
                }
            } else {
                if (!currentStr.isEmpty()) {
                    result.add(currentStr.toString());
                    currentStr.setLength(0);
                }
                currentStr.append(n);
            }
            last = n;

        }
        if (!currentStr.isEmpty()) {
            result.add(currentStr.toString());
        }
         System.out.println(Collections.unmodifiableList(result));
        return result;

    }
}
