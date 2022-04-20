package DSATREE;

import java.util.*;

public class BST {
    static Node insert(Node root,int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left =insert(root.left, data);
        }
        else {
            root.right=insert(root.right, data);
        }
        return root;
    }

    static void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    static void preorder(Node root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        inorder(root.left);
        inorder(root.right);
    }
    static void postorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data+" ");
    }

    static void searching(Node root,int val){
        if(root==null){
            System.out.println("Element not found");
        }
        else if(root.data==val)
            System.out.println("Element found.");
        else if(val<root.data)
            searching(root.left,val);
        else
            searching(root.right,val);
    }

    static int successor(Node root){
        if(root.left==null)
            return root.data;
        else
            return successor(root.left);
    }

    static Node deleteNode(Node root,int val){
        if(root==null)
            return null;
        if(val<root.data)
            root.left=deleteNode(root.left,val);
        else if(val>root.data)
            root.right=deleteNode(root.right,val);
        else{
            if(root.left==null && root.right==null)
                return null;
            else if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            else{
                int succ=successor(root.right);
                root.data=succ;
                root.right=deleteNode(root.right,succ);
            }
        }
        return root;
    }

    static int height(Node root){
        if(root==null)
            return -1;
        int lheight=height(root.left);
        //System.out.println(lheight);
        int rheight=height(root.right);
        if(lheight>rheight)
            return lheight+1;
        else
            return rheight+1;
    }

    static void levelOrderTraversal(Node root){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if (curr == null) {
                if (q.isEmpty())
                    return;
                q.add(null);
                System.out.println();
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
    }

    static class Nodedist{
        Node node;
        int dist;
        public Nodedist(Node node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    static void topView(Node root){
        Queue<Nodedist> q=new LinkedList<Nodedist>();
        Map<Integer,Integer> topviewMap=new TreeMap<Integer, Integer>();
        q.add(new Nodedist(root,0));
        while(!q.isEmpty()) {
            Nodedist curr = q.poll();
            if (curr == null) {
                return;
            } else {
                if(!topviewMap.containsKey(curr.dist))
                    topviewMap.put(curr.dist,curr.node.data);
                if (curr.node.left != null)
                    q.add(new Nodedist(curr.node.left,curr.dist-1));
                if (curr.node.right != null)
                    q.add(new Nodedist(curr.node.right,curr.dist+1));
            }
        }
        for(Integer key:topviewMap.keySet()){
            System.out.print(topviewMap.get(key)+" ");
        }
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

        System.out.println("\nPreorder:");
        preorder(root);

        System.out.println("\nPostorder:");
        postorder(root);

        searching(root,30);

        System.out.println("Height of tree "+height(root));

        System.out.println("Level traversel");
        levelOrderTraversal(root);

        System.out.println("\nTop view");
        topView(root);

        deleteNode(root,80);
        System.out.println("\nInorder:");
        inorder(root);
    }
}

