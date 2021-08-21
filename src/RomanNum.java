public class RomanNum {
    String[] one = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    String[] ten = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    String[] hundred = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    String[] thousand = {"","M","MM","MMM","MMMM"};

    // Метод преобразования арабского числа в римское
    String toRoman(int num) {
        String s_thousand = thousand[num / 1000];   // Переводим тысячи
        String s_hundred = hundred[num / 100 % 10]; // Переводим сотни
        String s_ten = ten[num / 10 % 10];          // Переводим десятки
        String s_one = one[num % 10];               // Переводим единицы
        return s_thousand + s_hundred + s_ten + s_one;
    }

    // Метод преобразования римского числа в арабское
    int toArabic(String roman) {
        int num = 0;
        if(roman == null) return -1;
        for (int i = 0; i < roman.length(); i++)
        {
            String symbol = roman.substring(i, i+1);
            // Проверка на исключительную ситуацию: вычитание в римской системе счисления
            if(i < roman.length()-1) { // Если i-й символ не последний
                String dev = roman.substring(i, i+2); // Добавим следующий символ и проверим на исключение
                if(dev.equals("IV") || dev.equals("IX") || dev.equals("XL") || dev.equals("XC") || dev.equals("CD") || dev.equals("CM")) {
                    symbol = dev;
                    i++;
                }
            }
            // Перевести очередной символ в число
            num += getNum(symbol);
        }
        return num;
    }

    // Поиск одного (двух) разрядов римского числа и преобразование в арабское число
    int getNum(String symbol) {
        int thousand_num=0;
        int hundred_num=0;
        int ten_num=0;
        int one_num=0;
        // Поиск римского символа в массиве с единицами
        for (int i = 0; i < one.length; i++) {
            if (one[i].equals(symbol)) {
                one_num = i;
                break;
            }
        }
        // Поиск римского символа в массиве с десятками
        for (int i = 0; i < ten.length; i++) {
            if (ten[i].equals(symbol)) {
                ten_num = i;
                break;
            }
        }
        // Поиск римского символа в массиве с сотнями
        for (int i = 0; i < hundred.length; i++) {
            if (hundred[i].equals(symbol)) {
                hundred_num = i;
                break;
            }
        }
        // Поиск римского символа в массиве с тысячами
        for (int i = 0; i < thousand.length; i++) {
            if (thousand[i].equals(symbol)) {
                thousand_num = i;
                break;
            }
        }
        return thousand_num * 1000 + hundred_num * 100 + ten_num * 10 + one_num;
    }
}
