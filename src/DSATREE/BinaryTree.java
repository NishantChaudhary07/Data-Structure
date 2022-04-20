package DSATREE;

import java.util.*;
class Node{
    int data;
    Node right;
    Node left;
    Node(int data){
        this.data=data;
    }
}
public class BinaryTree {
    static Node insert(){
        Node root=null;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter data");
        int data=sc.nextInt();
        if(data==-1)
            return null;
        root=new Node(data);
        System.out.print("Enter data to the left of "+data);
        root.left=insert();
        System.out.print("Enter data to the right of "+data);
        root.right=insert();
        return root;
    }

    public static void main(String args[]){
        insert();
    }
}

