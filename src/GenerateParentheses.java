import java.util.*;
import java.util.stream.Collectors;

public class GenerateParentheses {

    static HashMap<Integer, List<String>> map = new HashMap<>();

    static {
        map.put(1, Arrays.asList("()"));
        map.put(2, Arrays.asList("()()", "(())"));
        map.put(3, Arrays.asList("()()()", "((()))", "(()())", "(())()", "()(())"));
        //map.put(4, Arrays.asList("()()()()","(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())"));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = map.get(n);
        if (res != null) {
            return res;
        }
        if (n - map.size() == 1) {
            res = map.get(map.size());
        }
        Set<String> result = new HashSet<>();

        String str = res != null ? res.get(0) : "";


        String str1 = str + ")";
        String str2 = "(" + str;


        for (int i = 0; i < str.length(); i++) {
            String subStrO1 = str1.substring(0, i);
            String subStrO2 = str1.substring(i);
            //System.out.println(subStrO1+"("+subStrO2);
            result.add(subStrO1 + "(" + subStrO2);
            String subStrC1 = str2.substring(0, str.length() - i - 1);
            String subStrC2 = str2.substring(str.length() - i - 1);

            if (i != str.length() - 1) {
                // System.out.println(subStrC1 + ")" + subStrC2);
                result.add(subStrC1 + ")" + subStrC2);
            }

        }
        List<String> res1 = new ArrayList<>(result);
        res1.add(1, new String("(" + map.get(n - 1).get(1) + ")"));
        System.out.println(res1);
        map.put(n, res1);
        return res1;
    }
//    ()(), (()),
//   ()()(), ((())), (()()), ()()


}
