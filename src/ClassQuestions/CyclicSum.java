package ClassQuestions;
import java.util.*;
class Queue{
class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
    }
}
    Node front,rear;

    void insert(String data){
        Node new_node=new Node(data);
    if(front==null && rear==null){
        front=rear=new_node;
    }
    else{
        rear.next=new_node;
        rear=rear.next;
    }
    }

    void print() {
        if (front == null && rear == null)
            System.out.println("No data.");
        else {
            while (front!= null) {
                System.out.println(front.data);
                front = front.next;
            }
        }
    }
}

public class CyclicSum{
    public static void main(String[] args) {
        Queue obj=new Queue();
        int size=args.length;
        if(size>3)
            System.out.println("Size should be less than 3");
        else{
            int sum=0;
            for(int i=0;i<size;i++){
                String str=args[i];
                sum=0;
                for(int j=0;j<str.length();j++){
                    for(int k=j;k<str.length();k++){
                        sum+=Integer.parseInt(String.valueOf(str.charAt(k)));
                    }
                }
                String res=Integer.toString(sum);
                obj.insert(res);
            }
            obj.print();
        }

    }
}

