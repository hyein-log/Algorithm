package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

/*
 * 한 줄로 된 간단한 에디터를 구현하려고 한다. 
 * 길이가 L인 문자열이 현재 편집기에 입력되어 있으면, 커서가 위치할 수 있는 곳은 L+1가지 경우가 있다.
 *  L	커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
	D	커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
	B	커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
		삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
	P $	$라는 문자를 커서 왼쪽에 추가함
 */
public class _1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		LinkedList<String> arr = new LinkedList<>();
		int endnum = str.length();
		for (int i = 0; i < endnum; i++) {
			arr.add(String.valueOf(str.charAt(i)));
		}
		ListIterator<String> it = arr.listIterator();
		while(it.hasNext()) {
			it.next();
		}
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			String str2 = br.readLine();
			StringTokenizer st = new StringTokenizer(str2, " ");
			Character Order = st.nextToken().charAt(0);
			switch (Order) {
			case 'P':
				String plus = st.nextToken();
				it.add(plus);
				break;
			case 'L':
				if (it.hasPrevious()) {
					it.previous();
				}
				break;
			case 'D':
				if (it.hasNext()) {
					it.next();
				}
				break;
			default:// B
				if (it.hasPrevious()) {
					it.previous();
					it.remove();
				}
				break;
			}
		}
		System.out.println(String.join("", arr));
	}
	
}
