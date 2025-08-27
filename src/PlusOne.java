/**
 * Простая задача.
 * Основная идея:
 *
 * Идем с конца массива к началу, если очередной элемент 9 - мы его заменяем на 0, если очередной элемент не 9, мы увеличиваем его на 1 и выводим массив.
 * После цикла, если из цикла выхода не было (то есть все девятки, которые в цикле замениои на нули), мы возвращаем новый массив,
 * который по размеру digits.length+1 и первй элемент равен 1.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }
        int[] res = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        res[0] = 1;
        return res;
    }
}
