import utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Общая идея решения:
 * Преобразуем в массив
 * Если кол-во элементов нечетное - удаляем последний элемент
 * Идем по каждому второму элементу и свапаем элементы в массиве
 * Возвращаем элемент в массив(если он был)
 * Идем с конца массива и восстанавливаем ссылки
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode removed = null;
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode a = head;
        while (a != null) {
            arr.add(a);
            a = a.next;
        }
        if (arr.size() % 2 != 0) {
            removed = arr.remove(arr.size() - 1);
        }

        arr.get(arr.size() - 2).next = null;
        for (int i = arr.size() - 1; i > 0; i = i - 2) {
            Collections.swap(arr, i - 1, i);
        }
        if(removed != null){
            removed.next=null;
            arr.add(removed);
        }

        ListNode last = arr.get(arr.size() - 1);
        for (int i = arr.size() - 2; i > -1; i--) {
            arr.get(i).next = last;
            last = arr.get(i);
//            System.out.println(last.val);
        }
        return last;

    }

}
