package com.guyi.datastructures.linked;

/**
 * 演示双向链表
 *
 * @author 孤诣
 */
public class DoublyLinkedDemo {

    public static void main(String[] args) {
        DoublyLinked<Integer> doublyLinked = new DoublyLinked<>();
        doublyLinked.add(1);
        doublyLinked.add(2);

        System.out.println("获取元素 | 预期输出 1, 实际输出结果: " + doublyLinked.get(0));
        System.out.println("获取元素 | 预期输出 2, 实际输出结果: " + doublyLinked.get(1));
        System.out.println("链表大小 | 预期输出 2, 实际输出结果: " + doublyLinked.size());
        System.out.println("删除元素 | 预期输出 2, 实际输出结果: " + doublyLinked.remove(1));
        System.out.println("链表大小 | 预期输出 1, 实际输出结果: " + doublyLinked.size());
        System.out.println("获取元素 | 预期输出 1, 实际输出结果: " + doublyLinked.get(0));

        System.out.println("========以下预期抛异常========");
        System.out.println(doublyLinked.remove(1));
    }

}


/**
 * 双向链表
 *
 * @param <T> - 数据域存储的数据类型
 */
class DoublyLinked<T> {

    /**
     * 头结点
     */
    private Node<T> headNode;

    /**
     * 尾节点
     */
    private Node<T> tailNode;

    /**
     * 双向链表大小
     */
    private int size;

    /**
     * 向双向链表尾部添加元素
     *
     * @param data - 实际数据
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (headNode == null) {
            headNode = newNode;
        } else {
            tailNode.next = newNode;
            newNode.last = tailNode;
        }
        tailNode = newNode;
        size++;
    }

    /**
     * 删除链表指定索引的节点并返回节点中存储的数据
     *
     * @param index - 目标节点的索引位置
     * @return 被删除节点中存储的数据
     */
    public T remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> removeNode = headNode;
        if (headNode == tailNode) {
            headNode = null;
            tailNode = null;
        } else {
            removeNode = getNode(index);
            Node<T> last = removeNode.last;
            last.next = removeNode.next;
            Node<T> next = removeNode.next;
            if (next != null) {
                next.last = removeNode.last;
            }
        }
        size = (size == 0) ? 0 : (size - 1);
        return removeNode.data;
    }

    /**
     * 获取链表指定索引的节点中存储的数据
     *
     * @param index - 目标元素的索引位置
     * @return 数据
     */
    public T get(int index) {
        return getNode(index).data;
    }

    /**
     * 获取链表指定索引的节点
     *
     * @param index - 目标元素的索引位置
     * @return 数据
     */
    private Node<T> getNode(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> target = headNode;
        for (int i = 1; i <= index; i++) {
            target = target.next;
        }
        return target;
    }

    /**
     * 获取当前链表大小
     *
     * @return 当前链表大小
     */
    public int size() {
        return size;
    }

    /**
     * 节点
     *
     * @param <T> - 数据域存储的数据类型
     */
    private static class Node<T> {

        /**
         * 存储的数据
         */
        private T data;

        /**
         * 上一个节点
         */
        private Node<T> last;

        /**
         * 下一个节点
         */
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

    }

}
