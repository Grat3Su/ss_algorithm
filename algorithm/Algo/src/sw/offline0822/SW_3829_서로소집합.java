package sw.offline0822;

import java.io.*;
import java.util.*;


public class SW_3829_서로소집합 {
	static int[]parents;
	static int n = 10;
	static int N,M;//N : 배열 수, M : 연산 수 
	//N M
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			makeSet();
			sb.append("#").append(t+1).append(" ");
			for(int i = 0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b =Integer.parseInt(st.nextToken());
				if(op == 0) {//union
					union(a, b);
				} else {//find
					sb.append(findSet(a)==findSet(b)?1:0);
				}
			}
			System.out.println(sb);
		}
		
	}
	//서로소 집합을 표현하는 자료구조 생성 및 초기화
	static void makeSet() {//집합 만들깅		
		parents = new int[N+1];
		for(int i = 1; i<N; i++) {
			parents[i] = i;
		}	
	}
	
	//소속된 서로소 집합의 대표 원소를 리턴
	static int findSet(int x) {//어떤 수 x에 대해 대표자 리턴 
		//기저조건
		//value와 index 같은 조건
		if(parents[x]==x)	return x;
		else	return parents[x] = findSet(parents[x]);//path compression 하지 않는 경우
	}
	
	//두 서로소집합을 하나로 합친다
	//x의 대표자와 y의 대표자를 찾아서 합친다
	static void union(int x, int y) {//찾아서 한쪽으로 밀어넣으면 된다
		int px = findSet(x);//x의 최조ㅓㅇ 대표자 집합 원소
		int py = findSet(y);//y의 최종 대표자집합 원소
		
		//만약 px==py<=x,y 는 서로 같은 서로소 집합
		//그렇지 않으면 <=x,y는 서로 다른 서로소 집합
		parents[py] = px;		
	}

}
