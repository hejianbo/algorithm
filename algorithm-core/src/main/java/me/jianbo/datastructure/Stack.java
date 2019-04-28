package me.jianbo.datastructure;

public interface Stack<T> {
    /**
     * 栈大小
     * @return
     */
    int size();

    /**
     * 栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 出栈
     * @return
     */
    T pop();

    /**
     * 入栈
     * @return
     */
    boolean push(T data);

    /**
     * 查看栈顶元素
     * @return
     */
    T peek();
}
