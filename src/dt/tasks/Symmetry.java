package dt.tasks;

import utils.Point;

import java.util.Arrays;
import java.util.Comparator;

/*
Дан массив точек на плоскости (x, y) требуется дать ответ можно ли провести
вертикальную прямую так, что бы точки не лежащие на ней были симметричны

Пример входа:

[(0, 0), (0, 0), (1, 1), (3, 1), (4, 0), (4, 0)] - можно построить
[] - можно построить
[(0, 0)] - можно построить
[(0, 0), (1, 0), (3, 0)] - нельзя построить
*/

/**
 * Идея решения:
 * Сортируем массив, удаляя из него дубликаты. Это нужно, потому что симметрия будет для равноудаленных элементов по икс (поэтому компаратор переопределен для икс координат)
 * СЧитаем ось симметрии: берем равноудаленные точки (самую левую и самую правую)
 * и считаем середину, учитывая отступ слева: middle(simmLine) = left + (right-left)/2
 * Затем идем по массиву и проверяем крайние эелемнты (крайний справа и крайний слева).
 * Если разница координат крайних эелемнтов по y не 0, значит они на разной высоте и они не симметричны
 * (если хотим проверяь симметрию и по высоте, просто изменить условие, проверяя разность по модулю )
 * Затем проверяем равноудаленность крайхних точек по x относительно оис симметрии.
 * Если расстояние не одинакове для крайних точек - точки не симметричины - возвращаем false
 *
 * Если фолсов нет в цикле, значит по выходу из метода вернем тру
 */
public class Symmetry {

    public boolean checkPoint(Point[] points) {
        if (points.length <= 1) return true;

        Comparator<Point> comparator = (o1, o2) -> {
            if (o1.getX() > o2.getX()) return 1;
            if (o1.getX() < o2.getX()) return -1;
            return 0;
        };

        points = Arrays.stream(points).distinct().sorted(comparator).toArray(Point[]::new);

        double simmLine = points[0].getX() + (double) (points[points.length - 1].getX() - points[0].getX()) / 2;

        for (int i = 0; i < points.length/2; i++) {
            if (Point.dff(points[points.length - 1 - i], points[i]).getY() != 0) return false;
            if (Math.abs(points[i].getX() - simmLine) != Math.abs(points[points.length - 1 - i].getX() - simmLine))
                return false;
        }
        return true;
    }
}
