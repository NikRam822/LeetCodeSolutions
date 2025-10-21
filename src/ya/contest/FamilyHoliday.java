package ya.contest;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * НЕ все тесты прошло
 *
 * Ваня - известный повар в одном популярном московском ресторане. Он решил подготовить большой семейный праздник, позвать на него своих друзей и родственников, чтобы накормить их своими лучшими кулинарными шедеврами. Все друзья Вани (как и он) - зумеры, а вот родственники по большей части из поколения X. Разница в возрасте его гостей для Вани не проблема, но он беспокоится, чтобы всем гостям понравились его блюда на семейном празднике и поэтому решил заранее собрать от гостей списки тех блюд, которые они бы хотели видеть на праздничном столе.
 * Он собрал два списка блюд (от каждого из поколений), в которых пронумеровал все блюда натуральными числами и отсортировал их. Теперь он хочет из обоих списков выбрать не более K
 * K блюд и при этом он решил, что не будет готовить блюда, которые выбрало менее M
 * M человек. При этом, если есть несколько блюд, которые выбрало нужное количество человек и нужно выбрать, что добавить в меню из них, то он выбирает те, у которых номер больше.
 * Ване нужна понятная программа, которая сможет решить его задачу.
 * Формат ввода
 * В первой строке
 * 4 целых числа через пробел:
 * A - количество блюд в первом списке (не больше 1 млн)
 * B - количество блюд во втором списке (не больше 1 млн)
 * K - максимальное количество блюд, которые готов приготовить Ваня (K≤A+B)
 * M - минимальное количество голосов за блюдо, чтобы добавить его в итоговый список (не больше 1 млн)
 *
 * Во второй и третьей строке идут списки натуральных чисел - номера блюд в каждом из списков

 * Формат вывода
 * Наибольшую возможную сумму номеров блюд, которые выберет Ваня
 *
 * Пример 1
 * Ввод
 *
 * 6 4 3 2
 * 1 3 5 5 6 7
 * 2 4 5 6
 * Вывод
 *
 * 11
 * Пример 2
 * Ввод
 *
 * 3 3 2 2
 * 1 1 2
 * 2 3 3
 * Вывод
 *
 * 5
 */
public class FamilyHoliday {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // Чтение первой строки
        String[] firstLine = reader.readLine().split(" ");
        int A = Integer.parseInt(firstLine[0]);
        int B = Integer.parseInt(firstLine[1]);
        int K = Integer.parseInt(firstLine[2]);
        int M = Integer.parseInt(firstLine[3]);

        String[] secondLine = reader.readLine().split(" ");
        int[] listA = new int[A];
        for (int i = 0; i < A; i++) {
            listA[i] = Integer.parseInt(secondLine[i]);
        }

        String[] thirdLine = reader.readLine().split(" ");
        int[] listB = new int[B];
        for (int i = 0; i < B; i++) {
            listB[i] = Integer.parseInt(thirdLine[i]);
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o2>o1) return 1;
                if(o2<o1) return -1;
                return 0;
            }
        });

        Arrays.stream(listA).forEach(e -> {
            Integer el = treeMap.putIfAbsent(e, 1);
            if (el != null) treeMap.put(e, el + 1);
        });

        Arrays.stream(listB).forEach(e -> {
            Integer el = treeMap.putIfAbsent(e, 1);
            if (el != null) treeMap.put(e, el + 1);
        });

        //System.out.println(treeMap);

        int result = treeMap.entrySet().stream().filter(i->i.getValue()>=M).limit(K).mapToInt(Map.Entry::getKey).sum();

        writer.write(String.valueOf(result));

        reader.close();
        writer.close();


    }
}
