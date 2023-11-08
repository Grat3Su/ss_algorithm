package algo_study;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class SW_sameParents {
    static int V,E,v1,v2, max;
    static int[] parents;
    static List<List<Integer>> adjList;
    static StringBuilder sb = new StringBuilder();
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());

            parents = new int[V+1];
            
            for(int i = 0; i<=V; i++){
                adjList = new ArrayList<>();
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<E; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                parents[to] = from;
                
                adjList.get(to).add(from);
            }
        }
    }
    static void dfs(int cv, int cnt){
        for(int i = 0; i<adjList.get(cv).size(); i++){
            dfs(adjList.get(cv).get(i), cnt+1);
        }
        max = Math.max(max, cnt);
    }

}
