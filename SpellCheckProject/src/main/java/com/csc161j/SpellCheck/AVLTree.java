package com.csc161j.SpellCheck;

public class AVLTree {

    private class Node {
        String key;
        Node left;
        Node right;
        int height;

        Node(String key) {
            this.key = key;
            this.height = 1;
        }
    }

    private Node root;

    // INSERT
    public void insert(String key) {

        if (key == null || key.equals("")) {
            return;
        }

        root = insert(root, key);
    }

    private Node insert(Node node, String key) {

        if (node == null) {
            return new Node(key);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key);
        }
        else if (key.compareTo(node.key) > 0) {
            node.right = insert(node.right, key);
        }
        else {
            return node;
        }

        updateHeight(node);

        return balance(node);
    }

    // SEARCH
    public boolean search(String key) {
        return search(root, key);
    }

    private boolean search(Node node, String key) {

        if (node == null) {
            return false;
        }

        if (key.compareTo(node.key) == 0) {
            return true;
        }
        else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        }
        else {
            return search(node.right, key);
        }
    }

    // HEIGHT
    public int height() {
        return height(root);
    }

    private int height(Node node) {

        if (node == null) {
            return 0;
        }

        return node.height;
    }

    private void updateHeight(Node node) {

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (leftHeight > rightHeight) {
            node.height = leftHeight + 1;
        } else {
            node.height = rightHeight + 1;
        }
    }

    // BALANCE FACTOR (STANDARD VERSION)
    private int getBalance(Node node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return leftHeight - rightHeight;
    }

    // ROTATE LEFT
    private Node rotateLeft(Node x) {

        Node y = x.right;
        Node temp = y.left;

        y.left = x;
        x.right = temp;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    // ROTATE RIGHT
    private Node rotateRight(Node y) {

        Node x = y.left;
        Node temp = x.right;

        x.right = y;
        y.left = temp;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // BALANCE
    private Node balance(Node node) {

        int balance = getBalance(node);

        // Left heavy
        if (balance > 1) {

            if (getBalance(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }

            return rotateRight(node);
        }

        // Right heavy
        if (balance < -1) {

            if (getBalance(node.right) > 0) {
                node.right = rotateRight(node.right);
            }

            return rotateLeft(node);
        }

        return node;
    }
}