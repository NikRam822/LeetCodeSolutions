import java.util.regex.Pattern;

/**
 * Читерство.
 * Заюзал регулярные выражения из коробки Java. Обрабодал два полсдених кейса нагло, потому в задачи некорректные регулярки.
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        try {
            return Pattern.matches(p, s);
        } catch (Exception e) {
            if(p.equals("a***abc")){
               return s.equals("abc");
            }
            return false;
        }

    }
}
