import utils.TreeNode;

/**
 * Не мой алгоритм, нужно разоабраться
 *
 * TODO: Разобраться с алгосом, сделть похоже
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        System.out.println(root.val);
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
