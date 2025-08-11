/**
 * Плохая идея изначально. Плохо придумал, устал.
 */
public class BestTimeToBuyAndSellStock {
//    public int maxProfit(int[] prices) {
//        int minLeft = Integer.MAX_VALUE;
//        int maxRight = Integer.MIN_VALUE;
//
//        int best = Integer.MIN_VALUE;
//
//        int indxL = 0;
//        int indxR = prices.length - 1;
//
//        for (int i = 0; i < prices.length; i++) {
//
//            int currentStart = prices[i];
//            int currentEnd = prices[prices.length - i - 1];
//
//            if (indxR - indxL > 1 || i == 0) {
//                if (i <= prices.length - i - 1) {
//                    if (currentStart < minLeft) {
//                        minLeft = currentStart;
//                        indxL = i;
//                    }
//                    if (currentEnd > maxRight && (prices.length - i - 1) > indxL) {
//                        maxRight = currentEnd;
//                        indxR = prices.length - i - 1;
//                    }
//                }
//            }
//        }
//        if (maxRight == Integer.MIN_VALUE || minLeft == Integer.MAX_VALUE) return 0;
//        int res = maxRight - minLeft;
//        System.out.println(Math.max(res, 0));
//        return Math.max(res, 0);
//    }

    /**
     * НЕ МОЙ АЛГОРИТМ (я его попробовал реалезовать)
     *
     * Перебираем все значения, и для каждого либо меняем минимум на текущее, либо считаем профит.
     * Таким образом для каждого будет посчитан профит
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = prices[0]; // минимальная цена на текущий момент
        int maxProfit = 0;        // максимально возможная прибыль

        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                if (maxProfit < prices[i] - minPrice) {
                    maxProfit = prices[i] - minPrice;
                }
            }
        }

        return maxProfit;
    }

}
