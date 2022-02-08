package Assignment2;

import java.util.Scanner;

/*Q. In a sorted linked list(elements are sorted in ascending order), eliminate duplicates from the given linked list,
        such that output linked list contains only unique elements.*/
class Solution3{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    Node head=null;
    void insert(int data)
    {
        Node new_node=new Node(data);
        if(head==null)
            head=new_node;
        else{
            Node temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=new_node;
        }
    }

    void removeDuplicate(){
      Node temp=head;
      while(temp.next!=null){
          if(temp.data==temp.next.data) {
              temp.next = temp.next.next;
          }
          else{
              temp=temp.next;
          }
      }
    }

    void print(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}
public class Question3
{
    public static void main(String[] args) {
        Solution3 obj=new Solution3();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of elements:");
        int n=sc.nextInt();
        System.out.println("Enter elements sorted in ascending order:");
        for(int i=0;i<n;i++){
            obj.insert(sc.nextInt());
        }
        System.out.println("Data after removing duplicates:");
        obj.removeDuplicate();
        obj.print();
    }
}
