package LearningLinkedList;

import java.util.Scanner;

class CircularLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    int countNode(Node head) {
        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;

        }
        while (temp!=head);
        return count;
    }


    void insertFront(int data){
        Node new_node=new Node(data);
        if(head==null){
            head=new_node;
            tail=new_node;
            new_node.next=head;
        }
        else{
            new_node.next=head;
            head=new_node;
            tail.next=head;
        }
    }

    void insertInMiddle(int position,int data) {
        Node new_node = new Node(data);
        Node temp = head;
        if (position == 1)
            insertFront(data);
        else if(position==countNode(temp)+1)
            insertEnd(data);
        else if(position>countNode(temp)){
            System.out.println("Position greater than LinkedList length");
        }
        else {
            while (position > 2) {
                temp = temp.next;
                position--;
            }
            new_node.next = temp.next;
            temp.next = new_node;
        }
    }
    void insertEnd(int data) {
        Node new_node = new Node(data);
        if (head==null) {
            head=new_node;
            tail=new_node;
            new_node.next = head;
        }
        else {
                tail.next=new_node;
                tail=new_node;
                new_node.next=head;
            }
        }

        void deleteFront(){
        if(head==tail) {
            head=tail=null;
            System.out.println("Circular Linked List is empty. No element to delete.");
        }
        else{
            head=head.next;
            tail.next=head;
        }
        }

        void deleteEnd(){
            if(head==tail) {
                head=tail=null;
                System.out.println("Circular Linked List is empty. No element to delete.");
            }
            else{
                Node temp=head;
                while(temp.next!=tail){
                    temp=temp.next;
                }
              temp.next=head;
                tail=temp;
            }
        }

        void deletePos(int Position){
           if(Position==1)
               deleteFront();
           else if(Position==countNode(head))
               deleteEnd();
           else if(Position>countNode(head))
               System.out.println("Position greater than LinkedList length");
           else{
               Node previous=null,current=head;
               while(Position>1){
                   previous=current;
                   current=current.next;
                   Position--;
               }
               previous.next=current.next;
           }
        }

    void print(){
        if(head==null){
            System.out.println("Circular Linked List is empty.");
        }
        else{
            Node temp=head;
            do{
                System.out.println(temp.data);
                temp=temp.next;
            }
            while(temp!=head);
        }
    }
}

public class CircularLinkedList {
    public static void main(String[] args) {
        CircularLL obj=new CircularLL();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Enter \n1.To insert at front \n2.To insert at End\n3.To insert at specific position" +
                    "\n4.To delete element from front\n5.To delete from end\n6.To delete from given position\n0.To exit");
            int n= sc.nextInt();
            switch (n) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Enter the value to be inserted:");
                    int val = sc.nextInt();
                    obj.insertFront(val);
                    System.out.println("Updated data:");
                    obj.print();
                    break;
                case 2:
                    System.out.println("Enter the value to be inserted:");
                    int val1 = sc.nextInt();
                    obj.insertEnd(val1);
                    System.out.println("Updated data:");
                    obj.print();
                    break;
                case 3:
                    System.out.println("Enter the postion:");
                    int pos = sc.nextInt();
                    System.out.println("Enter the Value to be inserted:");
                    int val2 = sc.nextInt();
                    obj.insertInMiddle(pos, val2);
                    System.out.println("Updated data:");
                    obj.print();
                    break;
                case 4:
                    obj.deleteFront();
                    System.out.println("Updated data:");
                    obj.print();
                    break;
                case 5:
                    obj.deleteEnd();
                    System.out.println("Updated data:");
                    obj.print();
                    break;
                case 6:
                    System.out.println("Enter the position to be deleted:");
                    int position = sc.nextInt();
                    obj.deletePos(position);
                    System.out.println("Updated data:");
                    obj.print();
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}
