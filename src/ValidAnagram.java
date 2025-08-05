import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        System.out.println(Arrays.equals(sc, tc));
        return Arrays.equals(sc, tc);

    }
}
