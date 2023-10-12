package algo2.off231012;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ_2098_외판원순회 {
	static int N, allMask, INF = 999_999_999;
	static int[][] W;
	static int[][] memoi;
	
	//2<=N<=16
	//0001 <=1번 도시 방문
	//1010 <= 2,4번 도시 방문
	//1101<= 1 3 5번 도시 방문
	
	//memoi[i][j] => 현재 i번 도시에 있고, 거쳐온 도시가 j일때 남은 도시를 방문하는 데 필요한 최소 비용
	//memoi[3][1100101] => 1 3 5 7 도시 거쳐서 현재 3번 도시에 있을 때 남은 2,4,5를 방문하는 데 필요한 최소 비용
	//memoi[2][1100111](3->2) +
	//memoi[5][1101101](3->4)
	//memoi[5][1110101](3->5) 중 최솟값 선택
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		
		allMask = (1<<N)-1;//N이 5면 1<<5=>100000 ==> 1을 빼면 11111(5자리가 모두 1)
		memoi = new int[N][allMask];//비트마스킹

		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//0번째 도시에서 출발
		System.out.println(tsp(0,1));
		
	}
	
	static int tsp(int idx, int mask) {
		//기저조건
		if(mask==allMask) {//모든 도시를 방문한 상태, 처음으로 되돌아가는 비용 처리
			if(W[idx][0] == 0) return INF;
			else return W[idx][0];
		}
		
		//더 도시를 방문해야한다.
		if(memoi[idx][mask]!=0)return memoi[idx][mask];
		
		//처음이다
		memoi[idx][mask] = INF;
		
		//방문하지 않은 도시를 방문하도록 재귀
		for(int i = 0; i<N; i++) {
			//갈 수 없거나 이미 방문한 경우는 skip
			if(W[idx][i]==0||(mask&1<<i)!=0)continue;
			
			memoi[idx][mask] = Math.min(memoi[idx][mask], tsp(i, mask|(1<<i)) + W[idx][i]);
		}
		return memoi[idx][mask];
	}

}
