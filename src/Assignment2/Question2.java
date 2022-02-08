package Assignment2;
//Q.Design a method that returns true if element n is a member of given array  and false if not  by using the recursion
import java.util.*;
class Solution2{
       boolean isMember(int n,int []arr,int size){
           if(size==-1)
               return false;
           if(arr[size]==n)
               return true;
           else
               return isMember(n,arr,size-1);
       }
}
public class Question2 {
    public static void main(String[] args) {
        Solution2 obj=new Solution2();
        Scanner sc=new  Scanner(System.in);
        System.out.println("Enter array size:");
        int size=sc.nextInt();
        int arr[]=new int[size];
        System.out.println("Enter array elements:");
        for(int i=0;i<size;i++)
            arr[i]= sc.nextInt();
        System.out.println("Enter the element to be searched:");
        int n= sc.nextInt();
        System.out.println(obj.isMember(n,arr, arr.length-1));
    }
}
