import java.awt.*;

/**
 * Общая идея:
 * Сел, подумал, нашел формулу для формирования шага (отсуп по строке до нужного символа)
 * <p>
 * 1) Для первого и последнего шага (кол-во шагов = кол-ву строк): x=numRows * 2 - 2
 * 2) Для среднего элемента, если строка нечетная - просто обычный щаг, но только один (обычно чередуются)
 * 3) Во всех остальных случаях происходит чередование, поэтому шагов для строки обычно 2.
 * Каждый шаг формируется из предыдущего: x=x-2; y=y+2;
 * Т.к. шаг имеет два числа (чередование), я решил хранить их в Point
 * <p>
 * Итак, формируем шаг для каждой тсроки, как только шаг сформировали - заполняем итоговую строку:
 * При заполнении строки, кладем первый символ в строку, затем по формуле высчитали кол-во символов в строке с текущим шагом (формула:s.length() / step.x ),
 * затем, записываем символы в итоговую строку, увелечивая шаг. Если у нас есть чередование шагов,
 * тогда после каждого добавления мы меняем текущий шаг на следующий и уменьшаем инкремент, чтобы с новым шагом добавить нужные символы
 */
public class ZigzagConversion {
    int correct = 0;

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        String result = "";
        int x = numRows * 2 - 2;
        int y = 0;
        Point step = new Point();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                step = new Point(numRows * 2 - 2, 0);
                //System.out.println(step);
                result = fillResult(s, step, new StringBuilder(result));
                continue;
            }

            if (numRows % 2 == 1 && i == numRows / 2) {
                x = x - 2;
                y = y + 2;
                step = new Point(x, 0);
                //System.out.println(step);
                result = fillResult(s, step, new StringBuilder(result));
                continue;
            }

            x = x - 2;
            y = y + 2;
            step = new Point(x, y);
            //System.out.println(step);
            result = fillResult(s, step, new StringBuilder(result));

        }
        // System.out.println(result);
        return result;
    }

    private String fillResult(String s, Point step, StringBuilder result) {
        result.append(s.charAt(correct));
        int someStep = step.x;
        int currentStep = step.x;
        for (int i = 0; i < s.length() / step.x; i++) {
            if (someStep + correct < s.length()) {
                result.append(s.charAt(someStep + correct));

                if (step.y != 0 && currentStep == step.x) {
                    currentStep = step.y;
                    i--;
                } else {
                    if (step.y != 0) {
                        currentStep = step.x;
                        i--;
                    }
                }
                someStep += currentStep;
            }


        }
        correct++;
        return result.toString();
    }
}
