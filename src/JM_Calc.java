public class JM_Calc {
    public static void main(String[] args) {

        Input input = new Input();
        Calculate calc = new Calculate();
        CheckNumber number_1 = new CheckNumber();
        CheckNumber number_2 = new CheckNumber();



        String text_input;
        String[] elements;
        String operations;
        String s_num_1 = "", s_num_2 = "";
        int result = 0;





        // Получить от пользователя арифметическую операцию
        System.out.println("Введите арифметическую операцию:");
        // Сохранить введенную строку
        input.getInput();
        // Разделить строку на элементы разделенные пробелами
        input.splitInput();
        // Проверить введенные данные на корректность
        boolean is_correct = input.checkInput();
        if(is_correct)
        {
            // Проверить 1-й операнд
            number_1.checkNumber(input.str_num_1);
            // Проверить 2-й операнд
            number_2.checkNumber(input.str_num_2);


            if (number_1.is_correct && number_2.is_correct) {
                if (number_1.is_arabic && number_2.is_arabic) {
                    if(number_1.value > 0 && number_1.value <= 10 && number_2.value > 0 && number_2.value <= 10) {
                        result = calc.calculate(number_1.value, number_2.value, input.operation);
                        System.out.println("Результат: " + result);
                    } else {
                        System.out.println("Введено слишком маленькое или слишком большое значение");
                    }
                } else if (number_1.is_roman && number_2.is_roman) {
                    result = calc.calculate(number_1.value, number_2.value, input.operation);

                } else {
                    System.out.println("Используются одновременно разные системы счисления");
                }


            } else {
                System.out.println("Неизвестный формат.");
            }

        }












    }
}
