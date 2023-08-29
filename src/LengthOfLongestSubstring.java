import java.util.ArrayList;
import java.util.List;

/**
 * Общая идея:
 * Идем по строке, добавляем уникальные элементы в массив резульата,
 * если встретили символ повторно - добавляем массив результатов в список всех подстрок, вычисляя длину подстроки,
 * если это самая длинная строка - сохраняем ее
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        StringBuilder string = new StringBuilder();
        List<String> result = new ArrayList<>();
        int length = 0;
        int i = 0;
        int start = 0;
        while (i < s.length()) {
            if (!string.toString().contains(String.valueOf(array[i]))) {
                string.append(array[i]);
                if (i + 1 == s.length()) {
                    if (string.toString().length() > length) {
                        length = string.length();
                    }
                    result.add(string.toString());
                    string.setLength(0);
                }
                i++;
            } else {
                if (string.toString().length() > length) {
                    length = string.length();
                }
                result.add(string.toString());
                string.setLength(0);
                start++;
                i = start;
            }
        }

        return length;
    }
}
