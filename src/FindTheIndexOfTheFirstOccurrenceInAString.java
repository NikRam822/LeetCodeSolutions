/**
 * Простая задача.
 *  Если подстрока не содержится в строке - возвращаем -1
 *  Если подстрока в строке есть - выводим индекс
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    public int strStr(String haystack, String needle) {

        if (!haystack.contains(needle)) {
            return -1;
        }
        int i = haystack.indexOf(needle);

        return i;
    }
}
