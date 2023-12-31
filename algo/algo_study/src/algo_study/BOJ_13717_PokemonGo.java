package algo_study;
import java.io.*;
import java.util.*;
public class BOJ_13717_PokemonGo {
	static int N, ans, max;//진화시킬 총 마릿수
	static String pokemon;
	//static int[][] evol;
	//진화에 K개 필요하고 2개 돌려받음
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for(int i = 0; i<N; i++){
			String poke = br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int need = Integer.parseInt(st.nextToken())-2;
			int cur = Integer.parseInt(st.nextToken());

			int evol = cur/need;
			if(cur%need<2){
				evol -= 1;
			}

			if(evol >max){	
				max = evol;
				pokemon = poke;
			}
			ans += evol>0?evol:0;
		}

		System.out.println(ans);
		System.out.println(pokemon);
	}

}
