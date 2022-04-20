package LearningQueue;

import java.util.Scanner;

class CircularQ{
    int arr[];
    int front;
    int rear;
    CircularQ(int size){
        arr=new int[size];
        front=rear=-1;
    }

    void insertion(int element){
        if(front==-1 && rear==-1){
            front=rear=0;
            arr[rear]=element;
        }
        else if((front==0 && rear==arr.length-1) || (rear==front-1) ) {
            System.out.println("Queue is full");
        }
        else if(rear==arr.length-1 && front>0){
            rear=0;
            arr[rear]=element;
        }

        else{
            rear++;
            arr[rear]=element;
        }
    }

    int delete(){
        int del=0;
        if(front==-1 && rear==-1)
            System.out.println("Queue is empty");
        else if(front==rear && front!=-1){
            del=arr[front];
            arr[front]=0;
            front=rear=-1;
            System.out.println("Queue is empty");
        }
        else if(front==arr.length && rear<front){
            front=0;
        }
        else{
            del=arr[front];
            arr[front]=0;
            front++;
        }
        return del;
    }

    void display(){
        if(front==-1 && rear==-1)
            System.out.println("No element to display:");
        else {
            for (int i = front; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
            for (int i = 0; i < front; i++) {
                System.out.println(arr[i]);
            }
        }
    }
}
public class CircularQueue {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of Queue:");
        int size=sc.nextInt();
        CircularQ obj=new CircularQ(size);
        while(true){
            System.out.println("Enter:\n0.To exit\n1.To insert\n2.To delete");
            int choice=sc.nextInt();
            switch (choice){
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Enter the element to be inserted:");
                    int ele=sc.nextInt();
                    obj.insertion(ele);
                    System.out.println("Updated Queue:");
                    obj.display();
                    break;
                case 2:
                    int n=obj.delete();
                    System.out.println("Deleted element:"+n);
                    System.out.println("Updated Queue");
                    obj.display();
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}
