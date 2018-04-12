package com.company;

public class ListToBST {

    private static ListNode<Integer> head;

    public static BinaryTreeNode createTree(int[] arr) {
        return createTree(arr, null, 0, arr.length - 1, true);
    }

    public static BinaryTreeNode createTree(ListNode<Integer> listNode) {
        head = listNode;
        int size = 0;
        ListNode current = listNode;
        while (current != null) {
            size++;
            current = current.next;
        }

        return createTree(size-1);
    }

    private static BinaryTreeNode createTree(int size) {
        if (size <= 0) {
            return null;
        }

        BinaryTreeNode left = createTree(size / 2);

        BinaryTreeNode root = new BinaryTreeNode(head.value);
        root.left = left;

        head = head.next;

        root.right = createTree(size - (size / 2) - 1);
        return root;
    }

    private static BinaryTreeNode createTree(int[] arr, BinaryTreeNode parent, int low, int high, boolean left) {
        if (low <= high) {

            int middle = (low + high) / 2;

            if (parent != null && arr[middle] == parent.value) {
                return null;
            }

            BinaryTreeNode current;
            if (parent == null) {
                parent = new BinaryTreeNode(arr[middle]);
                current = parent;
            } else {
                current = new BinaryTreeNode(arr[middle]);
                if (left) {
                    parent.left = current;
                } else {
                    parent.right = current;
                }
            }

            createTree(arr, current, low, middle, true);
            createTree(arr, current, middle + 1, high, false);

            return current;
        }

        return null;
    }

}
