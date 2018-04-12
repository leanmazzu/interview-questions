package com.company;

import java.util.List;

public class ReverseLinkedList<T> {

    public ListNode<T> reverseList(ListNode<T> listNode) {
        ListNode previous = null;
        while (listNode != null) {
            ListNode<T> temp = listNode.next;
            listNode.next = previous;
            previous = listNode;
            listNode = temp;
        }
        return previous;
    }

    public ListNode<T> reverseListRecursive(ListNode<T> listNode) {
        ListNode<T> first = listNode;
        ListNode<T> last = first;
        while (last.next!=null) {
            last = last.next;
        }
        reverseListRecursiveInternal(listNode);
        first.next = null;
        return last;
    }

    private ListNode<T> reverseListRecursiveInternal(ListNode<T> listNode) {
        if (listNode == null) {
            return null;
        }

        ListNode nextReverse = reverseListRecursiveInternal(listNode.next);

        if (nextReverse!=null) {
            nextReverse.next = listNode;
        }

        return listNode;
    }

}
