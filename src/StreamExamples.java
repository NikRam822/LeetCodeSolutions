import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Примеры использования стримов в разных задачах
 */
class StreamExamples {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 6, 7, 89, 1, 2, 34, 56, 45, 75, 34, 57, 43, 23, 456, 78, 0, -56, 34, 57, 78, 3, 2, 87, 5556, 4545, -22203};
// Среднее, макс, мин, сумма ряда
        System.out.println(Arrays.stream(arr).average());
        System.out.println(Arrays.stream(arr).max());
        System.out.println(Arrays.stream(arr).min());
        System.out.println(Arrays.stream(arr).sum());

        String[] str = new String[]{"Apple ", "Apricot", "Avocado", "Bana na", "Blueb erry", "Cherry", "Dat e", "Elderberry", "Fig", "Grape", "Honeydew", "Kiwi", "Lemon", "Mango", "Nectarine"};
        // Фильтр строк, начианющихся с буквы A, фильтр чисел по условию
        Arrays.stream(str).filter((s) -> s.startsWith("A")).forEach(System.out::println);
        Arrays.stream(arr).filter(i -> i > 5000).forEach(System.out::println);

        System.out.println("////////////");
        // соритровка ряда. boxed нужен для преобразования int в Integer, так как только для Integer определн компаратор
        Arrays.stream(arr).boxed().sorted().forEach(System.out::println);
        System.out.println("////////////");
        // соритровка ряда в обратном порядке. boxed нужен для преобразования int в Integer, так как только для Integer определн компаратор
        Arrays.stream(arr).boxed().sorted((o1, o2) -> Integer.compare(o2, o1)).forEach(System.out::println);
        System.out.println("////////////");
        // преобразование строки в длинну
        Arrays.stream(str).map(String::length).forEach(System.out::println);
        // группировка строк на две группы: те, что рначианются на A вторая группа - отслаьные строки
        System.out.println(Arrays.stream(str).collect(Collectors.groupingBy(i -> i.startsWith("A"))));

        int[][] arrArr = {{100000}, {1, 2, 3}, {6, 8, 10, -7}, {100, -5, 12, 56}};
        // flatMap - обход вложенных массивов. Тут для каждого массаива из arrArr, кажый элемент преобразуется в Integer (boxed), а затем все это преобразуется в один List
        List<Integer> resultList = Arrays.stream(arrArr).flatMap(a -> Arrays.stream(a).boxed()).toList();
        System.out.println(resultList);

        // Разбивает массив строк, на массив слов (строки без пробелов)
        List<String> resS = Arrays.stream(str).flatMap(i -> Arrays.stream(i.split(" "))).toList();
        System.out.println(resS);
        // проверяет есть ли в массиве хотя бы один элеемнт больше 100. Метод anyMatch возвращает true, если такой элемент найден, иначе false
        System.out.println(Arrays.stream(arr).anyMatch(i -> i > 100));
        // вывод первого отрицательного числа
        System.out.println(Arrays.stream(arr).filter(i -> i < 0).findFirst());
        // Перевод листа в Set
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toSet()));
        // сумма чисел с использованием parallel stream. reduce - аккумулятор с помощью бинарной функции
        System.out.println(Arrays.stream(arr).parallel().boxed().reduce((a, b) -> a + b).get());
        // просто сумма чисел в массиве
        System.out.println(Arrays.stream(arr).sum());
    }

}