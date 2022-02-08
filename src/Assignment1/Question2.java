package Assignment1;
//To Count the length of Linked List
/*
  Sample Input:
  2
  10 76 39 -3 2 9 -23 9 -1
  -1
  Sample Output:
  8
  0
 */
import java.util.Scanner;

class Solution2{
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node head=null;
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

    String countNode(Node head){
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count+"";
    }
    void clear(){
        head=null;
    }
}
public class Question2 {
    public static void main(String[] args) {
        Solution2 obj = new Solution2();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input");
        //System.out.println("Enter number of test cases");
        int t = sc.nextInt();
        String arr[] = new String[t];
        for (int i = 0; i < t; i++) {
            while (true) {
                int ele = sc.nextInt();
                if (ele == -1)
                    break;
                else
                    obj.insertion(ele);
            }

            //System.out.println("List");
            //obj.print();
            //System.out.println("Res");
            arr[i] = obj.countNode(Solution2.head);
            obj.clear();
        }
        System.out.println("Output");
        for (String i : arr) {
            System.out.println(i);
        }
    }
}