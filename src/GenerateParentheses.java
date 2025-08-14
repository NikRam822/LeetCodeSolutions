import java.util.*;
import java.util.stream.Collectors;
//todo: дорешать
public class GenerateParentheses {

//    static HashMap<Integer, List<String>> map = new HashMap<>();
//
//    static {
//        map.put(1, Arrays.asList("()"));
//        map.put(2, Arrays.asList("()()", "(())"));
//        map.put(3, Arrays.asList("()()()", "((()))", "(()())", "(())()", "()(())"));
//        //map.put(4, Arrays.asList("()()()()","(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())"));
//    }
//
//    public List<String> generateParenthesis(int n) {
//        List<String> res = map.get(n);
//        if (res != null) {
//            return res;
//        }
//        if (n - map.size() == 1) {
//            res = map.get(map.size());
//        }
//        Set<String> result = new HashSet<>();
//
//        String str = res != null ? res.get(0) : "";
//
//
//        String str1 = str + ")";
//        String str2 = "(" + str;
//
//
//        for (int i = 0; i < str.length(); i++) {
//            String subStrO1 = str1.substring(0, i);
//            String subStrO2 = str1.substring(i);
//            //System.out.println(subStrO1+"("+subStrO2);
//            result.add(subStrO1 + "(" + subStrO2);
//            String subStrC1 = str2.substring(0, str.length() - i - 1);
//            String subStrC2 = str2.substring(str.length() - i - 1);
//
//            if (i != str.length() - 1) {
//                // System.out.println(subStrC1 + ")" + subStrC2);
//                result.add(subStrC1 + ")" + subStrC2);
//            }
//
//        }
//        List<String> res1 = new ArrayList<>(result);
//        res1.add(1, new String("(" + map.get(n - 1).get(1) + ")"));
//        System.out.println(res1);
//        map.put(n, res1);
//        return res1;
//    }
//   ()(), (()),
//   ()()(), ((())), (()()), ()()
//}
//
//}

    /**
     * НЕ МОЕ.
     * <p>
     * Рекурсивынй алгоритм, прикольно работает.
     * У нас есть max - допустимое кол-во скобок (max*2 - это в целом допустмая длинна валидной строки), есть open и close - кол-во скобоко (отрквающихся, или закрывающихся)  текущей строке
     * Запускаем алгоритм от пустой строки, если можно добавить открывающуйся - добалвяем и запускаем алгоритм (он будет запущен уже от строки "(" с open=1 и close = 0).
     * Затем также добовляем ( и снова запускаем уже от "((", open = 2, close=0; затем к текущей строке добавится )) и в базовом случае будет добавление такоей строки и ретюрн в предыдущий случай.
     * <p>
     * Таким образом мы веремся к моменту запуска функции от "(", 0,0 и пойдем дальше, добавив закрытую скобку и после череды вызово, получим "()()"
     * В итоге в массвие будет "(())" и "()()"
     *
     * ПРимеры:
     * при n=2
     *                       ""
     *                       /
     *                      "("
     *                   /       \
     *              "(("          "()"
     *               |           /
     *             "(()"      "()("
     *               |           |
     *             "(())"     "()()"
     *
     * При n=3
     * ""
     * └── "("
     * ├── "(("
     * │   ├── "((("
     * │   │   └── "((()"
     * │   │       └── "((())"
     * │   │           └── "((()))"
     * │   └── "(()"
     * │       ├── "(()("
     * │       │   └── "(()()"
     * │       │       └── "(()())"
     * │       └── "(())"
     * │           └── "(())()"
     * └── "()"
     * ├── "()("
     * │   ├── "()(("
     * │   │   └── "()(()"
     * │   │       └── "()(())"
     * │   └── "()()"
     * │       └── "()()()"
     * └── "())"
     *
     * Не валидные случаи не добавятся в массив, так как длинна будет меньше max*2 (также не возможен случай, когда закрывающаяся скобка перед открывающейся, так как условия сначала всегда добавляют открывающуюся )
     */
    public class Solution {
        private List<String> ans = new ArrayList<>();
        private int max;

        public List<String> generateParenthesis(int n) {
            max = n;
            backtrack("", 0, 0);
            return ans;
        }

        private void backtrack(String curr, int open, int close) {
            // Если длина строки достаточна, добавляем результат
            if (curr.length() == max * 2) {
                ans.add(curr);
                return;
            }

            // Можем добавить открывающую скобку, если не превысили лимит
            if (open < max) {
                backtrack(curr + "(", open + 1, close);
            }

            // Закрывающую скобку добавляем, если не закрываем больше, чем открыли
            if (close < open) {
                backtrack(curr + ")", open, close + 1);
            }
        }
    }
}

