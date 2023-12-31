package online;

import java.util.Scanner;

public class makeSpaceTest {
	static int space[][];
	static int white, green;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		space = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++)
				space[r][c] = sc.nextInt();
		}
		makeSpace(0, 0, N);
		System.out.println(white);
		System.out.println(green);
	}

	static void makeSpace(int sr, int sc, int size) {// 영역의 좌상단 r,c 영역 크기 size
		int sum = 0;
		for (int r = sr; r < sr + size; r++) {
			for (int c = sc; c < sc + size; c++)
				sum += space[r][c];
		}
		if (sum == 0) {// 모두  하얀색 / 이거 자체가 기저조건
			white++;// <= 재귀 유도x
		} else if (sum == size * size) {// 모두 초록/ 이거도 기저조건
			green++;// <= 재귀 유도 x
		} else {// 섞여있다
			int half = size / 2;
			makeSpace(sr, sc, half);// 1
			makeSpace(sr, sc + half, half);// 2
			makeSpace(sr + half, sc, half);// 3
			makeSpace(sr + half, sc + half, half);// 4
		}
	}

}
