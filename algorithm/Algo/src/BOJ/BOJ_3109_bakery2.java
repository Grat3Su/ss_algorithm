package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_bakery2 {
	static char[][] map;
	static int R,C,ans;
	static int[] dy = {-1,0,1};//우선순위
	
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char [R][];
		ans = 0;
		
		for(int i = 0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		//행으로 위에서 밑으로 내려가면서 최대한 많은 파이프라인을 ㅇㄴ결
		for(int i = 0; i<R; i++) {
			dfs(i,0);
		}
		System.out.println(ans);
	}
	
	//우선순위를 가진 delta를 수행하면서 각 좌표를 이동하고 연결 여부를 확인
	static void dfs(int y, int x) {
		int nx = x+1;//오른쪽으로 항상 이동
		if(nx == C-1) { 
			ans++;
			return;		
		}
		
		//우선순위를 가진 연결 시도
		for(int d = 0; d<3; d++) {
			int ny = y+dy[d];
			
			if(ny<0||ny>=R||map[ny][nx]=='x')continue;
			
			//방문? 성공 실패 여부에 관계없이 방문처리
			map[ny][nx]='x';
			dfs(ny,nx);//성공해도 계속 탐색. <= for문을  계속 반복하도록 되어있어서 fail
		}
	}

}
