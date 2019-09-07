package DataStructure;

import java.util.List;

public class Utils {

    public static Utils instance;

    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    public void TraverListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public ListNode createListNodeByList(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        for (int i = 0; i < list.size(); i++) {
            listNode.val = list.get(i);
            if (i != list.size() - 1) {
                listNode.next = new ListNode(0);
                listNode = listNode.next;
            }
        }
        return head;
    }
}
