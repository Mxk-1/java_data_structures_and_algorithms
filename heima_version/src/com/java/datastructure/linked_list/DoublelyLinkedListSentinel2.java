package com.java.datastructure.linked_list;

import java.util.Iterator;

/**
 * @author MXK
 * @version 1.0
 * @description 环形链表
 * @date 2023/3/8 21:52
 */

public class DoublelyLinkedListSentinel2 implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, -1, null);

    public DoublelyLinkedListSentinel2() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**
     * @param value
     * @description 添加到第一个
     * @author MXK
     * @date 2023/3/8 22:42
     */
    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * @param value
     * @description 添加到最后一个
     * @author MXK
     * @date 2023/3/8 22:49
     */
    public void addLast(int value) {
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * @description 删除第一个
     * @author MXK
     * @date 2023/3/8 22:50
     */
    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IllegalArgumentException();
        }
        Node a = sentinel;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    /**
     * @return void
     * @description 删除最后一个
     * @author MXK
     * @date 2023/3/8 22:52
     */
    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IllegalArgumentException();
        }
        Node a = removed.prev;
        Node b = sentinel;
        a.next = b;
        b.prev = a;
    }

    public void removeByValue(int value) {
        Node removed = findByValue(value);
        if (removed == null) {
            // 不用删
            return;
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    public Node findByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}