package LearningLinkedList;
import java.util.*;
class LinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    int countNode(Node head){
        int count=0;
        if(head==null)
            count=0;
        else{
            Node temp=head;
            while(temp!=null){
                temp=temp.next;
                count++;
            }
        }
        return count;
    }

    void insertBeginning(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
        } else {
            new_node.next = head;
            head = new_node;
        }
    }

    void insertInMiddle(int position,int data)
    {
        Node new_node=new Node(data);
        if(head==null)
            head=new_node;
        else if(position==1)
            insertBeginning(data);
        else if(position>countNode(head) || position==0)
            System.out.println("Enter a valid position");
        else {
            Node temp = head;
            while (position > 2) {
                temp = temp.next;
                position--;
            }
            new_node.next = temp.next;
            temp.next = new_node;
        }
    }
    void insertEnd(int data){
        Node new_node=new Node(data);
        if(head==null){
            head=new_node;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=new_node;
        }
    }

    void deleteFront(){
        if(head==null){
            System.out.println("Linked list is empty. No element to delete");
        }
        else{
            head=head.next;
        }
    }

    void deleteEnd(){
        if(head==null)
            System.out.println("Linked list is empty. No element to delete");
        else if(head.next==null){
            head=head.next;
        }
        else{
            Node ptr=head;
            Node nptr=ptr.next;
            while(nptr.next!=null){
                ptr=nptr;
                nptr=nptr.next;
            }
            ptr.next=null;
        }
    }

    void deletePos(int position){
        if(head==null)
            System.out.println("Linked list empty. No element to delete");
        else if(position==1)
            deleteFront();
        else if(countNode(head)<position) {
            System.out.println("Position greater than Linked list length.");
        }
        else{
             Node previous=null,current=head;
             //Node nptr=ptr.next;
             while(position>1){
                 previous=current;
                 current=current.next;
                 position--;
             }
             previous.next=current.next;
        }
    }
    void print() {
        if(head==null)
            System.out.println("Linked list id empty. No data to display.");
        else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
}


public class LinkedListImp {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        LinkedList obj=new LinkedList();

        while(true){
            System.out.println("1. To insert at beginning\n2. To insert at end\n3. To insert in middle" +
                    "\n4.To delete from front\n5.To delete from end\n6.To delete from given position\n0. To exit");
            int n=sc.nextInt();
        switch(n) {
            case 1:
                System.out.println("Enter the value to be inserted:");
                int value = sc.nextInt();
                obj.insertBeginning(value);
                System.out.println("Data after insertion:");
                obj.print();
                break;
            case 2:
                System.out.println("Enter the value to be inserted:");
                int value1 = sc.nextInt();
                obj.insertEnd(value1);
                System.out.println("Data after insertion:");
                obj.print();
                break;
            case 3:
                System.out.println("Enter the position to be inserted:");
                int pos= sc.nextInt();
                System.out.println("Enter the value to be inserted:");
                int val=sc.nextInt();
                obj.insertInMiddle(pos,val);
                System.out.println("Data after insertion:");
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
                int position=sc.nextInt();
                obj.deletePos(position);
                System.out.println("Updated data:");
                obj.print();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Wrong Choice");
        }
        }
    }
}
