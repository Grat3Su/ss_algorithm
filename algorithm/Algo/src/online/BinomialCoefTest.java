package online;
import java.io.*;
import java.util.*;
public class BinomialCoefTest {

	public static void main(String[] args) {
		Scanner  sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][]B = new int[N+1][K+1];
		
		for(int i = 0; i<=N; i++){
			for(int j = 0,end = Math.min(i, K); j<=end; j++) {
				if(j==0||i==j)//아무것도 안뽑거나 크기와 뽑는게 동일하면
					B[i][j]=1;
				else	B[i][j] = B[i-1][j-1]+B[i-1][j];
			}
		}
		System.out.println(B[N][K]);
		for(int i = 0; i<N+1; i++)
			System.out.println(Arrays.toString(B[i]));
	}

}
