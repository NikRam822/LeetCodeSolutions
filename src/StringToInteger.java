import java.util.HashMap;

/**
 * Код мне не нравится
 * Общее решение:
 * Создали мапу цифр. Идем по строке, если очередной символ число -
 * проеряем, что перед ним стоит '-', если минус есть меняем флаг на -1 если нет - флаг остается 1
 * Дальше добавляем число в результирующую строку и проверяем следующий символ
 * Если следующий символ не число - завершаем цикл, если нет - идем дальше
 * Также добавил проверки, что если текущий символ не число - мы проверяем,
 * что это пробел, если пробел - идем дальше, если нет - проверяю '-' это или '+'
 * Если это не '-' или '+' возвращяем ноль, если все же '-' или '+' я проверяю что за этим символом стоит число, если не число - возвращаю ноль, если число - иду дальше
 * <p>
 * Таким образом в результирующей строке будет чсило
 * Я пробую преоброзовать эту строку в число, домножая на флаг (если перед числом минус - значит оно отрицательное и нужно в начале его на -1 домножить)
 * Если получилось - возвращаю это число (это и есть ответ), если не получилось, возвращаю Integer.MIN_VALUE, если число отрицательное и Integer.MAX_VALUE, если положительное
 */
public class StringToInteger {
    static HashMap<Character, Integer> map = new HashMap<>();

    static {
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
    }

    public int myAtoi(String s) {
        int mult = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Integer c = map.get(s.charAt(i));
            if (c != null) {
                if (i != 0 && s.charAt(i - 1) == '-') {
                    mult = -1;
                }
                result.append(c);
                if (i + 1 < s.length() && map.get(s.charAt(i + 1)) == null) {
                    break;
                }
            } else {
                if (s.charAt(i) == ' ') {

                } else {
                    if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                        if (i + 1 < s.length() - 1 && map.get(s.charAt(i + 1)) == null) {
                            return 0;
                        }

                    } else {
                        return 0;
                    }

                }
            }

        }
        // System.out.println(result);
        try {
            int c = Integer.parseInt(result.toString()) * mult;
            // System.out.println(c);
            return c;
        } catch (Exception e) {
            if (result.length() == 0) {
                return 0;
            }
            if (mult == -1) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
}
