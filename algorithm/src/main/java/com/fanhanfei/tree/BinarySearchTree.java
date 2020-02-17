package com.fanhanfei.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangjunshuai
 * @date 2020/2/6
 * @description 二叉树查询
 **/
@Data
public class BinarySearchTree {
    private Node tree;

    /**
     * 二叉树的查找
     * @param data
     * @return
     */
    public Node find(Integer data){
        Node p = tree;
        while (p != null){
            if (data < p.data){
                p = p.left;
            }else if (data > p.data){
                p = p.right;
            }else {
                return p;
            }
        }
        return null;
    }

    /**
     * 二叉树的插入
     * @param data
     */
    public void insert(int data){
        if (tree == null){
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null){
            if (data > p.data){
                if (p.right == null){
                    Node node = new Node(data);
                    p.right = node;
                    return;
                }
                p = p.right;
            }else {
                if (p.left == null){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public static class Node{
        private Integer data;
        private Node left;
        private Node right;
        public Node(Integer data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Integer integer = new Integer(2);
        boolean equals = integer.equals(null);
        System.out.println(equals);
    }
}
