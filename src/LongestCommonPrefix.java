/**
 * Общая идея:
 * Берем первое слово и перебираем все буквы этого слова для каждого слова в массиве.
 * Сравниванме текущую букву в первом и текущем слове.
 * Если совпадение нашли - убеждаемся, что совпадение есть во всех словах (используем count для этого).
 * Если совпадение есть для всех слов - добавляем символ в ответ.
 * Если совпадения нет - выводим текущую результирующую строку.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs.length == 1) {
            return strs[0];
        }


        for (int i = 0; i < strs[0].length(); i++) {
            int count = 1;
            for (int j = 1; j < strs.length; j++) {
                if (i < strs[j].length() && strs[0].charAt(i) == strs[j].charAt(i)) {
                    count++;
                    if (j == strs.length - 1 && count==strs.length) {
                        result.append(strs[0].charAt(i));
                    }

                } else {
                  //  System.out.println(result);
                    return result.toString();
                }
            }
        }
        return result.toString();
    }
}
