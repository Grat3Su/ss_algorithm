package basic;

public class ArrayTest {

	public static void main(String[] args) {
		int [][]map = {
				{0,1,2,3},
				{0,1,2,3},
				{0,1,2,3},
				{0,1,2,3}
		};
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<map.length-1; i++) {
			for(int j = i+1; j<map[0].length; j++) {
				sb.append(i).append("+").append(j).append("=").append(i+j).append("\n");
			}
		}
		System.out.println(sb);

	}

}
