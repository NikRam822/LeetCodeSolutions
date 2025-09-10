package dt.tasks;

/**
 * Задача: Вывести true, если при удалении из строки одного символа строка будет палиндромом, иначе вывести false
 */
public class PalindromeWithDeleteOne {

    public boolean isPalindromeWithDeleteOne(String s) {

        int left = 0;
        int right = s.length() - 1;
        int countOfDel = 0;

        while (left <= right) {
            if (countOfDel > 1) return false;

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (s.charAt(left + 1) == s.charAt(right)) {
                    left++;
                    countOfDel++;
                } else {
                    if (s.charAt(right - 1) == s.charAt(left)) {
                        right--;
                        countOfDel++;
                    }
                }
                if (countOfDel == 0) return false;
            }
        }
        if (countOfDel > 1) return false;
        return true;
    }
}
