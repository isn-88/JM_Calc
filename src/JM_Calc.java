public class JM_Calc {
    public static void main(String[] args) {
        int result;
        Input input = new Input();
        Calculate calc = new Calculate();
        RomanNum roman = new RomanNum();

        // Получить от пользователя арифметическую операцию
        System.out.println("Введите арифметическую операцию:");
        // Получить введенную строку
        input.getInput();
        // Разделить строку на элементы разделенные пробелами
        input.splitInput();
        // Проверить введенные данные на корректность
        boolean is_correct = input.checkInput();
        if(is_correct) {
            if(input.type[0] == DataType.NUMBER && input.type[1] == DataType.MATH && input.type[2] == DataType.NUMBER) {
                // Введено: число 1, математическая операция, число 2
                int a = Integer.parseInt(input.elements[0]);
                int b = Integer.parseInt(input.elements[2]);
                if((a > 0 && a <= 10) && (b > 0 && b <= 10)) {
                    String operation = input.elements[1];
                    result = calc.calculate(a, b, operation);
                    System.out.println("Результат: " + result);
                } else {
                    System.out.println("Введено слишком маленькое либо слишком большое значение.");
                    System.out.println("Допустимое значение чисел от 1 до 10.");
                }
            } else if (input.type[0] == DataType.ROMAN && input.type[1] == DataType.MATH && input.type[2] == DataType.ROMAN) {
                // Введено: римское число 1, математическая операция, римское число 2
                int a = roman.toArabic(input.elements[0]);
                int b = roman.toArabic(input.elements[2]);
                if((a > 0 && a <= 10) && (b > 0 && b <= 10)) {
                    String operation = input.elements[1];
                    result = calc.calculate(a, b, operation);
                    if(result > 0) {
                        System.out.println("Результат: " + roman.toRoman(result));
                    } else {
                        System.out.println("Ошибка. Результат вычисления < 1.");
                        System.out.println("В римской системе счисления нет нуля и отрицательных чисел.");
                    }
                } else {
                    System.out.println("Введено слишком маленькое либо слишком большое значение.");
                    System.out.println("Допустимое значение чисел от 1 до 10.");
                }
            } else if ((input.type[0] == DataType.NUMBER || input.type[0] == DataType.ROMAN) &&
                    input.type[1] == DataType.MATH &&
                    (input.type[2] == DataType.NUMBER || input.type[2] == DataType.ROMAN)) {
                System.out.println("Ошибка. Используются одновременно разные системы счисления.");
            } else {
                System.out.println("Данные введены некорректно.");
                System.out.println("Пример ввода арифметической операции: 2 * 2 или V + III");
            }
       }
    }
}

