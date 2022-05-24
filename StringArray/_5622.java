package StringArray;

import java.util.Scanner;

public class _5622 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		char chararray[] = str.toCharArray();
		scan.close();
		int arr[] = new int[10];
		int n = 2;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = n;
			n++;
		}
		int sum=0;
		for (int i = 0; i < chararray.length; i++) {
			switch (chararray[i]) {
			case 'A':
			case 'B':
			case 'C':
				sum += arr[1];
				break;
			case 'D':
			case 'E':
			case 'F':
				sum += arr[2];
				break;
			case 'G':
			case 'H':
			case 'I':
				sum += arr[3];
				break;
			case 'J':
			case 'K':
			case 'L':
				sum += arr[4];
				break;
			case 'M':
			case 'N':
			case 'O':
				sum += arr[5];
				break;
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
				sum += arr[6];
				break;
			case 'T':
			case 'U':
			case 'V':
				sum += arr[7];
				break;
			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
				sum += arr[8];
				break;
			default:
				break;
			}
		}
		System.out.println(sum);
	}
}
