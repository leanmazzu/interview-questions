package com.company;

import java.util.ArrayList;

public class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode insertLeft(int leftValue) {
        this.left = new BinaryTreeNode(leftValue);
        return this.left;
    }

    public BinaryTreeNode insertRight(int rightValue) {
        this.right = new BinaryTreeNode(rightValue);
        return this.right;
    }

    public BinaryTreeNode insertLeft(BinaryTreeNode binaryTreeNode) {
        this.left = binaryTreeNode;
        return this.left;
    }

    public BinaryTreeNode insertRight(BinaryTreeNode binaryTreeNode) {
        this.right = binaryTreeNode;
        return this.right;
    }

    public BinaryTreeNode findLCA(BinaryTreeNode root, int value1, int value2) {
        if (root==null) {
            return null;
        }

        if (root.value == value1 || root.value == value2) {
            return root;
        }

        BinaryTreeNode leftLCA = findLCA(root.left, value1, value2);
        BinaryTreeNode rightLCA = findLCA(root.right, value1, value2);

        if (leftLCA!=null && rightLCA!=null) {
            return root;
        }

        if (leftLCA!=null) {
            return leftLCA;
        }

        if (rightLCA!=null) {
            return rightLCA;
        }

        return null;
    }

    public boolean isBST() {
        ArrayList<BinaryTreeNode> orderedNodeList = new ArrayList<>();
        inOrderTraversal(this, orderedNodeList);
        if (orderedNodeList.size()<2) {
            return true;
        }
        int previous = orderedNodeList.get(0).value;
        for (int i=1; i<orderedNodeList.size(); i++) {
            BinaryTreeNode current = orderedNodeList.get(i);
            if (current.value<previous) {
                return false;
            }
            previous = current.value;
        }

        return true;
    }

    private void inOrderTraversal(BinaryTreeNode node, ArrayList<BinaryTreeNode> items) {
        if (node==null) {
            return;
        }
        inOrderTraversal(node.left,items);
        items.add(node);
        inOrderTraversal(node.right,items);
    }

    public static BinaryTreeNode createValidBST() {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(10);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(20);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(6);

        root.insertLeft(binaryTreeNode1);
        root.insertRight(binaryTreeNode3);

        binaryTreeNode1.insertLeft(binaryTreeNode5);
        binaryTreeNode1.insertRight(binaryTreeNode6);

        binaryTreeNode3.insertRight(binaryTreeNode4);

        return root;
    }
}