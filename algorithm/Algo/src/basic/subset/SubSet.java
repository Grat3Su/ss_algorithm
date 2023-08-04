package basic.subset;

public class SubSet {
	static int[] src = {1,2,3,4,5};
	static boolean[] select = new boolean[src.length];
	//tgt를 만들지 않는 이유는 부분집합의 원소의 수가 가변적인 부분도 있지만 , 다른 자료구조로 대체할 수 있기 때문에
	
	public static void main(String[] args) {
		
		subset(0);
	}
	static void subset(int srcIdx) {
		//기저조건
		if(srcIdx == src.length) {//검토 끝
			printSubset();
			return;
		}
		//srcIdx의 항목에 대해 선택, 비선택을 반복하게 됨
		select[srcIdx] = true;
		subset(srcIdx+1);
		select[srcIdx] = false;
		subset(srcIdx+1);
	}
	static void printSubset() {
		System.out.print("{");
		for(int i = 0; i<select.length; i++) {
			if(select[i]) System.out.print(src[i]+" ");
		}
			
		System.out.print("}");
		System.out.print("\n");
	}
}
