import utils.ListNode;

import java.util.HashSet;

/**
 * Простая задачка
 *
 * Создаем сет, если очередной элемент не добавился - значит цикл есть, выводим true. Если где-то встретили null - выводим false
 */
public class Prerequisites {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet();
        boolean res = set.add(head);
        while(res){
            if(head.next==null) return false;
            head = head.next;
            res = set.add(head);
            if(!res) return !res;
        }
        return false;
    }
}
