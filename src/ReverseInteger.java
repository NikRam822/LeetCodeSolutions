/**
 * Общая идея:
 * Число преобразуем в строку, разворчаивая строку
 * (если впереди был '-' то после разворота, отбрасываем последний символ и при преобразовании - умножаем на -1 итоговое число)
 * Если при преобразовании возникла ошибка - возращаем 0ж
 */
public class ReverseInteger {
    public int reverse(int x) {
        StringBuilder s = new StringBuilder(String.valueOf(x));
        try {


            if (s.charAt(0) == '-') {
                int c = Integer.parseInt(s.reverse().substring(0, s.length() - 1)) * -1;
                return c;
            }
            int c = Integer.parseInt(s.reverse().toString());
            return c;
        } catch (Exception e) {
            return 0;
        }
    }
}
