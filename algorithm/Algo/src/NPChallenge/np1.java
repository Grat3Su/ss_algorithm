package NPChallenge;

public class np1 {
	static int[] src;
	static boolean np() {
		int i,j,k;
		i= j=k=src.length-1;
		while(i>0&&src[i-1]>=src[i]) --i;//큰 것이 나타날때까지 감소
		
		if(i==0) return false;//더 이상 큰 수를 만들 수 없음
		
		while(src[i-1]>=src[j])--j;
		
		swap(src, i-1, j);//교환
		
		while(i<k) {
			swap(src, i++,k--);
		}
		
		return true;
	}
	
	static void swap(int[]arr,int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
