package online;

import java.util.Arrays;

public class DisjointSetTest {
	static int N;// 초기 집합의 개수
	static int parents[];
	
	static void make() {//서로소 집합을 만드는 함수
		parents = new int[N];
		
		for(int i = 0; i<N; i++) {
			parents[i] = i;//모든 요소는 자기만 원소로 갖는 단위 서로소 집합이 되게 한다.
			//자신이 곧 대표자인 루트로 표현
		}
	}
	
	static int find(int a) {//a가 속한 곳의 대표자
		if(a==parents[a]) return a;//자신이 대표자인 경우
		return find(parents[a]);
	}
	
	static boolean union(int a, int b) {//a가 속한 집합과 b가 속한 집합을 합칠 수 있다면 합치고 true 반환. 아니면 false 반환
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot)		return false;// 서로의 대표자가 같은, 즉 같은 집합의 상황이므로 union하지 않음
		//유니온 처리(bRoot를 aRoot 아래에 붙ㅇ리기 임의로 
		parents[bRoot] = aRoot;
		return true;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=5;;
		make();
//		System.out.println("find(0) "+find(0));
//		System.out.println("find(0) "+find(1));
//		System.out.println("find(0) "+find(2));
//		System.out.println("find(0) "+find(3));
//		System.out.println("find(0) "+find(4));
		
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,1));
		System.out.println(Arrays.toString(parents));
	}

}
