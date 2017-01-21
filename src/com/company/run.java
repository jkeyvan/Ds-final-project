package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kayvan on 1/20/2017.
 */
public class run {

    static class Bipartite {

        private int V = 6;

        boolean isBipartite(Array.AList<Array.AList<Integer>> G) {
            int colorArr[] = new int[V];
            for (int i = 0; i < V; ++i)
                colorArr[i] = -1;

            colorArr[0] = 1 ;


            myQueue.AQueue<Integer> q = new myQueue.AQueue<Integer>();
            q.enqueue(0);


            while (q.length() != 0) {
                int u = q.dequeue();
                for (int v = 0; v < V; ++v) {

                    G.moveToPos(u);
                    Array.AList A;
                    A = G.getValue();
                    A.moveToPos(v);
                    int uv = (int) A.getValue();

                    if ((uv)!=0 && colorArr[v] == -1) {
                        colorArr[v] = 1 - colorArr[u];
                        q.enqueue(v);
                    } else if (uv !=0  && colorArr[v] == colorArr[u]) {
                        return false;
                    }
                }
            }
            return true;
        }

    }







    static int minVertex(Array.AList<Array.AList<Integer>> G, int[] D,int[] visited) {
        int v = 0; // Initialize v to any unvisited vertex;
        for (int i=0; i<G.length(); i++)
            if (visited[i] == 0) { v = i; break; }
        for (int i=0; i<G.length(); i++) // Now find smallest value
            if (visited[i] == 0 && (D[i] < D[v]))
                v = i;
        return v;
    }

    public static int next(Array.AList<Array.AList<Integer>> Mark,int v, int w) {
            int i=w+1;
            while (i<Mark.length()){

                Mark.moveToPos(v);
                Array.AList<Integer> A;
                A = Mark.getValue();
                A.moveToPos(i);
                int vi = A.getValue();
                if (vi != 0 )
                    return i;
                i++;}
            return Mark.length(); // No next edge;
        }

    public  static int first(Array.AList<Array.AList<Integer>> Mark,int v) {
        int i=0;
        while (i<Mark.length()){

            Mark.moveToPos(v);
            Array.AList<Integer> A;
            A = Mark.getValue();
            A.moveToPos(i);
            //if (A.getValue()==null) System.out.println("null"+" "+v+" "+i);
            int vi= A.getValue();
            //System.out.println(vi);

            if (vi != 0) return i;
            i++;}
        return Mark.length();
    }

    static void Prim(Array.AList<Array.AList<Integer>> G, int[] visited) {

//        int[] visited=new int[G.length()];
//        for( int j=0; j<G.length(); j++) visited[ j]=0;
        int[] D=new int[G.length()];
        int[] V=new int[G.length()];

        for(int k=0;k<G.length();k++) V[k]=0;

        for (int i=0; i<G.length(); i++) // Initialize
            D[i] = Integer.MAX_VALUE;
        D[0] = 0;


        for (int i=0; i<G.length(); i++) { // Process the vertices
            //System.out.println("this is ith vertex : "+i);
            int v = minVertex(G, D,visited);
            //System.out.println("this is ith minvertex : "+v);
            visited[v]=1;
            //if (v != 0) AddEdgetoMST(V[v], v);
            if (v != 0 ) {
//                System.out.println("these are our edges : ");
//                System.out.println(V[v]);
//                System.out.println(v);
                //System.out.println(11111111);
            }
            //if (D[v] == Integer.MAX_VALUE) return; // Unreachable
            int w;
            for (w = first(G,v); w < G.length(); w = next(G,v, w)){

                ///System.out.println("next first of : "+v +" is  "+w );

                G.moveToPos(v);
                Array.AList A;
                A = G.getValue();
                A.moveToPos(w);
                int vw= (int) A.getValue();

                if (D[w] > vw && vw>0 && D[w]!= vw && visited[w]==0) {
                    D[w] = vw;
                    V[w] = v;
//                    System.out.println("D array : " + Arrays.toString(D));
//                    System.out.println("V array : " + Arrays.toString(V));
                    //System.out.println("these are our edges : " + V[w] +" "+w);

                }
        }
//            System.out.println("list of D : ");
//            for(int y=0;y<D.length;y++) System.out.print(D[y]);
//            System.out.println("list of V : ");
//            for(int p=0;p<V.length;p++) System.out.print(V[p]);
        }

        System.out.println(Arrays.toString(V));
        int[][] ali=new int[6][6];
        for(int i=0;i<6;i++) {
            for(int j=0;j<6;j++){
                ali[i][j]=0;
            }
        }

        for(int k=0;k<6;k++){
            ali[k][V[k]]=D[k];
            ali[V[k]][k]=D[k];

        }

        System.out.println(Arrays.deepToString(ali));




    }




