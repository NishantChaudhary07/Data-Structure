package LearnStack;

import java.util.*;
class StackDemo{
    int arr[];
    int top;
    StackDemo(){
        arr=new int[5];
        top=-1;
    }
    void push(int ele){
        if(top<arr.length){
            top++;
            arr[top]=ele;
        }
        else{
            System.out.println("Stack is full");
        }
    }
    void pop(){
        if(top>-1){
            System.out.println(arr[top]);
            top--;
        }
        else
            System.out.println("Stack is empty");
    }
    void view(){
        if(top==-1)
        {
            System.out.println("Stack is empty/Underlow");
        }
        else{
            System.out.println("Stack elements");
            for(int i=top;i>=0;i--){
                System.out.println(arr[i]);
            }
        }
    }
}
public class StackImplementation
{
    public static void main(String[] args) {
        StackDemo obj=new StackDemo();
        while(true){
            System.out.println("\n Enter 1 for push");
            System.out.println("Enter 2 for pop");
            System.out.println("Enter 3 for display");
            System.out.println("Enter 4 for exit");
            System.out.println("Enter your choice");
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter the element");
                    //Scanner sc=new Scanner(System.in);
                    int ele=sc.nextInt();
                    obj.push(ele);
                    break;
                case 2:
                    obj.pop();
                    break;
                case 3:
                    obj.view();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Choice");

            }
        }
    }
}