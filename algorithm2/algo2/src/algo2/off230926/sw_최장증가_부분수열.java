package algo2.off230926;

import java.io.*;
import java.util.*;

public class sw_최장증가_부분수열 {
    static int T, N, len;
    static int[] input;
    static int[] memoi;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            input = new int[N];
            memoi = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }

            len = 0; 
            for(int i = 0; i<N; i++){
                int pos = Arrays.binarySearch(memoi, 0, len, input[i]);//정렬되어야함
                if(pos >=0)continue;//음수일떄 갱신
                pos = Math.abs(pos)-1;//보정이라던데
                memoi[pos] = input[i];
                if(len == pos)len++;
            }
            sb.append("#").append(t).append(" ").append(len).append("\n");            
        }
        System.out.println(sb);
    }
}
