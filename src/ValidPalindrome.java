/**
 * 1) Строку приводим к нижнему регистру и убираем все символы, кроме заглавных A-Z, строчных a-z, 0-9
 * 2) Если строка длины 1 или 0 - она и так полиндром, возвращаем тру
 * 3) Делаем два указателя сначала и с конца строки и сравниваем символы первый с поледним.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        if (s.length() <= 1) return true;

        int left = 0;
        int right = s.length() - 1;

        while (left != s.length() - 1) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
