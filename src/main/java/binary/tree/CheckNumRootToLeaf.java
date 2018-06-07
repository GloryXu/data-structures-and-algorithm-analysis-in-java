package binary.tree;

/**
 * 判断一个数是否是    一个二叉树从根节点到叶子节点所过的所有节点的value     之和
 *
 *                                  ①
 *                             /          \
 *                      ②                      ③
 *                   /      \                 /       \
 *               ④           ⑤         ⑥               ⑦
 *             /
 *           ⑧
 */
public class CheckNumRootToLeaf {
    public static void main(String[] args) {
        Node node8 = new Node(8, null ,null);
        Node node4 = new Node(4, node8 ,null);
        Node node5 = new Node(5, null ,null);
        Node node6 = new Node(6, null ,null);
        Node node7 = new Node(7, null ,null);

        // node 2 and node 3
        Node node2 = new Node(2, node4, node5);
        Node node3 = new Node(3, node6, node7);

        // root node
        Node root = new Node(1, node2, node3);


        System.out.println(checkNum(root, 15));
    }

    private static boolean checkNum(Node root, int num) {
        if (num == root.value && root.left == null && root.right == null) {
            return true;
        } else {
            if(num < 0)
                return false;
            boolean resultLeft = false;
            if (root.left != null) {
                resultLeft = checkNum(root.left, num - root.value);
            }
            if (resultLeft) {
                return resultLeft;
            }

            boolean resultRight = false;
            if (root.right != null) {
                resultRight = checkNum(root.right, num - root.value);
            }
            if (resultRight) {
                return resultRight;
            }
        }
        return false;
    }
}
