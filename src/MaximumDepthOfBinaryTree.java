import utils.TreeNode;

import java.util.AbstractMap;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {

    /**
     * Подсмотрел в решениях.
     *
     * Основная идея:
     * Обходим в глубину с помощью стека. В стеке храним структуру SimpleEntry (это по сути 1 элеемнт из hashMap ), где ключ - очередной узел, значение - его глубина.
     *
     * Изначально в стек кладем корень с глубиной 1.
     * Затем, в цикле, достаем эалемнт из стека.
     * Если очечредной узел из стека не null - мы сравниваем наш res (переменная для того, чтобы зафиксировать максимальную глубину. Изначально 0) с глубиной текущего элеемнта
     * и максимальных из них кладем в res. Таким образом, для первой итерации, рез будет 1 (так как глубина root всегда 1). Затем, будет меняться при увелечении глубины.
     * После сравнения res с глубиной, мы пушим в стек левый и правый эелемент, увеличив глубину на 1.
     *
     * P.S. Идея хранить глубину - для каждого узла не сложная, но структура данных прикольная.
     * Надо запомнить SimpleEntry - прикольная тема для хранения пар, лучше, чем массив.
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {

        Stack<AbstractMap.SimpleEntry<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root, 1));
        int res = 0;
        while (!stack.isEmpty()) {
            AbstractMap.SimpleEntry<TreeNode, Integer> entry = stack.pop();
            TreeNode currentNode = entry.getKey();
            int deep = entry.getValue();

            if (currentNode != null) {
                res = Math.max(res, deep);
                stack.push(new AbstractMap.SimpleEntry<>(currentNode.left, deep + 1));
                stack.push(new AbstractMap.SimpleEntry<>(currentNode.right, deep + 1));

            }

        }
        return res;
    }

    /**
     * НЕ МОЕ НО ОЧЕНЬ КРСИВОЕ РЕШЕНИЕ РЕКУРСИЕЙ.
     *
     * Идем в глубину по дереву, возвращаем глубину самого глубокого потомка +1 (текущий уроень).
     * Так, для последних узлов, будет 0. Для предпоследних 1(так как к последним прибавили 1 - получилось 1). Для предпредпоследних уже 2 и так увеличивается на 1 вплоть до корня.
     */
  /*  public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int maxChildDepth = Math.max(leftDepth, rightDepth);
        int result = 1 + maxChildDepth;

        return result;
    }*/

}
