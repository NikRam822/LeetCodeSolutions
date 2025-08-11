package dt.tasks;

import utils.Point;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/*
Дан массив точек на плоскости (x, y) требуется дать ответ можно ли провести
вертикальную прямую так, что бы точки не лежащие на ней были симметричны

Пример входа:

[(0, 0), (0, 0), (1, 1), (3, 1), (4, 0), (4, 0)] - можно построить
[] - можно построить
[(0, 0)] - можно построить
[(0, 0), (1, 0), (3, 0)] - нельзя построить
*/
public class Symmetry {

    public boolean checkPoint(Point[] points) {
        Comparator<Point> comparator = (o1, o2) -> {
            if (o1.getX() > o2.getX()) return 1;
            if (o1.getX() < o2.getX()) return -1;
            return 0;
        };

        //TODO: Сделать сортировку и попровобовать двумя уазателями идти слева и справа
        Optional<Point> min = Arrays.stream(points).min(comparator);
        Optional<Point> max = Arrays.stream(points).max(comparator);

        Point diff = Point.dff(max.get(), min.get());
        if (diff.getY() != 0) return false;

        double simmLine = min.get().getX() + (double) (max.get().getX() - min.get().getX()) / 2;

        return false;
    }
}
