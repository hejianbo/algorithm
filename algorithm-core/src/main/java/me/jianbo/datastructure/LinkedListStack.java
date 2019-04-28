package me.jianbo.datastructure;

public class LinkedListStack<T> implements Stack<T>{
    private int size;
    private LinkedList<T> datas;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T pop() {
        if (this.isEmpty()) {
            return null;
        }
        return this.datas.removeLast();
    }

    public boolean push(T data) {
        this.datas.add(data);
        return true;
    }

    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.datas.findLast();
    }
}
