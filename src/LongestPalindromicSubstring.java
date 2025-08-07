/**
 * Решение плохое, еле еле прошло последний тест
 * Общая идея:
 * Идем по строке, если нашли палиндром более длинный палиндром чем есть - кладем его в переменную и продолжаем идти до конца строки
 * Если строка закончилась - смещаем элемент и снова делаем итерации, до тех пор, пока не сместимся до последнего символа
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.equals(new StringBuilder(s).reverse().toString())) {
            return s;
        }
        int start = 0;
        String result = "";
        while (start <= s.length() - 1) {
            StringBuilder currentString = new StringBuilder();
            for (int i = start; i < s.length(); i++) {

                currentString.append(s.charAt(i));

                if (isPalindrome(currentString.toString()) && currentString.toString().length() > result.length()) {
                    result = currentString.toString();
                }
            }
            start++;
        }
        return result;
    }

    public boolean isPalindrome(String x) {
        for (int i = 0; i < x.length() / 2; i++) {
            if (x.charAt(i) != x.charAt(x.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Не мое решение, но крутое.
     * Основная идея:
     * Идем по символам строки, для каждого сивола проверям палиндром это, или нет
     * Проверка палиндрома вызыается 2 раза (для символа, чтобы проверить на четный палиндром и для символа, чтобы проверить нечетный палиндром) и работает так:
     * Для каждого символа, сравниваем его левого и правого соседа, если равны - продолжаем идти по соседям циклом, если не равны - возвращаем длинну (из координат правого соседа вычитаем координаты левого соседа)- она и будет длинной палиндромом
     * <p>
     * таким образом мы получим две длины: самый длинный четный и самый длинный нечетный палиндром
     * затем из двух длинн выбираем наибольшую - это будет длинна самого длинного палиндрома
     * <p>
     * Затем вычисляем координаты начала и конца самого длинного палиндрома:
     * Для координат начала мы просто из текущего элемента вычитам длину палиндрома (т.к. текущий эелемент - это середина палиндрома), а для конца - прибавляем длину палиндрома
     * <p>
     * В ответе возвращаем подстроку из изначальной строки по координатам
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);

    }

    private int expandFromMiddle(String s, int left, int right) {
        if (left > right) return 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            char a = s.charAt(left);
            char b = s.charAt(right);
            left--;
            right++;
        }
        return right - left - 1;
    }
}