/**
 * Общая идея:
 *  Идем по массиву длинн с двух строн. Берем более короткую сторону, считаем площадь и берем следующую после текущей короткой.
 *  Повторяем до тех пор, пока не пересекуться стороны.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int s = 0;
        int i = 0;
        int j = height.length - 1;
        int test = 0;


        while (i < j) {
            if (height[i] <= height[j]) {
                test = height[i] * (j - i);
                i++;
            } else {
                test = height[j] * (j - i);
                j--;
            }
            if (test > s) {
                s = test;
            }
        }
        System.out.println(s);
        return s;
    }
}
