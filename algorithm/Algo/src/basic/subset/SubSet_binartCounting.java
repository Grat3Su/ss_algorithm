package basic.subset;
//select 배열 대신 비트마스크	<= parameter
public class SubSet_binartCounting {
	static int[] src = {0,1,2,3,4,5};
	//static boolean[] select = new boolean[src.length];//비트 마스킹?으로 쓴다
	static int COUNT;
	//tgt를 만들지 않는 이유는 부분집합의 원소의 수가 가변적인 부분도 있지만 , 다른 자료구조로 대체할 수 있기 때문에
	//부분집합에서 짝수인 경우, 홀수인경우 같은 요소 검사 문제
	public static void main(String[] args) {
		subset(0,0);
	}
	
	static void subset(int idx, int mask) {//마스크는 스택 메모리라 메소드가 리턴할 때마다 없어짐
		if(idx == src.length) {//비교 연산 자체가 매우 빠름
			call(mask);
			return;
		}
		
		subset(idx+1, mask|1<<idx);
		subset(idx+1, mask);
	}
	
	static void call(int mask){
		
		for(int i = 0; i<src.length; i++) {
			if((mask&1<<i)!=0) {
				System.out.print(src[i]+" ");
			}
		}
		System.out.println();
	}
}
