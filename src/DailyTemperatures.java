import java.util.Arrays;
import java.util.Stack;

/**
 * Ну, как говорится, "зато свое". Придумал сам, но с реалезацией беда. Работает, но выглядит плохо.
 * Основная идея: идем с кнца массива, первый элемент добовляем в стек.
 * Если очередной элемент больше последнего в стеке - мы его заменяем, и разницу сохраняем в массив результатов.
 * *Есть момент, что может случиться ситуация, что большый элеемнт не послдений, тогда я перебираю все эалемнты стека, пока не найду, то , который больше текущего.
 * Если очередной элеемнт меньше, чем верхушка стека - я просто добавляю этот элеемнт, заполняя массив результатов.
 * Таким образом на верхушке всегда посдений элемент для которого был деть со сменой температуры
 * и он потенциально может стать днем для другого элемента
 */
public class DailyTemperatures {
   /* public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (temperatures.length - 1 == i) {
                stack.push(i);
                result[i] = 0;
            } else {
                if (temperatures[i] >= temperatures[stack.peek()]) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        result[i] = 0;
                        stack.push(i);
                        continue;
                    }
                    for (int k = stack.size() - 1; k >= 0; k--) {
                        if (temperatures[i] >= temperatures[stack.get(0)]) {
                            stack.clear();
                            stack.push(i);
                            result[i] = 0;
                            break;
                        }
                        int j = stack.get(k);
                        if (temperatures[i] < temperatures[j]) {
                            result[i] = j - i;
                            stack.push(i);
                            break;
                        }
                    }
                } else if (temperatures[i] < temperatures[stack.peek()]) {
                    result[i] = stack.peek() - i;
                    stack.push(i);
                }

            }

        }
        System.out.println(Arrays.toString(result));
        return result;
    }*/

    /**
     * НЕ МОЙ АЛГОРИТМ.
     *
     * Изначально, придумал что-то ближе к этому, но решил, что обратный порядок - идея хорошая + не додумался до хранения пар (i,v) в массиве.
     * Суть такая же:
     * В стеке храним только те эелементы, которые стали максимум для кого-то другого элеемнта.
     * Также, если очередной эдеемнт больше верхушки в стеке - заменяем его, в противном случае просто пушим в стек.
     * Также всегда происходит полный перебор стека. Поэтому алгоритмы идейно схожи, но у меня другая реалезация.
     * @param temperatures
     * @return
     */
        public int[] dailyTemperatures(int[] temperatures) {
            int[] res = new int[temperatures.length];
            Stack<int[]> stack = new Stack<>(); // пара: [температура, индекс]

            for (int i = 0; i < temperatures.length; i++) {
                int t = temperatures[i];
                while (!stack.isEmpty() && t > stack.peek()[0]) {
                    int[] pair = stack.pop();
                    res[pair[1]] = i - pair[1];
                }
                stack.push(new int[]{t, i});
            }
            return res;
        }
    }

