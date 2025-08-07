import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> s = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            List<String> result = map.get(Arrays.toString(chs));
            if (result == null) {
                List<String> arr = new ArrayList<>();
                arr.add(str);
                map.put(Arrays.toString(chs), arr);
            } else {
                result.add(str);
                map.put(Arrays.toString(chs), result);
            }
        }
        return map.values().stream().toList();
    }
}
