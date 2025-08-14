/**
 * Основная идея - до входа в цикл - добавил первый элеемнт, чтобы не было риска совпадения last с первым символом строки.
 *
 * В цикле идем по массиву, если очередной символ равен last - просто увеличиваем счетчик и идем дальше.
 * Если очередной символ не равен последнему - проверяем, если счетчик больш 1 мы записываем счетчик в строку, затем счетчик обнуляем и добавляем текущий символ в троку, увеличивая счетчик на 1.
 *
 * После выхода из цикла, проверяем, если счетчик больше 1 - добавляем счетчик в реультат.
 *
 * Далее, так как состовители задачи Дауны - нужно менять массив chars (типо нам дали массив, нужно его сжать), благо в StringBuilder есть фича,
 * которая позволяет легко и быстро перенести символы из билдера в какой-то массив. Так и сделал . Эта операция за n и в иделае без нее, но пофиг, тем более эта фича
 * на основе array.copy основана и там на уровне JVM все оптимизировано
 */
public class StringCompression {
    public int compress(char[] chars) {
        if(chars.length==0 || chars.length==1) return chars.length;
        StringBuilder result = new StringBuilder();
        result.append(chars[0]);
        char last =chars[0];
        int count = 1;

        for(int i=1; i<chars.length; i++){
            char n =chars[i];

            if(last==n){
                last=n;
                count++;
            } else{
                if(count>1){
                    result.append(count);
                }
                count =0;
                result.append(n);
                count++;
                last=n;
            }
        }
        if(count >1) result.append(count);

        result.getChars(0, result.length(), chars, 0);
        return result.length();
    }
}
