package LearningLinkedList;

import java.util.Scanner;

class DoublyLL {
    class Node {
        int data;
        Node previous;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;

    int countNode(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    void insertFront(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
        } else {
            new_node.next = head;
            head.previous = new_node;
            head = new_node;
        }
    }

    void insertEnd(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            new_node.previous = temp;
            temp.next = new_node;
        }
    }

    void insertAtPos(int position, int data) {
        Node new_node = new Node(data);
        Node temp = head;
        if (position == 1)
            insertFront(data);
        else if (position == countNode(temp) + 1)
            insertEnd(data);
        else if (position > countNode(temp)) {
            System.out.println("Position greater than LinkedList length");
        } else {
            while (position > 2) {
                temp = temp.next;
                position--;
            }
            new_node.next = temp.next;
            new_node.previous = temp;
            temp.next = new_node;
            temp.next.previous = new_node;
        }
    }

    void deleteFront() {
        if (head == null)
            System.out.println("List is empty.Nothing to delete.");
        else {
            head.previous = null;
            head = head.next;
        }
    }

    void deleteEnd(){
        if(head==null){
            System.out.println("List is empty.Nothing to delete.");
        }
        else if(countNode(head)==1)
            deleteFront();
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.previous.next=null;
        }
    }

    void deleteAtPos(int Position){
        if(head==null)
            System.out.println("Empty.No element to display.");
        else if(Position==1)
            deleteFront();
        else if(countNode(head)==Position)
            deleteEnd();
        else if(Position>countNode(head))
            System.out.println("Position greater than LinkedList length");
        else{
            Node temp=head;
            while(Position>1){
                temp=temp.next;
                Position--;
            }
            temp.previous.next=temp.next;
            temp.next.previous=temp.previous;
        }
    }
    void print() {
        if (head == null) {
            System.out.println("Empty.No element to display.");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
}
   /* void printReverse(){
        System.out.println("Reverse");
        if(head==null){
            System.out.println("Empty.No element to display.");
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        while(temp.previous!=null){
            System.out.println(temp.data);
            temp=temp.previous;
        }
        System.out.println(temp.data);
    }
}
*/
public class DoublyLinkedList {
       public static void main(String[] args) {
           DoublyLL obj = new DoublyLL();
           Scanner sc = new Scanner(System.in);
           while (true) {
               System.out.println("Enter \n1.To insert at front \n2.To insert at End\n3.To insert at specific position" +
                       "\n4.To delete element from front\n5.To delete from end\n6.To delete from given position\n0.To exit");
               int n = sc.nextInt();
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
                       obj.insertAtPos(pos, val2);
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
                    obj.deleteAtPos(position);
                    System.out.println("Updated data:");
                    obj.print();
                    break;
                   default:
                       System.out.println("Wrong choice");
               }
               // obj.printReverse();
           }
       }
   }



