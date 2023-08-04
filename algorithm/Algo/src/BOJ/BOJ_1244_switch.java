package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1244_switch {
	static int[] switchOnOff;
	static int[][] students;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken())+1;//배열 길이
		st = new StringTokenizer(br.readLine());
		switchOnOff = new int[N];
		
		for(int i = 1;  i<N; i++) {//스위치 배열
			switchOnOff[i] = Integer.parseInt(st.nextToken());
		}
		
		//학생 수
		st = new StringTokenizer(br.readLine());
		int sNum = Integer.parseInt(st.nextToken());
		students = new int[sNum][2];
		
		for(int i = 1; i<sNum; i++) {
			st = new StringTokenizer(br.readLine());
			students[i][0] = Integer.parseInt(st.nextToken());// 성별
			students[i][1] = Integer.parseInt(st.nextToken());// 받은 숫자			
		}
		System.out.println(Arrays.toString(switchOnOff));

		for(int i = 0; i<sNum; i++)
		{
			if(students[i][0]==1)
				turnOnOffB(students[i][1], 1);
			else
				turnOnOffG(students[i][1], 0);
				
		}	
		//성별 숫자
		System.out.println(Arrays.toString(switchOnOff));
		
	}
	
	static void turnOnOffG(int index, int range)
	{
		if(index>=N||index+range>=N||index-range<1)
		{System.out.println(Arrays.toString(switchOnOff));
			return;
		}
		int r = index+range;
		int l = index-range;
		int change = switchOnOff[r]==1?0:1;
		
			if(switchOnOff[r] == switchOnOff[l])
			{
				switchOnOff[l] = change;
				switchOnOff[r] = change;
			}
			turnOnOffG(index, range+1);
	}
	
	static void turnOnOffB(int index, int count)
	{
		if(index>=N)
		{
			return;
		}
		System.out.println("Boy "+index);
		System.out.println(Arrays.toString(switchOnOff));
		count +=1;
		switchOnOff[index] = switchOnOff[index] ==1?0:1;
		turnOnOffB(index*count, count);		
	}

}
