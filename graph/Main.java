package com.company;

import com.sun.jmx.remote.internal.ArrayQueue;


import java.util.ArrayDeque;
import java.util.Set;
import java.util.Queue;

public class Main {
    //__________________________________________________ Graph ADT  _______________________________________

    public interface Graph {

        public void Init(int n);

        public int n();

        public int e();

        public int first(int v);

        public int next(int v, int w);

        public void setEdge(int i, int j, int wght);

        public void delEdge(int i, int j);

        public boolean isEdge(int i, int j);

        public int weight(int i, int j);

        public void setMark(int v, int val);

        public int getMark(int v);
    }
    //_____________________________________________________________________________________________________________

    // _____________________________________________________ Graph: Adjacency matrix _______________________________

    class Graphm implements Graph {
        private int[][] matrix; // The edge matrix
        private int numEdge; // Number of edges
        private int[] Mark; // The mark array
        public Graphm() {} // Constructors
        public Graphm(int n) {
            Init(n);
        }

        public void Init(int n) {
            Mark = new int[n];
            matrix = new int[n][n];
            numEdge = 0;
        }
        public int n() { return Mark.length; }
        public int e() { return numEdge; }

        public int first(int v) {
            for(int i=0;i<Mark.length;i++){
                if (matrix[v][i]!=0) return i;}
            return Mark.length;
        }


        public int next(int v, int w) {
            for (int i=w+1; i<Mark.length; i++)
                if (matrix[v][i] != 0)
                    return i;
            return Mark.length;
        }

        public void setEdge(int i, int j, int wt) {
            assert wt!=0 : "Cannot set weight to 0";
            if (matrix[i][j] == 0) numEdge++;
            matrix[i][j] = wt;
        }

        public void delEdge(int i, int j) { // Delete edge (i, j)
            if (matrix[i][j] != 0) numEdge--;
            matrix[i][j] = 0;
        }

        public boolean isEdge(int i, int j)
        { return matrix[i][j] != 0; }


        public int weight(int i, int j) {
            return matrix[i][j];
        }
        public void setMark(int v, int val) { Mark[v] = val; }
        public int getMark(int v) { return Mark[v]; }
    }
    //____________________________________________________________________________________________________________

    // _____________________________________________________ Graph: Adjacency list  _______________________________

    /** Edge class for Adjacency List graph representation */
    class Edge {
        private int vert, wt;
        public Edge(int v, int w) // Constructor
        { vert = v; wt = w; }
        public int vertex() { return vert; }
        public int weight() { return wt; }
    }

    class Graphl implements Graph{
        private GraphList[] vertex;
        private int numEdge;
        private int[] Mark;
        public  Graphl(){}
        public Graphl(int n)
        {Init(n);}

        public void Init(int n){

            Mark=new int[n];
            vertex=new GraphList[n];
            for (int i=0;i<n;i++)
                vertex[i]=new GraphList();
            numEdge=0;
        }
        public int n(){return Mark.length;}
        public int e(){return numEdge;}
        public int first(int v){
            if (vertex[v].length()==0) return Mark.length;
            vertex[v].moveToStart();
            Edge it =vertex[v].getvalue();
            return it.vertex();
        }
        public int next(int v, int w){
            Edge it=null;
            if (isEdge(v,w)){
                vertex[v].next();
                it=vertex[v].getValue();
            }
            if (it!=null)
                return it.vertex();
            return Mark.length;
        }
        public void setEdge(int i, int j,int weight){
            assert weight!=0 : "the weight cant be zero";
            Edge it=new Edge(j,weight);
            if (isEdge(i,j)){
                vertex[i].remove();
                vertex[i].insert(it);

            }
            else {
                numEdge++;
                for (vertex[i].moveToStart();vertex[i].currPos()<vertex[i].length();vertex[i].next())
                    if (vertex[i].getValue().vertex()>j)
                        break;
                vertex[i].insert(it);
            }

        }
        public void delEdge(int i , int j){
            if (isEdge(i,j)) {vertex[i].remove();numEdge--;}



        }
        public boolean isEdge(int v , int w){
            for(vertex[v].moveToStart();vertex[v].currPos()<vertex[i].length;vertex[i].next())
                if (vertex[v].getValue.vertex()==w){
                    return true;}
            return false;

        }

        public int weight(int i , int j){

            if (isEdge(i,j))
                return vertex[i].getValue.weight();
            return 0;
        }

        public void setMark(int v, int val){Mark[v]=val;}
        public int getMark(int v){return Mark[v];}


    }
 //______________________________________________________________________________________________

//_________________________________________________ Traverse ___________________________________________________

    void graphTraverse(Graph G) {
        int v;
        for (v=0; v<G.n(); v++)
            G.setMark(v, UNVISITED); // Initialize
        for (v=0; v<G.n(); v++)
            if (G.getMark(v) == UNVISITED)
                doTraverse(G, v);
    }


    /** Depth first search */
    static void DFS(Graph G, int v) {
        PreVisit(G, v); // Take appropriate action
        G.setMark(v, VISITED);
        for (int w = G.first(v); w < G.n() ; w = G.next(v, w))
            if (G.getMark(w) == UNVISITED)
                DFS(G, w);
        PostVisit(G, v); // Take appropriate action
    }

    static void BFS(Graph G, int start){
        Queue<Integer> myqueue=new ArrayDeque<>(G.n());
        myqueue.enqueue(start);
        G.setMark(start,VISITED);
        while(myqueue.length>0){

            int y = Q.dequeue();
            preVisit(G,start);
            for(int w=G.first(start);w<G.n();w=G.next(start,w))
                if (G.getMark(w)==UNVISITED){
                    G.setMark(w,VISITED);
                    myqueue.enqueue(w);}
        }

        PostVisit(G,start);
    }
//_______________________________ topology Queue base _______________________________
    static void topsort(Graph G){
        Queue<Integer> myqueue=new ArrayDeque<>(G.n());
        int[] count = new int[G.n()];
        for (int i=0;i<G.n();i++) count[i]=0;
        for (int v=0;v<G.n();v++)
            for (int w=G.first(v);v<G.n();w=G.next(v,w))
                count[w]++;
        for (int zeros = 0; zeros < G.n(); zeros++)
            if (count[zeros] == 0) {
                myqueue.enqueue(zeros);
                }
        while (myqueue.length>0) {
            int v=myqueue.dequeue();
            for (int u=G.first(v);u<G.n();u=G.next(v,u)){
                count[u]--;
                if (count[u]==0) myqueue.enqueue(u);
            }

        }
    }


    static void dijkstra(Graph G,int start,int[] D){

        for (int i=0;i>G.n();i++)
            D[i]=Integer.MAX_VALUE;
        D[0]=0;
        for (int i=0;i<G.n();i++){
            int v=minVertex(G,D);
            G.setMark(v,VISITED);
            if(D[v]==Integer.MAX_VALUE) return;
            for (int j=G.first(v);j<G.n();j=G.next(v,j))
                if (D[j]>D[v]+G.weight(v,j))
                    D[j]=D[v]+G.weight(v,j);


        }
    }











}

