public class CheckNumber {

    int value = 0;
    boolean is_arabic = false;
    boolean is_roman = false;
    boolean is_correct = false;

    RomanNum roman = new RomanNum();


    int checkNumber(String s_num) {
        if (s_num.matches("[0-9.]+")) {
            value = Integer.valueOf(s_num);
            is_arabic = true;
            is_roman = false;
            is_correct = true;
        } else if (s_num.matches("[IVX.]+")) {
            value = roman.RomanToArabic(s_num);
            if (value > 0)  {
                is_arabic = false;
                is_roman=true;
                is_correct=true;
            }
        } else {
            is_correct = false;
        }
        return value;
    }







}
