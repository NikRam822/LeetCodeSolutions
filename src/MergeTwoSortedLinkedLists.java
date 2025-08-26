import utils.ListNode;

/**
 * Код грязноватый, но и по сложности и по памяти хороший.
 *
 * Основная идея: создаем две ноды - текущая и результирующая (сслыка изначально одна). В текущей храним самый глубокий узел, который сейчас есть.
 *
 * Идем по нодам пока обе не станут null.
 * Если одна из нод - null, просто вторую не нулевую пишем в результат и выводим ответ.
 * Далее рассмотри 3 случае:
 *  1) значения нод равны (нет минимального), тогда:
 *      если это првая итерация - у текущей ноды (которая как бы 0, null) заменяем 0 на текущее значение и добавляем сслыку на следущий эелемент(такого-го же значения)
 *      затем текущая нода - самая глубокая в текущей списке. ЕСли это не 1 итерация - просто для текущего добавляем следующий и также проваливаемся максимально глубоко в текущей ноде
 *  2) list1.val минимальный - если первая итерация, то в текущей ное меняем значение, если не первая, то меняем ссылку на следующий и двигаемся по ноде
 *  3) аналогично для list2.val
 * В итоге, мы просто в текущем храним последний добавленный и к нему добавляем ссылки на последующие минмальные и все это в ссылке
 */
public class MergeTwoSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        int count = 0;
        ListNode current = new ListNode();
        ListNode result = current;
        while (list1 != null || list2 != null) {

            if (list1 == null) {
                current.next = list2;
                return result;
            }

            if (list2 == null) {
                current.next = list1;
                return result;
            }

            if (list1.val == list2.val) {
                if (count == 0) {
                    current.val = list1.val;
                    current.next = new ListNode(list1.val);
                } else {
                    current.next = new ListNode(list2.val, new ListNode(list1.val));
                }
                list1 = list1.next;
                list2 = list2.next;
                current = current.next;
                if(current.next!=null) current=current.next;
                count++;
                continue;
            }

            if (list1.val < list2.val) {
                if (count == 0) {
                    current.val = list1.val;
                } else {
                    current.next = new ListNode(list1.val);
                }
                list1 = list1.next;
                if (current.next != null) current = current.next;
            } else {
                if (count == 0) {
                    current.val = list2.val;
                } else {
                    current.next = new ListNode(list2.val);
                }
                list2 = list2.next;
                if (current.next != null) current = current.next;
            }
            count++;
        }
        return result;
    }
}
