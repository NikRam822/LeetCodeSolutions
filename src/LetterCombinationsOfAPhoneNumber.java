import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Общая идея:
 * 1) Всегда строим первые два случаю вручную (в цикле берем букву и складываем с кажлой буквы следующего массива)
 * 2) Дальше я сделал руками, но можно заменить if на for от 1 до длинны words
 * 1 - создаем копию итогвого массива созданного из пары
 * 2 - прибавляем очередную букву к каждому значению из массива пар
 * 3 - делаем тоже самое для следующих чисел
 */
public class LetterCombinationsOfAPhoneNumber {


    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return new ArrayList<String>();
        }
        HashMap<Character, String[]> map = new HashMap<>();

        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});

        List<String> result = new ArrayList<>();
        List<String[]> words = new ArrayList<>();

        for (char num : digits.toCharArray()) {
            String[] word = map.get(num);
            words.add(word);
        }
        if (words.size() > 1) {
            String[] firstWord = words.get(0);
            String[] secondWord = words.get(1);
            for (int i = 0; i < firstWord.length; i++) {
                for (int j = 0; j < secondWord.length; j++) {
                    result.add(firstWord[i] + secondWord[j]);
                }
            }
        } else {
            result.addAll(Arrays.asList(words.get(0)));
            return result;
        }

        if (words.size() > 2) {
            List<String> internal = new ArrayList<>(result);
            result.clear();
            String[] thirdWord = words.get(2);
            Arrays.stream(thirdWord).forEach(w -> {
                internal.stream().forEach(i -> result.add(i + w));
            });
        }

        if (words.size() > 3) {
            List<String> internal = new ArrayList<>(result);
            result.clear();
            String[] fourthWord = words.get(3);
            Arrays.stream(fourthWord).forEach(w -> {
                internal.stream().forEach(i -> result.add(i + w));
            });
        }


        return result;
    }
}
