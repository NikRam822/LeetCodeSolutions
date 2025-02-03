import utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * использовал то же решение что и в MergeTwoSortedLists
 * Формируем из листов один массив со всеми элементами
 * Переопределяем компаратор для сравнения обьектов и сортируем массив
 * Идем циклом с конца массива  и каждому  элементу массива ставим ссылку на последний элемент
 */
public class MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;
        ArrayList<ListNode> arr = new ArrayList<>();
        AtomicInteger length = new AtomicInteger();
        Arrays.stream(lists).forEach(l -> {
            ListNode a = l;
            while (a != null) {
                arr.add(a);
                a = a.next;
                length.getAndIncrement();
            }

        });
        if (arr.isEmpty()) return null;
        Comparator<ListNode> valCmp = Comparator.comparingInt(l -> l.val);
        arr.sort(valCmp);
        ListNode last = arr.get(arr.size() - 1);
        for (int i = arr.size() - 2; i > -1; i--) {
            arr.get(i).next = last;
            last = arr.get(i);
            //System.out.println(last.val);
        }

        return last;
    }
}
