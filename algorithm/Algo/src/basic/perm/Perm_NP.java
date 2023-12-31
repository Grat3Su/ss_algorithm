package basic.perm;

import java.util.Arrays;
//이거 외워야됨
//그리거 뭐가 틀렸는지 볼것
public class Perm_NP {
//순열 <- ! 순열의 대상이 되는 항목(원소)가 큰 경우
	static int[] src = {3,1,5,4,2};//정렬되지 않은 수. 정렬하지 않으면 이거보다 더 큰 수로 수열이 만들어짐
	public static void main(String[] args) {
		//NP를 위한 정렬 <= 가장 작은 값을 구성하도록
		Arrays.sort(src);//가장 작은 수를 표현하도록 정렬
		
		while(true) {
			//complete code - 순열이기 때문에
			System.out.println(Arrays.toString(src));
			if(!np())break;
		}

	}
	
	//현재보다 큰 수를 만들 수 있으면 만들고 return true;
	//현재 수가 가장 큰 수면 false
	static boolean np() {
		//3가지
		//앞에서 교환되어야 하는 인덱스&작업
		int i = src.length-1;
		while(i>0&&src[i-1]>=src[i]) --i;//큰것이 나타날때까지 감소
		//이미 가장 큰 수 일때
		//desc
		if(i==0) return false;//더 이상 큰 수를 만들 수 없음
		
		//앞쪽에서 바꿀 index 확정 i-1
		
		//뒤에서 교환되어야 하는 인덱스&작업
		int j = src.length -1;
		while(src[i-1]>=src[j])--j;
		
		swap(src,i-1,j);
		
		//앞뒤 교환 후 뒤쪽 정리(교환)
		int k = src.length-1;
		while(i<k) {
			swap(src, i++,k--);
		}
		
		//j 확정
		//교환 후 뒤쪽을 작은 수로 정리
		return true;
	}

static void swap(int[] array, int i, int j) {
	int temp = array[i];
	array[i] = array[j];
	array[j] = temp;
}

}
