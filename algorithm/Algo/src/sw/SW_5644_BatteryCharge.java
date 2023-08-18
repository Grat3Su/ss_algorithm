package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_5644_BatteryCharge {
	    static int T, M, A, ans;
	    static int[] pathA, pathB;  // 두사람이 움직이는 경로를 저장
	    static BC[] bcArray; // 배터리 충전소의 배열
	    static int ay, ax, by, bx; // a, b 두 사람의 y, x 좌표
	    // delta <= 문제에 맞게 순서 필요 
	    static int[] dy = { 0, -1, 0, 1, 0 };
	    static int[] dx = { 0,  0, 1, 0,-1 };
	    
	    static StringBuilder sb = new StringBuilder();
	    
	    public static void main(String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        T = Integer.parseInt(br.readLine());
	        
	        for (int t = 1; t <= T; t++) {
	            
	            // 입력
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            M = Integer.parseInt(st.nextToken()); // 총 이동시간
	            A = Integer.parseInt(st.nextToken()); // BC 개수
	            
	            // path
	            pathA = new int[M];
	            pathB = new int[M];
	            
	            st = new StringTokenizer(br.readLine());
	            for (int i = 0; i < M; i++) {
	                pathA[i] = Integer.parseInt(st.nextToken());
	            }
	            
	            st = new StringTokenizer(br.readLine());
	            for (int i = 0; i < M; i++) {
	                pathB[i] = Integer.parseInt(st.nextToken());
	            }
	            
	            // BC
	            bcArray = new BC[A];
	            
	            for (int i = 0; i < A; i++) {
	                st = new StringTokenizer(br.readLine());
	                int x = Integer.parseInt(st.nextToken()); // x
	                int y = Integer.parseInt(st.nextToken());
	                int c = Integer.parseInt(st.nextToken());
	                int p = Integer.parseInt(st.nextToken());
	                bcArray[i] = new BC(y, x, c, p);
	            }
	            
	            // 초기화
	            ans = 0;
	            
	            ay = 1;
	            ax = 1;
	            by = 10;
	            bx = 10;
	            
	            // 풀이
	            // 충전
	            charge(); // 시작 위치 충전
	            // 이동 매 좌표마다 충전 - 충전할 때 마다 최대값을 선택해서 ans 에 누적합
	            for (int i = 0; i < M; i++) {
	                ay += dy[pathA[i]];
	                ax += dx[pathA[i]];
	                by += dy[pathB[i]];
	                bx += dx[pathB[i]];
	                // 충전
	                charge();
	            }
	            
	            // 출력
	            sb.append("#").append(t).append(" ").append(ans).append("\n");            
	        }
	        System.out.println(sb);
	    }

	    static void charge() {
	        int max = 0;
	        // 현재 ay, ax, by, bx 좌표에서 충전할 수 있는 최대 충전값을 구한 뒤 ans 누적합
	        // 완탐
	        // 모든 BC 에 대해서
	        //  위 BC 에 대해 모든 BC 에 대해서 고려 <= 이중 for
	        for (int i = 0; i < A; i++) {
	            for (int j = 0; j < A; j++) {
	                int sum = 0;
	                // a, b 각각 충전 시도
	                int aPower = getPower(bcArray[i], ay, ax);
	                int bPower = getPower(bcArray[j], by, bx);
	                
	                if( aPower == 0 && bPower == 0 ) continue; // 충전값이 없으면 skip
	                
	                // 둘다 충전되었거나, 어느 한쪽이 충전되었거나
	                // 두 충전소가 같은 지, 다른지에 따라 구별 처리
	                if( i != j ) { // 두 충전소가 다른 겨우
	                    sum = aPower + bPower;
	                }else { // 두 충전소가 같은 경우
	                    // #1 a, b 둘다 충전한 경우 && 같은 충전소 aPower == bPower == 100 => 50 + 50 ? aPower 또는 bPower 를 선택
	                    // #2 a, b 중 한 쪽만 충전한 겨우 => 한쪽은 0 => aPower 와 bPower 중 큰 값을 선택
	                    sum = Math.max(aPower, bPower);
	                }
	                
	                max = Math.max(max, sum);
	            }
	        }
	        
	        ans += max; // 현재 좌표에서 계산된  최대 충전값을 ans 에 누적합
	    }
	    
	    // 충전소 와 특정 좌표( y, x ) 에서 충전할 수 있는 power 
	    static int getPower(BC bc, int y, int x) {
	        if( Math.abs(bc.y - y) + Math.abs(bc.x - x) <= bc.c ) return bc.p;
	        return 0;
	    }
	    
	    static class BC{
	        int y, x, c, p;
	        BC(int y, int x, int c, int p){
	            this.y = y;
	            this.x = x;
	            this.c = c;
	            this.p = p;
	        }
	    }
}
