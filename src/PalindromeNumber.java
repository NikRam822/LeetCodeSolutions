/**
 * Общая идея:
 * Идем по числу с двух сторон, если очередной символ не совпал с противоположным - возвращаем false
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        char[] array = String.valueOf(x).toCharArray();
        int len = array.length;
        for (int i = 0; i < len / 2; i++) {
            if (array[i] != array[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
