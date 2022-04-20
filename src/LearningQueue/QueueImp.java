package LearningQueue;

import java.util.Scanner;

class QueueL{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    Node rear=null,front=null;
    void insertion(int data){
        Node new_node=new Node(data);
        if(front==null && rear==null)
            front=rear=new_node;
            else{
                rear.next=new_node;
                rear=rear.next;
            }
        }

        void delete() {
            if (front == null && rear == null)
                System.out.println("Queue is empty.");

            else {
                front = front.next;
                if (front == null) {
                    rear = null;
                }
            }
        }

        void print(){
           if(front==null && rear==null)
               System.out.println("Queue is empty.");
           else{
               Node temp=front;
               while(temp!=null){
                   System.out.println(temp.data);
                   temp=temp.next;
               }
           }
        }
    }

public class QueueImp {
    public static void main(String[] args) {
        QueueL obj = new QueueL();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter\n1.To insert.\n2.To delete\n and 0 to exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter element:");
                    obj.insertion(sc.nextInt());
                    obj.print();
                    break;
                case 2:
                    obj.delete();
                    obj.print();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}


