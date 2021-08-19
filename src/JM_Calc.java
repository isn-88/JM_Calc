public class JM_Calc {
    public static void main(String[] args) {

        Input input = new Input();
        RomanNum roman = new RomanNum();
        Calculate calc = new Calculate();


        String text_input;
        String[] elements;
        String operations;
        String s_num_1 = "", s_num_2 = "";
        int a = 0, b = 0;
        int result = 0;
        boolean num1_is_arabic=false;
        boolean num2_is_arabic=false;
        boolean num1_is_roman=false;
        boolean num2_is_roman=false;




        // Получить от пользователя арифметическую операцию
        System.out.println("Введите арифметическую операцию:");
        text_input = input.getInput();// Получить от пользователя арифметическую операцию
        elements = text_input.split(" ");// Получить все данные из введённой строки, которые были разделены пробелами
        if(elements.length == 3) {
            s_num_1 = elements[0];
            operations = elements[1];
            s_num_2 = elements[2];
        } else if (elements.length < 3){
            System.out.println("Арифметическая операция слишком короткая. ");
            return;
        } else if (elements.length > 3) {
            System.out.println("Арифметическая операция слишком длинная. ");
            return;
        }
        // Получить знак арифметической операции
        operations = elements[1];

        // Проверить 1й операнд
        if (s_num_1.matches("[0-9.]+")) {
            a = Integer.valueOf(s_num_1);
            num1_is_arabic = true;
        } else {
            a = roman.RomanToArabic(s_num_1);
            if (a > 0)  num1_is_roman = true;
        }

        // Проверить 2й операнд
        if (s_num_2.matches("[0-9.]+")) {
            b = Integer.valueOf(s_num_2);
            num2_is_arabic = true;
        } else {
            b = roman.RomanToArabic(s_num_2);
            if (b > 0)  num2_is_roman = true;
        }




        if (num1_is_arabic && num2_is_arabic) { // Если оба числа арабские
            result = calc.calculate(a, b, operations);
            System.out.println("Результат: " + result);
        } else if (num1_is_roman && num2_is_roman) {
            result = calc.calculate(a, b, operations);
            if(result  > 0) {
                System.out.println("Результат: " + result);
            } else {
                System.out.println("В римской системе нет отрицательных чисел");
            }

        } else {
            System.out.println("Используются одновременно разные системы счисления");
        }















    }
}
