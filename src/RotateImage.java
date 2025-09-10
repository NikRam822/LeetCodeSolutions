import java.util.Arrays;

public class RotateImage {
    /**
     * Читекрское решение с использованием 2-ой матрицы. Хотя так по условию задачи нельзя.
     *
     * Идем по матрице в таком порядке: [n][0], [n-1][0], [n-2][0] ... , [n][1],[n-1][1],[n-2][1]... n - размерность матрицы.
     * По первой координате итерируеся по j (ижем в обратном порядке), по второй координате итерируемся по i (в прямом порядке). То есть так [j][i]
     *
     * Записываем очередное число в итоговую матрицу, но в координаты обычного обхода матрицы. Обход для итогвой в таком порядке: [0][0], [0][1],[0][2] и т.д.
     * Итерация по i  и так в прямом порядке, а по j, т.к. порядок итерации обратный, нужно в каечтсве 2-ой координаты использовать формулу: matrix.length-1-j, тогда все будет корректно
     * После цикла в изначальную матрицу пихаем итоговую
     *
     * @param matrix
     */
  /*  public void rotate(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                result[i][matrix.length - 1 - j] = matrix[j][i];
            }
        }
        matrix = result;
        System.out.println(Arrays.deepToString(matrix));
    }*/

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                //todo: придумать, как при обходе эелементов, реалезовать замену элементов, чтобы соблюсти порядок и никакие элеемнты не заменить.
                System.out.println( matrix[j][i]);
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }


}
