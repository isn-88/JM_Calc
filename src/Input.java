import java.util.Scanner;
public class Input {

    String text = "";
    String[] elements;
    String str_num_1, str_num_2;
    String operation;


    void getInput() {
        Scanner s = new Scanner(System.in);
        text = s.nextLine();
    }

    void splitInput() {
        elements = text.split(" ");
    }


    boolean checkInput() {
        // Проверка на количество полученных элементов
        if(elements.length == 3) {
            str_num_1 = elements[0];
            operation = elements[1];
            str_num_2 = elements[2];
        } else if (elements.length < 3) {
            System.out.println("Арифметическая операция слишком короткая.");
            return false;
        } else if (elements.length > 3) {
            System.out.println("Арифметическая операция слишком длинная. ");
            return false;
        }
        return true;
    }
}
