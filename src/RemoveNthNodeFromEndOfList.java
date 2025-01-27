import utils.ListNode;

import java.util.*;

/**
 * Общая идея решения:
 * Циклом проходимя по всем элементам списка и каждый элемент добавляем в массив
 * Из массива удаляем заданный элемент n
 * Проходимся по массива с конца и каждому элементу заменям ссылку на элемент из предыдущей итерации
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> arr = new ArrayList<>();
        int length = 0;
        ListNode a = head;
        while (a != null) {
            arr.add(a);
            a = a.next;
            length++;
        }
        if (arr.size() == 1 && n == 1) {
            return null;
        }

        if (n != length) {
            arr.set(length - n - 1, new ListNode(arr.get(length - n - 1).val, arr.get(length - n).next));
        }
        arr.remove(length - n);

        ListNode last = arr.get(arr.size() - 1);
        for (int i = arr.size() - 2; i > -1; i--) {
            arr.get(i).next = last;
            last = arr.get(i);
            System.out.println(last.val);
        }

        return last;
    }

}
