package add.two.numbers;

import java.math.BigInteger;

/**
 * Общая идея:
 * Переводим оба remove.nth.node.from.end.of.list.ListNode в числа BigInteger, складываем их и суммарное число конвертируем обратно в remove.nth.node.from.end.of.list.ListNode
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return convertNumberToList(convertListToNumber(l1).add(convertListToNumber(l2)));
    }

    private BigInteger convertListToNumber(ListNode list) {
        StringBuilder sNumber = new StringBuilder();
        while (list != null) {
            sNumber.append(list.val);
            list = list.next;
        }
        return new BigInteger(sNumber.reverse().toString());
    }

    private ListNode convertNumberToList(BigInteger number) {
        ListNode list = new ListNode();
        ListNode firstList = list;
        char[] array = new StringBuilder().append(number).reverse().toString().toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                list.val = array[i] - '0';
                break;
            }
            list.val = array[i] - '0';
            list.next = new ListNode();
            list = list.next;

        }
        System.out.println(list);
        return firstList;
    }
}
