public class Demo01 {

    public ListNode removeElements(ListNode head, int val) {
        // 1. 链表为空的情况
        if(head == null) {
            return null;
        }
        // 2. 处理非头结点
        ListNode prev = head;
        ListNode node = head.next;
        while(node != null) {
            if(node.val == val) {
                prev.next = node.next;
                node = prev.next;
            }else {
                prev = node;
                node = node.next;
            }

        }
        // 3. 处理头结点
        if(head.val == val) {
            head = head.next;
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        // 1. 判定空链表的情况
        if (head == null) {
            return null;
        }
        // 2. 只有一个元素
        if (head.next == null) {
            return head;
        }
        ListNode newHead = null;
        // 3. 处理一般的情况
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            if (next == null) {
                // cur 已经指向最后一个节点了
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return newHead;
    }

    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int steps = size(head) / 2;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        int len = size(head);
        if(head == null || k <= 0 || k > len){
            return null;
        }
        int offset = len - k;
        ListNode cur = head;
        for (int i = 0; i < offset; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newHead = null;
        ListNode newTail = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                // 就把 cur1 指向的节点插入到新链表的尾部
                if (newHead == null) {
                    // 新链表是空链表
                    newHead = cur1;
                    newTail = cur1;
                    cur1 = cur1.next;
                } else {
                    // 新链表不是空链表
                    newTail.next = cur1;
                    // 更新尾部的指向.
                    newTail = newTail.next;
                    cur1 = cur1.next;
                }
            } else {
                // 就把 cur2 指向的节点插入到新链表的尾部
                if (newHead == null) {
                    newHead = cur2;
                    newTail = cur2;
                    cur2 = cur2.next;
                } else {
                    newTail.next = cur2;
                    newTail = newTail.next;
                    cur2 = cur2.next;
                }
            }
        }
        // 如何判定当前哪个链表到达结尾, 哪个链表还有剩余?
        if (cur1 == null) {
            // cur2 还有剩余
            newTail.next = cur2;
        } else {
            // cur1 还有剩余
            newTail.next = cur1;
        }
        return newHead;
    }


    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            // 只有一个元素
            return pHead;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        for (ListNode cur = pHead;
                cur != null; cur = cur.next) {
            if (cur.val < x) {
                // 插入到 smallTail 之后
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                // 插入到 bigTail 之后
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        // 创建一个新的链表, 用来放置不重复的元素
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;

        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null
                    && cur.val == cur.next.val) {
                // 说明 cur 指向的位置已经是重复的节点了
                // 继续往后找 cur, 找到那个不重复的节点的位置
                // 这样做是为了把若干个相同的节点都跳过去
                while (cur.next != null
                        && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // 循环结束, cur 指向的是这片重复元素的最后一个
                // 再多走一步, cur 指向的就是不重复的元素了
                cur = cur.next;
            } else {
                // 当前这个节点不是重复节点
                // 就把这个节点插入到新链表中
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        }   // end while
        return newHead.next;
    }

    public boolean chkPalindrome(ListNode A) {
        if (A == null) {
            // 此处只是假设算回文
            return true;
        }
        if (A.next == null) {
            // 只有一个元素, 就是回文
            return true;
        }
        // 1. 找中间节点
        int len = size(A);
        int steps = len / 2;
        ListNode B = A;
        for (int i = 0; i < steps; i++) {
            B = B.next;
        }
        // 经过画图演示, 发现奇数个和偶数个的情况
        // 下是可以用相同代码来表示的
        ListNode prev = null;
        ListNode cur = B;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                // 使用 B 指向新链表的头部
                B = cur;
            }
            cur.next = prev;
            // 更新 prev, 更新 cur
            prev = cur;
            cur = next;
        }
        // 3. 对比两个链表内容是否相同
        while (B != null) {
            if (A.val != B.val) {
                // 对应元素不相等, 一定不是回文
                return false;
            }
            A = A.next;
            B = B.next;
        }
        return true;
    }

    public int size(ListNode head) {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. 分别求两个链表的长度
        int lenA = size(headA);
        int lenB = size(headB);
        // 2. 让长的链表先走长度的差值步
        if (lenA > lenB) {
            int offset = lenA - lenB;
            for (int i = 0; i < offset; i++) {
                headA = headA.next;
            }
        } else {
            int offset = lenB - lenA;
            for (int i = 0; i < offset; i++) {
                headB = headB.next;
            }
        }
        // 3. 分别让两个链表的节点同时移动, 比较节点是否是相同节点
        while (headA != null && headB != null) {
            // 比较对象的身份(地址)
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
