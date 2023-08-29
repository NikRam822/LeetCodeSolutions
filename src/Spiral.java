import java.util.ArrayList;

/**
 * Общая идея:
 * Описываем опорные переменные: максимальная и минимальная строка и максимальный и минимальый столбец
 * Затем запускаем цикл по всем переменным матрицы
 *
 * описваем движение влево(каждый элемент, который мы положили в итоговый массив - обнуляем)
 * описываем также движение вниз, влево и вверх
 *
 * После каждой итерации основного цикла - меням опорные координаты
 * Максимаильная строка и столбец --
 * Минимальная строка и столбец ++
 *
 * так получается спираль
 */
public class Spiral {
    Integer[][] array = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};

    ArrayList<Integer> result = new ArrayList<>();

    public void spiralView() {

        showMatrix(array);
        int i = 0;
        int size = 25;

        int sMin = 0;
        int columnMax = 4;

        int sMax = 4;
        int columnMin = 0;


        while (i <= size) {

            //движение вправо
            for (int j = 0; j < 5; j++) {
                if (array[sMin][j] != null) {
                    result.add(array[sMin][j]);
                }
                array[sMin][j] = null;
                i++;
            }

            //движение вниз
            for (int j = 0; j < 5; j++) {
                if (array[j][columnMax] != null) {
                    result.add(array[j][columnMax]);
                }
                array[j][columnMax] = null;
                i++;
            }

            //движение влево
            for (int j = 4; j >= 0; j--) {
                if (array[sMax][j] != null) {
                    result.add(array[sMax][j]);
                }
                array[sMax][j] = null;
                i++;
            }

            //движение вверх
            for (int j = 4; j >= 0; j--) {
                if (array[j][columnMin] != null) {
                    result.add(array[j][columnMin]);
                }
                array[j][columnMin] = null;
                i++;
            }
            sMin++;
            columnMax--;
            sMax--;
            columnMin++;


        }
        for (Integer[] integers : array) {
            for (Integer integer : integers) {
                if (integer != null) {
                    result.add(integer);
                }
            }
        }
        showMatrix(array);
        System.out.println(result);
    }

    private void showMatrix(Integer[][] matrix) {
        for (Integer[] integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}