package basic.subset;

public class SubSet2 {
	static int[] src = {0,1,2,3,4,5,6,7,8,9,10};
	static boolean[] select = new boolean[src.length];//비트 마스킹?으로 쓴다
	static int COUNT;
	//tgt를 만들지 않는 이유는 부분집합의 원소의 수가 가변적인 부분도 있지만 , 다른 자료구조로 대체할 수 있기 때문에
	//부분집합에서 짝수인 경우, 홀수인경우 같은 요소 검사 문제
	public static void main(String[] args) {
//		System.out.println(10&3);
//		System.out.println(10&1<<3);
//		System.out.println(10&1<<2);
		System.out.println(10|3);
		System.out.println(10|1<<3);
		System.out.println(10|1<<2);
		//subset(0);
	}
	
	static void subset(int idx) {
		if(idx == select.length) {
			complete();
			unComplete();
			COUNT++;
			return;
		}
		
		select[idx] = true;
		subset(idx+1);//선택
		select[idx] = false;
		subset(idx+1);//미선택
	}
	
	static void complete() {//다양한 형태의 부분집합 문제들을 푼다
		//선택된 항목들 출력
		System.out.println("Complete");
		System.out.print("{");
		for(int i = 0; i<src.length; i++) {
			if(select[i])
			{
				System.out.print(src[i]+" ");				
			}
		}
		
		System.out.print("}");
		System.out.print("\n");		
		
		//============================
		System.out.println("Uncomplete");
		System.out.print("{");
		for(int i = 0; i<src.length; i++) {
			if(!select[i])
			{
				System.out.print(src[i]+" ");				
			}
		}
		System.out.print("}");
		System.out.print("\n");		
	}
	
	static void unComplete() {
		
	}

}
