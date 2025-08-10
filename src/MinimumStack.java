import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Все  методы взяты из стека, кроме getMin(). По сути, реалезовать можно только его.
 * ПРидумал 2 решения:
 * 1 - return stack.stream().min(Integer::compare).get();
 * Не трудеут ничегоДополнительного, просто такой ретюрн в методе и все. Компаратор взят стандартнй, интовый. Долго работает, за O(n)
 * 2 - Сделал через PriorityQueue с стандартным приориетом (min).
 * Нужно добавлять в очередь элементы, при добавлении в стек. Удалять эелемнты из очереди при удалении из стека.
 * Зато, когда getMin делаю, просто элеемнт из очереди беру и все.
 */
public class MinimumStack {

    static class MinStack {
        private Stack<Integer> stack;
        private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int val) {
            priorityQueue.add(val);
            stack.push(val);
        }

        public void pop() {
            priorityQueue.remove(stack.peek());
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            //return stack.stream().min(Integer::compare).get();
            return priorityQueue.peek();
        }
    }
}
