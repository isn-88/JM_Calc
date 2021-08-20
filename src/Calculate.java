public class Calculate {

    // Сложение
    int addition(int a, int b) {
        return a + b;
    }

    // Вычитание
    int subtraction(int a, int b) {
        return a - b;
    }

    // Умножение
    int multiplication(int a, int b) {
        return a * b;
    }

    // Деление
    int division(int a, int b) {
        return a / b;
    }



    int calculate(int a,int b, String operations) {
        int result=0;
        switch (operations) {
            case "+":
                result = addition(a, b);
                break;

            case "-":
                result = subtraction(a, b);
                break;

            case "*":
                result = multiplication(a, b);
                break;

            case "/":
                result = division(a, b);
                break;

            default:
                System.out.println("Введена недопустимая математическая операция.");
                break;
        }
        return result;
    }




}
