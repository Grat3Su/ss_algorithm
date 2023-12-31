package BOJ.offline_0825;

import java.util.*;
import java.io.*;

//시뮬레이션
public class BOJ_17143_FishingKing {

	static int R, C, M, sum;
	static Shark[][] map;
	static List<Shark> list = new ArrayList<>();
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R+1][C+1];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			Shark shark = new Shark(r, c, s, d-1, z);// d<delta 위치 보정
			list.add(shark);
			map[r][c] = shark;
		}
		
		for(int i = 1; i<=C; i++) {//col을 이동하면서
			//상어를 잡는다
			catchShark(i);
			//상어가 이동한다
			moveShark();
			//상어를 정리한다.
			killShark();
		}
		System.out.println(sum);
	}
	
	//맵에서 상어를 잡는다.
	static void catchShark(int col) {//col 자리에서 아래로 이동하면서
		for(int i = 1; i<=R; i++) {//밑으로 이동하면서
			if(map[i][col]!=null) {
				sum += map[i][col].z;
				list.remove(map[i][col]);
				break;//한 마리만 잡고 끝내야함
			} 
		}
	}
	
	//list에서 처리
	//맵에 반영안함
	static void moveShark() {
		for(Shark shark:list) {
			int r = shark.r;
			int c = shark.c;
			int s = shark.s;
			int d = shark.d;
			
			switch(d) {
			//상 하
			case 0:	case 1:
				s = s%((R-1)*2);//제자리로 오는 계산을 수학적으로 선처리한다. 어차피 왔다갔다 하면서 제자리로 돌아오기 때문에
				for(int i = 0; i<s; i++) {
					//양끝이면 반환전환
					if(r==1)d =1;//상->하
					else if(r==R)d = 0;//하->상
					r+=dy[d];
				}
				shark.r = r;
				shark.d = d;
				break;
			// 우 좌
			case 2:	case 3:
				s = s%((C-1)*2);//제자리로 오는 계산을 수학적으로 선처리한다. 어차피 왔다갔다 하면서 제자리로 돌아오기 때문에
				for(int i = 0; i<s; i++) {
					//양끝이면 반환전환
					if(c==1)d =2;//좌->우
					else if(c==C)d = 3;//우->좌
					c+=dx[d];
				}
				shark.c = c;
				shark.d = d;
				
				break;
			}
		}
		
	}
	
	//기존 맵 초기화
	//리스트에서 맵으로 기록하면서 겹치면 잡아먹는 처리
	static void killShark() {
		//맵 초기화
		for(int i = 1; i<=R; i++) {
			for(int j = 1; j<=C; j++) {
				map[i][j]=null;
			}
		}
		
		//list를 이용해서 맵 정리
		int size = list.size();
		for(int i = size-1; i>=0;i--) {//삭제 대응 뒤부터
			Shark s = list.get(i);
			if(map[s.r][s.c]==null) {//비어있으면 연결만
				map[s.r][s.c]=s;//연결				
			} else {//겹치는 상어가 있을 때
				if(s.z>map[s.r][s.c].z) {//리스트에서 꺼낸 상어가 더 크다
					list.remove(map[s.r][s.c]);
					map[s.r][s.c] = s;					
				}else {//list에서 꺼낸 상어가 더 작거나 같다. 있는 상어를 남긴다.
					list.remove(i);//index
					
				}
			}
		}
	}

	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}
}
