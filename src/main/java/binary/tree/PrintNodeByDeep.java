package binary.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 按深度打印二叉树节点数据
 *                                 ①
 *                             /          \
 *                      ②                      ③
 *                   /      \                 /       \
 *               ④           ⑤         ⑥               ⑦
 *             /    \      /     \       / \             /   \
 *          ⑩       11   99    102   150  200         555   999
 *   以上二叉树，最终打印顺序为1,2,3,4,5,6,7
 *
 */
public class PrintNodeByDeep {
    public static void main(String[] args) {
        // leaf node
//        Node node4 = new Node(4, new Node(10, null, null), new Node(11, null ,null));
//        Node node5 = new Node(5, new Node(99, null, null), new Node(102, null ,null));
//        Node node6 = new Node(6, new Node(150, null, null), new Node(200, null ,null));
//        Node node7 = new Node(7, new Node(555, null, null), new Node(999, null ,null));
        Node node4 = new Node(4, null ,null);
        Node node5 = new Node(5, null ,null);
        Node node6 = new Node(6, null ,null);
        Node node7 = new Node(7, null ,null);

        // node 2 and node 3
        Node node2 = new Node(2, node4, node5);
        Node node3 = new Node(3, node6, node7);

        // root node
        Node root = new Node(1, node2, node3);
        List<Node> list = new ArrayList<>();
        list.add(root);
        printNode(list);
    }

    private static void printNode(List<Node> nodes) {
        List<Node> listT = new ArrayList<>();
        for (Node node : nodes) {
//            if(node == null) {
//                continue;
//            }
            System.out.print(node.value + ",");
            if (node.left != null) {
                listT.add(node.left);
            }
            if (node.right != null) {
                listT.add(node.right);
            }
        }
        if(!listT.isEmpty()) {
            printNode(listT);
        }
    }
}
