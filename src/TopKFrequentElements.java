import java.util.*;
import java.util.stream.Collectors;

/**
 * Плохая сложность:
 * 1) Определили компаратор, который соритрует в обратном порядке.
 * 2) Используем TreeMap с моим компаратором, чтобы сортировка была в обратном порядке
 * 3) Заполняем мапу из массива, полчаем мапу, с сортированными ключами
 * 4) Берем отсортированную мапу, перебираем все entry мапы (Map.Entery <Integer, Integer>):
 *  1 - сортируем на основе моего компоратора
 *  2 - Преобразуем все эалаемнты в LinkedMap для сохранения порядка. Испоьзуем Collectors.toMap, который принимает 4 аргумента:
 *      1 - функция определения ключей
 *      2 - функция определения значений
 *      3 - решение конфликтов, для элементо в содинаковыми ключами (я просто беру первый элеемнт с ключом - второй скипаю)
 *      4 - обьект в который мэпим - LinkedMap
 *  5) Делаем слайс массива и возвращаем его
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        Comparator<Integer> comparator = (o1, o2) -> {
            if (o1 > o2) return -1;
            if (o1 < o2) return 1;
            return 0;
        };

        Map<Integer, Integer> map = new TreeMap<>(comparator);
        Arrays.stream(nums).forEach(i -> {
            Integer count = map.get(i);
            if (count == null) {
                map.put(i, 1);
            } else {
                map.replace(i, count + 1);
            }

        });

        LinkedHashMap<Integer, Integer> sortedByValue = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(comparator))
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (e1, e2) -> e1,  // при дубликатах оставляем первый
                        LinkedHashMap::new // сохраняем порядок вставки
                ));

             int[] keys = sortedByValue.keySet().stream().mapToInt(Integer::intValue).toArray();


//        System.out.println(Arrays.toString(Arrays.copyOfRange(keys, 0, k)));
        return Arrays.copyOfRange(keys, 0, k);
    }

}
