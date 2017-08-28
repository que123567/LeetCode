public class LeetCode234
{
    static class ListNode
    {
        public ListNode(int value) {
            this.val = value;
        }

        int val;
        ListNode next;
    }

    static ListNode reverseList(ListNode listNodeHead) {
        ListNode pRevertHead = null;
        ListNode pNode = listNodeHead;
        ListNode pPrev = null;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            if (pNext == null) {
                pRevertHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pRevertHead;
    }

    static boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(3);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(4);


        ListNode c = new ListNode(1);
        c.next = new ListNode(3);
        c.next.next = new ListNode(2);
        c.next.next.next = new ListNode(1);

        reverseList(a);
        if (isEqual(a, c))
            System.out.println("true");
    }

}
