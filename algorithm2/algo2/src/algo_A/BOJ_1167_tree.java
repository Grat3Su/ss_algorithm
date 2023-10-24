package algo_A;
import java.io.*;
import java.util.*;

public class BOJ_1167_tree {
    static int N;
    static boolean[]visit;
    static int[] dist;
    static List<Edge>[] adjList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st =new StringTokenizer(br.readLine());
        adjList = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i = 0; i<N; i++){
            int ro = br.readLine();
        }
    }

    static class Edge{
        int e, v;
        public Edge(int e, int v){
            this.e = e;
            this.v = v;
        }
    }
}
