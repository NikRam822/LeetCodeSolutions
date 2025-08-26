import java.util.Arrays;

/**
 * Сначала бинарным поиском выбираем нужный массив из нашего matrix. Каждую итерацию цикла мы сохраняем максимальный и минимальный элемент текущего массива и проаверяем,
 * что искомый элеемнт находится между минимальным и макимальным (если так - тогда в текущем массиве лежит нужное число).
 * Если искомый между минимум и максимумом - запускаем бинарный поиск для этого массива и выводим результат (если нашли таргет - тру иначе фолс)
 * Если искомый не между мин и макс - смещаем left  или right (взависимости от target>currMax) и в новой итерации middle (текущий индекс массива в матрица) изменится
 *
 * Обычный бинарный поиск, но для матрицы. Если нашли массив нужный - изем элеемнт также бинарный поиском.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (middle>=matrix.length) return false;

            int currMax = matrix[middle][matrix[middle].length - 1];
            int currMin = matrix[middle][0];

            if (currMin == target || currMax == target) return true;
            if (target > currMin && target < currMax) {
                int res = Arrays.binarySearch(matrix[middle], target);
                return res >= 0;
            }

            if (target > currMax) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }
}
