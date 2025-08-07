import java.util.HashMap;

/**
 * Общая идея:
 * Решение идиота. В мапу забил все варианты для всех разрядов
 * брал цифры, разбивал по разрядам и брал из мапы значения
 */
public class IntegerToRoman {
    HashMap<Integer, String> dict = new HashMap<>();

    private void initDict() {
        this.dict.put(0,"");
        this.dict.put(1, "I");
        this.dict.put(2, "II");
        this.dict.put(3, "III");
        this.dict.put(4, "IV");
        this.dict.put(5, "V");
        this.dict.put(6, "VI");
        this.dict.put(7, "VII");
        this.dict.put(8, "VIII");
        this.dict.put(9, "IX");

        this.dict.put(10, "X");
        this.dict.put(20, "XX");
        this.dict.put(30, "XXX");
        this.dict.put(40, "XL");
        this.dict.put(50, "L");
        this.dict.put(60, "LX");
        this.dict.put(70, "LXX");
        this.dict.put(80, "LXXX");
        this.dict.put(90, "XC");

        this.dict.put(100, "C");
        this.dict.put(200, "CC");
        this.dict.put(300, "CCC");
        this.dict.put(400, "CD");
        this.dict.put(500, "D");
        this.dict.put(600, "DC");
        this.dict.put(700, "DCC");
        this.dict.put(800, "DCCC");
        this.dict.put(900, "CM");


        this.dict.put(1000, "M");
        this.dict.put(2000, "MM");
        this.dict.put(3000, "MMM");
        this.dict.put(4000, "MMMM");
        this.dict.put(5000, "MMMMM");
        this.dict.put(6000, "MMMMMM");
        this.dict.put(7000, "MMMMMMM");
        this.dict.put(8000, "MMMMMMMM");
        this.dict.put(9000, "MMMMMMMMM");
        this.dict.put(10000, "MMMMMMMMMM");

    }

    public String intToRoman(int num) {
        String s = String.valueOf(num);
        initDict();
        StringBuilder result = new StringBuilder();
        if (dict.get(num) != null) {
            return dict.get(num);
        }
        for (int i = 0; i < s.length(); i++) {
            int a = (s.charAt(i) - '0') * (int) Math.pow(10, (s.length() - 1 - i));
            result.append(dict.get(a));
            System.out.println(a);
        }
        System.out.println(result);
        return result.toString();
    }
}
