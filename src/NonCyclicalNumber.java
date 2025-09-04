import java.util.HashSet;

/**
 *  Идем по числу, вложенным фором. В форе счиатем сумму квадратов цифр числа. Посчитанную сумму проевряем в вайле (если сумма ==1 ->true, иначе запускаем фор от суммы)
 *  также сумму складываем в сет и в вайле проверяем, что если сумма в сете есть -  выходим из вайла и возвраам фолс
 */

public class NonCyclicalNumber {

    public boolean isHappy(int n) {
        boolean isAdded = true;
        HashSet<Integer> set = new HashSet<>();
        String s = String.valueOf(n);
        int sumSquare = 0;

        while (isAdded) {
//            System.out.println(sumSquare);
            if (sumSquare == 1) return true;
            if (sumSquare != 0) {
                isAdded = set.add(sumSquare);
                s = String.valueOf(sumSquare);
                sumSquare = 0;
            }

            for (char c : s.toCharArray()) {
                int i = c - '0';
                sumSquare+=i*i;
            }

        }

        return 1 == sumSquare;
    }
}
