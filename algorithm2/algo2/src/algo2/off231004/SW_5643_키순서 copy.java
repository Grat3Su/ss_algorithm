package off231004;

import java.io.*;
import java.util.*;
//T N M
public class SW_5643_키순서 {
    static int T, N, M;
    static int[][] adjMatrix;
    static List<Integer>[] adjList;
    static boolean[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());//정점수
        M = Integer.parseInt(br.readLine());//간선 수

        adjMatrix = new int[N+1][N+1];
        adjList = new ArrayList[N+1];

        for(int i = 0; i<=N; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            adjList[to].add(i);
            adjMatrix[to][from] = 1;
        }

        for(int i = 1; i<=N; i++){
            System.out.println(Arrays.toString(adjMatrix[i]));
        }
    }

    static void find(int v){
        arr = new boolean[N+1];
        for(int i = 1; i<=N; i++){//v->
            if(adjMatrix[v][i] == 1){
                arr[]
            }

        }
    }
}
