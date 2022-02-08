package Assignment1;
//To print element at ith index with index starting from 0.
/*
Sample Input:
3
2 1 3 5 7 -1
0
12 21 13 14 -1
3
87 95 48 59 -1
5
Sample Output:
1
14

 */
import java.util.Scanner;

class Solution1{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    Node head=null;
    void insertion(int data){
        Node new_node=new Node(data);
        if(head==null)
            head=new_node;
        else {
            Node temp = head;
            while (temp.next!= null) {
                temp = temp.next;
            }
            temp.next = new_node;
        }
    }

    int countNode(Node head){
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    void print(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    String elementAtPos(int Position){
        String res="";
          if(Position>countNode(head)-1)
              res="";
          else{
              Node temp=head;
              while(Position>0){
                  temp=temp.next;
                  Position--;
              }
              res+=temp.data;
          }
        return res;
    }
    void clear(){
        head=null;
    }
}

public class Question1 {
    public static void main(String[] args) {
        Solution1 obj=new Solution1();
        Scanner sc=new Scanner(System.in);
        System.out.println("Input");
        //System.out.println("Enter number of test cases");
        int t= sc.nextInt();
        String arr[]=new String[t];

        for(int i=0;i<t;i++){
            while(true){
                int ele=sc.nextInt();
                if(ele==-1)
                    break;
                else
                  obj.insertion(ele);
            }

            //System.out.println("List");
            //obj.print();
            //System.out.println("Enter index");
            int Pos=sc.nextInt();
            //System.out.println("Res");
            arr[i]=obj.elementAtPos(Pos);
            obj.clear();
        }
        System.out.println("Output");
        for(String i:arr){
            System.out.println(i);
        }
    }
}
