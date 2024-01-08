package com.guyi.datastructures.linked;

/**
 * 演示单向链表
 *
 * @author 孤诣
 */
public class SinglyLinkedDemo {

    public static void main(String[] args) {
        SinglyLinked<Integer> singlyLinked = new SinglyLinked<>();
        singlyLinked.add(1);
        singlyLinked.add(2);

        System.out.println("获取元素 | 预期输出 2, 实际输出结果: " + singlyLinked.get(1));
        System.out.println("获取元素 | 预期输出 1, 实际输出结果: " + singlyLinked.get(0));
        System.out.println("链表大小 | 预期输出 2, 实际输出结果: " + singlyLinked.size());
        System.out.println("删除元素 | 预期输出 2, 实际输出结果: " + singlyLinked.remove(1));
        System.out.println("获取元素 | 预期输出 1, 实际输出结果: " + singlyLinked.get(0));
        System.out.println("链表大小 | 预期输出 1, 实际输出结果: " + singlyLinked.size());

        System.out.println("========以下预期抛异常========");
        System.out.println(singlyLinked.get(1));
    }

}

/**
 * 单向链表
 *
 * @param <T> - 数据域存储的数据类型
 */
class SinglyLinked<T> {

    /**
     * 头节点
     */
    private Node<T> headNode;

    /**
     * 尾节点
     */
    private Node<T> tailNode;

    /**
     * 链表大小
     */
    private int size;

    /**
     * 向单向链表的最后添加数据
     *
     * @param data - 实际数据
     */
    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (headNode == null) {
            headNode = node;
        } else {
            tailNode.next = node;
        }
        tailNode = node;
        size++;
    }

    /**
     * 删除链表指定索引的节点并返回节点中存储的数据
     *
     * @param index - 目标节点的索引位置
     * @return 被删除节点中存储的数据
     */
    public T remove(int index) {
        // 被删除节点
        Node<T> node = getNode(index);
        // 删除节点的上一个节点
        Node<T> lastNode = getNode(index - 1);
        lastNode.next = node.next;
        if (node == tailNode) {
            // 被删除节点是最后一个节点
            tailNode = lastNode;
        }
        size--;
        return node.data;
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
     * 获取当前单向链表的大小
     *
     * @return 当前单向链表的大小
     */
    public int size() {
        return size;
    }

    /**
     * 获取链表指定索引的节点
     *
     * @param index - 目标元素的索引位置
     * @return 节点
     */
    private Node<T> getNode(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> currentNode = headNode;
        for (int i = 1; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }


    /**
     * 节点
     *
     * @param <T> - 数据域存储的数据类型
     */
    private static class Node<T> {

        /**
         * 数据域
         */
        private T data;

        /**
         * 指针域 - 始终执行当前节点的下一个节点
         */
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

    }

}
