package com.company;

import java.util.ArrayList;

/**
 * Created by kayvan on 1/20/2017.
 */
public class run {

    class isBipartite {}
    static void Prim(int[][] G, int s, int[] D, int[] V) {
        int[] visited = new int[G.length];
        for(int i=0;i<G.length;i++) visited[i]=0;
        for (int i=0; i<G.length; i++) // Initialize
            D[i] = Integer.MAX_VALUE;
        D[s] = 0;
        for (int i=0; i<G.length; i++) { // Process the vertices
            int v = minVertex(G, D);
            visited[v]=1;
            if (v != s) AddEdgetoMST(V[v], v);
            if (D[v] == Integer.MAX_VALUE) return; // Unreachable
            for (int w ; w < G.length; w = G.next(v, w))
                if (D[w] > G[v][w]) {
                    D[w] = G[v][w];
                    V[w] = v;
                }
        }
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

        Array.AList injuriesofcity1 =new Array.AList<Array.element>();
        Array.AList injuriesofcity2 =new Array.AList<Array.element>();
        Array.AList injuriesofcity3 =new Array.AList<Array.element>();
        Array.AList injuriesofcity4 =new Array.AList<Array.element>();
        Array.AList injuriesofcity5 =new Array.AList<Array.element>();
        Array.AList injuriesofcity6 =new Array.AList<Array.element>();

        Array.getnode<Array.element> inj1= new Array.getnode<Array.element>(injuries,0);
        Array.getnode<Array.element> inj2= new Array.getnode<Array.element>(injuries,1);
        Array.getnode<Array.element> inj3= new Array.getnode<Array.element>(injuries,2);
        Array.getnode<Array.element> inj4= new Array.getnode<Array.element>(injuries,3);
        Array.getnode<Array.element> inj5= new Array.getnode<Array.element>(injuries,4);
        Array.getnode<Array.element> inj6= new Array.getnode<Array.element>(injuries,5);


        Array.AList<Array.State> Tocity1=new Array.AList<Array.State>();

        Array.AList<Array.State> Tocity2=new Array.AList<Array.State>();

        Array.AList<Array.State> Tocity3=new Array.AList<Array.State>();

        Array.AList<Array.State> Tocity4=new Array.AList<Array.State>();

        Array.AList<Array.State> Tocity5=new Array.AList<Array.State>();

        Array.AList<Array.State> Tocity6=new Array.AList<Array.State>();


        Array.State city1= new Array.State(3.232,3.545,null,injuriesofcity1);
        Array.State city2= new Array.State(7.5,4.5,null,injuriesofcity2);
        Array.State city3= new Array.State(9.5,4.5,null,injuriesofcity3);
        Array.State city4= new Array.State(10.5,4.5,null,injuriesofcity4);
        Array.State city5= new Array.State(11.5,4.5,null,injuriesofcity5);
        Array.State city6= new Array.State(12.5,4.5,null,injuriesofcity6);


        Tocity1.insert(city1);
        Tocity1.insert(city5);
        Tocity2.insert(city1);
        Tocity2.insert(city5);
        Tocity2.insert(city3);
        Tocity3.insert(city2);
        Tocity3.insert(city4);
        Tocity4.insert(city3);
        Tocity4.insert(city5);
        Tocity4.insert(city6);
        Tocity5.insert(city1);
        Tocity5.insert(city2);
        Tocity5.insert(city4);
        Tocity6.insert(city4);


        city1.path=Tocity1;
        city2.path=Tocity2;
        city3.path=Tocity3;
        city4.path=Tocity4;
        city5.path=Tocity5;
        city6.path=Tocity6;


        injuriesofcity1.insert(inj1);
        injuriesofcity2.insert(inj2);
        injuriesofcity3.insert(inj3);
        injuriesofcity4.insert(inj4);
        injuriesofcity5.insert(inj5);
        injuriesofcity6.insert(inj6);


        Array.DLList DLinkListofCities=new Array.DLList<Array.State>();
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
        row1.insert(0);
        row1.insert(1);
        row1.insert(0);
        row1.insert(0);
        row1.insert(1);
        row1.insert(0);

        row2.insert(1);
        row2.insert(0);
        row2.insert(1);
        row2.insert(0);
        row2.insert(1);
        row2.insert(0);

        row3.insert(0);
        row3.insert(1);
        row3.insert(0);
        row3.insert(1);
        row3.insert(0);
        row3.insert(0);

        row4.insert(0);
        row4.insert(0);
        row4.insert(1);
        row4.insert(0);
        row4.insert(1);
        row4.insert(1);

        row5.insert(1);
        row5.insert(1);
        row5.insert(0);
        row5.insert(1);
        row5.insert(0);
        row5.insert(0);

        row6.insert(0);
        row6.insert(0);
        row6.insert(0);
        row6.insert(1);
        row6.insert(0);
        row6.insert(0);


        khodemun.insert(row1);
        khodemun.insert(row2);
        khodemun.insert(row3);
        khodemun.insert(row4);
        khodemun.insert(row5);
        khodemun.insert(row6);

    }





