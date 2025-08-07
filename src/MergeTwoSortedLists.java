import utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Общая идея решения:
 * Формируем из двух листов один массив со всеми элементами
 * Переопределяем компаратор для сравнения обьектов и сортируем массив
 * Идем циклом с конца массива  и каждому  элементу массива ставим ссылку на последний элемент
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }
        ArrayList<ListNode> arr = new ArrayList<>();
        AtomicInteger length = new AtomicInteger();
        ListNode[] n = new ListNode[]{list1, list2};
        Arrays.stream(n).forEach(l -> {
            ListNode a = l;
            while (a != null) {
                arr.add(a);
                a = a.next;
                length.getAndIncrement();
            }

        });

        Comparator<ListNode> valCmp = Comparator.comparingInt(l -> l.val);
        arr.sort(valCmp);
        ListNode last = arr.get(arr.size() - 1);
        for (int i = arr.size() - 2; i > -1; i--) {
            arr.get(i).next = last;
            last = arr.get(i);
            System.out.println(last.val);
        }

        return last;
    }
}
