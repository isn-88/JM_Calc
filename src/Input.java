import java.util.Scanner;
public class Input {

    String textInput = "";
    String[] elements;
    DataType[] type;

    void getInput() {
        Scanner s = new Scanner(System.in);
        textInput = s.nextLine();
    }

    void splitInput() {
        elements = textInput.split(" ");
    }

    boolean checkInput() {
        boolean result = false;
        if (elements.length  == 3) {
            type = new DataType[elements.length];
            setDataType();
            if(checkMath(elements[1])) {
                result = true;
            } else {
                System.out.println("Некорректная математическая операция.");
            }
        } else if (elements.length < 3) {
            System.out.println("Введено слишком мало данных.");
            System.out.println("Пример ввода арифметической операции: 2 * 2 или V + III");
        } else {
            System.out.println("Введено слишком много данных.");
            System.out.println("Пример ввода арифметической операции: 2 * 2 или V + III");
        }
        return result;
    }

    boolean checkMath(String operation) {
        return operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/");
    }

    void setDataType() {
        for (int i = 0; i < type.length; i++) {
            if (elements[i].matches("-?[0-9]+")) {
                type[i] = DataType.NUMBER;
            } else if (elements[i].matches("[IVXLCDM.]+")) {
                type[i] = DataType.ROMAN;
            } else if (elements[i].matches("[-+*/.]+")) {
                type[i] = DataType.MATH;
            } else {
                type[i] = DataType.UNKNOWN;
            }
        }
    }
}
