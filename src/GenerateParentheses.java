import java.util.*;

public class GenerateParentheses {

    static HashMap<Integer, List<String>> map = new HashMap<>();
    static int max = 2;

    static {
        map.put(1, Arrays.asList("()"));
        map.put(2, Arrays.asList("()()", "(())"));
        //map.put(3, Arrays.asList("()()()", "((()))", "(()())", "(())()", "()(())"));
        //map.put(4, Arrays.asList("()()()()","(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())"));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = map.get(n);
        if (res != null) {
            return res;
        }
        if (n - max == 1) {
            res = map.get(max);
        }
        Set<String> result = new HashSet<>();

        String str = res != null ? res.get(0) : "";
        int currentIndex = 0;

        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }

        System.out.println(result);

        return null;
    }
//    ()(), (()),
//   ()()(), ((())), (()()), ()()


}
