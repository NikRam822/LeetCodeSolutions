import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * Хэш сет для красоты код, можно его убрать, просто придется дважды свитч-кейс делать
 * Просто идем по строке, если это число - кладем в стек, если опирация - применяем ее (в свитч-кейсе ) и кладем результат в стек
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        HashSet<String> set = new HashSet<>();

        set.add("+");
        set.add("*");
        set.add("-");
        set.add("/");

        Stack<Integer> stack = new Stack<>();
        Arrays.stream(tokens).forEach(i -> {
            if (set.contains(i)) {
                int a = stack.pop();
                int b = stack.pop();
                switch (i) {
                    case "*" -> stack.push(a * b);
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(b - a);
                    case "/" -> stack.push(b / a);
                }
            } else {
                stack.push(Integer.parseInt(i));
            }
        });
        System.out.println(stack.peek());
        return stack.peek();
    }
}
