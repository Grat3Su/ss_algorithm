package basic.subset;
//select 배열 대신 비트마스크	<= parameter
//src 소스로부터 모든 부분집합의 경우를 먼저 만든다. 각각의 수가 바로 부분집합의 구성을 의미하는데 각 자리가 각 원소의 선택 여부를 표현한다.
public class SubSet4 {
	//재귀호출 대신 for문 사용
	static int[] src = {1,2,3,4,5};
	static int subsetCnt = 1<<src.length;
	//tgt를 만들지 않는 이유는 부분집합의 원소의 수가 가변적인 부분도 있지만 , 다른 자료구조로 대체할 수 있기 때문에
	//부분집합에서 짝수인 경우, 홀수인경우 같은 요소 검사 문제
	public static void main(String[] args) {
		System.out.println(subsetCnt);
		
		//0-31
		//index i 가 각각의 부분집합 구성을 표현
		for(int i = 0; i<subsetCnt; i++) {
			//i = 00101 일종의 비트마스킹 역할
			//src의 항목 하나하나가 선택/비선택 했는지 판단이 가능 <= i와 각 항목의 idx와 비교
			for(int j = 0; j<src.length; j++) {
				if((i&1<<j)!=0) System.out.print(src[j]+" ");
			}
			System.out.println();
		}
	}
}