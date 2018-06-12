package hoop;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 判断链表是否有环？
 *
 * 使用两个指针，从头开始，一个一次前进一个节点，一个前进2个节点，则最多2N，后两个指针可以重合；如果无环，则正常停止。
 */
public class JudgeLinkedListIsHaveHoop {
    public static class Node {
        Node next;
    }
    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        Node node9 = new Node();

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node5;// 环节点为05
//        node9.next = null;// 没有环

        System.out.println(judgeIsHaveHoop(node1));
    }

    private static boolean judgeIsHaveHoop(Node root) {
        Node temp_1 = root;
        Node temp_2 = root;
        while (temp_1 != null && temp_2 != null && temp_2.next != null) {
            temp_1 = temp_1.next;
            temp_2 = temp_2.next.next;

            if (temp_1 == temp_2) {
                System.out.println("Have a Hoop, 有环!");
                return true;
            }
        }
        System.out.println("Have't a Hoop, 没有环!");
        return false;
    }
}
