package dt.tasks;

import java.util.ArrayList;

/*
Написать функцию, сжимающую строку

AAACCABBBBDDDDDC -> A3C2AB4D5C
*/

/**
 * Идем по массиву, если очередной символ равен последнему - увеличиваем счетчик.
 * Если очередной символ не равен last, проверяем счетчик: если там 0 или 1 (то есть это был первый пока что символ последовательности) -
 * - просто меняем ласт на текущий и добавляем элеемнт в массив.
 * Если это символ с счетчиком больше 1 - добавляем в итоговоую строку счетчик, счетчик обнуляем, обновляем последний символ (это уже новый символ, новой последовательности)
 * и кладем его в массив.
 */
public class Compressor {

    public String toCompress(String input) {

        StringBuilder result = new StringBuilder();
        char last = ' ';
        int count = 1;
        for (char c : input.toCharArray()) {
            if (c == last) {
                count++;
            } else {
                if (count > 1) {
                    result.append(count);
                    count = 1;
                }
                last = c;
                result.append(last);
            }
        }
        if (count > 1) {
            result.append(count);
        }

        return result.toString();

    }
}
