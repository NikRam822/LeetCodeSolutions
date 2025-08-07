import java.util.HashMap;

/**
 * Общая идея:
 * Складываем все числа подряд, кроме 1, 10 и 100
 * Если одни из этих чисел встреились - проверяем следующее число,
 * если оно больше, чем текущее - из следующего вычитаем текущее и пропускаем следующий символ, приступая к следующей итерации
 */
public class RomanToInteger {
    HashMap<Character, Integer> dict = new HashMap<>();

    public void initDict() {
        this.dict.put('I', 1);
        this.dict.put('V', 5);
        this.dict.put('X', 10);
        this.dict.put('L', 50);
        this.dict.put('C', 100);
        this.dict.put('D', 500);
        this.dict.put('M', 1000);
    }

    public int romanToInt(String s) {
        initDict();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I' || s.charAt(i) == 'X' || s.charAt(i) == 'C') {
                if (i + 1 < s.length() && dict.get(s.charAt(i + 1)) > dict.get(s.charAt(i))) {
                    result += dict.get(s.charAt(i + 1)) - dict.get(s.charAt(i));
                    i++;
                    continue;
                }

            }
            result += dict.get(s.charAt(i));
        }
        return result;
    }
}
