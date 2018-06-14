package linkedlist;

/**
 * 找到链表的倒数第m个元素，假设最后一个元素为倒数第0个。算法的复杂度为n
 */
public class GetLastMParam {
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
    public static void main(String[] args) {
        int needLastM = 8;
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = null;// 没有环

        long start = System.currentTimeMillis();
        System.out.println(method1(node1, needLastM));
        long end1 = System.currentTimeMillis();
        System.out.println("method1 耗时：" + (end1 - start));
        System.out.println(method2(node1, needLastM));
        System.out.println("method2 耗时：" + (System.currentTimeMillis() - end1));
    }

    /**
     * 双指针查找。用两个指针p1、p2，开始都指向头节点。p1先移动，当p1和p2的距离为m时，两个指针一起移动，
     * 当p1移动到尾节点时，此时p2指向的节点就是要找的节点。
     *
     * @param root 链表第一个元素
     * @param needLastM 倒数第needLastM个元素
     * @return
     */
    private static Node method2(Node root, int needLastM) {
        Node nodeT = root;
        Node result = root;
        int j = 0;
        while (nodeT != null) {
            for (;j<=needLastM;j++) {
                if (nodeT == null) {
                    throw new RuntimeException("链表到尾端了，请重新输入条件");
                }
                nodeT = nodeT.next;
            }
            if (nodeT == null) {
                return result;
            }
            nodeT = nodeT.next;
            result = result.next;
        }

        return result;
    }

    /**
     * 遍历链表，得到链表的长度，再找到链表的第n-m个元素即可（如果链表的长度知道就直接找第n-m个元素）。
     * @param root
     * @param needLastM
     * @return
     */
    private static Node method1(Node root, int needLastM) {
        int length = 0;
        Node nodeT = root;
        while(nodeT != null) {
            length++;
            nodeT = nodeT.next;
        }
        System.out.println("链表长度为：" + length);

        Node result = root;
        for (int i = 0; i<length - needLastM - 1; i++) {
            result = result.next;
        }
        return result;
    }

}
