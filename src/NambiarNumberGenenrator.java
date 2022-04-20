import java.util.*;
import java.lang.String;
public class NambiarNumberGenenrator {
    public static int numbiarNumber(String input1) {
        String res = "";
        int startpos = 0;
        //String input1=Integer.toString(input2);
        while (true) {
            if (startpos == input1.length()) {
                break;
            } else {
                int sum = 0;
                if (Character.getNumericValue(input1.charAt(startpos)) % 2 == 0) {
                    sum = Character.getNumericValue(input1.charAt(startpos));
                    startpos++;
                    while (sum % 2 == 0) {
                        if (startpos == input1.length())
                            break;
                        sum += Character.getNumericValue(input1.charAt(startpos));
                        startpos++;
                    }
                } else {
                    sum = Character.getNumericValue(input1.charAt(startpos));
                    startpos++;
                    while (sum % 2 != 0 || startpos == input1.length()) {
                        if (startpos == input1.length())
                            break;
                        sum += Character.getNumericValue(input1.charAt(startpos));
                        startpos++;
                    }
                }
                res = res + sum;
            }
        }
        return Integer.parseInt(res);

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        String num=sc.next();
        System.out.println(numbiarNumber(num));
    }
}
