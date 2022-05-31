package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

/*
 * �� �ٷ� �� ������ �����͸� �����Ϸ��� �Ѵ�. 
 * ���̰� L�� ���ڿ��� ���� �����⿡ �ԷµǾ� ������, Ŀ���� ��ġ�� �� �ִ� ���� L+1���� ��찡 �ִ�.
 *  L	Ŀ���� �������� �� ĭ �ű� (Ŀ���� ������ �� ���̸� ���õ�)
	D	Ŀ���� ���������� �� ĭ �ű� (Ŀ���� ������ �� ���̸� ���õ�)
	B	Ŀ�� ���ʿ� �ִ� ���ڸ� ������ (Ŀ���� ������ �� ���̸� ���õ�)
		������ ���� Ŀ���� �� ĭ �������� �̵��� ��ó�� ��Ÿ������, ������ Ŀ���� �����ʿ� �ִ� ���ڴ� �״����
	P $	$��� ���ڸ� Ŀ�� ���ʿ� �߰���
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
