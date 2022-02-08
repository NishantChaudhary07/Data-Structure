package Assignment2;
//Q. Write a recursive function to convert a decimal number into a binary number, print the binary number.
import java.util.*;
class  Solution1{
    //Using String function
    /*String decimalToBinary(int num) {
        if (num == 0)
            return "0";
        else {
            if (num == 1)
                return "1";
            else
                return decimalToBinary(num / 2) + num % 2;
        }
    }*/
    //Using Integer function
   int decimalToBinary(int num){
        if(num==0)
            return 0;
        else
            return num%2+10*decimalToBinary(num/2);
    }
}
public class Question1{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Solution1 obj=new Solution1();
        System.out.println("Enter the decimal number to be converted to binary:");
        int num=sc.nextInt();
        System.out.println(obj.decimalToBinary(num));
    }
}