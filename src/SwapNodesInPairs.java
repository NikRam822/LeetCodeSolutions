import utils.ListNode;

import java.util.ArrayList;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ArrayList<ListNode> arr = new ArrayList<>();
        int length = 0;
        ListNode a = head;
        while (a != null) {
            arr.add(a);
            a = a.next;
            length++;
        }


        for (int i = arr.size() - 1; i > 0; i--) {

//TODO: Реалезовать логику решения тут
            System.out.println(arr.get(i).val);
        }

        return null;

    }

}
