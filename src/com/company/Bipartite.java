package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

class Bipartite
{
    final static int V = 4; // No. of Vertices


    boolean isBipartite(int[][] Graph)
    {

        int colorArr[] = new int[V];
        for (int i=0; i<V; ++i)
            colorArr[i] = -1;

        colorArr[0] = 1;

        // Create a queue (FIFO) of vertex numbers and enqueue
        // source vertex for BFS traversal
        AQueue<Integer> q = new AQueue<Integer>();
        q.enqueue(src);

        // Run while there are vertices in queue (Similar to BFS)
        while (q.size() != 0)
        {

            // Dequeue a vertex from queue
            int u = q.dequeue();

            // Find all non-colored adjacent vertices
            for (int v=0; v<V; ++v)
            {
                // An edge from u to v exists and destination v is
                // not colored
                if (Graph[u][v]==1 && colorArr[v]==-1)
                {
                    // Assign alternate color to this adjacent v of u
                    colorArr[v] = 1-colorArr[u];
                    q.enqueue(v);
                }

                // An edge from u to v exists and destination v is
                // colored with same color as u
                else if (Graph[u][v]==1 && colorArr[v]==colorArr[u])
                    return false;
            }
        }
        // If we reach here, then all adjacent vertices can
        //  be colored with alternate color
        return true;
    }

    // Driver program to test above function
    public static void main (String[] args)
    {
        int G[][] = {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        Bipartite b = new Bipartite();
        if (b.isBipartite(G, 0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}