package sw.offline0822;

import java.util.*;
import java.io.*;

//기본적인 순열
public class SW_1247_OptimalPath_NP {
	static int T, N, comY, comX, homeX, homeY, min;
	static int cust[][], index[];// 회사랑 집좌표 포함해야해서 +2인거 잊지말기
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			cust = new int[N][2];
			min = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());
			comY = Integer.parseInt(st.nextToken());
			comX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {// 회사-집-고객'
				cust[i][0] = Integer.parseInt(st.nextToken());
				cust[i][1] = Integer.parseInt(st.nextToken());
			}
			
			//풀이
			index = new int[N];
			for (int i = 0; i < N; i++) {
				index[i]=i;
			}
			
			while(true) {
				//기저조건
				check();
				if(!np(index)) break;
			}
			
			sb.append("#").append(t + 1).append(" ").append(min).append("\n");

		}
		System.out.println(sb);
	}

	static void check() {
		int sum = distance(comY,comX,cust[index[0]][0],cust[index[0]][1]);
		//첫번째 고객->마지막 고객
		for(int i = 0; i<N-1; i++) {
			sum += distance(cust[index[i]][0],cust[index[i]][1],
					cust[index[i+1]][0],cust[index[i+1]][1] );
		}
		
		//마지막 고객->집
		sum += distance(homeY,homeX,cust[index[N-1]][0],cust[index[N-1]][1]);
		min = Math.min(min, sum);
	}
	
	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	static boolean np(int array[]) {
		//3가지
		//앞에서 교환되어야 하는 인덱스&작업
		int i,j,k;
		i=j=k= N-1;
		while(i>0&&array[i-1]>=array[i]) --i;//큰것이 나타날때까지 감소
		//이미 가장 큰 수 일때
		//desc
		if(i==0) return false;//더 이상 큰 수를 만들 수 없음
				
		//뒤에서 교환되어야 하는 인덱스&작업
		while(array[i-1]>=array[j])--j;
		
		swap(array,i-1,j);
		
		//앞뒤 교환 후 뒤쪽 정리(교환)
		while(i<k) {
			swap(array, i++,k--);
		}
		
		return true;
	}
	
	static int distance(int y1, int x1, int y2, int x2) {
		return Math.abs(y1-y2)+Math.abs(x1-x2);
	}

}
