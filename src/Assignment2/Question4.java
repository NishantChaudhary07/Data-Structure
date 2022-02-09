package Assignment2;
/*For a given singly linked list of integers, find and return the node present at the middle of the list
* Sample Input 1 :
1
1 2 3 4 5 -1
Sample Output 1 :
3
Sample Input 2 :
2
-1
1 2 3 4 -1
Sample Output 2 :
2*/
import java.util.Scanner;

class Solution4{
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

    int countNode(Node head){
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    int elementAtPos(int Pos){
        Node temp=head;
        while(Pos>0){
            temp=temp.next;
            Pos--;
        }
        return temp.data;
    }
}
public class Question4 {
    public static void main(String[] args) {
        Solution4 obj=new Solution4();
        Scanner sc=new Scanner(System.in);
        System.out.println("Input:");
        //Number of test cases
        int t=sc.nextInt();
        int arr[]=new int[t];
        for(int i=0;i<t;i++){
            while(true){
                int ele= sc.nextInt();
                if(ele==-1)
                    break;
                else {
                    obj.insert(ele);
                }
            }
            int half_count= (obj.countNode(Solution4.head)-1)/2;
            if(half_count<=0)
                arr[i]=-1;
            else
                arr[i]=obj.elementAtPos(half_count);
        }
        System.out.println("Output:");
        for(int i:arr)
            if(i==-1)
                System.out.println("");
            else
                System.out.println(i);
    }
}
