import java.util.HashSet;
import java.util.Set;

/**
 * Используется слайдинговое окно. Но сложность O(n*m) - близко к квадратичной. Можно сделать быстрее, если не менять i, а использовать два указателя.
 *
 * Основная идея:
 * Идем по строке, добавляем очередной символ в HashSet. ЕСли символ добавлися - мы добавляем его в текущую строку.
 * Если при очередном добавлении символа в сет, символ не добавился, мы длинну текущей строки пишем в рез (если длина текущей строки больше рез),
 * затем очищаем сет и текущую строку, а также двигаем окно на 1 (для этого используем переменную count. Заранее count 0, так как при попадании в цикл, for увеличиться на 1)
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) return s.length();
        int res = 0;
        int count = 0;
        StringBuilder currentString = new StringBuilder();
        Set<Character> currentSet = new HashSet<>();


        for (int i = 0; i < s.length(); i++) {
            boolean isAdded = currentSet.add(s.charAt(i));
            if (!isAdded) {
                if ( currentString.length() > res) {
                    res = currentString.length();
                }
                currentSet.clear();
                currentString.setLength(0);
                i = count;
                count++;

                continue;
            }
            currentString.append(s.charAt(i));
        }
        if ( currentString.length() > res) {
            res = currentString.length();
        }
        return res;
    }
}
