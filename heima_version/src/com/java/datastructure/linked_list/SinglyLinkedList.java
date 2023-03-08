package com.java.datastructure.linked_list;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author MXK
 * @version 1.0
 * @description 单向链表
 * @date 2023/3/8 16:57
 */

public class SinglyLinkedList implements Iterable<Integer> {
    private Node head = null; // 头指针


    /***
     * @description 迭代器实现
     *
     * @return java.util.Iterator<java.lang.Integer>
     * @author MXK
     * @date 2023/3/8 17:24
     */
    @Override
    public Iterator<Integer> iterator() {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<Integer> {
        Node p = head;

        @Override
        public boolean hasNext() { // 询问是否有下一个元素
            return p != null;
        }

        @Override
        public Integer next() { // 返回当前值，并指向下一个元素
            int v = p.value;
            p = p.next;
            return v;
        }
    }

    /**
     * 节点类
     * 内部类
     * 对外隐藏信息
     */
    private static class Node {
        int value; // 值
        Node next; // 下一个节点指针


        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /***
     * @description 向链表头添加
     * @param value - 待添加值
     * @author MXK
     * @date 2023/3/8 17:08
     */
    public void addFirst(int value) {
        // 1. 链表为空的情况
        // head = new Node(value, null);
        // 2. 链表非空的情况
        head = new Node(value, head);
    }

    /***
     * @description 遍历while循环
     * @author MXK
     * @date 2023/3/8 17:18
     */
    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            // 指针指向当前节点的下一节点
            consumer.accept(p.value);
            p = p.next;
        }
    }

    /***
     * @description 遍历for循环
     * @author MXK
     * @date 2023/3/8 17:18
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    /***
     * @description 查找最后一个节点
     *
     * @return com.java.datastructure.linked_list.SinglyLinkedList.Node
     * @author MXK
     * @date 2023/3/8 17:38
     */
    private Node findLast() {
        if (head == null) { // 空链表
            return null;
        }
        Node p;
        for (p = head; p.next != null; p = p.next) {
        }
        return p;
    }

    /**
     * @return void
     * @description 向最后一个节点添加元素
     * @author MXK
     * @date 2023/3/8 17:44
     */
    public void addLast(int value) {
        Node last = findLast();

        if (last == null) {
            addFirst(value);
            return;
        }

        last.next = new Node(value, null); // 新节点next为null
    }

/*     public void test() {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            System.out.println(p.value + " 索引是： " + i);
        }
    } */

    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        // 没找到
        return null;
    }

    /**
     * @param index 索引
     * @return int
     * @description 根据索引查找
     * @author MXK
     * @date 2023/3/8 20:43
     */
    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw illegalArgumentException(index);
        }
        return node.value;
    }

    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        // 上一个节点
        Node prev = findNode(index - 1);
        // 找不到
        if (prev == null) {
            throw illegalArgumentException(index);
        }
        prev.next = new Node(value, prev.next);
    }

    /***
     * @description 异常
     * @param index
     * @return java.lang.IllegalArgumentException
     * @author MXK
     * @date 2023/3/8 20:55
     */
    private IllegalArgumentException illegalArgumentException(int index) {
        return new IllegalArgumentException(String.format("index[%d] 不合法%n", index));
    }

    /**
     * @description 删除第一个
     * @author MXK
     * @date 2023/3/8 20:59
     */
    public void removeFirst() {
        if (head == null) {
            throw illegalArgumentException(0);
        }
        head = head.next;
    }

    /**
     * @param index
     * @description 删除指定index
     * @author MXK
     * @date 2023/3/8 21:05
     */
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
        } else {
            // 上一个节点
            Node prev = findNode(index);
            if (prev == null) {
                throw illegalArgumentException(index);
            }
            // 被删除的节点
            Node removed = prev.next;
            if (removed == null) {
                throw illegalArgumentException(index);
            }
            // 上一个节点指向被删除的节点的下一个节点
            prev.next = removed.next;
        }
    }

    /**
     * @param curr 当前要处理的节点
     * @description 递归遍历
     * 针对某个节点进行的操作
     * @author MXK
     * @date 2023/3/8 23:02
     */
    public void recursion(Node curr) {
        if (curr == null) {
            return;
        }
        System.out.println(curr.value);
        // 递归
        recursion(curr.next);
    }

    public void loop3() {
        recursion(head);
    }
}


    