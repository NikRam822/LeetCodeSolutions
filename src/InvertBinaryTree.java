import utils.TreeNode;

import java.util.Stack;

/**
 * НЕ МОЙ АЛГОРИТМ
 *
 * Рекусрсивно обходит дерево в глубину.
 * 1) Меняем местами у root левый и правый узел.
 * 2) ВЫзывем эту же функцию от root.left
 *  Функция работает с ссылками на root-а поэтму исходный рут меняяется.
 *  Функция вызовется, поменяет местами левый и правый узел root и вызовет эту же функцию для потомков последнего листа, сначала для левого (потом у левого еще также будет много раз вызывать) потом до правого (также)
 *  (будет до упора вызывать функцию в функции, пока все вложенные функции не сделают ретюрн)
 *
 *  Наглядный пример:
 *         1
 *       / \
 *      2   3
 *     / \
 *    4   5
 *
 *  invertTree(1)
 *  ├─ invertTree(3)
 *  │    ├─ invertTree(null) => возвращает null
 *  │    └─ invertTree(null) => возвращает null
 *  │    └─ возвращает узел 3
 *  └─ invertTree(2)
 *       ├─ invertTree(5)
 *       │   ├─ invertTree(null) => null
 *       │   └─ invertTree(null) => null
 *       │   └─ возвращает узел 5
 *       └─ invertTree(4)
 *           ├─ invertTree(null) => null
 *           └─ invertTree(null) => null
 *           └─ возвращает узел 4
 *       └─ возвращает узел 2
 * └─ возвращает узел 1 (с инвертированными детьми)
 *
 * P.S. Ретюрн, по факту по приколу, и без него работать будет, так как root один и новый не создается (ссылка одна)
 */
public class InvertBinaryTree {

  /*  public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }*/

    /**
     * Более понятный мне вариант со стеком (рекурсию сложно представить, но можно).
     * В стек добавляем вершину. Выполняем алгоритм, пока в стеке что-то есть.
     * В цикле берем верхушку стека, меняем у нее вершины местами. Далее проверяем.
     * Если правый узел не нулевой - добавляем его в стек (чтобы потом у него поменять местами узлы)
     * Если левый узел не нулевой - добаляем его в стек.
     *
     * Таким образом, мы будем добалвять все узлы (пока до конца не дойдем) и когда узлы отсануться последнми (ссылаются на null) - мы их скипнем
     *
     * P.S. Можно заметить, что мы root не меняем. Но заметим, что первый элеемнт в стеке - root.
     * Соответсвенной в массиве мы сначала у рута все поменяем (root стнает currentNode на первой итерации), а потом в стек будут пушится ссылки на узлы root и их будет обрабаотывать.
     * Поскольку сслки не меняются (это всегда ссылки root) то и сам root будет меняться. Если бы мы создавали новые обьекты - так бы не было.
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            TreeNode tmpNode = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = tmpNode;
            if(currentNode.right!=null){
                stack.push(currentNode.right);
            }

            if(currentNode.left!=null){
                stack.push(currentNode.left);
            }
        }
        return root;
    }

}
