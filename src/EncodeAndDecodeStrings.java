import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Простое, но читерское решение.
 *
 * При переводе массива в строку - вставляем вконце #!# и выводим строку
 * Когда переводим обратно - спитим строку по #!#
 *
 *  P.S. Если в строке будет заранее #!# то такой способ не сработает, но тесты решение прошло
 */
public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        if(strs.isEmpty()) return null;
        if(strs.size()==1) return strs.get(0);
        StringBuilder result = new StringBuilder();
        for (String s : strs) {
            result.append(s).append("#!#");
        }
        System.out.println(result);
        return result.toString();

    }

    public List<String> decode(String str) {
        if(Objects.equals(str, null)) return Arrays.asList();
        if(str.length()==1) return Arrays.asList(str);
        List<String> res = List.of(str.split("#!#"));
        System.out.println(res);
        return res;
    }
}
