package LearningGraph;

import java.util.*;

public class Graph {
    HashMap<Integer, List<Integer>> obj;
    public Graph(){
        obj=new HashMap<>();
    }

    public void addEdge(int source,int desti,boolean isbidirection)
    {
        List<Integer> sourceneighbour=obj.getOrDefault(source,new ArrayList<>());
        sourceneighbour.add(desti);
        obj.put(source,sourceneighbour);
        if(isbidirection){
            List<Integer> destineighbour=obj.getOrDefault(desti,new ArrayList<>());
            destineighbour.add(source);
            obj.put(desti,destineighbour);
        }
    }

    public void BFS(int val){
        Queue<Integer> q=new LinkedList<>();
        q.add(val);
        Set<Integer> vis=new HashSet<>();
        vis.add(val);
        while(!q.isEmpty()){
            int curr=q.poll();
            System.out.print(curr+" ");
            List<Integer> neighbour=obj.get(curr);
            for(int i:neighbour){
                if(!vis.contains(i)){
                    vis.add(i);
                    q.add(i);
                }
            }
        }
    }

    public void DFS(int val){
        Set<Integer> vis=new HashSet<>();
        DfsHelper(val,vis);
    }
    public void DfsHelper(int source,Set<Integer> vis){
        System.out.print(source+" ");
        vis.add(source);
        List<Integer> neighbourlst=obj.get(source);
        for(int neighbour:neighbourlst){
            if(!vis.contains(neighbour)){
                DfsHelper(neighbour,vis);
            }
        }
    }

    public void display(){
        for(Map.Entry<Integer,List<Integer>> entry:obj.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static void main(String[] args) {
        Graph obj=new Graph();
        obj.addEdge(1,2,true);
        obj.addEdge(1,4,true);
        obj.addEdge(2,3,true);
        obj.addEdge(3,4,true);
        obj.addEdge(3,5,true);
        obj.addEdge(5,6,true);
        System.out.println("Graph Details");
        obj.display();
        System.out.println("BFS");
        obj.BFS(2);
        System.out.println("\nDFS");
        obj.DFS(2);
    }
}
