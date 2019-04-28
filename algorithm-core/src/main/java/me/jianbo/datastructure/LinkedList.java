package me.jianbo.datastructure;

import java.util.Iterator;

/**
 * 链表
 */
public class LinkedList<T> implements Iterable<T>{
    private long size = 0;
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
    }

    /**
     * 向链表中加添元素 data
     * @param data
     * @return 返回该链表, 用于链式操作
     */
    public LinkedList<T> add(T data) {
        // 如果当前是空链表
        if (this.head == null) {
            Node<T> node = new Node(data);
            this.head = node;
            this.tail = node;
        } else {
            // 非空时, 则直接添加到链表尾部, 然后再将tail指针指向到新加入的结点
            Node<T> node = new Node(data, this.tail);
            this.tail = node;
        }
        this.size++;
        return this;
    }

    public LinkedList<T> remove(T data) {
        // 如果为空链表, 则直接返回
        if (this.head == null) {
            return this;
        }
        Node<T> current = this.findNode(data);
        if (current == null) {
            return this;
        }
        Node<T> prev = current.prev;
        if (prev != null) {
            // 用当前结点的父结点指向当前结点的下一个节点
            prev.next = current.next;
            current.next.prev = prev;
            // 清除当前结点的引用, 便于垃圾回收
            current.next = null;
            current.prev = null;
        } else {
            this.head = current.next;
            current.next.prev = null;
            current.next = null;
        }
        return this;
    }

    /**
     * 清空链表
     * @return
     */
    public LinkedList<T> clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        return this;
    }

    public T removeLast() {
        if (this.tail != null) {
            Node<T> last = this.tail;
            Node<T> prev = last.prev;
            if (prev != null) {
                prev.next = null;
                last.prev = null;
                this.tail = prev;
            } else {
                this.head = null;
                this.tail = null;
            }
            return last.data;
        }
        return null;
    }

    public T findLast() {
        return this.tail != null ? this.tail.data : null;
    }

    public T findFirst() {
        return this.head != null ? this.head.data : null;
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    public Iterator<T> iterator() {
        return null;
    }

    private class Node<T> {
        private T data;
        private Node next;
        private Node prev;
        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node<T> prev) {
            this.prev = prev;
            this.data = data;
            this.next = null;
        }
    }

    /**
     * 根据 data 查找结点, 找到则返回 Node; 否则返回 null
     * @param data
     * @return
     */
    private Node<T> findNode(T data) {
        if (this.head == null) {
            return null;
        }
        for (Node<T> current = this.head; current != null; current = current.next) {
            if (current.data.equals(data)) {
                return current;
            }
        }
        return null;
    }
}
