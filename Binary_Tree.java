package com.Tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Binary_Tree {

    public TreeNode root;

    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;

        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void createTree(){
            TreeNode first = new TreeNode(1);
            TreeNode second = new TreeNode(2);
            TreeNode third = new TreeNode(3);
            TreeNode fourth = new TreeNode(4);
            TreeNode fifth = new TreeNode(5);

            root = first; //root is generated
            root.left = second;
            root.right = third; // second <-- root --> third

            second.left = fourth;
            second.right = fifth; // fourth <-- second --> fifth
    }

    public void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

//    Pre Order iterative traversal of tree
    /*public void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        Stack <TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp = s.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null){
                s.push(temp.right);
            }
            if (temp.left != null){
                s.push(temp.left);
            }
        }
    }*/

    //    In Order Recursive traversal of tree
    /*public void InOrder(TreeNode root){
        if (root == null){
            return;
        }
        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }*/

    public void InOrder(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = root;
        while(!s.isEmpty() || temp != null){
            if (temp != null){
                s.push(temp);
                temp = temp.left;
            }
            else{
                temp = s.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

//    Post Order Recursive traversal of tree
    /*public void PostOrder(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode temp = root;
        PostOrder(temp.left);
        PostOrder(temp.right);
        System.out.print(temp.data + " ");
    }*/

    public void levelOrder(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null){
                q.offer(temp.left);
            }
            if (temp.right != null){
                q.offer(temp.right);
            }
        }
    }

    public void PostOrder(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;
        while(!s.isEmpty() || current != null){
            if (current != null){
                s.push(current);
                current = current.left;
            }
            else{
                TreeNode temp = s.peek().right;
                if (temp == null){
                    temp = s.pop();
                    System.out.print(temp.data + " ");
                    while (!s.isEmpty() && temp == s.peek().right){
                        temp = s.pop();
                        System.out.print(temp.data + " ");
                    }
                }
                else {
                    current = temp;
                }
            }
        }
    }

    public int MaxValue(TreeNode root){
        if (root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = MaxValue(root.left);
        int right = MaxValue(root.right);
        if (left > result){
            result = left;
        }
        if (right > result){
            result = right;
        }
        return result;
    }

    public static void main(String[] args) {

        Binary_Tree bt = new Binary_Tree();
        bt.createTree();
        bt.preOrder(bt.root);

        System.out.println();

        bt.InOrder(bt.root);

        System.out.println();

        bt.PostOrder(bt.root);

        System.out.println();

        bt.levelOrder(bt.root);

        System.out.println("\nThe maximum value in the treeNode is\n" +
                bt.MaxValue(bt.root));
    }
}