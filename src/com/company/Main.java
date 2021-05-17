package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][]graph = new int[n][n];
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1 - 1][v2 - 1] = 1;
            graph[v2 - 1][v1 - 1] = 1;
        }
        output(graph);
        System.out.println(components(graph, 0));
    }

    public static void output (int [][]arr) {
        for (int []x: arr) {
            for (int n: x) {
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }

    public static int components (int [][]graph, int v) {
        int comp = 0;
        for (int i  = 0; i < graph.length; i++) {
            if (graph[v][i] == 1) {
                graph[v][i] = 0;
                graph[i][v] = 0;
                comp += components(graph, i);
            }
        }
        return comp;
    }
}