    public static void main(String[] args) {

        Array.element injured1 = new Array.element("jack", 18, 3);
        Array.element injured2 = new Array.element("james", 22, 5);
        Array.element injured3 = new Array.element("luck", 8, 7);
        Array.element injured4 = new Array.element("anna", 28, 1);
        Array.element injured5 = new Array.element("nika", 18, 7);
        Array.element injured6 = new Array.element("Lewis", 78, 3);

        Array.LList injuries = new Array.LList<Array.element>();

        injuries.insert(injured1);
        injuries.insert(injured2);
        injuries.insert(injured3);
        injuries.insert(injured4);
        injuries.insert(injured5);
        injuries.insert(injured6);

        Array.AList injuriesofcity1 = new Array.AList<Array.element>();
        Array.AList injuriesofcity2 = new Array.AList<Array.element>();
        Array.AList injuriesofcity3 = new Array.AList<Array.element>();
        Array.AList injuriesofcity4 = new Array.AList<Array.element>();
        Array.AList injuriesofcity5 = new Array.AList<Array.element>();
        Array.AList injuriesofcity6 = new Array.AList<Array.element>();

        Array.getnode<Array.element> inj1 = new Array.getnode<Array.element>(injuries, 0);
        Array.getnode<Array.element> inj2 = new Array.getnode<Array.element>(injuries, 1);
        Array.getnode<Array.element> inj3 = new Array.getnode<Array.element>(injuries, 2);
        Array.getnode<Array.element> inj4 = new Array.getnode<Array.element>(injuries, 3);
        Array.getnode<Array.element> inj5 = new Array.getnode<Array.element>(injuries, 4);
        Array.getnode<Array.element> inj6 = new Array.getnode<Array.element>(injuries, 5);


        Array.AList<Array.State> Tocity1 = new Array.AList<Array.State>();

        Array.AList<Array.State> Tocity2 = new Array.AList<Array.State>();

        Array.AList<Array.State> Tocity3 = new Array.AList<Array.State>();

        Array.AList<Array.State> Tocity4 = new Array.AList<Array.State>();

        Array.AList<Array.State> Tocity5 = new Array.AList<Array.State>();

        Array.AList<Array.State> Tocity6 = new Array.AList<Array.State>();


        Array.State city1 = new Array.State(3.232, 3.545, null, injuriesofcity1);
        Array.State city2 = new Array.State(7.5, 4.5, null, injuriesofcity2);
        Array.State city3 = new Array.State(9.5, 4.5, null, injuriesofcity3);
        Array.State city4 = new Array.State(10.5, 4.5, null, injuriesofcity4);
        Array.State city5 = new Array.State(11.5, 4.5, null, injuriesofcity5);
        Array.State city6 = new Array.State(12.5, 4.5, null, injuriesofcity6);


        Tocity1.append(city1);
        Tocity1.append(city5);
        Tocity2.append(city1);
        Tocity2.append(city5);
        Tocity2.append(city3);
        Tocity3.append(city2);
        Tocity3.append(city4);
        Tocity4.append(city3);
        Tocity4.append(city5);
        Tocity4.append(city6);
        Tocity5.append(city1);
        Tocity5.append(city2);
        Tocity5.append(city4);
        Tocity6.append(city4);


        city1.path = Tocity1;
        city2.path = Tocity2;
        city3.path = Tocity3;
        city4.path = Tocity4;
        city5.path = Tocity5;
        city6.path = Tocity6;


        injuriesofcity1.append(inj1);
        injuriesofcity2.append(inj2);
        injuriesofcity3.append(inj3);
        injuriesofcity4.append(inj4);
        injuriesofcity5.append(inj5);
        injuriesofcity6.append(inj6);


        Array.DLList DLinkListofCities = new Array.DLList<Array.State>(6);
        DLinkListofCities.insert(city1);
        DLinkListofCities.insert(city2);
        DLinkListofCities.insert(city3);
        DLinkListofCities.insert(city4);
        DLinkListofCities.insert(city5);
        DLinkListofCities.insert(city6);


        Array.AList<Array.AList<Integer>> khodemun = new Array.AList<Array.AList<Integer>>();
        Array.AList<Integer> row1 = new Array.AList<Integer>();
        Array.AList<Integer> row2 = new Array.AList<Integer>();
        Array.AList<Integer> row3 = new Array.AList<Integer>();
        Array.AList<Integer> row4 = new Array.AList<Integer>();
        Array.AList<Integer> row5 = new Array.AList<Integer>();
        Array.AList<Integer> row6 = new Array.AList<Integer>();
        row1.append(0);
        row1.append(5);
        row1.append(0);
        row1.append(3);
        row1.append(16);
        row1.append(12);

        row2.append(5);
        row2.append(0);
        row2.append(0);
        row2.append(0);
        row2.append(0);
        row2.append(10);

        row3.append(0);
        row3.append(0);
        row3.append(0);
        row3.append(1);
        row3.append(4);
        row3.append(0);

        row4.append(3);
        row4.append(0);
        row4.append(1);
        row4.append(0);
        row4.append(0);
        row4.append(0);

        row5.append(16);
        row5.append(0);
        row5.append(4);
        row5.append(0);
        row5.append(0);
        row5.append(0);

        row6.append(12);
        row6.append(10);
        row6.append(0);
        row6.append(0);
        row6.append(0);
        row6.append(0);


        khodemun.append(row1);
        khodemun.append(row2);
        khodemun.append(row3);
        khodemun.append(row4);
        khodemun.append(row5);
        khodemun.append(row6);


        int[] visited=new int[khodemun.length()];
        for( int j=0; j<khodemun.length(); j++) visited[ j]=0;


        Prim(khodemun,visited);
        Bipartite dividable=new Bipartite();
        System.out.println(dividable.isBipartite(khodemun));
    }
}








