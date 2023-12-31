import java.util.Arrays;
import java.util.Scanner;

public class AreaAdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int[] area = new int[5001];
		
		long start = System.nanoTime();
		//50개 생성
		for(int i = 0; i<5001; i++) {
			area[i] = i;//0은 더미
		}
		int sum = 0;
		for(int i = a; i<b+1; i++) {
			sum += area[i];
		}
		System.out.println(sum);
		long end = System.nanoTime();
		
		System.out.println("일반 배열의 시간 : "+((end-start)/1_000_000.0));
		
		start = System.nanoTime();
		//구간합 생성
		for(int i = 1; i<5001; i++) {
			area[i] = i+area[i-1];//0은 더미
		}
		end = System.nanoTime();
		System.out.println((area[b]-area[a-1]));
		System.out.println("구간합 배열의 시간 : "+((end-start)/1_000_000.0));
		
		int[][] arr = new int[5][5];
		
		for(int i = 1; i<=4;i++) {
			for(int j = 1; j<=4; j++) {
				arr[i][j] = 1+arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
			}
		}
		
		for(int i = 0; i<5; i++)
			System.out.println(Arrays.toString(arr[i]));
	}
}
