import utils.ListNode;

/**
 * Основная идея:
 * <p>
 * Воспользовался ограничениями задачи:
 * 0 <= The length of the list <= 1000
 * <p>
 * Так как эелементов в ListNode не больше 1000, создал массив ListNode[1000] и в конец массива слкадывал листы.
 * Если очередной лист null возвращаем предыдущий добавленный массив
 */
public class ReverseLinkedList {
   /* public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode[] arr = new ListNode[1000];

        arr[999] = new ListNode(head.val);
        ListNode currentNode = head.next;
        for (int i = 1000 - 2; i > 0; i--) {
            if (currentNode == null) return arr[i + 1];
            ListNode temp = new ListNode(currentNode.val, currentNode.next);
            currentNode.next = arr[i + 1];
            arr[i] = currentNode;
            currentNode = temp.next;

        }
        return null;
    }*/

    /**
     * Решение более простое, без массива.
     * Создаем ноду результатов, кладем в нее значение головы.
     * Создаем текущую ноду (по которой будем итераироваться) и кладем в нее значение следующией от головы.
     * Пока текущая нода не null - резултат заменяем на новую ноду, где значение - значение текущей ноды, а ссылка - ссылка на результат.
     * Затем текущую ноду заменяем на следующую.
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = new ListNode(head.val);
        ListNode currentNode = head.next;

        while (currentNode != null) {
            result = new ListNode(currentNode.val, result);
            currentNode = currentNode.next;
        }
        return result;
    }
}
