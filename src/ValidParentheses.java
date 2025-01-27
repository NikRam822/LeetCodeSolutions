import java.util.HashMap;
import java.util.Stack;

/**
 * Основная идея:
 * 1) Создаем мапу скобок и пустой стек
 * 2) Идем циклом по строке:
 *  - По очередному ключу берем значение из мапы, если значение удалось достать,
 *  то кладем закрывающую скобку в стек, если нет - проверяем следующее:
 *          - Если стек пуст - значит закрывающейся скобки нет и возвращаем false
 *          - Если стек не пуст, сравниваем верхний элемент стека с текущим, если они сходятся - удаляем элемент из стека и продолжаем цикл,
 *          если нет - возвращаем false
 *
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        if (map.get(chars[0]) == null) {
            return false;
        }
        for (Character c : chars) {
            Character expectedChar = map.get(c);
            if (expectedChar != null) {
                stack.push(expectedChar);
            } else {
                if(stack.isEmpty()){return false;}
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
