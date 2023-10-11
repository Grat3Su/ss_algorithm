package algo2.off231010;

import java.util.*;
import java.io.*;

public class SW_5607_Combine {
    static int MOD = 1234567891;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            //Factorial
            long[] facto = new long[N + 1];//1! ~ 10!
			facto[1] = 1; //1! = 1			
			for (int i = 2; i <= N; i++) {
				facto[i] = (facto[i - 1] * i) % MOD;
			}

            long bottom = (facto[R] * facto[N-R]) % MOD;// 1/a에서 a에 해당하는 값
			bottom = pow(bottom, MOD -2);	

            sb.append("#").append(t).append(" ").append((facto[N]*bottom)%MOD);
        }
        System.out.println(sb);
    }
    static long pow(long a, int b){//a의 b승
        if(b==0) return 1;
        else if(b==1) return a;

        if(b%2 == 0){//b : 짝수
            long temp = pow(a, b/2);
            return (temp*temp)%MOD;
        }
        long temp = pow(a, b-1)%MOD;//pow(2,5) ==> pow(2,4)
        return (temp *a)%MOD;
    }
}
