package com.company;

public class ListNode<T> {
    T value;
    ListNode<T> next;

    public String printNodes() {
        StringBuilder sb = new StringBuilder();
        ListNode<T> node = this;
        while (node != null) {
            sb.append(node.value);
            sb.append("->");
            node = node.next;
        }

        return sb.toString();
    }

    public static <T> ListNode<T> createList(T[] elems) {
        ListNode<T> head = new ListNode<>();
        ListNode current = head;
        ListNode previous = null;
        for (int i=0; i<elems.length; i++) {
            current.value = elems[i];
            if (previous != null) {
                previous.next = current;
            }
            previous = current;
            if (i<elems.length-1) {
                current = new ListNode();
            }

        }
        return head;
    }
}
