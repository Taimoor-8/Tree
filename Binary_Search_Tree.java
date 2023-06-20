package com.Tree;

public class Binary_Search_Tree {

    private TreeNode root;
    private static class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        TreeNode(int data){
            this.data = data;
        }
    }

    public void insert(int value){
        root = insert(root , value);
    }

    public TreeNode insert(TreeNode root , int value){
        if (root == null){
            root = new TreeNode(value);
            return root;
        }
        if (root.data > value){
            root.left = insert(root.left , value);
        }
        else{
            root.right = insert(root.right , value);
        }
        return root;
    }

    static TreeNode val;
    public void search(int key){
        root = search(root , key);
    }
    public TreeNode search(TreeNode root , int key){
        if (root == null || root.data == key){
            val = root;
            return val;
        }
        if (root.data > key){
            val = search(root.left , key);
            return val;
        }
        else {
            val = search(root.right , key);
            return val;
        }
    }

    public boolean isValid(TreeNode root , long min , long max){
        if (root == null){
            return true;
        }
        if (root.data <= min || root.data >= max){
            return false;
        }
        boolean left = isValid(root.left , min , root.data);
        if (left){
            boolean right = isValid(root.right , root.data , max);
            return right;
        }
        return false;
    }

    public void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {

        Binary_Search_Tree bst = new Binary_Search_Tree();
        bst.insert(4);
        bst.insert(2);
        bst.insert(3);
        bst.insert(6);
        bst.insert(8);

        bst.inOrder(bst.root);

        /*System.out.println();

        bst.search(2);
        if (val == null) {
            System.out.println("Key not found");
        }
        else{
            System.out.println("Key is found");
        }*/

        System.out.println();
        if (bst.isValid(bst.root , Integer.MIN_VALUE , Integer.MAX_VALUE)){
            System.out.println("The given binary search tree is valid");
        }
        else{
            System.out.println("The given binary search tree is not valid");
        }
    }
}
