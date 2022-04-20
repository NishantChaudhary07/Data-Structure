package Assignment2;

import java.util.Scanner;

class Solution5 {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    static Node head=null;
    void insert(int data){
        Node new_node=new Node(data);
        if(head==null)
            head=new_node;
        else{
            Node temp=head;
            while(temp.next!=null)
                temp=temp.next;
            temp.next=new_node;
        }
    }

    void reverse(Node head){
        if(head==null);
        else {
            reverse(head.next);
            System.out.println(head.data);
        }
    }
}

public class Question5 {
    public static void main(String[] args) {
        Solution5 obj=new Solution5();
        Scanner sc=new Scanner(System.in);
        while(true){
            int ele=sc.nextInt();
            if(ele==-1)
                break;
            else
                obj.insert(ele);
        }
        obj.reverse(Solution5.head);
    }
}
