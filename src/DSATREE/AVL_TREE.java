package DSATREE;

public class AVL_TREE{
    static class Node{
        int data;
        Node left;
        Node right;
        int height;
        int bfac;
        Node(int data){
            this.data=data;
        }
    }
    public static Node rightRotate(Node A){
        Node B=A.left;
        Node Bright=B.right;
        B.right=A;
        A.left=Bright;
        updateHeightndBalance(A);
        updateHeightndBalance(B);
        return B;
    }
    public static Node leftRotate(Node A){
        Node B=A.right;
        Node Bleft=B.left;
        B.left=A;
        A.right=Bleft;
        updateHeightndBalance(A);
        updateHeightndBalance(B);
        return B;
    }
    public static void updateHeightndBalance(Node root){
        int rh=-1,lh=-1;
        if(root.left!=null)
            lh=root.left.height;
        if(root.right!=null)
            rh=root.right.height;
        root.bfac=lh-rh;
        root.height=Math.max(lh,rh+1);
    }
    public static Node getRotation(Node node){
        updateHeightndBalance(node);
        if(node.bfac==2){
            if(node.left.bfac==1){
                return rightRotate(node);
            }
            else{
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(node.bfac==-2)
        {
            if(node.right.bfac==-1)
            {
                return leftRotate(node.right);
            }
            else{
                node.right=rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    public static Node insert(Node root,int val){
        if(root==null)
        {
            root=new Node(val);
            return root;
        }
        else if(val<root.data){
             root.left=insert(root.left,val);
            }
        else if(val>root.data)
        {
            root.right=insert(root.right,val);
        }
        root=getRotation(root);
        return root;
    }
    static void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root=insert(null,50);
        insert(root,30);
        insert(root,80);
        insert(root,70);
        insert(root,40);
        insert(root,10);
        System.out.println("Inorder:");
        inorder(root);
    }
}
